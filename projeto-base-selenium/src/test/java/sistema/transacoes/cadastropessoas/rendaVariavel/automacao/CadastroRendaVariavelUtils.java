package sistema.transacoes.cadastropessoas.rendaVariavel.automacao;


import utils.leitorDeArquivo.config_json.LeitorJson;
import sistema.servico.utils.UtilitarioCadastro;
import sistema.transacoes.cadastropessoas.rendaVariavel.pagina.PaginaCadastroRendaVariavel;

public class CadastroRendaVariavelUtils extends UtilitarioCadastro<CadastroRendaVariavel> {
    public CadastroRendaVariavelUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private final PaginaCadastroRendaVariavel pagina = new PaginaCadastroRendaVariavel();

    @Override
    public void preencheDados(CadastroRendaVariavel dados, int posicao) {
        LeitorJson.carregarDados(obterCaminhoArquivo(), posicao, CadastroRendaVariavel.class);

    }
    @Override
    public void consultar(CadastroRendaVariavel dados, int posicao) {
        dados = LeitorJson.carregarDados(obterCaminhoArquivo(), posicao, CadastroRendaVariavel.class);
        preencheFiltroPesquisa("Carteira", dados.carteira());
        confirmaConsulta();
    }
    @Override
    protected String transacao() {
        return "Transações > Cadastros de Pessoas > Carteiras > Cadastros > Renda Variável";
    }

}
