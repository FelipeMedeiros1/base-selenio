package amplis.transacoes.cadastrobasico.moedas.automacao;

import servico.leitorDeArquivo.config_json.LeitorJson;
import amplis.transacoes.cadastrobasico.moedas.pagina.PaginaMoedas;
import webdriver.base.navegacao.automacao.MenuNavegacao;
import servico.utils.UtilitarioCadastro;
;


import static com.aventstack.extentreports.model.service.TestService.createTest;


public class MoedasUtils extends UtilitarioCadastro<Moedas> {
    public MoedasUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }


    private PaginaMoedas pagina = new PaginaMoedas();

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
    public void acessaPagina() {
        new MenuNavegacao().transacoesCadastroBasico(pagina.paginaMoedas);

    }

    @Override
    protected String transacao() {
        return "Transações > Cadastros Básicos > Moedas";
    }

}
