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

## Modelagem das Classes

A aplicação foi desenvolvida seguindo os pilares da programação orientada a objetos. Segue o diagrama de classes utilizado para representar sua estrutura:

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

...

Liste todas as dependencias e libs que o usuário deve ter instalado na máquina antes de rodar a aplicação 

## Como rodar a aplicação :arrow_forward:

1- No terminal, clone o projeto: 

```
git clone https://github.com/ICEI-PUC-Minas-PCO-SI/pco-ads-2024-2-p3-poo-tp-g3-urna-eletronica.git
```
2- Navegue até o diretório clonado:
```
cd pco-ads-2024-2-p3-poo-tp-g3-urna-eletronica
```
3- Faça a instalação do node.js:
```
node.js
```
4- Faça a instalação das dependência(se necessário):
```
npm install
```
5- Execute o comando para rodar a aplicação:
```
npm start
```


## Como rodar os testes
1- Clone o projeto e navegue até o diretório clonado:
```
git clone https://github.com/ICEI-PUC-Minas-PCO-SI/pco-ads-2024-2-p3-poo-tp-g3-urna-eletronica.git
cd pco-ads-2024-2-p3-poo-tp-g3-urna-eletronica
```
2- Caso ainda não tenha feito, instale as dependências:
```
npm install
```
3- Execute o comando de teste:
```
npm test
```


## Principio do Projeto

O principio utilizado foi o SOLID, possibilitando que o projeto seja mais bem reaproveitado, tenha uma manutenção e entendimento fáceis. É possivel verificar os principios: :heavy_check_mark: SRP - as classes não possuem mais de um motivo para alterar;
:heavy_check_mark: LSP - os objetos das classes filhas podem substituir das classes mães;
:heavy_check_mark: ISP - o sistema possui interfaces mais especificas do que somente uma geral.

## Padrão da Aplicação

O padrão utilizado foi o Singleton, aplicado para assegurar que somente uma instância da eleição seja criada e gerenciada.

### Tecnologias Utilizadas

<H6>Back End</H6> 
*Linguagem de Prgramação: JAVA;
*Framework: Spring;
*Banco de Dados:;

<H6>Front End</H6> 
*Formatação: HTML;
*Estilização: CSS;

<H6>Ambiente de hospedagem do repositório</H6> 
*GitHub

## Testes

coloque os testes






