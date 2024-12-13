package webdriver.base.navegacao.automacao;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.componentes.Espera;
import webdriver.componentes.JsExecutor;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class NavDinamica {

//    public static void navegarParaPagina(String navegacao) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
//
//        List<String> partes = Arrays.asList(navegacao.split(">\\s*"));
//
//
//        String menuText = partes.get(0).trim();
//        String moduloText = partes.get(1).trim();
//        String penultimoTexto = partes.get(partes.size() - 2).trim();
//        String pagina = partes.get(partes.size() - 1).trim();
//
//        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@id, 'menu')]/span[contains(text(), '" + menuText + "')]")));
////        new JsExecutor().rolarParaBaixoAteEncontrar(menu);
////        new Espera().esperaElementoSerClicavel(menu);
////        new Actions(getDriver()).moveToElement(menu).perform();
//
//
////        WebElement moduloElement = getDriver().findElement(By.xpath("//a[(text()='" + moduloText + "' or @title='" + moduloText + "')]")) || getDriver().findElement(By.xpath("//a[contains(@title, '" + moduloText + "') or contains(text(), '" + moduloText + "')]");
//
//        String xpathExpression = "//a[(text()='" + moduloText + "' or @title='" + moduloText + "') or contains(@title, '" + moduloText + "') or contains(text(), '" + moduloText + "')]";
//
//        WebElement moduloElement = getDriver().findElement(By.xpath(xpathExpression));
//
//
//        if (partes.size() > 3) {
//            WebElement proximoElemento = getDriver().findElement(By.xpath("//*[contains(text(), '" + penultimoTexto + "')]/following-sibling::*"));
//            new Botao().clickActions(menu, moduloElement, proximoElemento);
//
//        } else {
//            WebElement subModuloElement = getDriver().findElement(By.xpath("//a[(text()='" + pagina + "' or @title='" + pagina + "')]"));
//            new Botao().clickActions(menu, moduloElement, subModuloElement);
//
//        }
//
//
//    }


//    public static void navegarParaPagina(String navegacao) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60)); // Aumente o tempo de espera
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
//
//        List<String> partes = Arrays.asList(navegacao.split(">\\s*"));
//
//        String menuText = partes.get(0).trim();
//        String moduloText = partes.get(1).trim();
//        String penultimoTexto = partes.get(partes.size() - 2).trim();
//        String pagina = partes.get(partes.size() - 1).trim();
//
//        // Use ExpectedConditions.elementToBeClickable para garantir que o elemento seja clicável
//        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[starts-with(@id, 'menu')]/span[contains(text(), '" + menuText + "')]")));
//
//        // Rolar para baixo até encontrar o elemento menu
////        new JsExecutor().rolarParaBaixoAteEncontrar(menu);
//
//        // Esperar o elemento menu ser clicável
//        new Espera().esperaElementoSerClicavel(menu);
//
//        // Encontrar o elemento modulo
//        String xpathExpression = "//a[(text()='" + moduloText + "' or @title='" + moduloText + "') or contains(@title, '" + moduloText + "') or contains(text(), '" + moduloText + "')]";
//        WebElement moduloElement = getDriver().findElement(By.xpath(xpathExpression));
//
//        if (partes.size() > 3) {
//            // Encontrar o próximo elemento
//            WebElement proximoElemento = getDriver().findElement(By.xpath("//*[contains(text(), '" + penultimoTexto + "')]/following-sibling::*"));
//             clickActions(menu, moduloElement, proximoElemento); // Clique no proximoElemento
//
//        } else {
//            // Encontrar o submódulo
//            WebElement subModuloElement = getDriver().findElement(By.xpath("//a[(text()='" + pagina + "' or @title='" + pagina + "')]"));
//            clickActions(menu, moduloElement, subModuloElement); // Clique no subModuloElement
//        }
//    }
//
//    public static void clickActions(WebElement menu, WebElement modulo, WebElement pagina) {
//        Actions acoes = new Actions(getDriver());
//        Espera espera = new Espera();
//        espera.esperaElementoSerClicavel(menu);
//        acoes.moveToElement(menu).perform();
//        acoes.moveToElement(modulo).perform();
//        acoes.click(pagina).perform(); // Clique no elemento pagina
//        espera.esperaPor(1500);
//    }

//    public static void navegarParaPagina(String navegacao) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60)); // Aumente o tempo de espera
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
//
//        List<String> partes = Arrays.asList(navegacao.split(">\\s*"));
//
//        String menuText = partes.get(0).trim();
//        String moduloText = partes.get(1).trim();
//        String penultimoTexto = partes.get(partes.size() - 2).trim();
//        String pagina = partes.get(partes.size() - 1).trim();
//
//        // Use ExpectedConditions.elementToBeClickable para garantir que o elemento seja clicável
//        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[starts-with(@id, 'menu')]/span[contains(text(), '" + menuText + "')]")));
//
//        // Rolar para baixo até encontrar o elemento menu
//        new JsExecutor().rolarParaBaixoAteEncontrar(menu);
//
//         
//        new Espera().esperaElementoSerClicavel(menu);
//
//        // Clicar no elemento menu
//
//        new Actions(getDriver()).moveToElement(menu).perform();
//
//        // Encontrar o elemento modulo
//        String xpathExpression = "//a[(text()='" + moduloText + "' or @title='" + moduloText + "') or contains(@title, '" + moduloText + "') or contains(text(), '" + moduloText + "')]";
//        WebElement moduloElement = getDriver().findElement(By.xpath(xpathExpression));
//
//        // Clicar no elemento modulo
//
//        new Actions(getDriver()).moveToElement(moduloElement).perform();
//
//        if (partes.size() > 3) {
//            WebElement proximoElemento = getDriver().findElement(By.xpath("//*[contains(text(), '" + penultimoTexto + "')]/following-sibling::*"));
//            new Actions(getDriver()).moveToElement(proximoElemento).perform();
//            // Clicar no elemento proximoElemento
//            new Actions(getDriver()).click(proximoElemento).perform();
//        } else {
//            WebElement subModuloElement = getDriver().findElement(By.xpath("//a[(text()='" + pagina + "' or @title='" + pagina + "')]"));
//            new Actions(getDriver()).click(subModuloElement).perform();
//        }
//
//    }
//public static void navegarParaPagina(String navegacao) {
//    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60)); // Aumente o tempo de espera
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
//
//    List<String> partes = Arrays.asList(navegacao.split(">\\s*"));
//
//    String menuText = partes.get(0).trim();
//    String moduloText = partes.get(1).trim();
//    String penultimoTexto = partes.get(partes.size() - 2).trim();
//    String pagina = partes.get(partes.size() - 1).trim();
//
//    // Use ExpectedConditions.elementToBeClickable para garantir que o elemento seja clicável
//    WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[starts-with(@id, 'menu')]/span[contains(text(), '" + menuText + "')]")));
//
//    // Rolar para baixo até encontrar o elemento menu
//    new JsExecutor().rolarParaBaixoAteEncontrar(menu);
//
//    // Esperar o elemento menu ser clicável
//    new Espera().esperaElementoSerClicavel(menu);
//
//    // Clicar no elemento menu
//    new Actions(getDriver()).moveToElement(menu).perform();
//    menu.click();
//
//    // Encontrar o elemento modulo
//    String xpathExpression = "//a[(text()='" + moduloText + "' or @title='" + moduloText + "') or contains(@title, '" + moduloText + "') or contains(text(), '" + moduloText + "')]";
//    WebElement moduloElement = getDriver().findElement(By.xpath(xpathExpression));
//
//    // Clicar no elemento modulo
//    new Actions(getDriver()).moveToElement(moduloElement).perform();
//    moduloElement.click();
//
//    if (partes.size() > 3) {
//        // Encontrar o próximo elemento
//        WebElement proximoElemento = null;
//        try {
//            proximoElemento = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), '" + penultimoTexto + "')]/following-sibling::*")));
//        } catch (Exception e) {
//            // Se o elemento não for encontrado, não faça nada
//        }
//
//        if (proximoElemento != null) {
//            // Mover o mouse para o proximoElemento
//            new Actions(getDriver()).moveToElement(proximoElemento).perform();
//            // Clicar no elemento proximoElemento
//            new Actions(getDriver()).click(proximoElemento).perform();
//        }
//    } else {
//        // Encontrar o submódulo
//        WebElement subModuloElement = null;
//        try {
//            subModuloElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[(text()='" + pagina + "' or @title='" + pagina + "')]")));
//        } catch (Exception e) {
//            // Se o elemento não for encontrado, não faça nada
//        }
//
//        if (subModuloElement != null) {
//            // Clicar no elemento subModuloElement
//            new Actions(getDriver()).click(subModuloElement).perform();
//        }
//    }
//}

    public static void navegarParaPagina1(String navegacao) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));  
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        List<String> partes = Arrays.asList(navegacao.split(">\\s*"));

        String menuTexto = partes.get(0).trim();
        String moduloTexto = partes.get(1).trim();
        String penultimoTexto = partes.get(partes.size() - 2).trim();
        String pagina = partes.get(partes.size() - 1).trim();

         
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[starts-with(@id, 'menu')]/span[contains(text(), '" + menuText + "')]")));
       
        new JsExecutor().rolarParaBaixoAteEncontrar(menu);
        new Espera().esperaElementoSerClicavel(menu);
        new Actions(getDriver()).moveToElement(menu).perform();
 
        String xpathExpression = "//a[(text()='" + moduloText + "' or @title='" + moduloText + "') or contains(@title, '" + moduloText + "') or contains(text(), '" + moduloText + "')]";
        WebElement moduloElement = getDriver().findElement(By.xpath(xpathExpression));
 
        new Actions(getDriver()).moveToElement(moduloElement).perform();

        getChildrens();
        List<WebElement> elementosList = getChildrens();
        for (WebElement elemento : elementosList) {
            try {
                WebElement el = elemento.findElement(By.tagName("a"));
                if (el.getAttribute("onclick").contains(pagina)) {
                    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", el);
                    wait.until(ExpectedConditions.urlContains(pagina));
                    new Espera().esperaAjaxTerminar();
                    break;
                }
            } catch (Exception e) {

            }
        }


//        if (partes.size() > 3) {
//            WebElement proximoElemento = getDriver().findElement(By.xpath("//*[contains(text(), '" + penultimoTexto + "')]/following-sibling::*"));
//            new Actions(getDriver()).moveToElement(proximoElemento).perform();
//            // Clicar no elemento proximoElemento
//            new Actions(getDriver()).click(proximoElemento).perform();
//        } else {
//            // Encontrar o último elemento (página) usando o id
//            WebElement ultimoElemento = wait.until(ExpectedConditions.elementToBeClickable(By.id("mainForm:j_id_1z:16:j_id_2w:13:j_id_2z:0:j_id_36")));
//
//            // Clicar no último elemento
//            new Actions(getDriver()).click(ultimoElemento).perform();
//        }
    }

    public static List<WebElement> getChildrens() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        // Localiza o último elemento pai visível e clicável
        WebElement ultimoElemento = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("..")));

        // Aguarda e retorna todos os elementos filhos <li>
        return wait.until(driver -> {
            List<WebElement> elements = ultimoElemento.findElements(By.tagName("li"));
            return elements.isEmpty() ? null : elements; // Retorna null para aguardar se vazio
        });
    }



//    public static void navegarParaPagina(String navegacao) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60)); // Aumente o tempo de espera
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
//
//        List<String> partes = Arrays.asList(navegacao.split(">\\s*"));
//
//        String menuText = partes.get(0).trim();
//        String moduloText = partes.get(1).trim();
//        String penultimoTexto = partes.get(partes.size() - 2).trim();
//        String pagina = partes.get(partes.size() - 1).trim();
//
//        // Use ExpectedConditions.elementToBeClickable para garantir que o elemento seja clicável
//        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[starts-with(@id, 'menu')]/span[contains(text(), '" + menuText + "')]")));
//
//        // Rolar para baixo até encontrar o elemento menu
//        new JsExecutor().rolarParaBaixoAteEncontrar(menu);
//
//        // Esperar o elemento menu ser clicável
//        new Espera().esperaElementoSerClicavel(menu);
//
//        // Clicar no elemento menu
//        new Actions(getDriver()).moveToElement(menu).perform();
//
//        // Encontrar o elemento modulo
//        String xpathExpression = "//a[(text()='" + moduloText + "' or @title='" + moduloText + "') or contains(@title, '" + moduloText + "') or contains(text(), '" + moduloText + "')]";
//        WebElement moduloElement = getDriver().findElement(By.xpath(xpathExpression));
//
//        // Clicar no elemento modulo
//        new Actions(getDriver()).moveToElement(moduloElement).perform();
//
//        if (partes.size() > 3) {
//            WebElement proximoElemento = getDriver().findElement(By.xpath("//*[contains(text(), '" + penultimoTexto + "')]/following-sibling::*"));
//            new Actions(getDriver()).moveToElement(proximoElemento).perform();
//            // Clicar no elemento proximoElemento
//            new Actions(getDriver()).click(proximoElemento).perform();
//        } else {
//            // Encontrar o último elemento (página) usando XPath e ExpectedConditions.elementToBeClickable
//            WebElement ultimoElemento = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), '" + pagina + "')]")));
//
//            // Clicar no último elemento
//            new Actions(getDriver()).click(ultimoElemento).perform();
//        }
//    }

//    public static void navegarParaPagina(String navegacao) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60)); // Aumente o tempo de espera
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
//
//        List<String> partes = Arrays.asList(navegacao.split(">\\s*"));
//
//        // Encontrar o menu
//        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[starts-with(@id, 'menu')]/span[contains(text(), '" + partes.get(0).trim() + "')]")));
//
//        // Rolar para baixo até encontrar o elemento menu
//        new JsExecutor().rolarParaBaixoAteEncontrar(menu);
//
//        // Esperar o elemento menu ser clicável
//        new Espera().esperaElementoSerClicavel(menu);
//
//        // Clicar no elemento menu
//        new Actions(getDriver()).moveToElement(menu).perform();
//
//        // Percorrer a lista de elementos a partir da segunda posição
//        for (int i = 1; i < partes.size(); i++) {
//            String elementoText = partes.get(i).trim();
//
//            // Encontrar o elemento na lista
//            WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), '" + elementoText + "')]")));
//
//            // Clicar no elemento
//            new Actions(getDriver()).click(elemento).perform();
//        }
//    }

    public static void navegarParaPagina(String navegacao) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));

        // Aguarda até que o body esteja visível para garantir que a página carregou
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        // Divide a string de navegação em partes
        List<String> partes = Arrays.asList(navegacao.split(">\\s*"));

        String menuText = partes.get(0).trim();
        String moduloText = partes.get(1).trim();
        String pagina = partes.get(partes.size() - 1).trim();

        // Localiza o menu principal e aguarda até ser clicável
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[starts-with(@id, 'menu')]/span[contains(text(), '" + menuText + "')]")));

        // Clica no menu usando uma ação segura
        menu.click();

        // Localiza o módulo associado e aguarda até ser clicável
        WebElement moduloElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[(text()='" + moduloText + "' or @title='" + moduloText + "') or contains(@title, '" + moduloText + "') or contains(text(), '" + moduloText + "')]")));

        // Clica no módulo
        moduloElement.click();

        // Obtém os elementos filhos e busca o elemento da página desejada
        List<WebElement> elementosList = getChildrens();
        for (WebElement elemento : elementosList) {
            try {
                WebElement linkElement = elemento.findElement(By.tagName("a"));
                if (linkElement.getAttribute("onclick") != null && linkElement.getAttribute("onclick").contains(pagina)) {
                    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", linkElement);
                    wait.until(ExpectedConditions.urlContains(pagina));
                    break;
                }
            } catch (Exception e) {
                // Tratamento simples de exceções para elementos que não possuem os atributos esperados
                System.out.println("Elemento não encontrado ou não clicável: " + e.getMessage());
            }
        }
    }

}
