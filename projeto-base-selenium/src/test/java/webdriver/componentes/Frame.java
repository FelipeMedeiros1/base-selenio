package webdriver.componentes;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

/**
 * Classe utilitária para gerenciar frames e janelas em testes automatizados.
 * <p>
 * Fornece métodos para entrar e sair de frames, e para trocar entre janelas.
 */
public class Frame {
    /**
     * Entra em um frame específico.
     *
     * @param id O ID do frame.
     */
    public void entrarFrame(String id) {
        getDriver().switchTo().frame(id);
    }

    /**
     * Sai do frame atual e retorna para o conteúdo padrão da página.
     */
    public void sairFrame() {
        getDriver().switchTo().defaultContent();
    }

    /**
     * Troca para uma janela específica.
     *
     * @param id O ID da janela.
     */
    public void trocarJanela(String id) {
        getDriver().switchTo().window(id);
    }
}
