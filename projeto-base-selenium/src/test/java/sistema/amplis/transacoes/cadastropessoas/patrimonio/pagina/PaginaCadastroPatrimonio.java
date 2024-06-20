package sistema.amplis.transacoes.cadastropessoas.patrimonio.pagina;

import webdriver.base.Interagivel;
import sistema.servicos.navegacao.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaCadastroPatrimonio extends Interagivel {
    //region
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:1:j_id_3z")
    static WebElement cadPatrimonio;
    @FindBy(id = "mainForm:carteiraDropdownInput")
    private WebElement carteira;
    @FindBy(id = "mainForm:valorCotaInicialTextField:campo")
    private WebElement cota;
    //endregion

    public void acessa() {
        new Acessa().transacoesCadastroDePessoas(cadPatrimonio);
        inserir();

    }

    public PaginaCadastroPatrimonio carteira(String valor) {
        preencheAutoComplete(carteira, valor);
        return this;
    }

    public PaginaCadastroPatrimonio valorDaCotaInicial(String valor) {
        preenche(cota, valor);
        return this;
    }
}
