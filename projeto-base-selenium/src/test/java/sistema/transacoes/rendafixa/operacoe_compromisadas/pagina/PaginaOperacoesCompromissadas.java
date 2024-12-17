package sistema.transacoes.rendafixa.operacoe_compromisadas.pagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.base.BasePagina;


public class PaginaOperacoesCompromissadas extends BasePagina {

    public DadosDaMovimentacaoAba dadosDaMovimentacao;
    public LastroDeCompraAba lastroDeCompra;
    public LastroDeVendaAba lastroDeVenda;


    public DadosDaMovimentacaoAba dadosDaMovimentacao() {
        if (dadosDaMovimentacao == null) {
            dadosDaMovimentacao = new DadosDaMovimentacaoAba();
        }
        return dadosDaMovimentacao;
    }

    public LastroDeCompraAba lastroDeCompra() {
        if (lastroDeCompra == null) {
            lastroDeCompra = new  LastroDeCompraAba();
        }
        return lastroDeCompra;
    }

    public LastroDeVendaAba lastroDeVenda() {
        if (lastroDeVenda == null) {
            lastroDeVenda = new  LastroDeVendaAba();
        }
        return lastroDeVenda;
    }

}
