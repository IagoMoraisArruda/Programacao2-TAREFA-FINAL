# 🏠 Sistema de Gerenciamento Imobiliário

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/POO-Programação%20Orientada%20a%20Objetos-blue?style=for-the-badge" alt="POO" />
  <img src="https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge" alt="Status" />
</p>

Uma aplicação de gerenciamento imobiliário desenvolvida em Java, utilizando os conceitos de **Programação Orientada a Objetos (POO)** para administrar imóveis, clientes, funcionários e transações imobiliárias.

O sistema permite realizar operações de compra e locação, controlar a disponibilidade dos imóveis, gerenciar comissões e consultar informações dos funcionários e das transações realizadas.

> 📌 **Objetivo do Projeto:** Desenvolver uma aplicação que simule o funcionamento de uma imobiliária, aplicando conceitos de orientação a objetos, organização de classes, herança, encapsulamento, abstração e polimorfismo.

---

## 🗺️ Sumário do Documento

* 📦 Estrutura do Projeto
* 🛠️ Pré-requisitos
* ⚠️ Aviso de Compatibilidade com Linux
* ▶️ Como Executar o Projeto
* 🎮 Funcionalidades Disponíveis
* 🧠 Conceitos de Programação Orientada a Objetos
* 📋 Regras de Negócio
* 💾 Armazenamento de Dados
* 📌 Observações

---

## 📦 Estrutura do Projeto

```text
ProjetoImobiliaria/
│
├── src/
│   │
│   ├── Classes/
│   │   ├── Apartamento.java       --> Representa imóveis do tipo apartamento
│   │   ├── Casa.java              --> Representa imóveis do tipo casa
│   │   ├── CategoriaImovel.java   --> Categorias dos imóveis
│   │   ├── Cliente.java           --> Gerenciamento de clientes
│   │   ├── Endereco.java          --> Informações de endereço
│   │   ├── FormaPagamento.java    --> Formas de pagamento
│   │   ├── Funcionario.java       --> Gerenciamento de funcionários
│   │   ├── Imovel.java            --> Classe base dos imóveis
│   │   ├── ImovelResidencial.java --> Classe base dos imóveis residenciais
│   │   ├── Locacao.java           --> Representação de locações
│   │   ├── Pessoa.java            --> Classe base para pessoas
│   │   ├── SalaComercial.java     --> Representa salas comerciais
│   │   ├── StatusImovel.java      --> Controle de disponibilidade
│   │   ├── Terreno.java           --> Representa terrenos
│   │   ├── Transacao.java         --> Classe base das transações
│   │   └── Venda.java             --> Representação de vendas
│   │
│   ├── Main/
│   │   └── Main.java              --> Menu principal e execução
│   │
│   └── service/
│       └── Imobiliaria.java       --> Regras de negócio e gerenciamento
│
└── .gitignore
```

### Organização do código

O projeto foi dividido em três pacotes principais:

- **Classes:** contém as entidades do sistema, como imóveis, clientes, funcionários e transações.
- **Main:** responsável pela inicialização e interação com o usuário através do terminal.
- **service:** concentra as operações e regras de negócio da imobiliária.

---

## 🛠️ Pré-requisitos

Para executar o projeto, é necessário possuir:

* **Java JDK:** versão 17 ou superior para execução geral.
* **Java JDK 27:** recomendado para ambientes Linux, conforme o aviso de compatibilidade abaixo.
* **IntelliJ IDEA:** Community ou Ultimate (opcional, mas recomendado).
* **Terminal:** para executar e interagir com a aplicação.

---

## ⚠️ Aviso de Compatibilidade com Linux

> [!WARNING]
> **Atenção, usuários Linux!**
>
> O projeto pode apresentar problemas de execução ou comportamento inesperado em determinados ambientes Linux.
>
> Caso ocorram esses problemas, é necessário utilizar o **Java JDK 27** para executar a aplicação.
>
> Recomenda-se verificar a versão do Java instalada antes de iniciar o programa.

Para verificar a versão instalada:

```bash
java -version
javac -version
```

Caso seja necessário utilizar o Java 27, certifique-se de que tanto o `java` quanto o `javac` estejam apontando para essa versão.

---

## ▶️ Como Executar o Projeto

### Passo 1 — Clonar o repositório

```bash
git clone URL_DO_REPOSITORIO
```

Entre na pasta do projeto:

```bash
cd ProjetoImobiliaria
```

### Passo 2 — Verificar a instalação do Java

```bash
java -version
javac -version
```

Certifique-se de que o JDK esteja instalado e configurado corretamente.

### Passo 3 — Compilar o projeto

Na pasta principal do projeto, execute:

```bash
javac -d out src/Classes/*.java src/service/*.java src/Main/*.java
```

O comando irá compilar as classes e organizar os arquivos `.class` dentro da pasta `out`.

### Passo 4 — Executar a aplicação

```bash
java -cp out Main.Main
```

Após a execução, o menu principal será apresentado no terminal.

---

## 🎮 Funcionalidades Disponíveis

O sistema disponibiliza um menu interativo com as seguintes operações:

| Opção | Funcionalidade |
|---|---|
| 1 | Listar imóveis cadastrados |
| 2 | Buscar imóveis por bairro |
| 3 | Listar imóveis disponíveis para venda |
| 4 | Listar imóveis disponíveis para locação |
| 5 | Registrar venda de imóvel |
| 6 | Registrar locação de imóvel |
| 7 | Listar transações realizadas |
| 8 | Consultar salário de funcionário |
| 9 | Cadastrar cliente |
| 10 | Cadastrar funcionário |
| 11 | Cadastrar imóvel |
| 0 | Encerrar o sistema |

### 🏡 Gerenciamento de Imóveis

* Cadastro de diferentes categorias de imóveis.
* Consulta de imóveis cadastrados.
* Busca por bairro.
* Controle de disponibilidade para venda e locação.
* Atualização do status após a conclusão de uma transação.

### 👥 Gerenciamento de Clientes e Funcionários

* Cadastro de clientes.
* Cadastro de funcionários.
* Busca por CPF.
* Associação de proprietários aos imóveis.
* Controle de informações dos funcionários.

### 💰 Gerenciamento de Transações

* Registro de vendas.
* Registro de locações.
* Geração automática de números de contrato.
* Registro de valores negociados.
* Controle de comissões imobiliárias.
* Histórico de transações realizadas.

---

## 🧠 Conceitos de Programação Orientada a Objetos

O projeto utiliza os principais conceitos de POO:

| Conceito | Aplicação no Projeto |
|---|---|
| Encapsulamento | Proteção dos atributos e utilização de métodos de acesso |
| Herança | Especialização de classes, como Casa, Apartamento e Terreno |
| Abstração | Classes abstratas para representar entidades genéricas |
| Polimorfismo | Comportamentos específicos para diferentes tipos de imóveis e transações |
| Enumerações | Controle de categorias, status e formas de pagamento |

### Hierarquia de Classes

A organização das classes permite reutilizar atributos e comportamentos entre diferentes entidades.

Exemplos:

- `Pessoa` → `Cliente` e `Funcionario`.
- `Imovel` → `ImovelResidencial`, `Terreno` e `SalaComercial`.
- `ImovelResidencial` → `Casa` e `Apartamento`.
- `Transacao` → `Venda` e `Locacao`.

Essa estrutura facilita a manutenção e a expansão do sistema.

---

## 📋 Regras de Negócio

O sistema implementa validações para garantir a consistência das operações imobiliárias.

Entre as principais regras estão:

* Não permitir o cadastro de imóveis sem pelo menos um proprietário.
* Impedir o cadastro de imóveis com códigos duplicados.
* Impedir CPFs duplicados dentro dos cadastros de clientes e funcionários.
* Não permitir a venda de imóveis indisponíveis para venda.
* Não permitir a locação de imóveis indisponíveis para locação.
* Exigir pelo menos um fiador para realizar uma locação.
* Exigir pelo menos duas indicações para realizar uma locação.
* Não permitir valores negociados menores ou iguais a zero.
* Não permitir comissões imobiliárias negativas.
* Atualizar automaticamente o status do imóvel após uma transação.

---

## 💾 Armazenamento de Dados

Atualmente, o sistema utiliza estruturas de dados em memória, principalmente `ArrayList`, para armazenar:

* Imóveis;
* Clientes;
* Funcionários;
* Transações.

**Importante:** o projeto ainda não possui integração com banco de dados. Dessa forma, os dados cadastrados durante a execução são perdidos quando a aplicação é encerrada.

---

## 📌 Observações

* A aplicação possui interface textual executada pelo terminal.
* Alguns dados de exemplo são cadastrados automaticamente durante a inicialização.
* O sistema foi organizado em pacotes para facilitar a manutenção e a compreensão do código.
* O projeto pode receber melhorias futuras, incluindo persistência em banco de dados e implementação de uma interface gráfica.

---

## 👨‍💻 Desenvolvimento

Projeto desenvolvido com Java, utilizando Programação Orientada a Objetos para simular as operações de uma imobiliária.

O foco principal é aplicar conceitos de engenharia de software e organização de código em uma aplicação prática.

---

<p align="center">
  Desenvolvido com ☕ Java
</p>
