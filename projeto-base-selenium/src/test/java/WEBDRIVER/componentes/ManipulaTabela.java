package WEBDRIVER.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public class ManipulaTabela {

    public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela){
        //procurar coluna do registro
        WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);

        //encontrar Leitor linha do registro
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        //procurar coluna do botao
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

        //clicar no botao da celula encontrada
        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
        return celula;
    }

    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
        WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
        celula.findElement(By.xpath(".//input")).click();

    }

    protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
        int idLinha = -1;
        for(int i = 0; i < linhas.size(); i++) {
            if(linhas.get(i).getText().equals(valor)) {
                idLinha = i+1;
                break;
            }
        }
        return idLinha;
    }

    protected int obterIndiceColuna(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for(int i = 0; i < colunas.size(); i++) {
            if(colunas.get(i).getText().equals(coluna)) {
                idColuna = i+1;
                break;
            }
        }
        return idColuna;
    }

    public void excluirLinha(String id_tabela, int linha) {

        WebElement tab = getDriver().findElement(By.xpath("//*[@id='"+id_tabela+"']/tbody/tr["+linha+"]/td[2]/Leitor[2]/span"));
        tab.findElement(By.xpath(".//input")).click();

    }

}
