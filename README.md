# 🔐 API de Autenticação com Spring Security

Uma API REST desenvolvida com **Java** e **Spring Boot** com o objetivo de estudar autenticação e autorização utilizando **Spring Security** e **JWT (JSON Web Token)**.

O projeto implementa um fluxo completo de cadastro, login, geração de tokens e proteção de endpoints, servindo como base para aprofundar os estudos em segurança de aplicações.

---

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- PostgreSQL
- JWT (Auth0 Java JWT)
- BCrypt
- Maven
- Lombok
- Bean Validation

---

## 📌 Funcionalidades

- Cadastro de usuários
- Login com autenticação via Spring Security
- Criptografia de senhas utilizando BCrypt
- Geração de JWT
- Validação de Token JWT
- Autorização de endpoints
- Usuários cadastrados recebem automaticamente a role **USER**
- Tratamento de exceções
- Validação de requisições

---

## 🔑 Fluxo de autenticação

1. O usuário realiza o cadastro.
2. A senha é criptografada com BCrypt.
3. O usuário faz login informando e-mail e senha.
4. O sistema autentica o usuário utilizando o Spring Security.
5. Um JWT é gerado e retornado ao cliente.
6. O token deve ser enviado no cabeçalho das próximas requisições.

Exemplo:

```http
Authorization: Bearer <TOKEN>
```

---

## 👤 Controle de acesso

Atualmente, todos os usuários cadastrados recebem automaticamente a role:

```text
ROLE_USER
```

As rotas protegidas exigem autenticação e são autorizadas conforme a role do usuário autenticado.

---

## 📂 Estrutura do projeto

```text
src
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── infra
├── repository
├── service
└── config
```

---

## ⚙️ Como executar

Clone o repositório:

```bash
git clone https://github.com/kellyxwz/NOME_DO_REPOSITORIO.git
```

Entre na pasta:

```bash
cd NOME_DO_REPOSITORIO
```

Crie um arquivo `.env`:

```env
DB_URL=
DB_USERNAME=
DB_PASSWORD=

JWT_SECRET=
```

Execute a aplicação:

```bash
mvn spring-boot:run
```

---

## 📚 Conceitos estudados

- Spring Security
- JWT (JSON Web Token)
- AuthenticationManager
- UserDetails
- UserDetailsService
- BCryptPasswordEncoder
- Filtros de autenticação
- Roles
- DTOs
- Injeção de dependências
- Arquitetura em camadas
- APIs REST

---

## 🚧 Próximas implementações

- Controle de acesso com múltiplas roles (ADMIN e SUPER_ADMIN)
- Refresh Token
- Recuperação de senha
- Swagger/OpenAPI
- Testes unitários
- Testes de integração
- Docker
- Deploy

---

## 👨‍💻 Autor

**Kelly Ramos**

GitHub: https://github.com/kellyxwz
