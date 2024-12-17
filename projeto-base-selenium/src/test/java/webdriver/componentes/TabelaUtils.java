package webdriver.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class TabelaUtils {

    public void selecionarNaGrid( String idTabela, String... nomesPesquisados) {
        List<String> nomesList = List.of(nomesPesquisados);

        // Aguarda até que a tabela seja visível
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idTabela)));

        // Localiza a tabela
        WebElement tabela = getDriver().findElement(By.id(idTabela));

        // Cria o Predicate para verificar se a célula contém um nome pesquisado
        Predicate<WebElement> contemNomePesquisado = criarPredicateParaNomes(nomesList);


        List<WebElement> celulasFiltradas = filtrarCelulas(tabela, contemNomePesquisado);


//        for (WebElement celula : celulasFiltradas) {
//            WebElement linha = celula.findElement(By.xpath("./ancestor::tr")); // Obtém a linha da célula
//            List<WebElement> colunas = linha.findElements(By.tagName("td"));
//            if (colunas.size() > 0) {
//                WebElement checkbox = colunas.get(0).findElement(By.tagName("input[type='checkbox']")); // Assumindo que a checkbox está na primeira coluna
//                if (!checkbox.isSelected()) {
//                    checkbox.click(); // Marca a checkbox se não estiver selecionada
//                }
//            }
//        }


        boolean todosCheckboxSelecionados = nomesList.stream().allMatch(nome -> {
            WebElement checkboxSelecionado = tabela.findElements(By.tagName("tr")).stream()
                    .flatMap(linha -> linha.findElements(By.tagName("td")).stream())
                    .filter(td -> td.getText().equals(nome))
                    .findFirst()
                    .map(td -> td.findElement(By.xpath("preceding-sibling::td/input[@type='checkbox']")))
                    .orElse(null);
            return checkboxSelecionado != null && checkboxSelecionado.isSelected();
        });

        if (!todosCheckboxSelecionados) {
            throw new AssertionError("Nem todos os nomes tiveram suas checkboxes selecionadas!");
        }
    }
    public static List<WebElement> filtrarCelulas(WebElement tabela, Predicate<WebElement> filtro) {
        return tabela.findElements(By.tagName("tr")).stream()
                .flatMap(linha -> linha.findElements(By.tagName("td")).stream())
                .filter(filtro)
                .collect(Collectors.toList());
    }


    public static Predicate<WebElement> criarPredicateParaNomes(List<String> nomes) {
        return celula -> nomes.contains(celula.getText());
    }

}

