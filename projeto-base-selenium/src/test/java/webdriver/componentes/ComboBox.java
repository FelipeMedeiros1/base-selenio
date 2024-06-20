package webdriver.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class ComboBox   {

    public void seleciona(WebElement element, String valor) {
        new Select(element).selectByVisibleText(valor);
        new Espera().esperaPor(1000);

    }

    public void seleciona(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
        String valorAtual = combo.getFirstSelectedOption().getText();
        new Espera().esperaPor(1500);
        if (valorAtual.equals(valor)) {
            throw new RuntimeException("O texto não foi persistido corretamente.");
        }
    }

    public String[] selecionaVarios(WebElement element, String... valores) {
        element.click();
        Select combo = new Select(element);

        combo.deselectAll();
        new Actions(getDriver()).keyDown(Keys.CONTROL);

        for (String valor : valores) {
            combo.selectByVisibleText(valor);
        }
        return valores;
    }

    public String[] selecionaVarios(String id, String... valores) {
        WebElement element = getDriver().findElement(By.id(id));
        element.click();
        Select combo = new Select(element);

        combo.deselectAll();
        new Actions(getDriver()).keyDown(Keys.CONTROL);

        for (String valor : valores) {
            combo.selectByVisibleText(valor);
        }
        return valores;
    }


    public void deseleciona(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);
    }

    public void deseleciona(WebElement element, String value) {
        new Select(element).deselectByVisibleText(value);
    }

    public String obterValor(WebElement element) {
        return new Select(element).getFirstSelectedOption().getText();
    }

    public String obterValor(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public List<String> obterValores(WebElement element) {
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for (WebElement option : allSelectedOptions) {
            valores.add(option.getText());
        }
        return valores;
    }

    public List<String> obterValores(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for (WebElement opcao : allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }


    public void selecionaTodos(WebElement selecionaTodos) {
        selecionaTodos.click();
    }


    public void selecionaTodos() {
        By selector = By.cssSelector("[id$='includeAll']");
        WebElement elemento = getDriver().findElement(selector);
        elemento.click();
    }
    public void deselecionaTodos() {
        By selector = By.cssSelector("[id$='excludeAll']");
        WebElement elemento = getDriver().findElement(selector);
        elemento.click();
    }
    public void incluirSelecionados() {
        By selector = By.cssSelector("[id$='includeSelected']");
        WebElement elemento = getDriver().findElement(selector);
        elemento.click();
    }


    public int obterQuantidadeOpcoes(WebElement element) {
        List<WebElement> options = new Select(element).getOptions();
        return options.size();
    }

    public int obterQuantidadeOpcoes(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> opcoes = combo.getOptions();
        return opcoes.size();
    }

    public boolean verificarOpcaoCombo(String id, String opcao) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> opcoes = combo.getOptions();
        for (WebElement opt : opcoes) {
            if (opt.getText().equals(opcao)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarOpcaoCombo(WebElement element, String opcao) {
        List<WebElement> options = new Select(element).getOptions();
        for (WebElement opt : options) {
            if (opt.getText().equals(opcao)) {
                return true;
            }
        }
        return false;
    }


}
