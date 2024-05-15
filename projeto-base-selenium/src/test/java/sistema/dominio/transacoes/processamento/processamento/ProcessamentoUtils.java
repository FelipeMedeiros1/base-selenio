package sistema.dominio.transacoes.processamento.processamento;

import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.leitorDeArquivo.config_xls.LeitorXls;
import sistema.servicos.utils.UtilitarioCadastroTestCase;

import webdriver.pages.transacoes.processamento.processamento.ProcessamentoPage;


public class ProcessamentoUtils extends UtilitarioCadastroTestCase<Processamento, ProcessamentoPage> {
    public ProcessamentoUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    protected void preencheDados(ProcessamentoPage page, Processamento modeloDeCadastro, int posicao) {
        modeloDeCadastro = LeitorJson.carregarDados(getNomeDaPlanilha(), posicao, Processamento.class);

        page.modulos(modeloDeCadastro.getModulos());
        ;
        page.tipoDeProcessamento(modeloDeCadastro.getTipoDeProcessamento());

        page.dataInicial(modeloDeCadastro.getDataInicial());

        page.dataFinal(modeloDeCadastro.getDataFinal());

        page.filtroCarteira(modeloDeCadastro.getFiltroCarteira());
        page.carteira(modeloDeCadastro.getCarteira());

    }

    public ProcessamentoUtils executarTeste(Processamento modeloDeCadastro, int posicao) {
        try {
            var page = new ProcessamentoPage();
            page.acessaPagina();
            preencheDados(page, modeloDeCadastro, posicao);
            page.executar();

        } catch (Exception e) {
            e.printStackTrace();

            throw new RuntimeException("Teste fahou");
        }


        return this;
    }


    @Override
    protected void preencheDados(ProcessamentoPage page, Processamento modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorXls.carregarDados(getNomeDaPlanilha(), chavePrimaria, "Processamento", Processamento.class);

        page.modulos(modeloDeCadastro.getModulos());

        page.tipoDeProcessamento(modeloDeCadastro.getTipoDeProcessamento());

        page.dataInicial(modeloDeCadastro.getDataInicial());
        ;
        page.dataFinal(modeloDeCadastro.getDataFinal());

        page.filtroCarteira(modeloDeCadastro.getFiltroCarteira());
        page.carteira(modeloDeCadastro.getCarteira());

    }

    @Override
    public ProcessamentoUtils executarTeste(Processamento modeloDeCadastro, String chavePrimaria) {
        ProcessamentoPage page = new ProcessamentoPage();
        page.acessaPagina();
        preencheDados(page, modeloDeCadastro, chavePrimaria);
        page.executar();
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


