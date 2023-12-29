package WEBDRIVER.pageObject.transacoes.processamento.processamento_contabil;

import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProcessamentoContabilPage extends BasePage {
    //region
    @FindBy(id = "mainForm:functionPickList:firstSelect")private WebElement varios;
    @FindBy(id = "mainForm:functionPickList:includeSelected")private WebElement incluirModulos;
    @FindBy(id = "mainForm:initialDateCalendar:campoInputDate")private WebElement inicio;
    @FindBy(id = "mainForm:finalDateCalendar:campoInputDate")private WebElement fim;
    @FindBy(id = "mainForm:portfolioMnemonicCriteria:criteriaOperator:campo")private WebElement filtro;
    @FindBy(id = "mainForm:portfolioMnemonicCriteria:criteriaInputText:campo")private WebElement carteira;
    @FindBy(id = "mainForm:dataTable1:0:processPortfolioCheckbox")private WebElement selecionaGrid ;


    //endregion

    public void acessaPaginaaProcessamentoContabil(){
        new Acessa().processamentoContabil();
    }
    public void modulos(String... valores){
        selecionaVarios(varios,valores);
    }
    public void dataInicial(String valor){
        preenche(inicio,valor);
    }
    public void dataFinal(String valor){
        preenche(fim,valor);
    }
    public void  carteira(String valor){
        selecionaUm(filtro,"Igual");
        preenche(carteira,valor);
    }
    public void executar(){
        confirmar();
        scrollParaBaixoAteEncontrar(selecionaGrid);
        selecionaGrid.click();
        confirmar();
        clicarBotaoOk();
        esperaPor(1000);


    }

}
