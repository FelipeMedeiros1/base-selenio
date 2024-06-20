package sistema.amplis.transacoes.cadastropessoas.renda_fixa.pagina;

import webdriver.base.Interagivel;
import sistema.servicos.navegacao.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaCadastroRendaFixa extends Interagivel {
    //region
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:2:j_id_3z")
    static WebElement cadRendaFixa;
    @FindBy(id = "mainForm:carteiraDropdownInput")private WebElement carteira;
    @FindBy(id = "mainForm:carteiraDropdownButton")private WebElement btn;
    //endregion
    public void acessa(){
        new Acessa().transacoesCadastroDePessoas(cadRendaFixa);
    }
    public void carteira(String valor){
        preencheAutoComplete(carteira, valor);

    }
    public NegociacaoAba negociacao(){
        NegociacaoAba negociacaoAba = new NegociacaoAba();
        negociacaoAba.seleciona();
        return negociacaoAba;
    }

 }
