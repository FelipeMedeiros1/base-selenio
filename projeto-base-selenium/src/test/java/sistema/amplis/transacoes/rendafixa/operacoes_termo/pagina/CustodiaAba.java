package sistema.amplis.transacoes.rendafixa.operacoes_termo.pagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustodiaAba extends PaginaOperacoesATermo   {

    //region
    @FindBy(id = "mainForm:tab3:header")
    public WebElement custodia;
    @FindBy(id = "mainForm:custodian_dropdown:campo")
    public WebElement custodiante;
    @FindBy(id = "mainForm:custodyLocal_dropdown:campo")
    public WebElement localDeCustodia;
    @FindBy(id = "mainForm:custodyCheckingAccount_dropdown:campo")
    public WebElement contaDeCustodia;

    //endregion


}
