package sistema.amplis.transacoes.rendafixa.operacoe_compromisadas.pagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.base.BasePagina;
import sistema.servicos.navegacao.Acessa;


public class PaginaOperacoesCompromissadas extends BasePagina {
    @FindBy(id = "mainForm:j_id_1z:8:j_id_2w:2:j_id_2z:3:j_id_36")
    private WebElement opCompromissadas;
    public DadosDaMovimentacaoAba dadosDaMovimentacao;
    public LastroDeCompraAba lastroDeCompra;
    public LastroDeVendaAba lastroDeVenda;


    public void acessa() {
        new Acessa().transacoesRendaFixa(opCompromissadas);
    }

    public DadosDaMovimentacaoAba dadosDaMovimentacao() {
        if (dadosDaMovimentacao == null) {
            dadosDaMovimentacao = new DadosDaMovimentacaoAba();

        }
        return dadosDaMovimentacao;
    }

    public LastroDeCompraAba lastroDeCompra() {
        if (lastroDeCompra == null) {
            lastroDeCompra = new LastroDeCompraAba();

        }
        return lastroDeCompra;
    }

    public LastroDeVendaAba lastroDeVenda() {
        if (lastroDeVenda == null) {
            lastroDeVenda = new LastroDeVendaAba();

        }
        return lastroDeVenda;
    }

}
