package servico.utils;


import webdriver.base.Interagivel;
import webdriver.base.navegacao.automacao.NavegacaoSistema;

public abstract class UtilitarioRelatorio<M> extends Interagivel {

    private final String caminhoArquivo;
    public UtilitarioRelatorio(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }
    protected abstract void preencheDados(M dados, int posicao);
    protected abstract UtilitarioRelatorio<M> gerarRelatorio(M dados, int posicao);
    protected  void acessaPagina(){
        new NavegacaoSistema().navegarPara(relatorio());
    }

    protected abstract String relatorio();


    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
}
