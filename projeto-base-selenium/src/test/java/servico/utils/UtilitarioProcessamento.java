package servico.utils;


import webdriver.base.Interagivel;
import webdriver.base.navegacao.automacao.NavegacaoAmplis;

import static webdriver.componentes.Evidencia.capturaTelaInfo;

public abstract class UtilitarioProcessamento<M> extends Interagivel {
    private final String caminhoArquivo;

    public UtilitarioProcessamento(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    protected abstract void preencheDados(M dados, int posicao);

    public UtilitarioProcessamento<M> executar(M dados, int posicao) {
        acessaPagina();
        capturaTelaInfo("capturaTelaMenuTransacoes", "Acessando: " + transacao());
        preencheDados(dados, posicao);
        capturaTelaInfo("capturaTelaDadosProcessamento", "Foram preenchidos os dados para Processamento.");
        executarProcessamento();
        return this;
    }

    protected  void acessaPagina(){
        new NavegacaoAmplis().navegarPara(transacao());
    }

    protected abstract String transacao();

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
}
