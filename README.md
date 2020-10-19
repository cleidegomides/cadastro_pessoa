# cadastro_pessoa_endereco

## 📰Sobre:
A Api tem função de criar cadastros de pessoas e endereços, foi utilizado CRUD para criar, atualizar, deletar e listar pessoas e endereços.
___

## 🛠Ferramentas Utilizadas:

- Intellij
- Docker
- MySQL
- Postman
- Dbeaver
- Cmdr
___
## 🎮Tecnologias Utilizadas:

- Java8
- Spring Data
-  Spring Boot
- Swagger2
- Lombok
- Mapstruct
___
## 📝Documentação:

- URL para acessar a documentação: http://localhost:8080/swagger-ui.html#/
___

## Comando Utilizados no Docker:

```bash
#criar um novo container
docker run -p 3306:3306 --name some-mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql

#listar todos container
docker container ls -a;

#Iniciar o container
docker container start some-mysql;

#Parar o container
docker container stop some-mysql.
```
