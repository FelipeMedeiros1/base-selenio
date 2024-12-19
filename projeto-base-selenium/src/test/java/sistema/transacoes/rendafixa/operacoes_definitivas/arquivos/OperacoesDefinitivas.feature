# language: pt

@OperacoesDefinitivas
Funcionalidade:  Esta funcionalidade testa as operação Inclusão de uma movimentação no sistema.
  A operação deve ser realizadas com sucesso, validando a mensagem de feedback do sistema.

  Contexto:
    Dado que o usuário esteja logado no sistema

  @Inclusao
  Cenário: Realizar a inclusão de uma movimentação de Operacoes Definitivas no sistema

    Dado que o usuário acesse a página: "Transferências > Renda Fixa > Movimentação > Operações Definitivas"

    E recebe os dados do Arquivo .json "transacoes/cadastrobasico/moedas/automacao/arquivos/OperacoesDefinitivas.json", para realização dos testes

    Quando o usuário preenche os campos com os dados para realizar a inclusão da movimentação

    Então a nova operação deverá ser incluída no sistema devolvendo a mensagem de sucesso


