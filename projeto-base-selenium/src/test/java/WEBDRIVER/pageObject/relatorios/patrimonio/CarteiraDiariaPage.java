package WEBDRIVER.pageObject.relatorios.patrimonio;

import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class CarteiraDiariaPage extends BasePage {
    //region
    @FindBy(id = "mainForm:calendarDateBegin:campoInputDate")private WebElement inicio;
    @FindBy(id = "mainForm:calendarDateEnd:campoInputDate")private WebElement fim;
    @FindBy(id = "mainForm:headerValuePositionType:excludeAll")private WebElement deseleciona;
    @FindBy(id = "mainForm:headerValuePositionType:firstSelect")private WebElement seleciona;
    @FindBy(id = "mainForm:headerValuePositionType:includeSelected")private WebElement incluir;
    @FindBy(id = "mainForm:tipoDeConsolidacao:campo")private WebElement consolidacao;
    @FindBy(id = "mainForm:tipoCustoMedio:campo")private WebElement custo;
    @FindBy(id = "mainForm:portfolioPickList:firstSelect")private WebElement carteira;
    @FindBy(id = "mainForm:portfolioPickList:includeSelected")private WebElement incluirCarteira;
    @FindBy(id = "mainForm:tipoRelatorio:campo")private WebElement tipoRelatorio;
    @FindBy(id = "mainForm:saida:campo")private WebElement saida;
    //endregion

    public void acessaPaginaCarteiraDiaria(){new Acessa().relCarteiraDiaria();}
    public void dataInicio(String valor){preenche(inicio,valor); esperaPor(1000);}
    public void dataFinal(String valor){
        preenche(fim,valor);
    }
    public void tipoDePosicao(String... valores){ deseleciona.click();selecionaVarios(seleciona,incluir,valores);}
    public void tipoDeConsolidacao(String valor){
        selecionaUm(consolidacao,valor);
    }
    public void custoMedio(String valor){
        selecionaUm(custo,valor);
    }
    public void carteira(String... valores){
        selecionaVarios(carteira,incluirCarteira,valores);
    }
    public void tipoDoRelatorio(String valor){
        selecionaUm(tipoRelatorio,valor);
    }
    public void saida(String valor){selecionaUm(saida,valor);}

}
