package SISTEMA.transacoes.processamento.processamento;

import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.componentes.Screenshot;
import WEBDRIVER.pageObject.transacoes.processamento.processamento.ProcessamentoPage;

public class ProcessamentoUtils {
    private String nomeDaPlanilhaTeste;

    public ProcessamentoUtils(String planilhaTeste){
        this.nomeDaPlanilhaTeste = planilhaTeste;
    }
    public ProcessamentoUtils executar(Processamento modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorPlanilha.carregarDados(nomeDaPlanilhaTeste,chavePrimaria,"Processamento", Processamento.class);

        ProcessamentoPage page = new ProcessamentoPage();
        page.acessaPagina();
        page.modulos(modeloDeCadastro.getModulos());
        page.tipoDeProcessamento(modeloDeCadastro.getTipoDeProcessamento());
        page.dataInicial(modeloDeCadastro.getDataInicial());
        page.dataFinal(modeloDeCadastro.getDataFinal());
        page.carteira(modeloDeCadastro.getCarteira());
        page.executarProcessamento();Screenshot.capturaScreenshot();

        return this;
    }
    public ProcessamentoUtils executarComPreview(Processamento modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorPlanilha.carregarDados(nomeDaPlanilhaTeste,chavePrimaria,"Processamento", Processamento.class);

        ProcessamentoPage page = new ProcessamentoPage();
        page.acessaPagina();
        page.modulos(modeloDeCadastro.getModulos());
        page.tipoDeProcessamento(modeloDeCadastro.getTipoDeProcessamento());
        page.dataInicial(modeloDeCadastro.getDataInicial());
        page.dataFinal(modeloDeCadastro.getDataFinal());
        page.carteira(modeloDeCadastro.getCarteira());
        page.executarProcessamentoComPreview();
        return this;
    }
}
