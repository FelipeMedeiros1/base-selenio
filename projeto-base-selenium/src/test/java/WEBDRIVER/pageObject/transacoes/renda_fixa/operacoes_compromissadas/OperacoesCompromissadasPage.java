package WEBDRIVER.pageObject.transacoes.renda_fixa.operacoes_compromissadas;

import API.transacoes.renda_fixa.operacoes_compromissadas.DadosDaMovimentacaoAba;
import API.transacoes.renda_fixa.operacoes_compromissadas.LastroDeCompraAba;
import API.transacoes.renda_fixa.operacoes_compromissadas.LastroDeVendaAba;
import API.transacoes.renda_fixa.operacoes_compromissadas.OperacoesCompromissadas;
import WEBDRIVER.base.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;


public class OperacoesCompromissadasPage extends BasePage implements OperacoesCompromissadas {
    private DadosDaMovimentacaoAba dadosDaMovimentacao;
    private LastroDeCompraAba lastroDeCompra;
    private LastroDeVendaAba lastroDeVenda;

    @Override
    public void acessaPagina() {
        new Acessa().operacoesCompromissadas();
    }
    @Override
    public DadosDaMovimentacaoAba dadosDaMovimentacao() {
        if (dadosDaMovimentacao == null) {
            dadosDaMovimentacao = new DadosDaMovimentacaoAbaImpl();
            dadosDaMovimentacao.seleciona();
        }
        return dadosDaMovimentacao;
    }
    @Override
    public LastroDeCompraAba lastroDeCompra() {
        if (lastroDeCompra == null) {
            lastroDeCompra = new LastroDeCompraAbaImpl();
            lastroDeCompra.seleciona();
        }
        return lastroDeCompra;
    }
    @Override
    public LastroDeVendaAba lastroDeVenda() {
        if (lastroDeVenda == null) {
            lastroDeVenda = new LastroDeVendaAbaImpl();
            lastroDeVenda.seleciona();
        }
        return lastroDeVenda;
    }

}
