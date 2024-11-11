package webdriver.componentes;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static servico.utils.LogUtil.info;
import static webdriver.fabrica.FabricaDeDriver.getDriver;

/**
 * Classe responsável por interagir com comboboxes em testes automatizados.
 *
 * <p>Essa classe fornece métodos para selecionar, deselecionar, obter valores
 * e realizar outras operações em comboboxes. Ela também inclui métodos para
 * lidar com comboboxes que permitem seleção múltipla.</p>
 */

public class ComboBox {

    private Espera espera = new Espera();
    private Botao botao = new Botao();
    private JsExecutor js = new JsExecutor();

    /**
     * Seleciona um item em um combobox, localizado por seu elemento.
     *
     * <p>Esse método rola a página até que o elemento combobox esteja visível,
     * espera até que o elemento esteja presente na tela e, em seguida, seleciona
     * o item com o valor especificado. O método também verifica se o elemento
     * está habilitado e se o valor não está vazio. Após selecionar o item,
     * o método espera por 1200 milissegundos.</p>
     *
     * @param elemento O elemento combobox.
     * @param valor    O valor do item a ser selecionado.
     */
    public void seleciona(WebElement elemento, String valor) {
        info(elemento.getTagName() + ":" + valor);
        js.rolarParaBaixoAteEncontrar(elemento);
        espera.esperaAteElementoAparecerNaTela(elemento);

        long tempoInicial = System.currentTimeMillis();
        long tempoLimite = tempoInicial + 10000;
        boolean elementoEncontrado = false;
try {
    if (elemento.isDisplayed() && elemento.isEnabled()) {
        while (System.currentTimeMillis() < tempoLimite) {
            try {
                new Select(elemento).selectByVisibleText(valor);
                if (new Select(elemento).getFirstSelectedOption().getText().equals(valor)) {
                    elementoEncontrado = true;
                    return;
                }
            } catch (StaleElementReferenceException e) {
                elemento.getLocation();
            }
        }
    }
}catch (Exception e){
    throw new ElementNotInteractableException("Erro ao tentar selecionar, valor: [" + valor + "] não encontrado no elemento: " + elemento,e);
}


    }

    /**
     * Seleciona um item em um combobox, localizado por seu elemento.
     *
     * <p>Esse método rola a página até que o elemento combobox esteja visível,
     * espera até que o elemento esteja presente na tela e, em seguida, seleciona
     * o item com o valor especificado. O método também verifica se o elemento
     * está habilitado e se o valor não está vazio. Após selecionar o item,
     * o método espera por 1200 milissegundos.</p>
     *
     * @param id    O elemento combobox.
     * @param valor O valor do item a ser selecionado.
     */
    public void seleciona(String id, String valor) {
        info("Selecionando valor: " + valor);
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
        String valorAtual = combo.getFirstSelectedOption().getText();
        new Espera().esperaPor(1200);
        if (valorAtual.equals(valor)) {
            throw new RuntimeException("O texto não foi persistido corretamente.");
        }
    }

    /**
     * Seleciona múltiplos itens em um combobox, localizado por seu elemento.
     *
     * <p>Esse método rola a página até que o elemento combobox esteja visível,
     * espera até que o elemento esteja presente na tela e, em seguida, seleciona
     * os itens com os valores especificados. O método também verifica se o
     * elemento está habilitado, se a lista de valores não está vazia e se
     * todos os valores são válidos (não estão vazios). Após selecionar os
     * itens, o método retorna a lista de valores selecionados.</p>
     *
     * @param elemento O elemento combobox.
     * @param valores  Os valores dos itens a serem selecionados.
     * @return Os valores dos itens selecionados, ou `null` se o elemento não
     * estiver habilitado, a lista de valores estiver vazia ou algum valor
     * estiver vazio.
     */
    public String[] selecionaVarios(WebElement elemento, String... valores) {
        info(elemento.getTagName() + ":" + valores);
        espera.esperaPor(500);
        js.rolarParaBaixoAteEncontrar(elemento);
        espera.esperaAteElementoAparecerNaTela(elemento);
        if (elemento.isEnabled() && valores.length > 0 && Arrays.stream(valores).allMatch(valor -> !valor.isEmpty())) {
            elemento.click();
            Select combo = new Select(elemento);

            combo.deselectAll();
            new Actions(getDriver()).keyDown(Keys.CONTROL);

            for (String valor : valores) {
                combo.selectByVisibleText(valor);
            }
            return valores;
        }
        return null;
    }


    /**
     * Seleciona múltiplos itens em um combobox, localizado por seu ID.
     *
     * <p>Esse método localiza o combobox por seu ID e, em seguida, seleciona
     * os itens com os valores especificados. O método desmarca todos os
     * itens selecionados anteriormente e usa a tecla `CONTROL` para selecionar
     * múltiplos itens. Após selecionar os itens, o método retorna a lista de
     * valores selecionados.</p>
     *
     * @param id      O ID do elemento combobox.
     * @param valores Os valores dos itens a serem selecionados.
     * @return Os valores dos itens selecionados.
     */
    public String[] selecionaVarios(String id, String... valores) {
        info("Selecionando valor : " + valores);
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

    /**
     * Deseleciona um item em um combobox, localizado por seu ID.
     *
     * <p>Esse método localiza o combobox por seu ID e, em seguida,
     * deseleciona o item com o valor especificado.</p>
     *
     * @param id    O ID do elemento combobox.
     * @param valor O valor do item a ser deselecionado.
     */
    public void deseleciona(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);
    }

    /**
     * Deseleciona um item em um combobox, localizado por seu elemento.
     *
     * @param element O elemento combobox.
     * @param value   O valor do item a ser deselecionado.
     */
    public void deseleciona(WebElement element, String value) {
        new Select(element).deselectByVisibleText(value);
    }

    /**
     * Obtém o valor do item selecionado em um combobox, localizado por seu elemento.
     *
     * @param element O elemento combobox.
     * @return O valor do item selecionado.
     */
    public String obterValor(WebElement element) {
        return new Select(element).getFirstSelectedOption().getText();
    }

    /**
     * Obtém o valor do item selecionado em um combobox, localizado por seu elemento.
     *
     * @param id O elemento combobox.
     * @return O valor do item selecionado.
     */
    public String obterValor(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    /**
     * Obtém os valores dos itens selecionados em um combobox, localizado por seu ID.
     *
     * <p>Esse método localiza o combobox por seu ID e, em seguida, obtém
     * os valores dos itens selecionados. O método retorna uma lista com os
     * valores dos itens selecionados.</p>
     *
     * @param elemento O ID do elemento combobox.
     * @return Uma lista com os valores dos itens selecionados.
     */
    public List<String> obterValores(WebElement elemento) {
        Select combo = new Select(elemento);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for (WebElement option : allSelectedOptions) {
            valores.add(option.getText());
        }
        return valores;
    }

    /**
     * Obtém os valores dos itens selecionados em um combobox, localizado por seu ID.
     *
     * <p>Esse método localiza o combobox por seu ID e, em seguida, obtém
     * os valores dos itens selecionados. O método retorna uma lista com os
     * valores dos itens selecionados.</p>
     *
     * @param id O ID do elemento combobox.
     * @return Uma lista com os valores dos itens selecionados.
     */
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


    public String[] pickList(WebElement elemento, String... valores) {
        info("pickList:" + Arrays.toString(valores));
        espera.esperaPor(500);
        js.rolarParaBaixoAteEncontrar(elemento);
        espera.esperaAteElementoAparecerNaTela(elemento);
        if (valores.length == 1 && valores[0].equals("todos")) {
            botao.clicar(elemento.getAttribute("id") + ":includeAll");
            return valores;
        }
        if (elemento.isEnabled() && valores.length > 0 && Arrays.stream(valores).allMatch(valor -> !valor.isEmpty())) {

            botao.clicar(elemento.getAttribute("id") + ":excludeAll");
            Select combo = new Select(getDriver().findElement(By.id(elemento.getAttribute("id") + ":firstSelect")));
            new Actions(getDriver()).keyDown(Keys.CONTROL);

            for (String valor : valores) {
                combo.selectByVisibleText(valor);
            }
            botao.clicar(elemento.getAttribute("id") + ":includeSelected");
            return valores;
        }
        return null;
    }

    public String[] pickList(String elemento, String... valores) {
        info("Selecionando valor : " + valores);
        espera.esperaPor(500);


        if (valores.length > 0 && Arrays.stream(valores).allMatch(valor -> !valor.isEmpty())) {
            botao.clicar(elemento + ":excludeAll");
            Select combo = new Select(getDriver().findElement(By.id(elemento + ":firstSelect")));

            new Actions(getDriver()).keyDown(Keys.CONTROL);

            for (String valor : valores) {
                combo.selectByVisibleText(valor);
            }
            botao.clicar(elemento + ":includeSelected");
            return valores;
        }
        return null;
    }


}
