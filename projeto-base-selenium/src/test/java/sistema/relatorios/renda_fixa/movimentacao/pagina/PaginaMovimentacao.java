package sistema.relatorios.renda_fixa.movimentacao.pagina;

import webdriver.base.BasePagina;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaMovimentacao extends BasePagina {
    //region
    @FindBy(id = "mainForm:j_id_62:1:j_id_6n:0:j_id_82")
    public WebElement movimentacao;
    @FindBy(id = "mainForm:calendarDateBegin:campoInputDate")
    public WebElement dataInicio;
    @FindBy(id = "mainForm:calendarDateEnd:campoInputDate")
    public WebElement dataFinal;
    @FindBy(id = "mainForm:modalityPickList")
    public WebElement modalidadeDeMovimento;
    @FindBy(id = "mainForm:security_dropdown:campo")
    public WebElement titulo;
    @FindBy(id = "mainForm:issue_dropdown:campo")
    public WebElement emissao;
    @FindBy(id = "mainForm:portfolioPickList")
    public WebElement carteira;
    @FindBy(id = "mainForm:reportExtension:campo")
    public WebElement saida;
    @FindBy(id = "mainForm:reportIdiom:campo")
    public WebElement idioma;
    @FindBy(id = "mainForm:reportCurrency:campo")
    public WebElement moeda;
    @FindBy(id = "mainForm:reportType:campo")
    public WebElement tipoRelatorio;

    //endregion

}
