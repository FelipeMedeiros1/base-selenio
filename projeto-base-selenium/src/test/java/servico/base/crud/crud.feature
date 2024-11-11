# language: pt
@crud
Funcionalidade: Validar CRUD da página

  Contexto:
  Esta funcionalidade testa as operações CRUD (Criar, Consultar, Atualizar e Excluir)
  para o cadastro de diferentes entidades no sistema.
  As operações devem ser realizadas com sucesso,
  validando as mensagens de feedback do sistema.

  Esquema do Cenário: Realizar inclusão, consulta, atualização e exclusão
    Dado que abra o navegador e acesse a página especificada "<pagina>" com o arquivo "<caminhoJson>"
    Quando preencher os dados da pagina "<pagina>" e executar a operação CRUD especificada "<operacao>" na posição Json <posicao>
    Então verifica se a mensagem pelo tipo de operação "<operacao>"

    Exemplos:
      | pagina | operacao  | posicao | caminhoJson                                            |
      | Moedas | cadastrar | 1       | transacoes/cadastrobasico/moedas/automacao/Moedas.json |
      | Moedas | atualizar | 2       | transacoes/cadastrobasico/moedas/automacao/Moedas.json |
      | Moedas | excluir   | 3       | transacoes/cadastrobasico/moedas/automacao/Moedas.json |



