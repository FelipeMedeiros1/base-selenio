package WEBDRIVER.pageObject.transacoes.renda_fixa.operacoestermo;


import API.transacoes.renda_fixa.operacoes_termo.CustodiaAba;
import API.transacoes.renda_fixa.operacoes_termo.DadosDeMovimentacaoAba;
import API.transacoes.renda_fixa.operacoes_termo.OperacoesATermo;
import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;

public class OperacoesATermoPage extends BasePage implements OperacoesATermo {

    public void acessaPagina(){
        new Acessa().operacoesATermo();
        inserir();
    }

    @Override
    public DadosDeMovimentacaoAba dadosDaMovimentacao() {
        DadosDeMovimentacaoAba dadosDeMovimentacaoAba = new DadosDaMovimentacaoAbaImpl();
        dadosDeMovimentacaoAba.seleciona();
        return dadosDeMovimentacaoAba;
    }

    @Override
    public CustodiaAba custodia() {
        CustodiaAba custodiaAba = new CustodiaAbaImpl();
        custodiaAba.seleciona();
        return custodiaAba;
    }
}
