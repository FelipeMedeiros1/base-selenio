package sistema.amplis.transacoes.rendafixa.operacoe_compromisadas.pagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.base.Interagivel;
import sistema.servicos.navegacao.Acessa;


public class PaginaOperacoesCompromissadas extends Interagivel {
    @FindBy(id = "mainForm:j_id_1z:8:j_id_2w:2:j_id_2z:3:j_id_36")
    private WebElement opCompromissadas;
    private DadosDaMovimentacaoAba dadosDaMovimentacao;
    private LastroDeCompraAba lastroDeCompra;
    private LastroDeVendaAba lastroDeVenda;


    public void acessa() {
        new Acessa().transacoesRendaFixa(opCompromissadas);
    }

    public DadosDaMovimentacaoAba dadosDaMovimentacao() {
        if (dadosDaMovimentacao == null) {
            dadosDaMovimentacao = new DadosDaMovimentacaoAba();
            dadosDaMovimentacao.seleciona();
        }
        return dadosDaMovimentacao;
    }

    public LastroDeCompraAba lastroDeCompra() {
        if (lastroDeCompra == null) {
            lastroDeCompra = new LastroDeCompraAba();
            lastroDeCompra.seleciona();
        }
        return lastroDeCompra;
    }

    public LastroDeVendaAba lastroDeVenda() {
        if (lastroDeVenda == null) {
            lastroDeVenda = new LastroDeVendaAba();
            lastroDeVenda.seleciona();
        }
        return lastroDeVenda;
    }

}
