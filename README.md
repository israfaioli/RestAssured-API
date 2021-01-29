### Projeto de automação API ###
URL de estudos para o portifólio: https://fakerestapi.azurewebsites.net/index.html

### Pré-requesitos ###

* Java 8.

* Maven

### Tecnologias Utilizadas ###

* RestAssured
* Junit
* Lombok
* Maven
* Java

### Estrutura do projeto ###

* Common - Classes onde terão métodos em comum que poderão ser usadas por outras classes.
* Common > Base - A base e onde temos os principais métodos onde utilizamos na automação.
* Models - Onde são criados os objetos que podem ser usados na automação.
* Runners - Suite principal para execução dos testes (API).
* Api - Onde ficam os testes de API.
* Utils - Classes com algumas funções uteis para o projeto.

### Rodando o projeto ###

Em alguns casos, a depender de suas configurações locais, pode ser necessário executar o projeto com permissões de administrador adicionando "sudo" antes dos comandos abaixo.

* Acessa a pasta do projeto
* Rode o seguinte comando do maven:

## Execução dos Testes de API ##

```
mvn clean test -Dtest=ApiRunner
```