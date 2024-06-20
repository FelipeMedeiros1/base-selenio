package sistema.amplis.relatorios.patrimonio.carteira_diaria.automacao;


import sistema.amplis.relatorios.patrimonio.carteira_diaria.pagina.PaginaCarteiraDiaria;
import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.UtilitarioRelatorioTestCase;


public class CarteiraDiariaUtils extends UtilitarioRelatorioTestCase<CarteiraDiaria> {

    private PaginaCarteiraDiaria pagina = new PaginaCarteiraDiaria();

    public CarteiraDiariaUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(CarteiraDiaria dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CarteiraDiaria.class);

        pagina.preenche(pagina.dataInicio, dados.dataInicio());
        pagina.preenche(pagina.dataFinal, dados.dataFinal());
        pagina.clicar(pagina.deseleciona).selecionaVarios(pagina.tipoDePosicao, pagina.incluir, dados.tipoDePosicao());
        pagina.selecionaUm(pagina.tipoDeConsolidacao, dados.tipoDeConsolidacao());
        pagina.selecionaUm(pagina.custoMedio, dados.custoMedio());
        pagina.selecionaVarios(pagina.carteira, pagina.incluirCarteira, dados.carteira());
        pagina.selecionaUm(pagina.tipoDoRelatorio, dados.tipoDoRelatorio());
        pagina.selecionaUm(pagina.saida, dados.saida());
    }

    @Override
    public CarteiraDiariaUtils gerarRelatorio(CarteiraDiaria dados, int posicao) {
        acessa();
        preencheDados(dados, posicao);
        pagina.confirma();
        return this;
    }

    @Override
    public void acessa() {
        pagina.acessa();
    }

    @Override
    public void confirmaOperacao() {
        pagina.confirma();
    }
}
