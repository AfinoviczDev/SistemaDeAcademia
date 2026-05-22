
# 🏋️ API de Gerenciamento de Academia

API RESTful desenvolvida com **Spring Boot** para simular um sistema completo de gerenciamento de academia. A aplicação permite controlar alunos, avaliações físicas, treinos e exercícios, seguindo boas práticas de arquitetura, modelagem de dados e organização em camadas.

---

## 🚀 Visão Geral do Projeto

Este projeto foi desenvolvido com foco em:

- Arquitetura limpa e escalável  
- Boas práticas com Spring Boot e JPA  
- Modelagem relacional consistente  
- Separação de responsabilidades (DDD simplificado)  
- Preparação para evolução futura  

---

## 🧰 Tecnologias Utilizadas

| Tecnologia        | Descrição |
|------------------|----------|
| Java 17+         | Linguagem principal |
| Spring Boot      | Framework backend |
| Spring Data JPA  | Abstração ORM |
| Hibernate        | Implementação JPA |
| Maven            | Gerenciador de dependências |
| H2 / PostgreSQL  | Banco de dados |
| Lombok           | Redução de código boilerplate |
| Swagger/OpenAPI  | Documentação da API |

---

## 🏗️ Arquitetura

A aplicação segue o padrão de **arquitetura em camadas (Layered Architecture)**:

### 📦 Estrutura de Pacotes

com.gym.api
├── controller
├── service
├── repository
├── entity
├── dto
├── config
└── exception

### 🔍 Responsabilidades

- **Controller** → Recebe e trata requisições HTTP  
- **Service** → Contém regras de negócio  
- **Repository** → Comunicação com o banco de dados  
- **Entity** → Mapeamento das tabelas  
- **DTO** → Transferência de dados  

---

## 🧩 Modelo de Domínio

### 📊 Relacionamentos

- **Aluno (Student)**
  - 1:1 → Avaliação Física  
  - 1:N → Treinos  

- **Treino (Workout)**
  - N:N → Exercícios (via tabela associativa)  

- **Exercício (Exercise)**
  - Classificado por grupo muscular  

---

### 🗂️ Entidades

#### 👤 Aluno
- id  
- nome  
- email  

#### 📊 Avaliação Física
- id  
- peso  
- altura  
- percentual de gordura  

#### 🏋️ Treino
- id  
- nome  

#### 💪 Exercício
- id  
- nome  
- grupo muscular  



### ▶️ Como Executar
- Clone o repositório
git clone https://github.com/AfinoviczDev/SistemaDeAcademia

- Acesse a pasta
cd SistemaDeAcademia

- Execute o projeto

- Acesse a aplicação

API: http://localhost:8080

Swagger: http://localhost:8080/swagger-ui.html

---

### 📈 Melhorias Futuras
🔐 Autenticação com JWT + Spring Security

📱 Integração com frontend (React ou Angular)
