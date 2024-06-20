package sistema.amplis.transacoes.cadastropessoas.renda_fixa.pagina;

import webdriver.componentes.Aba;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NegociacaoAba extends PaginaCadastroRendaFixa implements Aba {
    //region
    @FindBy(id = "mainForm:tab3:header")private WebElement negociacao;
    @FindBy(id = "mainForm:dataTable3:0:mtmDropdown:campo")private WebElement mtm;
    //endregion

    @Override
    public Aba seleciona() {
        return selecionaAba(negociacao);
    }

    public void mtm (String opcao){
        selecionaUm(mtm, opcao);
    }


}
