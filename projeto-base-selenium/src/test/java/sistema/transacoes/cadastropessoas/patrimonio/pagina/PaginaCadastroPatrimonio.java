package sistema.transacoes.cadastropessoas.patrimonio.pagina;

import webdriver.base.BasePagina;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaCadastroPatrimonio extends BasePagina {
    //region
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:1:j_id_3z")
    public WebElement cadastroPatrimonio;
    @FindBy(id = "mainForm:carteiraDropdownInput")
    public WebElement carteira;
    @FindBy(id = "mainForm:valorCotaInicialTextField:campo")
    public WebElement valorDaCotaInicial;
    //endregion

}
