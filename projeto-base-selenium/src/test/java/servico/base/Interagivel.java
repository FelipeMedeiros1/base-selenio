package servico.base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.componentes.*;

import java.time.Duration;
import java.util.NoSuchElementException;


import static webdriver.componentes.Evidencia.*;
import static webdriver.componentes.PainelMensagem.*;
import static webdriver.fabrica.FabricaDeDriver.getDriver;

/**
 * Classe que representa uma página ou componente de uma página web,
 * contendo métodos para interagir com elementos da página e realizar ações.
 */
public abstract class Interagivel {

    /**
     * Realiza a ação de inserir um novo registro.
     * <p>
     * Verifica se há AJAX em execução e aguarda o término caso haja.
     * Clica no botão "Inserir".
     */
    protected void inserir() {
        try {
            pressionarAltMaisLetra('i');
        } catch (Exception e) {
            inserir();
        }
    }

    /**
     * Realiza a ação de alterar um registro.
     * <p>
     * Verifica se há AJAX em execução e aguarda o término caso haja.
     * Clica no botão "Alterar".
     */
    protected void alterar() {
        esperaAjaxTerminar();
        clicarGrid();
        pressionarAltMaisLetra('a');


    }

    /**
     * Realiza a ação de excluir um registro.
     * <p>
     * Verifica se há AJAX em execução e aguarda o término caso haja.
     * Clica no botão "Excluir".
     * Clica no botão "Sim" da caixa de diálogo de confirmação .
     * Obtém a mensagem exibida na página .
     * Verifica se a mensagem termina com "sucesso.".
     */
    protected void excluir() {
        esperaAjaxTerminar();
        selecionaGrid();
        try {
            pressionarAltMaisLetra('e');
            validaMensagemExclusao();
        } catch (Exception e) {
            excluir();
        }
    }

    /**
     * Realiza a ação de confirmar.
     * <p>
     * Verifica se há AJAX em execução e aguarda o término caso haja.
     * Clica no botão "Confirmar".
     */
    protected void confirma() {
        esperaAjaxTerminar();
        try {
            pressionarAltMaisLetra('o');
        } catch (Exception e) {
            confirma();
        }
        esperaPor(1000);
    }

    /**
     * Realiza a ação de confirmar uma consulta.
     * <p>
     * Verifica se há AJAX em execução e aguarda o término caso haja.
     * Chama o método `confirma()`.
     * Clica em um elemento da grid (para visualizar o resultado da consulta).
     */
    protected void confirmaConsulta() {
        try {
            capturaTelaInfo("DadosConsulta", "realizando consulta...");
            pressionarAltMaisLetra('o');
        } catch (Exception e) {
            confirmaConsulta();
        }
    }

    /**
     * Realiza a ação de confirmar uma operação e verifica a mensagem de sucesso.
     * <p>
     * Chama o método `confirma()`.
     * Obtém a mensagem exibida na página.
     * Verifica se a mensagem corresponde a mensagem esperada.
     * Clica no botão "OK" da caixa de diálogo de mensagem.
     */
    protected void confirmaOperacao() {
        pressionarAltMaisLetra('o');
        validaMensagemInclusao();

    }

    protected void cancela() {
        pressionarAltMaisLetra('c');
    }

    protected void exportar() {
        pressionarAltMaisLetra('x');
    }

    protected void importar() {
        pressionarAltMaisLetra('z');
    }

    /**
     * Seleciona um checkbox em uma tabela de dados.
     *
     * @param index O índice da linha da tabela que contém o checkbox a ser selecionado.
     */
    protected void selectGrid(int index) {
        new CheckBox().seleciona("mainForm:filterDataTable:" + index + ":chk");
    }

    /**
     * Clica em um elemento da página web.
     *
     * @param elemento O elemento da página web que será clicado.
     * @return O próprio objeto Interagivel, permitindo encadeamento de métodos.
     */
    protected Interagivel clicar(WebElement elemento) {
        new Botao().clicar(elemento);
        return this;
    }

    /**
     * Clica em um elemento da página web.
     *
     * @param id O elemento da página web que será clicado.
     */
    protected void clicar(String id) {
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(id);
        new Botao().clicar(id);
    }


    /**
     * Clica em um elemento da página web.
     * <p>
     * Clica no indice 0 da grid
     */
    private void clicarGrid() {
        try {
            clicar("mainForm:filterDataTable:0:coluna_mnemonic");
        } catch (Exception e) {
            logFalha("Elemento não encontrado na grid");
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     *
     */
    private void selecionaGrid() {
        try {
            clicar("mainForm:filterDataTable:0:chk");
        } catch (Exception e) {
            logFalha("Elemento não encontrado na grid");
            throw new RuntimeException(e.getMessage());
        }
    }

    public Interagivel consultarNaGrid(String... valores) {
        new TabelaUtils().selecionarNaGrid("mainForm:filterDataTable", valores);
        return this;
    }


    /**
     * Clica em um elemento fora do campo de entrada, para remover o foco do campo.
     */
    private void clicarForaDoCampo() {
        clicar("mainForm:headerTransacao");
    }

    /**
     * Seleciona uma aba na página web.
     * <p>
     * Aguarda o término do AJAX, se estiver presente, antes de selecionar a aba.
     *
     * @param elemento O elemento da página web que representa a aba a ser selecionada.
     */
    protected void selecionaAba(WebElement elemento) {
        esperaAjaxTerminar();
        new Botao().selecionaAba(elemento);
    }

    /**
     * Preenche um campo de texto na página web.
     * <p>
     * Aguarda o término do AJAX, se estiver presente, antes de preencher o campo.
     *
     * @param elemento O elemento da página web que representa o campo de texto a ser preenchido.
     * @param valor    O valor que será inserido no campo de texto.
     * @return O próprio objeto Interagivel, permitindo encadeamento de métodos.
     */
    protected Interagivel preenche(WebElement elemento, String valor) {
        esperaAjaxTerminar();
        new CampoTexto().preenche(elemento, valor);
        return this;
    }

    protected Interagivel preencheNativo(WebElement elemento, String valor) {
        esperaAjaxTerminar();
        new CampoTexto().preencheNativo(elemento, valor);
        return this;
    }

    protected Interagivel preencheDuplicado(WebElement elemento, String valor) {
        esperaAjaxTerminar();
        new CampoTexto().preencheDuplicado(elemento, valor);
        return this;
    }

    /**
     * Preenche um campo de autocompletar na página web.
     * <p>
     * Aguarda o término do AJAX, se estiver presente, antes de preencher o campo.
     * Após preencher o campo, clica fora dele para garantir que a sugestão seja selecionada.
     *
     * @param elemento O elemento da página web que representa o campo de autocompletar a ser preenchido.
     * @param valor    O valor que será inserido no campo de autocompletar.
     * @return O próprio objeto Interagivel, permitindo encadeamento de métodos.
     */
    protected Interagivel preencheAutoComplete(WebElement elemento, String valor) {
        esperaAjaxTerminar();
        preenche(elemento, valor);
        clicarForaDoCampo();
        return this;
    }

    /**
     * Seleciona um item específico em um ComboBox na página web.
     * <p>
     * Aguarda o término do AJAX, se estiver presente, antes de selecionar o item.
     *
     * @param elemento O elemento da página web que representa o ComboBox a ser manipulado.
     * @param valor    O valor do item que será selecionado no ComboBox.
     * @return O próprio objeto Interagivel, permitindo encadeamento de métodos.
     */
    protected Interagivel selecionaUm(WebElement elemento, String valor) {
        esperaAjaxTerminar();
        new ComboBox().seleciona(elemento, valor);
        esperaPor(500);
        return this;
    }

    protected Interagivel selecionaPickList(WebElement elemento, String... valores) {
        esperaAjaxTerminar();
        new ComboBox().pickList(elemento, valores);
        esperaPor(500);

        return this;
    }

    public void selecionaFiltroPesquisa(String nomeDoCampo, String valor) {
        new Filtro().filtroPesquisaSeleciona(nomeDoCampo, valor);
    }

    public void preencheFiltroPesquisa(String nomeDoCampo, String valor) {
        new Filtro().filtroPesquisaPreenche(nomeDoCampo, valor);
    }


    /**
     * Seleciona ou desmarca um checkbox na página web.
     * <p>
     * Aguarda o término do AJAX, se estiver presente, antes de selecionar o checkbox.
     * Rolar a página para baixo até encontrar o checkbox antes de interagir com ele.
     *
     * @param elemento O elemento da página web que representa o checkbox a ser manipulado.
     * @param boleano  Se `true`, seleciona o checkbox. Se `false`, desmarca o checkbox.
     */
    protected void selecionaChekBox(WebElement elemento, Boolean boleano) {
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(elemento);
        new CheckBox().seleciona(elemento, boleano);

    }

    private void pressionarAltMaisLetra(char letra) {
        new Atalho().pressionarAltMaisLetra(letra);
    }

    protected void rolarParaBaixoAteEncontrar(WebElement elemento) {
        esperaAjaxTerminar();
        esperaPor(500);
        new JsExecutor().rolarParaBaixoAteEncontrar(elemento);
    }

    protected void rolarParaBaixoAteEncontrar(String id) {
        WebElement elemento = getDriver().findElement(By.id(id));
        esperaAjaxTerminar();
        esperaPor(500);
        new JsExecutor().rolarParaBaixoAteEncontrar(elemento);
    }

    protected void validaIgualdadeNaMensagem(String texto, WebElement elemento) {
        try {
            aguardaElementoTerTexto(elemento, texto);
            Assert.assertEquals(elemento.getText(), texto, "A mensagem do elemento '" + elemento + "' não corresponde ao esperado: '" + texto + "'");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("O elemento '" + elemento.toString() + "' não foi encontrado.", e);
        } catch (TimeoutException e) {
            throw new RuntimeException("O elemento '" + elemento.toString() + "' não exibiu o texto '" + texto + "' dentro do tempo limite.", e);
        }
    }


    private void aguardaElementoTerTexto(WebElement elemento, String texto) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElementValue(elemento, texto));
    }

    protected void esperaElementoSerClicavel(WebElement elemento) {
        new Espera().esperaElementoSerClicavel(elemento);
    }

    protected void esperaAjaxTerminar() {
        new Espera().esperaAjaxTerminar();
    }


    public Interagivel esperaPor(int mill) {
        new Espera().esperaPor(mill);
        return this;
    }

    protected void executarProcessamento() {
        confirma();
        if (new PainelMensagem().estaVisivel()) {
            throw new RuntimeException(obterMensagemAtual());
        }
        clicar("mainForm:dataTable1:0:processPortfolioCheckbox");
        confirma();
        validaMensagemProcessamento();

    }

    protected void importarArquivo( String nomeArquivo) {
        new ImportarArquivo().importar(nomeArquivo);
    }

    public boolean estaVisivel(WebElement elemento) {
        try {
            return elemento.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
