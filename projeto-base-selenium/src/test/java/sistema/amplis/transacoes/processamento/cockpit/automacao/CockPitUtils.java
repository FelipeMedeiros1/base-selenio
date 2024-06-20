package sistema.amplis.transacoes.processamento.cockpit.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.leitorDeArquivo.config_xls.LeitorXls;
import sistema.servicos.utils.UtilitarioCadastroTestCase;

import sistema.amplis.transacoes.processamento.cockpit.pagina.PaginaCockPit;
import sistema.servicos.utils.UtilitarioProcessamentoTestCase;


public class CockPitUtils extends UtilitarioProcessamentoTestCase<CockPit> {

    public CockPitUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }
    private PaginaCockPit pagina = new PaginaCockPit();
    @Override
    protected void preencheDados(  CockPit dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CockPit.class);
        pagina.preenche(pagina.dataProcessamento,dados.dataProcessamento());
        pagina.selecionaUm(pagina.tipoProcessamennto,dados.tipoProcessamennto());
        pagina.selecionaUm(pagina.filtroCarteira ,dados.filtroCarteira());
        pagina.preenche(pagina.carteira,dados.carteira());
        pagina.selecionaUm(pagina.statusProcessamento,dados.statusProcessamento());
    }

    @Override
    public CockPitUtils executar(CockPit dados, int posicao) {
        acessa();
        preencheDados(  dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void acessa() {
        pagina.acessa();
    }

    @Override
    public void confirmaOperacao() {
        pagina.pesquisaResultado();
    }
}
