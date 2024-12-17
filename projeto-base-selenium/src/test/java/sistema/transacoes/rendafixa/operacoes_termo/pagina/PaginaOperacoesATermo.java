package sistema.transacoes.rendafixa.operacoes_termo.pagina;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.base.BasePagina;

public class PaginaOperacoesATermo extends BasePagina {
    @FindBy(id = "mainForm:j_id_1z:8:j_id_2w:2:j_id_2z:2:j_id_36")
    public WebElement opTermo;
    private sistema.transacoes.rendafixa.operacoes_termo.pagina.DadosDaMovimentacaoAba dadosDeMovimentacaoAba;
    private sistema.transacoes.rendafixa.operacoes_termo.pagina.CustodiaAba custodiaAba;

    public sistema.transacoes.rendafixa.operacoes_termo.pagina.DadosDaMovimentacaoAba dadosDaMovimentacao() {
        if (dadosDeMovimentacaoAba == null) {
            dadosDeMovimentacaoAba = new sistema.transacoes.rendafixa.operacoes_termo.pagina.DadosDaMovimentacaoAba();
        }
        return dadosDeMovimentacaoAba;
    }


    public sistema.transacoes.rendafixa.operacoes_termo.pagina.CustodiaAba custodia() {
        if (custodiaAba == null) {
            custodiaAba = new sistema.transacoes.rendafixa.operacoes_termo.pagina.CustodiaAba();
        }
        return custodiaAba;
    }
}
