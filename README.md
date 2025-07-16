# 📦 MyAnimeVault

MyAnimeVault é uma aplicação desenvolvida em Java com Spring Boot que permite buscar, importar e armazenar animes utilizando a API pública Jikan (MyAnimeList). A aplicação armazena os dados em um banco MySQL e oferece uma API REST para consulta e manipulação dos dados.

---

## 🛠 Dependências:

O projeto utiliza as seguintes dependências principais:

- **spring-boot-starter-web**: para criação da API REST.
- **spring-boot-starter-data-jpa**: para integração com banco de dados usando JPA/Hibernate.
- **spring-boot-starter-validation**: para validação de dados.
- **flyway-core** e **flyway-mysql**: para versionamento e migração do banco de dados.
- **mysql-connector-j**: driver JDBC para conexão com MySQL.
- **lombok**: para reduzir boilerplate no código (getters, setters, etc).
- **jackson-databind**: para manipulação de JSON.
- **spring-boot-devtools**: para facilitar o desenvolvimento com reload automático.

---

### Tecnologias Utilizadas:

- Java 17 ou superior instalado.
- Maven 3.8 ou superior instalado.
- Servidor MySQL instalado e em execução.

