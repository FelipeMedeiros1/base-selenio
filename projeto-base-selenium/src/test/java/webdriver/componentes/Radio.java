package webdriver.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

/**
 * Classe utilitária para manipular elementos de rádio em testes automatizados.
 * <p>
 * Fornece métodos para selecionar e verificar se um elemento de rádio está selecionado.
 */
public class Radio {
    /**
     * Seleciona um elemento de rádio.
     *
     * @param element O elemento de rádio a ser selecionado.
     */
    public void seleciona(WebElement element) {
        element.click();
    }

    /**
     * Seleciona um elemento de rádio.
     *
     * @param id O elemento de rádio a ser selecionado.
     */
    public void seleciona(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    /**
     * Verifica se um elemento de rádio está selecionado.
     *
     * @param element O elemento de rádio a ser verificado.
     * @return True se o elemento estiver selecionado, false caso contrário.
     */
    public boolean estaSelecionado(WebElement element) {
        return element.isSelected();
    }

    /**
     * Verifica se um elemento de rádio está selecionado.
     *
     * @param id O elemento de rádio a ser verificado.
     * @return True se o elemento estiver selecionado, false caso contrário.
     */
    public boolean estaSelecionado(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }


}
