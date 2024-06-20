package sistema.amplis.transacoes.processamento.cockpit.pagina;

import webdriver.base.Interagivel;
import sistema.servicos.navegacao.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PaginaCockPit extends Interagivel {
    //region
    @FindBy(id = "mainForm:j_id_1z:18:j_id_2w:0:j_id_2z:4:j_id_36")
    public WebElement cockPit;
    @FindBy(id = "mainForm:dtCriteriaTextField:campoInputDate")
    public WebElement dataProcessamento;
    @FindBy(id = "mainForm:tipoPosicaoDropdown:campo")
    public WebElement tipoProcessamennto;
    @FindBy(id = "mainForm:mnemonicCriteria:criteriaOperator:campo")
    public WebElement filtroCarteira;
    @FindBy(id = "mainForm:mnemonicCriteria:criteriaInputText:campo")
    public WebElement carteira;
    @FindBy(id = "mainForm:statusCriteria:criteriaOperator:campo")
    public WebElement statusProcessamento;
    @FindBy(css = "#mainForm\\:clientTree\\:0\\:j_id_ah_2_5y > div > span.rf-trn-hnd-colps.rf-trn-hnd")
    public WebElement resultado;
    @FindBy(css = "#mainForm\\:clientTree\\:0\\.0\\:j_id_ah_2_67 > div > span.rf-trn-hnd-colps.rf-trn-hnd")
    public WebElement check;
    @FindBy(id = "mainForm:clientTree:0.0.0:dataTablePatrimonio:0:mensagensPatrimonio")
    public WebElement msg;
    //endregion

    public void acessa() {
        new Acessa().transacoesProcessamento(cockPit);
    }

    public void pesquisaResultado() {
        confirma();
        rolarParaBaixoAteEncontrar(resultado);
        esperaElementoSerClicavel(resultado);
        clicar(resultado);
        rolarParaBaixoAteEncontrar(check);
        clicar(check);
        rolarParaBaixoAteEncontrar(msg);

//        validaMensagem("Processamento realizado com sucesso.",msg);
    }
}
