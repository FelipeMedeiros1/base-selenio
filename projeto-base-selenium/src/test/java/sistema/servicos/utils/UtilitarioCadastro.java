package sistema.servicos.utils;



import webdriver.base.Interagivel;



public abstract class UtilitarioCadastro<M> extends Interagivel {
    private final String caminhoArquivo;
    public UtilitarioCadastro(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    protected abstract void preencheDados(M dados, int posicao);

    public abstract UtilitarioCadastro<M> incluir(M dados, int posicao);

    public abstract void consultar(M dados, int posicao);

    public abstract UtilitarioCadastro<M> atualizar(M dados, int posicao);

    public abstract void excluir(M dados, int posicao);

    public abstract void acessaPagina();


    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
}
