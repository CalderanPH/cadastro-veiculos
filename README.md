A API "Veiculos" é um sistema para gerenciamento de veículos, que oferece uma variedade de funcionalidades para interagir com os dados de veículos armazenados no sistema.

Os Principais recursos da API são:

- Obter todos os veículos cadastrados.
- Filtrar veículos com base na marca, ano e cor.
- Buscar um veículo por ID.
- Obter todos os veículos não vendidos.
- Obter todos os veículos de uma determinada década.
- Obter todos os veículos de uma determinada marca.
- Obter os veículos cadastrados na última semana.
- Criar um novo veículo.
- Atualiza o veículo.
- Atualizar o status (vendido ou não vendido) de um veículo.
- Excluir um veículo.

A API é projetada para ser consumida por meio de requisições HTTP, seguindo as práticas RESTful. Ela utiliza os métodos GET, POST, PUT e DELETE para realizar as operações de CRUD (Create, Read, Update, Delete) nos recursos de veículos.

## Funcionalidades
Aplicação tem diversas funcionalidades, contando com algumas em especial que o usuário consegue filtrar o veículo utilizando todos ou apenas um dos seguintes filtros: marca, ano e cor, em seguida é listado todos os veiculos que possuem as descrições fornecidas pelo usuário.

Conta com a funcionalidade de listar todos os veículos de uma década, ou seja, se o usuário informar que deseja receber os veículos de 1990 é retornado todos os veículos entre 1990 à 1999,
caso o usuário passe uma data como 1995 ou qualquer outra que esteja no range de 1990 à 1999. Ele retorna todos os dados desta data.

É possivel filtrar todos os veiculos de uma determinada marca (fabricante) ou exibir todos os veículos cadastrados na última semana.

Ao usuário cadastrar um veículo caso esteja com a nomeclatura da Marca escrito de maneira errada é disparada uma exception, 
vejamos o seguinte exemplo: usuário digita "FORDE" é disparada a exception, tendo em vista que o nome correto é "FORD".

Há um recurso que o usuário consegue alterar o status do veículo de vendido para disponivel.


## Challenge
O package challenge contem 4 desafios que consistem em:
- Relação ao total de eleitores.
- Algoritmo de ordenação Bubble Sort.
- Fatorial.
- Soma dos multiplos de 3 ou 5.

Para acessar o challenge basta seguir o caminho: "src/main/java/challenge". Neste package contem todos os desafios citados acima.

## Test 
A aplicação possue estrutura de testes unitários que valida as funcionalidades do sistema.

## Single Page
A aplicação conta com uma aplicação front-end que consume a API do back-end. 
A finalidade do Single Page é o usuário conseguir testar a aplicação sem a utilização do postman.


