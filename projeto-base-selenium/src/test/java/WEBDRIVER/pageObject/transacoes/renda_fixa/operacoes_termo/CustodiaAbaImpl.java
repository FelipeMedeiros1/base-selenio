package WEBDRIVER.pageObject.transacoes.renda_fixa.operacoes_termo;

import API.componente.Aba;
import API.componente.SelecionaUm;
import API.transacoes.renda_fixa.operacoes_termo.CustodiaAba;
import WEBDRIVER.base.basePage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustodiaAbaImpl extends BasePage implements CustodiaAba {

    //region
    @FindBy(id = "mainForm:tab3:header")
    private WebElement custodia;
    @FindBy(id = "mainForm:custodian_dropdown:campo")
    private WebElement custodiante;
    @FindBy(id = "mainForm:custodyLocal_dropdown:campo")
    private WebElement localDeCustodia;
    @FindBy(id = "mainForm:custodyCheckingAccount_dropdown:campo")
    private WebElement contaDeCustodia;

    //endregion
    @Override
    public Aba seleciona() {
        return selecionaAba(custodia);
    }

    @Override
    public SelecionaUm custodiante(String valor) {
        return selecionaUm(custodiante, valor);
    }

    @Override
    public SelecionaUm localDeCustodia(String valor) {
        return selecionaUm(localDeCustodia, valor);
    }

    @Override
    public SelecionaUm contaDeCustodia(String valor) {
        return selecionaUm(contaDeCustodia, valor);
    }

}
