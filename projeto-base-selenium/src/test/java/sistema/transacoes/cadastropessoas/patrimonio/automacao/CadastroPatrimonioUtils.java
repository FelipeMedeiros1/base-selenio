package sistema.transacoes.cadastropessoas.patrimonio.automacao;


import servico.leitorDeArquivo.config_json.LeitorJson;
import servico.utils.UtilitarioCadastro;
import sistema.transacoes.cadastropessoas.patrimonio.pagina.PaginaCadastroPatrimonio;

public class CadastroPatrimonioUtils extends UtilitarioCadastro<CadastroPatrimonio> {
    public CadastroPatrimonioUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private final PaginaCadastroPatrimonio pagina = new PaginaCadastroPatrimonio();

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
    protected String transacao() {
        return null;
    }
}
