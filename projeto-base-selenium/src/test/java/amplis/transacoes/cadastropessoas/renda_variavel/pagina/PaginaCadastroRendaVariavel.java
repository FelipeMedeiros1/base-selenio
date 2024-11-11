package amplis.transacoes.cadastropessoas.renda_variavel.pagina;

import webdriver.base.BasePagina;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaCadastroRendaVariavel extends BasePagina {
    //region
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:3:j_id_3z")
    static WebElement cadRendaVariavel;
    @FindBy(id = "mainForm:carteiraDropdownInput")
    static WebElement caerteira;
    //endregion

}
