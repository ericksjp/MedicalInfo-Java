# Aplicação de Cálculo de Saúde

Este projeto é uma aplicação Java para calcular e armazenar informações relacionadas à saúde de uma pessoa. A aplicação fornece uma interface gráfica do usuário (GUI) para entrada de dados e exibição de resultados, além de permitir que o usuário salve os resultados em arquivos CSV ou TXT.

## Funcionalidades

- **Entrada de Dados**: O usuário pode inserir informações como nome, idade, altura, peso, gênero e nível de atividade física.
- **Cálculo de Perfil de Saúde**: Com base nas informações inseridas, a aplicação calcula o perfil de saúde da pessoa.
- **Exibição de Resultados**: Os resultados são exibidos na interface do usuário.
- **Salvar em Arquivos**: Os resultados podem ser salvos em formato CSV ou TXT.

## Estrutura do Projeto

O projeto é composto pelos seguintes componentes:

- **Model**: Contém a definição da classe `Pessoa` que representa uma pessoa e seus atributos relacionados à saúde.
- **Utils**: Fornece utilitários para formatação e conversão de dados.
- **View**: Contém a GUI da aplicação, incluindo a classe `MasterFrame` que é a janela principal da aplicação.
- **Enums**: Define enumerações para o gênero e o nível de atividade física.
- **exec**: Contém o método de inicialização da aplicação.

## Como Executar
```
git clone https://github.com/ericksjp/MedicalInfo-Java/
cd MedicalInfo-Java/
find ./src/ -type f -name "*.java" -exec javac -cp ./src/ -d ./out/ '{}' +
cd ./out/
java exec/Main
```
