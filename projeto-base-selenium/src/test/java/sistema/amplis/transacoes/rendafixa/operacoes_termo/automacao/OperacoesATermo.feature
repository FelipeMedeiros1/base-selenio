# language: pt
@operacaoATermo
Funcionalidade: Operações a Termo

  @incluir
  Esquema do Cenário: Cenário: Realizar inclusão de Operações a Termo
    Dado que acesse a página Transações > Renda Fixa > Movimentação > Operações a Termo
    Quando preencher dados válidos para a operação
    Então deverá lançar uma mensagem:<mensagem>
    Exemplos:
      | mensagem                         |
      | "Operação realizada com sucesso" |

