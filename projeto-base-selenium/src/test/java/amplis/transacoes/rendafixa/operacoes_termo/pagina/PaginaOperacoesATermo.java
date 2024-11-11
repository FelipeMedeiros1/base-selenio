package amplis.transacoes.rendafixa.operacoes_termo.pagina;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.base.BasePagina;

public class PaginaOperacoesATermo extends BasePagina {
    @FindBy(id = "mainForm:j_id_1z:8:j_id_2w:2:j_id_2z:2:j_id_36")
    public WebElement opTermo;
    private DadosDaMovimentacaoAba dadosDeMovimentacaoAba;
    private  CustodiaAba custodiaAba;

    public DadosDaMovimentacaoAba dadosDaMovimentacao() {
        if (dadosDeMovimentacaoAba == null) {
            dadosDeMovimentacaoAba = new DadosDaMovimentacaoAba();
        }
        return dadosDeMovimentacaoAba;
    }


    public CustodiaAba custodia() {
        if (custodiaAba == null) {
            custodiaAba = new CustodiaAba();
        }
        return custodiaAba;
    }
}
