package servico.utils;


import servico.base.Interagivel;

import static webdriver.componentes.Evidencia.capturaTelaInfo;

public abstract class UtilitarioImportacao<M> extends Interagivel {
    private final String caminhoArquivo;

    public UtilitarioImportacao(String caminhoJson) {
        this.caminhoArquivo = caminhoJson;
    }

    protected abstract void preencheDados(M dados, int posicao);

    public UtilitarioImportacao<M> importar(M dados, int posicao) {
        acessaPagina();
        capturaTelaInfo("capturaTelaMenuTransacoes", "Acessando: " + transacoes());
        preencheDados(dados, posicao);
        capturaTelaInfo("capturaTelaDadosImportação", "Foram preenchidos os dados para Importação.");
        importar();
        confirmaOperacao();
        return this;
    }

    public abstract void acessaPagina();

    protected abstract String transacoes();

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
}
