package amplis.transacoes.cadastropessoas.fundos.pagina;

import webdriver.base.BasePagina;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaCadastroFundos extends BasePagina {
    //region
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:4:j_id_3z")
    public WebElement cadastroFundos;
    @FindBy(id = "mainForm:carteiraDropdownInput")
    public WebElement carteira;
    @FindBy(id = "mainForm:formaCondominioDropdown:campo")
    public WebElement formaDeCondominio;
    @FindBy(id = "mainForm:classificacaoCarteiraDropdown:campo")
    public WebElement tipoDeFundos;

    //endregion



}
