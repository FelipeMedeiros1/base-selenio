package sistema.amplis.transacoes.cadastropessoas.fundos.pagina;

import webdriver.base.Interagivel;
import sistema.servicos.navegacao.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaCadastroFundos extends Interagivel {
    //region
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:4:j_id_3z")
    static WebElement cadFundos;
    @FindBy(id = "mainForm:carteiraDropdownInput")
    private WebElement carteira;
    @FindBy(id = "mainForm:formaCondominioDropdown:campo")
    private WebElement condominio;
    @FindBy(id = "mainForm:classificacaoCarteiraDropdown:campo")
    private WebElement tipoFundos;

    //endregion
    public void acessa() {
        new Acessa().transacoesCadastroDePessoas(cadFundos);
        inserir();
    }
    public PaginaCadastroFundos carteira(String valor) {
        preencheAutoComplete(carteira, valor);
        inserir();
        esperaPor(1000);
        return this;
    }

    public PaginaCadastroFundos formaDeCondominio(String opcao) {
        selecionaUm(condominio, opcao);
        return this;
    }

    public PaginaCadastroFundos tipoDeFundos(String opcao) {
        selecionaUm(tipoFundos, opcao);
        return this;
    }

}
