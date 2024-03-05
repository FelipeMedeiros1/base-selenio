package SISTEMA.config.servicos.utils;

import lombok.Getter;


public abstract class UtilitarioRelatorioTestCase<T, P>{
    @Getter
    private final String nomeDaPlanilha;
    public UtilitarioRelatorioTestCase(String nomeDaPlanilha) {
        this.nomeDaPlanilha = nomeDaPlanilha;
    }
    protected abstract void preencheDados(P page, T modeloDeCadastro, String chavePrimaria);
    protected abstract UtilitarioRelatorioTestCase<T,P> gerarRelatorio(T modeloDeCadastro, String chavePrimaria);
}
