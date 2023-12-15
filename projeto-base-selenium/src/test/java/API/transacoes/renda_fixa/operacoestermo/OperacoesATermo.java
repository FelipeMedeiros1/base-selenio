package API.transacoes.renda_fixa.operacoestermo;


import API.componente.TestCase;

public interface OperacoesATermo extends TestCase {
    DadosDeMovimentacaoAba dadosDaMovimentacao();
    CustodiaAba custodia();
}
