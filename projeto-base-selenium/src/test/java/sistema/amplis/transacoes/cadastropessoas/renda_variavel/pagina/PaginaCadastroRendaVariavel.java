package sistema.amplis.transacoes.cadastropessoas.renda_variavel.pagina;

import webdriver.base.Interagivel;
import sistema.servicos.navegacao.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaCadastroRendaVariavel extends Interagivel {
    //region
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:3:j_id_3z")
    static WebElement cadRendaVariavel;
    @FindBy(id = "mainForm:carteiraDropdownInput")private WebElement caerteira;
    //endregion

    @Override
    public void acessa() {
        new Acessa().transacoesCadastroDePessoas(cadRendaVariavel);
        inserir();
    }

    public PaginaCadastroRendaVariavel carteira(String valor){
        preencheAutoComplete(caerteira,valor);
        return this;
    }


}
