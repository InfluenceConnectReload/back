# Influence Connect

## Descrição
O backend do projeto Influence Connect é uma REST API desenvolvida com o objetivo de criar uma ferramenta eficaz para empresas parceiras que desejam promover seus produtos ou serviços por meio de campanhas publicitárias em mídias sociais.

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- PostgreSQL

## Estrutura do Projeto
O projeto está organizado da seguinte forma:

```plain
com.senac.influenceconnect
├── main
├── config
├── controllers
├── dto
├── enums
├── models
│ └── pk
├── repositories
└── services
```

## Dependências
As seguintes dependências são utilizadas no projeto:

- `spring-boot-starter-data-jpa`
- `spring-boot-starter-web`
- `spring-boot-devtools`
- `postgresql`
- `spring-boot-starter-test`
- `springdoc-openapi-starter-webmvc-ui`
- `springfox-swagger-ui`
- `springdoc-openapi-ui`

## Instruções para Rodar o Projeto

1. **Clonar o repositório:**
   ```bash
   git clone <URL_DO_REPOSITORIO>
   ```
2. **Ter o PostgreSQL versão 13 ou superior instalado.**
3. **Criar um banco de dados com o nome `influenceconnect`:**
   ```sql
   CREATE DATABASE influenceconnect;
   ```
4. **Certificar-se de que o PostgreSQL está rodando na porta 5432 (padrão) e a senha do usuário `postgres` é `1234`.**
5. **Importar o projeto no Eclipse, IntelliJ IDEA ou Spring Tools Suite 4.**
6. **Fazer alterações no `application.properties` caso o PostgreSQL não esteja na porta padrão ou a senha não seja a recomendada.**
7. **Rodar o projeto.**
8. **O projeto está configurado para rodar na porta 8001.**

## Documentação da API

Após rodar o projeto, a documentação da API estará disponível via Swagger no seguinte endereço:

[http://localhost:8001/influenceconnect/swagger-ui/index.html](http://localhost:8001/influenceconnect/swagger-ui/index.html)
