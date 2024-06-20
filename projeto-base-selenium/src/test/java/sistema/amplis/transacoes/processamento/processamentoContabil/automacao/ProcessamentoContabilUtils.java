package sistema.amplis.transacoes.processamento.processamentoContabil.automacao;

import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.leitorDeArquivo.config_xls.LeitorXls;
import sistema.amplis.transacoes.processamento.processamentoContabil.pagina.PaginaProcessamentoContabil;
import sistema.servicos.utils.UtilitarioCadastroTestCase;
import sistema.servicos.utils.UtilitarioProcessamentoTestCase;

public class ProcessamentoContabilUtils extends UtilitarioProcessamentoTestCase<ProcessamentoContabil> {

    public ProcessamentoContabilUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaProcessamentoContabil pagina = new PaginaProcessamentoContabil();

    @Override
    protected void preencheDados(ProcessamentoContabil dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, ProcessamentoContabil.class);
        pagina.selecionaVarios(pagina.modulos, dados.modulos());
        pagina.preenche(pagina.dataInicial, dados.dataInicial());
        pagina.preenche(pagina.dataFinal, dados.dataFinal());
        pagina.selecionaUm(pagina.filtroCarteira, dados.filtroCarteira());
        pagina.preenche(pagina.carteira,dados.carteira());
    }

    @Override
    protected ProcessamentoContabilUtils executar(ProcessamentoContabil dados, int posicao) {
        acessa();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void acessa() {
        pagina.acessa();
    }

    @Override
    public void confirmaOperacao() {
        pagina.executarProcessamento(pagina.selecionaGrid);
    }
}
