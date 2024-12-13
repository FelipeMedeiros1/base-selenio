# language: pt
@moedas
Funcionalidade: Moedas

  Contexto:
  Esta funcionalidade testa as operação Inclusão
  para o cadastro de moedas no sistema.
  A operação devem ser realizadas com sucesso,
  validando a mensagem de feedback do sistema.


  Esquema do Cenário: Realizar inclusão de moeda no sitema

    Dado que o usuário acessa a página <pagina>, <nomeDoArquivo>

    Quando o usuário preenche os campos com os dados do arquivo <nomeDoArquivo> na posição <posicao> do arquivo json

    Então a nova operação deverá ser incluída com sucesso no sistema

    Exemplos:
      | pagina                                    | nomeDoArquivo                                                   | posicao |
      | "Transações > Cadastros Básicos > Moedas" | "amplis/transacoes/cadastrobasico/moedas/automacao/Moedas.json" | 1       |
