package sistema.amplis.transacoes.cadastropessoas.fundamental.pagina;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sistema.servicos.navegacao.Acessa;
import webdriver.base.Interagivel;

public class PaginaFundamentalConsulta extends PaginaFundamental {
    //region
    @FindBy(id = "mainForm:mnemonicCriteria:criteriaOperator:campo")
    public WebElement filtroConsulta;
    @FindBy(id = "mainForm:mnemonicCriteria:criteriaInputText:campo")
    public WebElement codigoConsulta;
    //endregion


    public void acessaConsulta() {
        new Acessa().transacoesCadastroDePessoas(fundamental);
    }

}