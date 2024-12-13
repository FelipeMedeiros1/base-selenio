package amplis.transacoes.cadastropessoas.rendaFixa.pagina;

import webdriver.base.BasePagina;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaCadastroRendaFixa extends BasePagina {
    //region
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:2:j_id_3z")
    public WebElement cadRendaFixa;
    @FindBy(id = "mainForm:carteiraDropdownInput")
    public WebElement carteira;
    @FindBy(id = "mainForm:carteiraDropdownButton")
    public WebElement btn;
    private NegociacaoAba negociacaoAba;

    //endregion

    public NegociacaoAba negociacao() {
        if (negociacaoAba == null) {
            negociacaoAba = new NegociacaoAba();
        }
        return negociacaoAba;
    }
}
