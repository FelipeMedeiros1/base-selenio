package SISTEMA.transacoes.processamento.processamentoContabil;



import SISTEMA.config.servicos.leitorDeArquivo.config_xls.LeitorXls;
import WEBDRIVER.pageObject.transacoes.processamento.processamento_contabil.ProcessamentoContabilPage;

public class ProcessamentoContabilUtils {
    private String planilhaTeste;

    public ProcessamentoContabilUtils(String planilhaTeste) {
        this.planilhaTeste = planilhaTeste;
    }
    public ProcessamentoContabilUtils executar(ProcessamentoContabil modeloDecadastro,String chavePrimaria){
        modeloDecadastro = LeitorXls.carregarDados(planilhaTeste,chavePrimaria,"ProcessamentoContabil", ProcessamentoContabil.class);
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
