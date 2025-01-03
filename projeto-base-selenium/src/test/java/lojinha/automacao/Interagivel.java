package lojinha.automacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.componentes.Botao;
import webdriver.componentes.CaixaTexto;
import webdriver.componentes.Espera;

import static webdriver.componentes.Evidencia.logFalha;

public class Interagivel {

    protected void adicionarProduto() {
        clicarXpath("/html/body/div[2]/div/div/a");
    }

    protected void listaDeProdutos() {
        new Espera().esperaPor(1000);
        clicarXpath("/html/body/div[2]/div/div/div[3]/form/div[4]/a");
    }

    protected void adicionarComponente() {
        clicarXpath("/html/body/div[2]/div/div/div[3]/div[1]/a");
    }

    protected void editar(String nome) {
        clicarXpath(nome);
    }

//    protected void remover(String nome) {
//        clicarLink(nome);
//        clicarLink("delete");
//    }

    protected void salvarProduto() {
        clicar("btn-salvar");
        ValidadorMensagem.validaMensagem("Produto adicionado com sucesso");
    }

    protected void salvarComponente() {
        clicarXpath("//*[@id=\"novocomponente\"]/div/div[4]/a[1]");
        ValidadorMensagem.validaMensagem("Produto adicionado com sucesso");
    }

    protected void cacelarComponente() {
        clicarXpath("//*[@id=\"novocomponente\"]/div/div[4]/a[2]");
    }
    protected void entrar() {
        clicar("btn-entrar");
    }



    protected Interagivel preenche(WebElement elemento, String valor) {
        new CaixaTexto().preenche(elemento, valor);
        return this;
    }

    protected void clicar(String id) {
        new Botao().clicar(id);
    }
    protected void clicarXpath(String nome) {
        try {
            new Botao().clicar(By.xpath(nome));
        } catch (Exception e) {
            logFalha("Elemento não encontrado: " + nome);
            throw new RuntimeException(e.getMessage());
        }
    }

}
