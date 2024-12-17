package sistema.transacoes.cadastrobasico.moedas.automacao;

import servico.leitorDeArquivo.config_json.LeitorJson;
import servico.utils.UtilitarioCadastro;
import sistema.transacoes.cadastrobasico.moedas.pagina.PaginaMoedas;

public class MoedasUtils extends UtilitarioCadastro<Moedas> {
    public MoedasUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }


    private final PaginaMoedas pagina = new PaginaMoedas();

    @Override
    public void preencheDados(Moedas dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Moedas.class);
        preenche(pagina.codigo, dados.codigo());
        preenche(pagina.nome, dados.nome());
        preenche(pagina.simbolo, dados.simbolo());
        selecionaUm(pagina.status, dados.status());
    }

    public void consultar(Moedas dados, int posicao) {
        try {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Moedas.class);
        preencheFiltroPesquisa("Código", dados.codigo());
        confirmaConsulta();

        }catch (Exception e){
        }
    }

    @Override
    protected String transacao() {
        return "Transações > Cadastros Básicos > Moedas";
    }

}
