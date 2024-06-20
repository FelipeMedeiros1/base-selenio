package sistema.servicos.navegacao;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class NavegacaoTela {

//    public void navigateToPage(String navigationPath) {
//        String[] pathElements = navigationPath.split(" > ");
//
//        WebElement currentElement = getTransactionsElement();
//        navigateToDropdown(currentElement);
//
//        WebElement dropdownMenu = getDropdownMenuElement();
//        if (dropdownMenu != null) {
//            for (int i = 1; i < pathElements.length; i++) {
//                String elementText = pathElements[i];
//                currentElement = getDropdownElementFromMenuByLinkText(dropdownMenu, elementText);
//                if (currentElement != null) {
//                    navigateToDropdown(currentElement);
//                    dropdownMenu = getDropdownMenuElement();
//                }
//            }
//
//            String finalElementText = pathElements[pathElements.length - 1];
//            currentElement = getElementByXpathContainingOnClick(dropdownMenu, "//ul[@id='dropdownMenu']//li/a[contains(@onclick, '" + finalElementText + "')]");
//            if (currentElement != null) {
//                navigateToLink(currentElement);
//            } else {
//                throw new RuntimeException("Não foi possível encontrar o elemento de destino: " + finalElementText);
//            }
//        } else {
//            throw new RuntimeException("Não foi possível encontrar o dropdown menu.");
//        }
//    }
//
//    private WebElement getTransactionsElement() {
//        return getDriver().findElement(By.xpath("//*[@id='menuButtonSpan']"));
//    }
//
//    private WebElement getDropdownMenuElement() {
//        try {
//            return getDriver().findElement(By.xpath("//*[@id='0__ID']/div"));
//        } catch (NoSuchElementException e) {
//            return null;
//        }
//    }
//
//    private WebElement getDropdownElementFromMenuByLinkText(WebElement dropdownMenu, String text) {
//        List<WebElement> dropdownElements = dropdownMenu.findElements(By.xpath(".//a[contains(., '" + text + "')]"));
//        for (WebElement element : dropdownElements) {
//            if (element.getTagName().equalsIgnoreCase("a")) {
//                return element;
//            }
//        }
//        return null;
//    }
//
//    private WebElement getElementByXpathContainingOnClick(WebElement context, String xpath) {
//        try {
//            List<WebElement> elements = context.findElements(By.xpath(xpath));
//            for (WebElement element : elements) {
//                if (element.getAttribute("onclick").contains(xpath)) {
//                    return element;
//                }
//            }
//            return null;
//        } catch (NoSuchElementException e) {
//            return null;
//        }
//    }
//
//    private void navigateToDropdown(WebElement element) {
//        Actions actions = new Actions(getDriver());
//        waitForElementToBeClickable(element, 20);
//        actions.moveToElement(element).perform();
//    }
//
//    private void navigateToLink(WebElement element) {
//        Actions actions = new Actions(getDriver());
//        waitForElementToBeClickable(element, 20);
//        actions.click(element).perform();
//        waitForPageLoad(30);
//    }
//
//
//
//        private void waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), timeoutInSeconds);
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
//
//    private void waitForPageLoad(int timeoutInSeconds) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), timeoutInSeconds);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
//    }


//    private Actions actions;
//    public NavegacaoTela( ) {
//
//        this.actions = new Actions(getDriver());
//    }
//
//
//    private WebElement getTransactionsElement() {
//        return getDriver().findElement(By.xpath("//*[@id='menuButtonSpan']"));
//    }
//
//    private WebElement getDropdownMenuElement() {
//        try {
//            return getDriver().findElement(By.xpath("//*[@id='0__ID']/div"));
//        } catch (NoSuchElementException e) {
//            return null;
//        }
//    }
//
//    private WebElement getMenuElement(int index) {
//        try {
//            // Verifica se o elemento é um link
//            return getDriver().findElement(By.xpath(String.format("//*[@id='0__ID']/div[%d]/a", index + 1)));
//        } catch (NoSuchElementException e) {
//            // Verifica se o elemento é um cabeçalho (h4, h5 ou h6)
//            WebElement headerElement = getDriver().findElement(By.xpath(String.format("//*[@id='0__ID']/div[%d]/h4 | //*[@id='0__ID']/div[%d]/h5 | //*[@id='0__ID']/div[%d]/h6", index + 1, index + 1, index + 1)));
//            if (headerElement != null) {
//                System.out.println("Elemento " + headerElement.getText() + " é um cabeçalho");
//                return null;
//            }
//            // Caso não seja nem link nem cabeçalho, retorna null
//            return null;
//        }
//    }
//
//    public void navegarParaPagina(String navigationPath) {
//        String[] path = navigationPath.split(">");
//
//        WebElement transactionsElement = getTransactionsElement();
//        actions.moveToElement(transactionsElement).click().perform();
//
//        WebElement dropdownElement = getDropdownMenuElement();
//        if (dropdownElement != null) {
//            actions.moveToElement(dropdownElement).click().perform();
//        }
//
//        for (int i = 2; i < path.length; i++) {
//            WebElement menuElement = getMenuElement(i);
//            if (menuElement != null && menuElement.getTagName().equals("a")) {
//                // O elemento é um link, clique nele
//                actions.moveToElement(menuElement).click().perform();
//            } else {
//                // O elemento é um cabeçalho, apenas prossiga para o próximo
//                System.out.println("Elemento " + path[i] + " é um cabeçalho, ignorando...");
//            }
//        }
//    }


//  public void navegarParaPagina(String caminhoNavegacao) {
//        String[] elementos = caminhoNavegacao.split(" > ");
//
//        WebElement transactionsElement = getTransactionsElement();
//        esperaElementoSerClicavel(transactionsElement);
//        transactionsElement.click();
//
//        WebElement dropdownMenuElement = getDropdownMenuElement();
//        esperaElementoSerClicavel(dropdownMenuElement);
//
//        for (int i = 0; i < elementos.length; i++) {
//            WebElement menuElement = getMenuElement(i);
//            if (menuElement != null && menuElement.getText().equals(elementos[i])) {
//                menuElement.click();
//            } else {
//                System.out.println("Não foi possível encontrar o elemento: " + elementos[i]);
//                return;
//            }
//        }
//    }
//
//    private static WebElement getTransactionsElement() {
//        return getDriver().findElement(By.xpath("//*[@id='menuButtonSpan']"));
//    }
//
//    private WebElement getDropdownMenuElement() {
//        try {
//            return getDriver().findElement(By.xpath("//*[@id='0__ID']/div"));
//        } catch (NoSuchElementException e) {
//            return null;
//        }
//    }
//
//    private WebElement getMenuElement(int index) {
//        try {
//            // Verifica se o elemento é um link
//            return getDriver().findElement(By.xpath(String.format("//*[@id='0__ID']/div[%d]/a", index + 1)));
//        } catch (NoSuchElementException e) {
//            // Verifica se o elemento é um cabeçalho (h4, h5 ou h6)
//            WebElement headerElement = getDriver().findElement(By.xpath(String.format("//*[@id='0__ID']/div[%d]/h4 | //*[@id='0__ID']/div[%d]/h5 | //*[@id='0__ID']/div[%d]/h6", index + 1, index + 1, index + 1)));
//            if (headerElement != null) {
//                System.out.println("Elemento " + headerElement.getText() + " é um cabeçalho");
//                return null;
//            }
//            // Caso não seja nem link nem cabeçalho, retorna null
//            return null;
//        }
//    }
//}

    public void navegarParaPagina(String caminhoNavegacao) {
        String[] elementos = caminhoNavegacao.split(" > ");

        WebElement transactionsElement = getTransactionsElement();
//        esperaElementoSerClicavel(transactionsElement);
        transactionsElement.click();

        WebElement dropdownMenuElement = getDropdownMenuElement();
//        esperaElementoSerClicavel(dropdownMenuElement);

        for (int i = 0; i < elementos.length; i++) {
            WebElement menuElement = getMenuElement(i, elementos[i]);
            if (menuElement != null) {
                menuElement.click();
                // Adiciona um pequeno delay para garantir que a ação seja processada antes do próximo clique
                try {
                    Thread.sleep(500); // espera 500 milissegundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Não foi possível encontrar o elemento: " + elementos[i]);
                return;
            }
        }
    }

    private WebElement getTransactionsElement() {
        return getDriver().findElement(By.xpath("//*[@id='menuButtonSpan']"));
    }

    private WebElement getDropdownMenuElement() {
        try {
            return getDriver().findElement(By.xpath("//*[@id='0__ID']/div"));
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    private WebElement getMenuElement(int index, String expectedText) {
        try {
            // Verifica se o elemento é um link
            WebElement linkElement = getDriver().findElement(By.xpath(String.format("//*[@id='0__ID']/div[%d]/a", index + 1)));
            if (linkElement.getText().equals(expectedText)) {
                return linkElement;
            }
        } catch (NoSuchElementException e) {
            // Não encontrou o link, continua para verificar cabeçalhos
        }

        try {
            // Verifica se o elemento é um cabeçalho (h4, h5 ou h6)
            WebElement headerElement = getDriver().findElement(By.xpath(String.format("//*[@id='0__ID']/div[%d]/h4 | //*[@id='0__ID']/div[%d]/h5 | //*[@id='0__ID']/div[%d]/h6", index + 1, index + 1, index + 1)));
            System.out.println("Elemento " + headerElement.getText() + " é um cabeçalho");
            return null;
        } catch (NoSuchElementException e) {
            // Não encontrou o cabeçalho, retorna null
        }

        return null;
    }

//    public void esperaElementoSerClicavel(WebElement element) {
//        new Espera().esperaElementoSerClicavel(element);
//
//        // Aqui você pode adicionar uma espera explícita para garantir que o elemento seja clicável
//        // Exemplo:
//        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        // wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
}




