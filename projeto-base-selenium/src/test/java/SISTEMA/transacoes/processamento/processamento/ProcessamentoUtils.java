package SISTEMA.transacoes.processamento.processamento;

import SISTEMA.config.servicos.leitorDeArquivo.config_json.LeitorJson;
import SISTEMA.config.servicos.leitorDeArquivo.config_xls.LeitorXls;
import SISTEMA.config.servicos.utils.UtilitarioCadastroTestCase;

import WEBDRIVER.pageObject.transacoes.processamento.processamento.ProcessamentoPage;

import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.evidencia;
import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.logDeFalha;

public class ProcessamentoUtils extends UtilitarioCadastroTestCase<Processamento, ProcessamentoPage> {
    public ProcessamentoUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    protected void preencheDados(ProcessamentoPage page, Processamento modeloDeCadastro, int posicao) {
        modeloDeCadastro = LeitorJson.carregarDados(getNomeDaPlanilha(),posicao,Processamento.class);

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

    public ProcessamentoUtils executarTeste(Processamento modeloDeCadastro, int posicao) {
        try {
            var page = new ProcessamentoPage();
            page.acessaPagina();
            preencheDados(page, modeloDeCadastro, posicao);
            page.executar();

        } catch (Exception e) {
            e.printStackTrace();
            logDeFalha("Processamento");
            throw new RuntimeException("Teste fahou");
        }


        return this;
    }


    @Override
    protected void preencheDados(ProcessamentoPage page, Processamento modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorXls.carregarDados(getNomeDaPlanilha(), chavePrimaria, "Processamento", Processamento.class);

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
            logDeFalha("Processamento");
            throw new RuntimeException("Teste fahou");
        }


        return this;
    }

    public ProcessamentoUtils executarComPreview(Processamento modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorXls.carregarDados(getNomeDaPlanilha(), chavePrimaria, "Processamento", Processamento.class);

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


