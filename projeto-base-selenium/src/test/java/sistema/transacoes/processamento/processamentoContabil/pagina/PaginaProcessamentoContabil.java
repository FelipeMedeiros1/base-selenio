package sistema.transacoes.processamento.processamentoContabil.pagina;

import webdriver.base.BasePagina;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaProcessamentoContabil extends BasePagina {
    //region
    @FindBy(id = "mainForm:j_id_1z:18:j_id_2w:2:j_id_2z:0:j_id_36")
    public WebElement processamentoContabil;
    @FindBy(id = "mainForm:functionPickList")
    public WebElement modulos;
    @FindBy(id = "mainForm:functionPickList:includeSelected")
    public WebElement incluirModulos;
    @FindBy(id = "mainForm:initialDateCalendar:campoInputDate")
    public WebElement dataInicial;
    @FindBy(id = "mainForm:finalDateCalendar:campoInputDate")
    public WebElement dataFinal;
    @FindBy(id = "mainForm:portfolioMnemonicCriteria:criteriaOperator:campo")
    public WebElement filtroCarteira;
    @FindBy(id = "mainForm:portfolioMnemonicCriteria:criteriaInputText:campo")
    public WebElement carteira;
    @FindBy(id = "mainForm:dataTable1:0:processPortfolioCheckbox")
    public WebElement selecionaGrid;
    //endregion

}
