package WEBDRIVER.pageObject.transacoes.cadastro_pessoas.renda_fixa;

import WEBDRIVER.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NegociacaoAba extends BasePage {
    //region
    @FindBy(id = "mainForm:tab3:header")private WebElement negociacao;
    @FindBy(id = "mainForm:dataTable3:0:mtmDropdown:campo")private WebElement mtm;
    //endregion

    public NegociacaoAba negociacaoAba(){
        selecionaAba(negociacao);
        return this;
    }
    public NegociacaoAba mtm (String opcao){
        selecionaUm(mtm, opcao);
        return this;
    }
}
