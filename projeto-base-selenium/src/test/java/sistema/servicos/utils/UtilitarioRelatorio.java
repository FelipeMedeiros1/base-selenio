package sistema.servicos.utils;


import webdriver.base.Interagivel;

public abstract class UtilitarioRelatorio<M> extends Interagivel {

    private final String caminhoArquivo;
    public UtilitarioRelatorio(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }
    protected abstract void preencheDados(M dados, int posicao);
    protected abstract UtilitarioRelatorio<M> gerarRelatorio(M dados, int posicao);
    public abstract void acessaPagina();


    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
}
