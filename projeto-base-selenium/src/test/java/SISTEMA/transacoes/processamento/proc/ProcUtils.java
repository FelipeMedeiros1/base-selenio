package SISTEMA.transacoes.processamento.proc;



import SISTEMA.config.servicos.leitorDeArquivo.config_xls.LeitorXls;
import SISTEMA.config.servicos.utils.UtilitarioCadastroTestCase;
import WEBDRIVER.pageObject.transacoes.processamento.processamento.ProcessamentoPage;

import static WEBDRIVER.base.BaseTest.finalizar;

public class ProcUtils extends UtilitarioCadastroTestCase< Proc, ProcessamentoPage> {
    public ProcUtils(String nomeDoArquivo) {
        super(nomeDoArquivo);
    }

    @Override
    protected void preencheDados(ProcessamentoPage page,  Proc modeloDeCadastro, String id) {
        modeloDeCadastro = LeitorXls.carregarDados(getNomeDaPlanilha(), id, "Processamento", Proc.class);

        page.modulos(modeloDeCadastro.getModulos());
        page.tipoDeProcessamento(modeloDeCadastro.getTipoDeProcessamento());
        page.dataInicial(modeloDeCadastro.getDataInicial());
        page.dataFinal(modeloDeCadastro.getDataFinal());
        page.filtroCarteira(modeloDeCadastro.getFiltroCarteira());
        page.carteira(modeloDeCadastro.getCarteira());
    }



    @Override
    protected UtilitarioCadastroTestCase< Proc, ProcessamentoPage> executarTeste(Proc modeloDeCadastro, String id) {
        try {
            ProcessamentoPage page = new ProcessamentoPage();
            page.acessaPagina();
            preencheDados(page, modeloDeCadastro, id);
            page.executar();
        } catch (Exception e) {
            finalizar();
            e.printStackTrace();

        }
        return this;
    }


}
