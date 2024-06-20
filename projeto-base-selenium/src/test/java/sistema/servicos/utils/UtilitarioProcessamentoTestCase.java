package sistema.servicos.utils;


public abstract class UtilitarioProcessamentoTestCase<M> {
    private final String caminhoArquivo;

    public UtilitarioProcessamentoTestCase(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }
    protected abstract void preencheDados(M dados, int posicao);

    protected abstract UtilitarioProcessamentoTestCase<M> executar(M dados, int posicao);
    public abstract void acessa();
    public abstract void confirmaOperacao();

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
}
