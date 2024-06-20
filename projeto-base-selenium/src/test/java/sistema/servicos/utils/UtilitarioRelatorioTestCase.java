package sistema.servicos.utils;




public abstract class UtilitarioRelatorioTestCase<M>{

    private final String caminhoArquivo;
    public UtilitarioRelatorioTestCase(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }
    protected abstract void preencheDados(M dados, int posicao);
    protected abstract UtilitarioRelatorioTestCase<M> gerarRelatorio(M dados, int posicao);
    public abstract void acessa();
    public abstract void confirmaOperacao();

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
}
