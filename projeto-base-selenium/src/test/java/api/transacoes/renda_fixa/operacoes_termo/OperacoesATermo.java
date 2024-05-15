package api.transacoes.renda_fixa.operacoes_termo;


import api.componente.TestCase;

public interface OperacoesATermo extends TestCase {
    DadosDeMovimentacaoAba dadosDaMovimentacao();
    CustodiaAba custodia();
}
