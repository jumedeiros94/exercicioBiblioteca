# API de Biblioteca 📚

## Descrição

Este projeto consiste em uma API de Biblioteca que permite o gerenciamento de livros. Ela inclui funcionalidades como exibir todos os livros, exibir um livro específico, cadastrar um novo livro, alterar um livro existente e excluir um livro. Cada livro é definido por atributos como nome, autor, data de lançamento e código do livro. A aplicação utiliza um banco de dados PostgreSQL para armazenar os dados dos livros.

## Funcionalidades

1. **Exibir todos os livros:** Endpoint para listar todos os livros cadastrados na biblioteca.

2. **Exibir um livro específico:** Endpoint para obter informações detalhadas de um livro específico com base em seu código.

3. **Cadastro de um novo livro:** Endpoint para adicionar um novo livro à biblioteca. Os atributos necessários são nome, autor, data de lançamento e código do livro.

4. **Alteração de um livro:** Endpoint para atualizar informações de um livro existente. Os atributos do livro podem ser alterados, exceto seu código.

5. **Deleção de um livro:** Endpoint para remover um livro da biblioteca com base em seu código.

## Requisitos

1. **Banco de dados PostgreSQL:** A aplicação utiliza o banco de dados PostgreSQL para armazenar os dados dos livros. Certifique-se de configurar corretamente as informações de conexão no arquivo de configuração.

## Como Usar

1. Clone o repositório para a sua máquina local.
2. Configure as informações de conexão com o banco de dados PostgreSQL no arquivo de configuração da aplicação.
3. Utilize uma ferramenta como o Postman para realizar requisições HTTP aos endpoints da API.
4. Consulte a documentação da API ou os comentários no código-fonte para obter detalhes sobre os endpoints disponíveis e os atributos necessários.

## Contribuição

Contribuições são bem-vindas! Se você deseja melhorar este projeto, sinta-se à vontade para abrir um Pull Request ou reportar problemas abrindo uma Issue.

## Licença

Este projeto está licenciado sob a MIT License. Consulte o arquivo [LICENSE](LICENSE) para obter detalhes.

