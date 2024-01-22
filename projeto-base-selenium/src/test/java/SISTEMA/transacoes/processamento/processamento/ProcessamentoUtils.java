package SISTEMA.transacoes.processamento.processamento;

import SISTEMA.propriedades.utils.UtilitarioCadastroTestCase;
import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.componentes.CapturaDeTela;
import WEBDRIVER.pageObject.transacoes.processamento.processamento.ProcessamentoPage;

public class ProcessamentoUtils extends UtilitarioCadastroTestCase<Processamento, ProcessamentoPage> {
    public ProcessamentoUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(ProcessamentoPage page, Processamento modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorPlanilha.carregarDados(getNomeDaPlanilha(), chavePrimaria, "Processamento", Processamento.class);

        page.modulos(modeloDeCadastro.getModulos());
        new CapturaDeTela().evidencia("processamento","preenchendo-modulos");
        page.tipoDeProcessamento(modeloDeCadastro.getTipoDeProcessamento());
        new CapturaDeTela().evidencia("processamento","preenchendo-tipoDeProcessamento");
        page.dataInicial(modeloDeCadastro.getDataInicial());
        page.dataFinal(modeloDeCadastro.getDataFinal());
        new CapturaDeTela().evidencia("processamento","preenchendo-data");
        page.filtroCarteira(modeloDeCadastro.getFiltroCarteira());
        page.carteira(modeloDeCadastro.getCarteira());
        new CapturaDeTela().evidencia("processamento","preenchendo-carteira");
    }

    @Override
    public ProcessamentoUtils executarTeste(Processamento modeloDeCadastro, String chavePrimaria) {
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


