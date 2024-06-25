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
   git clone https://github.com/InfluenceConnectReload/back
   ```
   
2. **Instalar o PostgreSQL:**
   - Verifique se possui o PostgreSQL versão 13 ou superior instalado.

3. **Configurar o Banco de Dados:**
   - Crie um banco de dados chamado `influenceconnect`:
     ```sql
     CREATE DATABASE influenceconnect;
     ```

4. **Verificar Configurações do PostgreSQL:**
   - Certifique-se de que o PostgreSQL está rodando na porta 5432 (padrão) e que o usuário `postgres` tem a senha `1234`.
   - Ou ajuste o arquivo `application.properties` com as novas configurações.

5. **Importar e Configurar o Projeto:**
   - Importe o projeto no IDE de sua escolha (Eclipse, IntelliJ IDEA, ou Spring Tools Suite 4).
   - Faça ajustes no arquivo `application.properties` caso necessário.
   
6. **Executar o Projeto:**
   - Utilize a IDE para executar o projeto.
   - Ou utilize o CLI do maven.
   ```bash
   # Comando para iniciar o projeto
   ./mvnw spring-boot:run
   ```

7. **Acesso à Aplicação:**
   - A aplicação estará configurada para rodar na porta 8001.


## Documentação da API

Após rodar o projeto, a documentação da API estará disponível via Swagger no seguinte endereço:

[http://localhost:8001/influenceconnect/swagger-ui/index.html](http://localhost:8001/influenceconnect/swagger-ui/index.html)
