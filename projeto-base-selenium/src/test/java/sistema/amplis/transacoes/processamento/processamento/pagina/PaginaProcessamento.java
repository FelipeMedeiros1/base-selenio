package sistema.amplis.transacoes.processamento.processamento.pagina;

import webdriver.base.BasePagina;
import sistema.servicos.navegacao.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PaginaProcessamento extends BasePagina {
    //region
    @FindBy(id = "mainForm:j_id_1z:18:j_id_2w:0:j_id_2z:1:j_id_36")
    public WebElement processamento;
    @FindBy(id = "mainForm:functionPickList")
    public WebElement modulos;
    @FindBy(id = "mainForm:functionPickList:includeSelected")
    public WebElement incluirModulos;
    @FindBy(id = "mainForm:evaluationSituationPickList")
    public WebElement tipoDeProcessamento;
    @FindBy(id = "mainForm:evaluationSituationPickList:includeSelected")
    public WebElement incluirTipo;
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

    public void acessa() {
        new Acessa().transacoesProcessamento(processamento);
    }


}
