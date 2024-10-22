package webdriver.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

/**
 * Classe utilitária para manipular tabelas em testes automatizados.
 * <p>
 * Fornece métodos para encontrar células, clicar em botões dentro de tabelas,
 * excluir linhas e obter índices de colunas e linhas.
 */
public class ManipulaTabela {
    /**
     * Obtém uma célula específica em uma tabela com base em valores de coluna e linha.
     *
     * @param colunaBusca O nome da coluna que contém o valor de busca.
     * @param valor       O valor a ser buscado na coluna.
     * @param colunaBotao O nome da coluna que contém o botão.
     * @param idTabela    O ID da tabela.
     * @return A célula encontrada.
     */
    public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {
        //procurar coluna do registro
        WebElement tabela = getDriver().findElement(By.xpath("//*[@id='" + idTabela + "']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);

        //encontrar Leitor linha do registro
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        //procurar coluna do botao
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

        //clicar no botao da celula encontrada
        WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
        return celula;
    }

    /**
     * Clica em um botão dentro de uma célula específica em uma tabela.
     *
     * @param colunaBusca O nome da coluna que contém o valor de busca.
     * @param valor       O valor a ser buscado na coluna.
     * @param colunaBotao O nome da coluna que contém o botão.
     * @param idTabela    O ID da tabela.
     */
    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
        WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
        celula.findElement(By.xpath(".//input")).click();

    }

    /**
     * Obtém o índice da linha que contém um valor específico em uma coluna.
     *
     * @param valor    O valor a ser buscado na coluna.
     * @param tabela   A tabela onde o valor deve ser buscado.
     * @param idColuna O índice da coluna onde o valor deve ser buscado.
     * @return O índice da linha encontrada, ou -1 se não for encontrado.
     */
    protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
        int idLinha = -1;
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getText().equals(valor)) {
                idLinha = i + 1;
                break;
            }
        }
        return idLinha;
    }

    /**
     * Obtém o índice da coluna que contém um nome específico.
     *
     * @param coluna O nome da coluna a ser buscada.
     * @param tabela A tabela onde a coluna deve ser buscada.
     * @return O índice da coluna encontrada, ou -1 se não for encontrado.
     */
    protected int obterIndiceColuna(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++) {
            if (colunas.get(i).getText().equals(coluna)) {
                idColuna = i + 1;
                break;
            }
        }
        return idColuna;
    }

    /**
     * Exclui uma linha específica em uma tabela.
     *
     * @param id_tabela O ID da tabela.
     * @param linha     O índice da linha a ser excluída.
     */
    public void excluirLinha(String id_tabela, int linha) {
        WebElement tab = getDriver().findElement(By.xpath("//*[@id='" + id_tabela + "']/tbody/tr[" + linha + "]/td[2]/Leitor[2]/span"));
        tab.findElement(By.xpath(".//input")).click();

    }

}
