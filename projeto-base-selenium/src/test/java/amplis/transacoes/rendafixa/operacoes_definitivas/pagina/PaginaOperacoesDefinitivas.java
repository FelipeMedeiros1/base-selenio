package amplis.transacoes.rendafixa.operacoes_definitivas.pagina;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.base.BasePagina;

public class PaginaOperacoesDefinitivas extends BasePagina {
    @FindBy(id = "mainForm:j_id_1z:8:j_id_2w:2:j_id_2z:1:j_id_36")
    public WebElement opDefinitivas;
    private DadosDaMovimentacaoAba dadosDaMovimentacao;

    public DadosDaMovimentacaoAba dadosDaMovimentacao() {
        if (dadosDaMovimentacao == null) {
            dadosDaMovimentacao = new DadosDaMovimentacaoAba();

        }
        return dadosDaMovimentacao;
    }
}
