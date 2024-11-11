package amplis.transacoes.cadastropessoas.patrimonio.automacao;

import amplis.transacoes.cadastropessoas.patrimonio.pagina.PaginaCadastroPatrimonio;
import servico.leitorDeArquivo.config_json.LeitorJson;
import webdriver.base.navegacao.automacao.MenuNavegacao;
import servico.utils.UtilitarioCadastro;

public class CadastroPatrimonioUtils extends UtilitarioCadastro<CadastroPatrimonio> {
    public CadastroPatrimonioUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaCadastroPatrimonio pagina = new PaginaCadastroPatrimonio();

    @Override
    public void preencheDados(CadastroPatrimonio dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CadastroPatrimonio.class);
        preencheAutoComplete(pagina.carteira, dados.carteira());
        preencheAutoComplete(pagina.valorDaCotaInicial, dados.valorDaCotaInicial());
    }

    @Override
    public void consultar(CadastroPatrimonio dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CadastroPatrimonio.class);
        preencheFiltroPesquisa("Carteira", dados.carteira());
        confirmaConsulta();
    }

    @Override
    public void acessaPagina() {
        new MenuNavegacao().transacoesCadastroDePessoas(pagina.cadastroPatrimonio);
    }

    @Override
    protected String transacao() {
        return null;
    }
}
