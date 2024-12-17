package sistema.relatorios.renda_fixa.rendimentos.pagina;

import webdriver.base.BasePagina;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaRendimentos extends BasePagina {
    //region
    @FindBy(id = "mainForm:j_id_62:1:j_id_6n:1:j_id_82")
    public WebElement rendimentos;
    @FindBy(id = "mainForm:calendarDateBegin:campoInputDate")
    public WebElement dataInicial;
    @FindBy(id = "mainForm:calendarDateEnd:campoInputDate")
    public WebElement dataFinal;
    @FindBy(id = "mainForm:portfolioPickList")
    public WebElement carteira;
    @FindBy(id = "mainForm:reportExtension:campo")
    public WebElement saida;
    @FindBy(id = "mainForm:reportIdiom:campo")
    public WebElement idioma;
    @FindBy(id = "mainForm:moeda:campo")
    public WebElement moeda;

    //endregion


}
