package sistema.amplis.transacoes.cadastrobasico.moedas.pagina;


import webdriver.base.BasePagina;
import sistema.servicos.navegacao.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaMoedas extends BasePagina {
    //region
    @FindBy(id = "mainForm:j_id_1z:3:j_id_2w:4:j_id_5b")
    public WebElement moedas;
    @FindBy(id = "mainForm:mnemonicTextField:campo")
    public WebElement codigo;
    @FindBy(id = "mainForm:nameTextField:campo")
    public WebElement nome;
    @FindBy(id = "mainForm:symbolTextField:campo")
    public WebElement simbolo;
    @FindBy(id = "mainForm:statusDropdown:campo")
    public WebElement status;
    //endregion
    private PaginaMoedasConsulta consulta;

    @Override
    public void acessa() {
        new Acessa().transacoesCadastroBasico(moedas);
    }

    public PaginaMoedasConsulta consulta() {
        if (consulta == null) {
            consulta = new PaginaMoedasConsulta();
        }
        return consulta;
    }


}
