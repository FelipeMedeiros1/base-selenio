package webdriver.pages.transacoes.cadastro_pessoas.pessoa;

import webdriver.base.BasePage;
import webdriver.config.acesso.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PessoaPage extends BasePage {
    //region
    @FindBy(id = "mainForm:mnemonicTextField:campo")private WebElement cod;
    @FindBy(id = "mainForm:core_typeDropdown:campo")private WebElement seleciona;
    @FindBy(id = "mainForm:name_TextField:campo")private WebElement rzSocial;
    @FindBy(id = "mainForm:fantasy_name_TextField:campo")private WebElement nFantasia;
    @FindBy(id = "mainForm:cpf_cnpj_Ndocto_TextField:campo")private WebElement cnpj;
    @FindBy(id = "mainForm:site_Dropdown:campo")private WebElement loc;
    @FindBy(id = "mainForm:activitySector_Dropdown:campo")private WebElement sAtividade;
    @FindBy(id = "mainForm:accessibilityDropdown:campo")private WebElement status;
    //endregion

    public PessoaPage acessaPagina(){
        new Acessa().cadastroPessoas();
        inserir();
        return this;
    }
    public PessoaPage codigo(String valor){
        preenche(cod,valor);
        return this;
    }
    public PessoaPage tipoDaPessoa(String valor){
        selecionaUm(seleciona,valor);
        return this;
    }
    public PessoaPage razaoSocial(String valor){
        preenche(rzSocial,valor);
        return this;
    }
    public PessoaPage nomeFantasia(String valor){
        preenche(nFantasia,valor);
        return this;
    }
    public PessoaPage cnpj(String valor){
        preenche(cnpj,valor);
        return this;
    }
    public PessoaPage localidade(String valor){
        selecionaUm(loc,valor);
        return this;
    }
    public PessoaPage setorDeAtividade(String valor){
        selecionaUm(sAtividade,valor);
        return this;
    }
    public PessoaPage status(String valor){
        selecionaUm(status,valor);
        return this;
    }
}
