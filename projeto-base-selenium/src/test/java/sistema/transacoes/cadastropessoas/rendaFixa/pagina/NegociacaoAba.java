package amplis.transacoes.cadastropessoas.rendaFixa.pagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NegociacaoAba extends PaginaCadastroRendaFixa {
    //region
    @FindBy(id = "mainForm:tab3:header")
    public WebElement negociacao;
    @FindBy(id = "mainForm:dataTable3:0:mtmDropdown:campo")
    public WebElement mtm;
    //endregion
}
