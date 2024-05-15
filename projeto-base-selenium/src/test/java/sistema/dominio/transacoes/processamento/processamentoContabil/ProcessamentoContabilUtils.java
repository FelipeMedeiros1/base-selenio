package sistema.dominio.transacoes.processamento.processamentoContabil;

import sistema.servicos.leitorDeArquivo.config_xls.LeitorXls;
import webdriver.pages.transacoes.processamento.processamento_contabil.ProcessamentoContabilPage;

public class ProcessamentoContabilUtils {
    private String planilhaTeste;

    public ProcessamentoContabilUtils(String planilhaTeste) {
        this.planilhaTeste = planilhaTeste;
    }

    public ProcessamentoContabilUtils executar(ProcessamentoContabil modeloDecadastro, String chavePrimaria) {
        modeloDecadastro = LeitorXls.carregarDados(planilhaTeste, chavePrimaria, "ProcessamentoContabil", ProcessamentoContabil.class);
        ProcessamentoContabilPage page = new ProcessamentoContabilPage();
        page.acessaPagina();
        page.modulos(modeloDecadastro.getModulos());
        page.dataInicial(modeloDecadastro.getDataInicial());
        page.dataFinal(modeloDecadastro.getDataFinal());
        page.carteira(modeloDecadastro.getCarteira());
        page.executar();
        return this;
    }
}
