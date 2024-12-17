package sistema.transacoes.rendafixa.operacoes_definitivas.pagina;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.base.BasePagina;

public class PaginaOperacoesDefinitivas extends BasePagina {

    private DadosDaMovimentacaoAba dadosDaMovimentacao;

    public DadosDaMovimentacaoAba dadosDaMovimentacao() {
        if (dadosDaMovimentacao == null) {
            dadosDaMovimentacao = new DadosDaMovimentacaoAba();

        }
        return dadosDaMovimentacao;
    }
}
