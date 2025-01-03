package webdriver.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Filtro {
    private final Espera espera = new Espera();
    private final ComboBox comboBox = new ComboBox();

    public void filtroPesquisaPreenche(String nomeDoCampo, String valor) {

        WebElement tipoCriterio = espera.esperaAteElementoAparecerNaTela(By.xpath("(//span[text()='" + nomeDoCampo + "']/following-sibling::*//" + "select)[1]"));
        comboBox.seleciona(tipoCriterio, "Igual");
        espera.esperaPor(500);
        espera.esperaAjaxTerminar();
        WebElement campoFiltro = espera.esperaAteElementoAparecerNaTela(By.xpath("(//span[text()='" + nomeDoCampo + "']/following-sibling::*//" + "input)[1]"));
        new CaixaTexto().preenche(campoFiltro, valor);
    }

    public void filtroPesquisaSeleciona(String nomeDoCampo, String valor) {
        WebElement tipoCriterio = espera.esperaAteElementoAparecerNaTela(By.xpath("(//span[text()='" + nomeDoCampo + "']/following-sibling::*//" + "select)[1]"));
        comboBox.seleciona(tipoCriterio, "Igual");
        espera.esperaPor(500);
        espera.esperaAjaxTerminar();
        WebElement campoFiltro = espera.esperaAteElementoAparecerNaTela(By.xpath("(//span[text()='" + nomeDoCampo + "']/following-sibling::*//" + "select)[2]"));
        comboBox.seleciona(campoFiltro, valor);
    }


}
