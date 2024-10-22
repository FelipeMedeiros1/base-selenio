package webdriver.base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.componentes.*;

import java.time.Duration;
import java.util.NoSuchElementException;

import static sistema.servicos.utils.LogUtil.info;
import static sistema.servicos.utils.LogUtil.warn;
import static webdriver.componentes.Assertivas.obterMensagemAtual;
import static webdriver.fabrica.FabricaDeDriver.getDriver;

/**
 * Classe que representa uma página ou componente de uma página web,
 * contendo métodos para interagir com elementos da página e realizar ações.
 */
public abstract class Interagivel {
    public abstract void acessaPagina();

    /**
     * Realiza a ação de inserir um novo registro.
     * <p>
     * Verifica se há AJAX em execução e aguarda o término caso haja.
     * Clica no botão "Inserir".
     */
    protected void inserir() {
        info("Iniciando teste de Inclusão");
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
        info("Iniciando teste de Atualizaçção");
        esperaAjaxTerminar();
        clicarGrid();
        try {
            pressionarAltMaisLetra('a');

        } catch (Exception e) {
            alterar();
        }
        esperaPor(1000);
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
        info("Iniciando teste de Exclusão");
        esperaAjaxTerminar();
        selecionaGrid();
        try {
            pressionarAltMaisLetra('e');
            new PainelMensagem().validaMensagemExcluir();
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
        new PainelMensagem().validaMensagemCadastro();

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
            return;
        }
    }

    private void selecionaGrid() {
        clicar("mainForm:filterDataTable:0:chk");


    }

    protected Interagivel selecionaNaGrid(int indice) {
        esperaAjaxTerminar();
        new CheckBox().seleciona("mainForm:filterDataTable:" + indice + ":chk");
        clicarGrid();
        return this;
    }

    public Interagivel consultarNaGrid(String... valores) {
        new TabelaUtils().selecionarNaGrid("mainForm:filterDataTable", valores);
        return this;
    }


    /**
     * Clica em um elemento fora do campo de entrada, geralmente para remover o foco do campo.
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
     * Preenche um campo de texto na página web de forma lenta, digitando cada caractere individualmente.
     * <p>
     * Aguarda o término do AJAX, se estiver presente, antes de preencher o campo.
     * Após preencher o campo, clica fora dele para garantir que o foco seja removido.
     *
     * @param elemento O elemento da página web que representa o campo de texto a ser preenchido.
     * @param valor    O valor que será inserido no campo de texto.
     * @return O próprio objeto Interagivel, permitindo encadeamento de métodos.
     */
    protected Interagivel preencheDevagar(WebElement elemento, String valor) {
        esperaAjaxTerminar();
        new CampoTexto().preencheDevagar(elemento, valor);
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

    /**
     * Seleciona múltiplos itens em um ComboBox na página web.
     * <p>
     * Aguarda o término do AJAX, se estiver presente, antes de selecionar os itens.
     * Após selecionar os itens, chama o método `incluirSelecionados()` e aguarda 1 segundo.
     *
     * @param elemento O elemento da página web que representa o ComboBox a ser manipulado.
     * @param valores  Os valores dos itens que serão selecionados no ComboBox.
     * @return O próprio objeto Interagivel, permitindo encadeamento de métodos.
     */
    protected Interagivel selecionaVarios(WebElement elemento, String... valores) {
        esperaAjaxTerminar();
        new ComboBox().selecionaVarios(elemento, valores);
        incluirSelecionados();
//        esperaPor(1000);

        return this;
    }

    /**
     * Seleciona múltiplos itens em um ComboBox na página web e confirma a seleção.
     * <p>
     * Aguarda o término do AJAX, se estiver presente, antes de selecionar os itens.
     * Após selecionar os itens, clica no botão de confirmação e aguarda 500 milissegundos.
     *
     * @param elemento O elemento da página web que representa o ComboBox a ser manipulado.
     * @param incluir  O elemento da página web que representa o botão de confirmação da seleção.
     * @param valores  Os valores dos itens que serão selecionados no ComboBox.
     * @return O próprio objeto Interagivel, permitindo encadeamento de métodos.
     */
    protected Interagivel selecionaVarios(WebElement elemento, WebElement incluir, String... valores) {
        esperaAjaxTerminar();
        selecionaVarios(elemento, valores);
        clicar(incluir);
        esperaPor(500);

        return this;
    }

    protected Interagivel selecionaPickList(WebElement elemento, String... valores) {
        esperaAjaxTerminar();
        new ComboBox().pickList(elemento, valores);
        esperaPor(500);

        return this;
    }


    /**
     * Confirma a seleção de itens em um ComboBox.
     */
    protected void incluirSelecionados() {
        new ComboBox().incluirSelecionados();
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
        new JavascriptExecutor().rolarParaBaixoAteEncontrar(elemento);
    }

    protected void rolarParaBaixoAteEncontrar(String id) {
        WebElement elemento = getDriver().findElement(By.id(id));
        esperaAjaxTerminar();
        esperaPor(500);
        new JavascriptExecutor().rolarParaBaixoAteEncontrar(elemento);
    }

    protected void validaIgualdadeNaMensagem(String texto, WebElement elemento) {
        try {
            aguardaElementoTerTexto(elemento, texto);
            Assert.assertEquals(elemento.getText(), texto, "A mensagem do elemento '" + elemento.toString() + "' não corresponde ao esperado: '" + texto + "'");
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
            throw new RuntimeException(obterMensagemAtual("messageContent"));
        }
        clicar("mainForm:dataTable1:0:processPortfolioCheckbox");
        confirma();
        new PainelMensagem().validaMensagemProcessamento();

    }
}



