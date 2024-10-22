package sistema.amplis.transacoes.processamento.cockpit.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;

import sistema.amplis.transacoes.processamento.cockpit.pagina.PaginaCockPit;
import sistema.servicos.utils.UtilitarioProcessamento;


public class CockPitUtils extends UtilitarioProcessamento<CockPit> {

    public CockPitUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaCockPit pagina = new PaginaCockPit();

    @Override
    protected void preencheDados(CockPit dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CockPit.class);
        preenche(pagina.dataProcessamento, dados.dataProcessamento());
        selecionaUm(pagina.tipoProcessamennto, dados.tipoProcessamennto());
        selecionaUm(pagina.filtroCarteira, dados.filtroCarteira());
        preenche(pagina.carteira, dados.carteira());
        selecionaUm(pagina.statusProcessamento, dados.statusProcessamento());
    }

    @Override
    public CockPitUtils executar(CockPit dados, int posicao) {
        this.acessaPagina();
        preencheDados(dados, posicao);
        pesquisaResultado();
        return this;
    }

    @Override
    public void acessaPagina() {
        pagina.acessa();
    }



    public void pesquisaResultado() {
        confirma();
        rolarParaBaixoAteEncontrar(pagina.resultado);
        esperaElementoSerClicavel(pagina.resultado);
        clicar(pagina.resultado);
        rolarParaBaixoAteEncontrar(pagina.check);
        clicar(pagina.check);
        rolarParaBaixoAteEncontrar(pagina.mensagemAtual);
        //validaMensagem("Processada", mensagemAtual);
    }
}
