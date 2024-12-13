package amplis.transacoes.cadastropessoas.pessoa.pagina;

import webdriver.base.BasePagina;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaPessoa extends BasePagina {
    //region
    @FindBy(id = "mainForm:j_id_1z:6:j_id_2w:0:j_id_5b")
    public WebElement pessoas;
    @FindBy(id = "mainForm:mnemonicTextField:campo")
    public WebElement codigo;
    @FindBy(id = "mainForm:core_typeDropdown:campo")
    public WebElement tipoDaPessoa;
    @FindBy(id = "mainForm:name_TextField:campo")
    public WebElement razaoSocial;
    @FindBy(id = "mainForm:fantasy_name_TextField:campo")
    public WebElement nomeFantasia;
    @FindBy(id = "mainForm:cpf_cnpj_Ndocto_TextField:campo")
    public WebElement cnpjCpf;
    @FindBy(id = "mainForm:site_Dropdown:campo")
    public WebElement localidade;
    @FindBy(id = "mainForm:activitySector_Dropdown:campo")
    public WebElement setorDeAtividade;
    @FindBy(id = "mainForm:accessibilityDropdown:campo")
    public WebElement status;
    //endregion

}
