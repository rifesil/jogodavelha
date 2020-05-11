# Microsserviço Jogo

Microsserviço 

## Sumário

* [Introdução](#introdução)
  + [Objetivo](#objetivo)
  + [Evolução](#evolução)
* [Instalação](#instalação)
  + [Pré-requisitos](#pré-requisitos)
  + [Configuração da Aplicação](#configuração-da-aplicação)
    - [Perfil `default`](#perfil-default)
    - [Perfil `local`](#perfil-local)
* [Utilização](#utilização)
  + [Compilação](#compilação)
  + [Execução da Aplicação](#execução-da-aplicação)
  + [Contratos de APIs](#contratos-de-apis)
* [Documentação](#documentação)
* [Contribuições](#contribuições)
* [Equipe](#equipe)
* [Licença](#licença)

## Introdução
> TODO: descreva o contexto e histórico que motivaram a construção desse microsserviço.

### Objetivo
> TODO: descreva o objetivo e principais funcionalidades contempladas por esse microsserviço

### Evolução
> TODO: descreva as potenciais funcionalidades que ainda serão desenvolvidas nesse microsserviço 

## Instalação

Baixe o código-fonte desse repositório usando `git clone` ou de forma manual (.zip).
Para prosseguir com a instação deste projeto é necessário atender a tabela de pré-requisitos com componentes na versão
especificada ou superior.

### Pré-requisitos

| Componente   | Versão       | Descrição                      |
|--------------|--------------|--------------------------------|
| OpenJDK      | 11.0.3 (LTS) | Plataforma Java                |
| Apache Maven | 3.6.1        | Build e Gestão de Dependências |


### Configuração da Aplicação

A aplicação foi planejada para ser executada em dois ambientes distintos compartilhando o máximo de similaridades possíveis.
Para isso foram criados dois perfis (_profiles_). Detalhes das configurações, profiles e sua utilização estão na próxima seção.

## Utilização

Abaixo seguem instruções de uso do projeto. Os comandos devem ser executados no terminal, ou diretamente na IDE de preferência
do desenvolvedor.

### Compilação

Para fazer o download de dependências e compilar o código-fonte da aplicação, navegue até o diretório raiz do projeto execute:

```bash
mvn clean package
```

### Execução da Aplicação

Para executar a aplicação :

```bash
mvn spring-boot:run 
```

A aplicação estará executando no endereço http://localhost:8080/


### Contratos de APIs

Este projeto utiliza a especificação OpenAPI para documentação e catálogo de APIs.
Depois de executar a aplicação, é possível consultar todas operações fornecidas pelo serviço e testá-las respectivamente
acessando o endereço http://localhost:8080/swagger-ui.html.
