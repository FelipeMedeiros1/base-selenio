package WEBDRIVER.pageObject.relatorios.renda_fixa;

import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RendimentosPage extends BasePage {
    //region
    @FindBy(id = "mainForm:calendarDateBegin:campoInputDate")private WebElement dataInicial;
    @FindBy(id = "mainForm:calendarDateEnd:campoInputDate")private WebElement dataFinal;
    @FindBy(id = "mainForm:portfolioPickList:firstSelect")private WebElement carteira;
    @FindBy(id = "mainForm:portfolioPickList:includeSelected")private WebElement incluir;
    @FindBy(id = "mainForm:reportExtension:campo")private WebElement saida;
    @FindBy(id = "mainForm:reportIdiom:campo")private WebElement idioma;
    @FindBy(id = "mainForm:moeda:campo")private WebElement moeda;

    //endregion

    public void acessarPaginaRelRendimentos(){ new Acessa().relRendimentosRendaFixa();}
    public void dataInicial(String valor){preenche(dataInicial,valor);}
    public void dataFinal(String valor){preenche(dataFinal,valor);}
    public void carteira(String valor){selecionaVarios(carteira,incluir,valor);}
    public void saida(String valor){selecionaUm(saida,valor);}
    public void idioma(String valor){selecionaUm(idioma,valor);}
    public void moeda(String valor){selecionaUm(moeda,valor);}

}
