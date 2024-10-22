package sistema.amplis.transacoes.rendafixa.operacoes_definitivas.pagina;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.base.BasePagina;
import sistema.servicos.navegacao.Acessa;

public class PaginaOperacoesDefinitivas extends BasePagina {
    @FindBy(id = "mainForm:j_id_1z:8:j_id_2w:2:j_id_2z:1:j_id_36")
    private WebElement opDefinitivas;
    private DadosDaMovimentacaoAba dadosDaMovimentacao;

    public void acessa() {
        new Acessa().transacoesRendaFixa(opDefinitivas);

    }
    public DadosDaMovimentacaoAba dadosDaMovimentacao() {
        if (dadosDaMovimentacao == null) {
            dadosDaMovimentacao = new DadosDaMovimentacaoAba();

        }
        return dadosDaMovimentacao;
    }
}
