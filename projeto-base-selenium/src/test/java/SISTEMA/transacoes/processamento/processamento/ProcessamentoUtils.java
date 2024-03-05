package SISTEMA.transacoes.processamento.processamento;

import SISTEMA.config.servicos.utils.UtilitarioCadastroTestCase;
import SISTEMA.config.servicos.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.processamento.processamento.ProcessamentoPage;

import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.adicionarLogDeFalha;
import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.evidencia;

public class ProcessamentoUtils extends UtilitarioCadastroTestCase<Processamento, ProcessamentoPage> {
    public ProcessamentoUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(ProcessamentoPage page, Processamento modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorPlanilha.carregarDados(getNomeDaPlanilha(), chavePrimaria, "Processamento", Processamento.class);

        page.modulos(modeloDeCadastro.getModulos());

        evidencia("Processamento", "preenchendoCampo-modulos");
        page.tipoDeProcessamento(modeloDeCadastro.getTipoDeProcessamento());
        evidencia("Processamento", "preenchendoCampo-tipoDeProcessamento");
        page.dataInicial(modeloDeCadastro.getDataInicial());
        evidencia("Processamento", "preenchendoCampo-dataInicial");
        page.dataFinal(modeloDeCadastro.getDataFinal());
        evidencia("Processamento", "preenchendoCampo-dataFinal");
        page.filtroCarteira(modeloDeCadastro.getFiltroCarteira());
        page.carteira(modeloDeCadastro.getCarteira());
        evidencia("Processamento", "preenchendoCampo-carteira");
    }

    @Override
    public ProcessamentoUtils executarTeste(Processamento modeloDeCadastro, String chavePrimaria) {
        try {
            ProcessamentoPage page = new ProcessamentoPage();
            page.acessaPagina();
            preencheDados(page, modeloDeCadastro, chavePrimaria);
            page.executar();
        } catch (Exception e) {
            e.printStackTrace();
            adicionarLogDeFalha("Processamento");
        }
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
        page.executarComPreview();
        return this;
    }





}


