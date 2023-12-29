package WEBDRIVER.pageObject.transacoes.renda_fixa.operacoestermo;


import API.transacoes.renda_fixa.operacoes_termo.CustodiaAba;
import API.transacoes.renda_fixa.operacoes_termo.DadosDeMovimentacaoAba;
import API.transacoes.renda_fixa.operacoes_termo.OperacoesATermo;
import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;

public class OperacoesATermoPage extends BasePage implements OperacoesATermo {
    private DadosDeMovimentacaoAba dadosDeMovimentacaoAba;
    private CustodiaAba custodiaAba;


    public void acessaPagina() {
        new Acessa().operacoesATermo();
        inserir();
    }

    @Override
    public DadosDeMovimentacaoAba dadosDaMovimentacao() {
        if (dadosDeMovimentacaoAba == null) {
            dadosDeMovimentacaoAba = new DadosDaMovimentacaoAbaImpl();
            dadosDeMovimentacaoAba.seleciona();
        }
        return dadosDeMovimentacaoAba;
    }

    @Override
    public CustodiaAba custodia() {
        if (custodiaAba == null) {
            custodiaAba = new CustodiaAbaImpl();
            custodiaAba.seleciona();
        }
        return custodiaAba;
    }
}
