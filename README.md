# SISTEMA DE CADASTRO DE INVESTIMENTOS - TESTE BACK-END - GF INNOVATION

## Descrição
Este projeto é um sistema de cadastro de investimentos desenvolvido em Java 21, utilizando o framework Spring Boot e gerenciador de dependências Maven. As dependências do projeto são Spring web, Lombok e Spring Dev Tools. 

 O sistema possui a criação, leitura, atualização e exclusão de registros de investimentos.

 ## Endpoints da API

 1.POST
 url: http://localhost:8080/investments

body:
{
  "name":"Fundo X",
  "type":"Ação",
  "amount":100,
  "date":"2025-03-19T00:26:14.786+00:00"
}

Descrição: para o cadastro, deve conter o nome, tipo, valor e data. O valor deve ser maior que 0 e a data não pode estar no futuro.

2.GET
url: http://localhost:8080/investments

Descrição: O método get retorna todos os investimentos cadastrados. O projeto não faz a busca por id único.

3.PATCH
url:http://localhost:8080/investments/{id}

body:
{
  "name":"Fundo X",
  "type":"Ação",
  "amount":100,
  "date":"2025-03-19T00:26:14.786+00:00"
}

Descrição: O método atualiza qualquer campo dos dados, seguindo as regras do POST.

4.DELETE
url:http://localhost:8080/investments/{id}

Descrição: O método remove o investimento selecionado.

## Execução do Projeto
Para executar o projeto, siga os passos abaixo:

Clone o repositório:
git clone <URL_DO_REPOSITORIO>

Navegue até o diretório do projeto:
cd <NOME_DO_DIRETORIO>

Instale as dependências:
mvn clean install

Compile e execute o projeto:
mvn spring-boot:run

A API estará disponível em http://localhost:8080/investments