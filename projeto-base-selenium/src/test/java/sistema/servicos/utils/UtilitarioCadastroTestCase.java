package sistema.servicos.utils;


public abstract class UtilitarioCadastroTestCase<M> {
    private final String caminhoArquivo;

    public UtilitarioCadastroTestCase(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    protected abstract void preencheDados(M dados, int posicao);

    protected abstract UtilitarioCadastroTestCase<M> executar(M dados, int posicao);

    protected abstract void consulta(M dados, int posicao);

    protected abstract UtilitarioCadastroTestCase<M> atualizar(M dados, int posicao);

    protected abstract void excluir(M dados, int posicao);

    public abstract void acessa();

    public abstract void confirmaOperacao();

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
}
