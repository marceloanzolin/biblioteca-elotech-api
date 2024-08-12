Projeto Biblibloteca Elotech

## Descrição
- Projeto desenvolvido em JAVA versão 17
- Spring Boot Versão 3.3.2
- Swagger
- Maven
## Configurações
- Banco de dados: MySql versão '10.4.24-MariaDB'
- Nome da BASE de dados: `biblioteca`
- Usuário: `root`
- Senha: Não possui senha
- Utilização do FlyWay, base de dados é criada pelos scripts que estão na pasta `src/main/resources/db/migration` 
## Funcionalidades
- CRUD e lista paginada de Livros 
- CRUD e listagem de Usuários
- Empréstimos
  - Criação de um empréstimo 
  - Alteração de status do empréstimo e data de devolução
  - Listagem de empréstimos por Id
  - Listagem paginada dos empréstimos
- Recomendação de livros para o usuário passado por parametro com base na categoria do livros emprestados
- Busca de livros por titulo na api do Google Books
- Inserção de livros na base de dados da biblioteca para o livro encontrado pelo título
## Observações
- Link de acesso ao Swagger (http://localhost:8080/swagger-ui/index.html#/)
- Em `src/main/resources/examples` temos um JSON para simulação das requisições
- No email de retorno deste teste temos uma pasta zipada com alguns dados para inserção na base de dados

