package sistema.relatorios.patrimonio.carteira_diaria.pagina;

import webdriver.base.BasePagina;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaCarteiraDiaria extends BasePagina {
    //region
    @FindBy(id = "mainForm:j_id_62:2:j_id_6n:0:j_id_82")
    public WebElement carteiraDiaria;
    @FindBy(id = "mainForm:calendarDateBegin:campoInputDate")
    public WebElement dataInicio;
    @FindBy(id = "mainForm:calendarDateEnd:campoInputDate")
    public WebElement dataFinal;
    @FindBy(id = "mainForm:headerValuePositionType:excludeAll")
    public WebElement deseleciona;
    @FindBy(id = "mainForm:headerValuePositionType")
    public WebElement tipoDePosicao;
    @FindBy(id = "mainForm:headerValuePositionType:includeSelected")
    public WebElement incluir;
    @FindBy(id = "mainForm:tipoDeConsolidacao:campo")
    public WebElement tipoDeConsolidacao;
    @FindBy(id = "mainForm:tipoCustoMedio:campo")
    public WebElement custoMedio;
    @FindBy(id = "mainForm:portfolioPickList")
    public WebElement carteira;
    @FindBy(id = "mainForm:portfolioPickList:includeSelected")
    public WebElement incluirCarteira;
    @FindBy(id = "mainForm:tipoRelatorio:campo")
    public WebElement tipoDoRelatorio;
    @FindBy(id = "mainForm:saida:campo")
    public WebElement saida;

    //endregion

}
