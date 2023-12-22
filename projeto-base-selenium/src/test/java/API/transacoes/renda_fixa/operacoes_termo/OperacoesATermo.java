package API.transacoes.renda_fixa.operacoes_termo;


import API.componente.TestCase;

public interface OperacoesATermo extends TestCase {
    DadosDeMovimentacaoAba dadosDaMovimentacao();
    CustodiaAba custodia();
}
