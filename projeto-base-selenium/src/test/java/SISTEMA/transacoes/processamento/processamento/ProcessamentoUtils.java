package SISTEMA.transacoes.processamento.processamento;

import SISTEMA.utils.UtilitarioCadastroTestCase;
import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.processamento.processamento.ProcessamentoPage;

public class ProcessamentoUtils extends UtilitarioCadastroTestCase<Processamento, ProcessamentoPage> {
    public ProcessamentoUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(ProcessamentoPage page, Processamento modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorPlanilha.carregarDados(getNomeDaPlanilha(), chavePrimaria, "Processamento", Processamento.class);

        page.modulos(modeloDeCadastro.getModulos());
        page.tipoDeProcessamento(modeloDeCadastro.getTipoDeProcessamento());
        page.dataInicial(modeloDeCadastro.getDataInicial());
        page.dataFinal(modeloDeCadastro.getDataFinal());
        page.filtroCarteira(modeloDeCadastro.getFiltroCarteira());
        page.carteira(modeloDeCadastro.getCarteira());
    }

    @Override
    public ProcessamentoUtils iniciarTeste(Processamento modeloDeCadastro, String chavePrimaria) {
        ProcessamentoPage page = new ProcessamentoPage();
        page.acessaPagina();
        preencheDados(page, modeloDeCadastro, chavePrimaria);
        page.executarProcessamento();
        return this;
    }

    public ProcessamentoUtils executarComPreview(Processamento modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorPlanilha.carregarDados(getNomeDaPlanilha(), chavePrimaria, "Processamento", Processamento.class);

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


