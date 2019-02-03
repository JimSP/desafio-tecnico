###Deploy

Para baixar os fontes

	git clone https://github.com/JimSP/desafio-tecnico.git

Acessando o diretório dos fontes

	cd desafio-tecnico

Para fazer um clean

	./gradlew clean

Para fazer um build

	./gradlew build

Para executar a app
	
	./gradlew bootRun

Para gerar uma imagem Docker

	sudo ./gradlew buildDocker
	
Para executar a imagem docker

	docker run -p 9000:9000 com.vagas/desafio-tecnico:0.0.1

Para fazer um clean, gerar um build, criar uma imagem com Docker e executar a app (tudo o que você precisa)

	sudo ./runApp.sh

###Documentação API

http://localhost:9000/swagger-ui.html

###Lógica
O modelo pensando efetua o calculo de distancias na Regiao (Grafo) à partir de uma Localidade (Nó), calculando assim todas as distancias para essa Localidade.

Na inicialização são carregadas as Regioes para cada Localidade, e por demanda essa região vai sendo calculada e armazenada no cache do cluster.c

Melhorias possiveis:

	Caso o tamanho da Regiao fique absurdamente grande (ordem de dezena de milhões) talvez deva ser considerado dois pontos:
		1. efetuar o calculo da Regiao durante a inicialização.
		2. alterar a lógica para efetuar busca por Caminhos (arestas), para isso seria preciso criar um novo método na classe FuncaoMenorCaminho. O novo método:
			public Optional<Localidade> buscarLocalidade(Regiao regiao, Ponto pontoOrigem, Ponto pontoDestino);
			
		Com essa abordagem não seria mais preciso ter uma carga de Regiões na inicialização, porém o tempo médio de uma busca seria significamente mais alto, porém ainda dentro do aceitavel (muito menor que 1s).

###Arquitetura

O primeiro ponto levado em consideração foi manter o código simples, limpo e
legivel.

Foi escolhido o spring-boot como "microcontainer" para a execução da mesma pela simplicidade de pouca configuração que o mesmo oferece, ter diversas features já bem resolvidas e maduras, tal como actuator, spring-data, spring-mvc. (Esses foram utilizados).

Foi escolhido o gradle para fazer o build do projeto pela clareza e facilidade de efetuar alterações no mesmo, a manutenção do build.gradle é mais simples do que um pom.xml.

A construção foi iniciada pelas funções para efetuar busca de menor distancia e calculo da pontuação..
Essa decisão foi tomada levando em cosideração:

	que esse é o objetivo final, o que realmente possui valor..
	todos os demais requisitos dependem dessas funções estarem funcionando corretamente, qualquer alteração nessas funções poderiam ter um custo alto de rafatoração mais na frente..
	os demais requisitos são na maioria utilização de frameworks, framework tem que ser fácil tirar e por. Regra é dificil corrigir depois que tudo funciona ao seu redor menos ela..

Para facilitar o entendimento do problema o termo grafo, nó e aresta foram abstraidos, Região, Localização e Caminho são nomes que permitem explicar o problema de maneira mais simples (primeiro ponto a ser levado em consideração)..
Por cossequencia parte da modelagem do problema foi resolvida..

Logo após foi construida a parte de persistencia..
Foi escolhido o Hazelcast por ser um memory data grid facil de escalar, com mecanismos de auto-discovery, clusterização e provider de cache do spring boot já muito bem resolvidos, além disso ele oferece uma performance bastante significativa..

O Fato dele ter opção de funcionamento embarcado com Spring Boot e possuir biblioteca que implementa as interfaces de repositories do spring-data foi levado em consideração.
Dessa forma foi simples e pouco custoso para resolver a persistencia..

Foi construida então a camada de API com base na documentação fornecida nos enunciados desse desafio.
Foram criados Dtos para fazer o transporte de dados na camada afim de preservar o contrato de dados de alterações do Core e de preservar alterações no Core devido a alterações de contrato de dados.

Foi utilizado o ModelMapper para tratar as conversões de dados entre a camada de API e o core, foi escolhido esse framework pela sofisticação e flexibilidade que o mesmo oferece para fazer as projecoes e as planificaçoes de dados.

Foi utilizado java-validations para validar os payloads de requisição e o Jackson para Serializações e Deserializações de Json trafegados na API.

Foi utilizado o swagger para auto-documentar a API, o que saiu de graça..

Então foi montada a camada se serviços, e os componentes de Funções, Persistencia e API foram naturalmente se ligado.

O Cache foi utilizado para armazenar as rotas calculadas, afim de evitar custo para calcular a mesma rota N vezes, o mesmo foi feito para o calculo de score..
Os testes únitarios foram sendo escritos conforme a necessidade de verificação do funcionamento de partes especificas do código.
Alguns perderam o sentido e foram retirados do código.
Foram levados dois pontos em consideração:

	1.	testar funcionalidades. 
	2.	os testes foram escritos para terem sentido e serem integrados.
	3.	ter uma corbertura realmente significativa, ou seja, cobrir trechos de código que precisam ser cobertos.

O Tratamento de erros foi feito com o intuito de ser o mais auto-explicativo e fornecer uma boa rastreabilidade para analises..
O Log segue esse mesmo raciocinio, foi utilizado um padrão bastante rigoroso na escrita de logs afim de facilitar a O Log segue esse mesmo raciocinio, foi utilizado um padrão bastante rigoroso na escrita de logs afim de facilitar consultas e consultas por um Splunk Graylog ou ELK por exemplo..

Colocando um API-Gateway com balanceamento e auto-discovery "na frente" da API, é possivel ter quantas instancias se quiser dessa aplicação, não apenas a carga será distribuida, os dados tambem, isso ficou de graça com o Hazelcast.

Para facilitar a execução e o deploy da aplicação, foi utilizado o docker através do gradle, assim com 1 único comando, tudo acontece, bem mais simples (o que sempre deve ser levado em consideração).

Foi add plugin para integração com SonarQube para analise de código e do JFrog para publicação e versionamento do Jar, como o mesmo é pago, está comentado, foi mantido para demonstração.

Não foi implementado um Jenkinsfile pois uma pipeline tem muitas dependencias operacionais e de infraestrutura.

###Testes Manuais

Url:http://localhost:9000/v1/vagas

Method:POST

Content-Type:application/json

Payload:
{
    "empresa": "Teste",
    "titulo": "Vaga teste",
    "descricao": "Criar os mais diferentes tipos de teste",
    "localizacao": "A",
    "nivel": 3
}

Response:
{
  "codigo": 0,
  "mensagem": "OK",
  "empresa": "Teste",
  "titulo": "Vaga teste",
  "descricao": "Criar os mais diferentes tipos de teste",
  "localizacao": "A",
  "nivel": 3,
  "id": 144493360189538305
}

-----------------------------------------------------------------

Url:http://localhost:9000/v1/pessoas

Method:POST

Content-Type:application/json

Payload:
{
    "nome": "John Doe",
    "profissao": "Engenheiro de Software",
    "localizacao": "C",
    "nivel": 2
}

Response:
{
  "codigo": 0,
  "mensagem": "OK",
  "id_pessoa": 144493360189603841,
  "nome": "John Doe",
  "profissao": "Engenheiro de Software",
  "localizacao": "C",
  "nivel": 2,
  "score": null
}

-----------------------------------------------------------------

Url:http://localhost:9000/v1/candidaturas

Method:POST

Content-Type:application/json

Payload:
{
    "id_vaga": 144493360189538305,
    "id_pessoa": 144493360189603841
}

Response:
{
  "codigo": 0,
  "mensagem": "OK",
  "idCandidato": 144482807190716417,
  "idVaga": 144482807190650881
}

-----------------------------------------------------------------

Url:http://localhost:9000/v1/vagas/144493360189538305/candidaturas/ranking

Method:GET

Response:
{
  "codigo": null,
  "mensagem": null,
  "id_pessoa": 144493360189603841,
  "nome": "John Doe",
  "profissao": "Engenheiro de Software",
  "localizacao": "C",
  "nivel": 2,
  "score": 62
}