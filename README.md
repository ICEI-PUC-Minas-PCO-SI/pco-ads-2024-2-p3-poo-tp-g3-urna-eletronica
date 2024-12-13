[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=17323872&assignment_repo_type=AssignmentRepo)
# SISTEMA DE GERENCIAMENTO DE URNAS ELETRÔNICAS

`CURSO: Analise e Desenvolvimento de Sistemas - Sistemas de Informação`

`DISCIPLINA: Projeto - Projeto de Infraestrutura`

`Eixo: 5`

Este trabalho apresenta um sistema de gerenciamento de urna eletrônica, com foco em eleições para Prefeito e Vereador. A aplicação é dividida em dois módulos principais: Eleições do Executivo e Eleições do Legislativo, seguindo as regras definidas pela legislação eleitoral brasileira. 

## Integrantes


* Eduarda Silva Santos Nunis
* Matheus Felipe Galdino
* Míriam Cristina Alves de Jesus
* Rafael Brandão Silva

## Orientador

* Fabio Leandro Rodrigues Cordeiro
  
## Objetivo

O objetivo deste trabalho é uma aplicação para simular uma urna eletrônica baseada na legislação brasileira utilizando os conceitos vistos ao longo do curso de poo.

## Modelagem das Classes

 Segue o diagrama de classes utilizado para representar sua estrutura:

![Eleicao2 drawio](https://github.com/user-attachments/assets/2d9809b3-d9d0-4d72-b4e1-b9a433f0ffb1)


 ## Funcionalidades

:heavy_check_mark: Autenticação do eleitor (identificação e elegibilidade).

:heavy_check_mark: Registro do voto com anonimato e segurança.

:heavy_check_mark: Encerramento e geração de resultados (boletim de urna).

:heavy_check_mark: Usabilidade e acessibilidade para diferentes perfis de eleitores.

## Layout ou Deploy da Aplicação :dash:

> Link do deploy da aplicação. Exemplo com netlify: https://certificates-for-everyone-womakerscode.netlify.app/

... 

Se ainda não houver deploy, insira capturas de tela da aplicação ou gifs

## Pré-requisitos

:warning: [Node](https://nodejs.org/en/download/)

## Principio do Projeto

O principio utilizado foi o SOLID, possibilitando que o projeto seja mais bem reaproveitado, tenha uma manutenção e entendimento fáceis. É possivel verificar os principios:\br
:heavy_check_mark: SRP - as classes não possuem mais de um motivo para alterar;\br
:heavy_check_mark: LSP - os objetos das classes filhas podem substituir das classes mães;\br
:heavy_check_mark: ISP - o sistema possui interfaces mais especificas do que somente uma geral.\br

## Padrão da Aplicação

O padrão utilizado foi o Singleton, aplicado para assegurar que somente uma instância da eleição seja criada e gerenciada.

### Tecnologias Utilizadas

<H6>Back End</H6> 
* Linguagem de Prgramação: JAVA
* Framework: Spring
* Banco de Dados: H2 DataBase

<H6>Front End</H6> 
* Formatação: HTML
* Estilização: CSS

<H6>Ambiente de hospedagem do repositório</H6> 
* GitHub







