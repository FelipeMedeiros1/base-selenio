package sistema.amplis.transacoes.fundos.movimentacao.pagina;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sistema.servicos.navegacao.Acessa;

public class PaginaMovimentacaoConsulta extends PaginaMovimentacao {
    //region
    @FindBy(id = "mainForm:carteiraCriteria:criteriaOperator:campo")
    public WebElement filtroCarteira;


    @FindBy(id = "mainForm:carteiraCriteria:criteriaInputText:campo")
    public WebElement carteiraConsulta;

    //endregion

    public void acessaConsulta() {
        new Acessa().transacoesFundos(movimentacao);

    }
}
