package sistema.amplis.transacoes.processamento.processamentoContabil.automacao;

import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.amplis.transacoes.processamento.processamentoContabil.pagina.PaginaProcessamentoContabil;
import sistema.servicos.utils.UtilitarioProcessamento;

public class ProcessamentoContabilUtils extends UtilitarioProcessamento<ProcessamentoContabil> {

    public ProcessamentoContabilUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaProcessamentoContabil pagina = new PaginaProcessamentoContabil();

    @Override
    protected void preencheDados(ProcessamentoContabil dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, ProcessamentoContabil.class);
        selecionaPickList(pagina.modulos, dados.modulos());
        preenche(pagina.dataInicial, dados.dataInicial());
        preenche(pagina.dataFinal, dados.dataFinal());
        selecionaUm(pagina.filtroCarteira, dados.filtroCarteira());
        preenche(pagina.carteira, dados.carteira());
    }

    @Override
    protected ProcessamentoContabilUtils executar(ProcessamentoContabil dados, int posicao) {
        this.acessaPagina();
        preencheDados(dados, posicao);
        executarProcessamento();
        return this;
    }

    @Override
    public void acessaPagina() {
        pagina.acessa();
    }


}
