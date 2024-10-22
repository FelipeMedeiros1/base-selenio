# language: pt
@moedas
Funcionalidade: Moedas

  Contexto:
  Esta funcionalidade testa as operações CRUD (Criar, consultar, Atualizar e Excluir)
  para o cadastro de moedas no sistema.
  As operações devem ser realizadas com sucesso,
  validando as mensagens de feedback do sistema.


  Cenário: Realizar inclusão, consulta, atualização e exclusão

    Dado que acesse a página Transações > Cadastros Básicos > Moedas

    Quando preencher dados válidos para cada operação

    Então deverá exibir uma mensagem de sucesso:

