package test.java.lojinha.automacao;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.webdriver.base.BasePagina;

public class PaginaLojinha extends BasePagina {

    public PaginaLojinha() {
    }


    @FindBy(id = "produtonome")
    public WebElement nomeDoProduto;

    @FindBy(id = "produtovalor")
    public WebElement valorDoProduto;

    @FindBy(id = "produtocores")
    public WebElement coresDoProduto;


    @FindBy(id = "componentenomeadicionar")
    public WebElement nomeDoComponente;


    @FindBy(id = "componentequantidadeadicionar")
    public WebElement quantidadeComponente;

    @FindBy(id = "toast-container")
    public WebElement painelMensagem;

}
