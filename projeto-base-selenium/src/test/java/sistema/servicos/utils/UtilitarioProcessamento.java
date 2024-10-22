package sistema.servicos.utils;


import webdriver.base.Interagivel;

public abstract class UtilitarioProcessamento<M> extends Interagivel {
    private final String caminhoArquivo;

    public UtilitarioProcessamento(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }
    protected abstract void preencheDados(M dados, int posicao);

    protected abstract UtilitarioProcessamento<M> executar(M dados, int posicao);
    public abstract void acessaPagina();


    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
}
