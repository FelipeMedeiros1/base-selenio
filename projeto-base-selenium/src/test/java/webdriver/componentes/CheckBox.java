package webdriver.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static utils.LogUtil.info;
import static webdriver.fabrica.FabricaDeDriver.getDriver;

/**
 * Classe responsável por interagir com checkboxes em testes automatizados.
 *
 * <p>Essa classe fornece métodos para selecionar e deselecionar checkboxes,
 * verificar se um checkbox está selecionado e esperar até que um checkbox
 * esteja selecionado.</p>
 */
public class CheckBox {
    private final Espera espera = new Espera();

    /**
     * Seleciona ou deseleciona um checkbox, com base no valor booleano fornecido.
     *
     * <p>Esse método verifica se o checkbox já está no estado desejado.
     * Se não estiver, ele clica no checkbox para alterá-lo para o estado
     * desejado. O método também espera que o AJAX termine antes de clicar
     * no checkbox e espera por 1 segundo após o clique.</p>
     *
     * @param elemento O elemento checkbox.
     * @param boleano  `true` para selecionar o checkbox, `false` para deselecionar.
     * @return `false` (o método não retorna um valor significativo).
     */
    public boolean seleciona(WebElement elemento, Boolean boleano) {
        info("Checkbox selecionado: " + boleano);
        if (boleano && !estaSelecionado(elemento)) {
            espera.esperaAjaxTerminar();
            elemento.click();
        }
        if (!boleano && estaSelecionado(elemento)) {
            espera.esperaAjaxTerminar();
            elemento.click();
        }
        new Espera().esperaPor(1000);
        return false;
    }

    /**
     * @param id      O elemento checkbox.
     * @param boleano `true` para selecionar o checkbox, `false` para deselecionar.
     * @return `false` (o método não retorna um valor significativo).
     */
    public boolean seleciona(String id, Boolean boleano) {
        info("Checkbox selecionado: " + boleano);
        WebElement chk = getDriver().findElement(By.id(id));
        if (boleano) {
            espera.esperaAjaxTerminar();
            if (!estaSelecionado(chk)) {
                chk.click();
            }
        } else {
            chk.click();
        }
        espera.esperaPor(1000);
        return false;
    }

    /**
     * @param id O ID do elemento checkbox.
     */
    public void seleciona(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    /**
     * Espera até que um elemento select tenha um item selecionado pelo índice.
     *
     * <p>Esse método cria um objeto `Select` para o elemento fornecido e
     * seleciona o item com o índice especificado.</p>
     *
     * @param elemento O elemento select.
     * @param posicao  O índice do item a ser selecionado.
     */
    public void esperaPorIndex(WebElement elemento, int posicao) {
        new Select(elemento).selectByIndex(posicao);
    }

    /**
     * Verifica se um checkbox está selecionado.
     *
     * @param elemento O elemento checkbox.
     * @return `true` se o checkbox estiver selecionado, `false` caso contrário.
     */
    public boolean estaSelecionado(WebElement elemento) {
        return elemento.isSelected();
    }

    /**
     * Verifica se um checkbox está selecionado.
     *
     * @param id O elemento checkbox.
     * @return `true` se o checkbox estiver selecionado, `false` caso contrário.
     */
    public boolean estaSelecionado(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }
}
