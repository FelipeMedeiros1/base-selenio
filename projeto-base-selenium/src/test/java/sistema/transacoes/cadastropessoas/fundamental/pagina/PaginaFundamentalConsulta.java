package amplis.transacoes.cadastropessoas.fundamental.pagina;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaFundamentalConsulta extends PaginaFundamental {
    //region
    @FindBy(id = "mainForm:mnemonicCriteria:criteriaOperator:campo")
    public WebElement filtroConsulta;
    @FindBy(id = "mainForm:mnemonicCriteria:criteriaInputText:campo")
    public WebElement codigoConsulta;
    //endregion



}