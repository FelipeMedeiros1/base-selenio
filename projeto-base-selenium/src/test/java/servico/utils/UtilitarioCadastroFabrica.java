package servico.utils;

import amplis.relatorios.patrimonio.carteira_diaria.automacao.CarteiraDiariaUtils;
import amplis.relatorios.renda_fixa.movimentacao.automacao.MovimentacaoRelFixUtils;
import amplis.relatorios.renda_fixa.rendimentos.automacao.RendimentosRelFixUtils;
import amplis.transacoes.cadastrobasico.moedas.automacao.MoedasUtils;
import amplis.transacoes.cadastropessoas.fundamental.automacao.FundamentalUtils;
import amplis.transacoes.cadastropessoas.fundos.automacao.CadastroFundosUtils;
import amplis.transacoes.cadastropessoas.patrimonio.automacao.CadastroPatrimonioUtils;
import amplis.transacoes.cadastropessoas.pessoa.automacao.PessoaUtils;
import amplis.transacoes.cadastropessoas.renda_fixa.automacao.CadastroRendaFixaUtils;
import amplis.transacoes.fundos.movimentacao.automacao.MovimentacaoFdsUtils;
import amplis.transacoes.processamento.bloqueio_liberacao.automacao.BloqueioELiberacaoUtils;
import amplis.transacoes.processamento.cockpit.automacao.CockPitUtils;
import amplis.transacoes.processamento.processamento.automacao.ProcessamentoUtils;
import amplis.transacoes.processamento.processamentoContabil.automacao.ProcessamentoContabilUtils;
import amplis.transacoes.rendafixa.operacoe_compromisadas.automacao.OperacoesCompromissadasFixUtils;
import amplis.transacoes.rendafixa.operacoes_definitivas.automacao.OperacoesDefinitivasFixUtils;
import amplis.transacoes.rendafixa.operacoes_termo.automacao.OperacoesATermoFixUtils;

public class UtilitarioCadastroFabrica {
    public static UtilitarioCadastro<?> getUtilitarioCadastro(String pagina, String caminhoJson) {
        switch (pagina) {
            case "Transações > Cadastros Básicos > Moedas" -> new MoedasUtils(caminhoJson);
            case "fundamental" -> new FundamentalUtils(caminhoJson);
            case "cadastrofundo" -> new CadastroFundosUtils(caminhoJson);
            case "patrimonio" -> new CadastroPatrimonioUtils(caminhoJson);
            case "pessoa" -> new PessoaUtils(caminhoJson);
            case "cadastrorendafixa" -> new CadastroRendaFixaUtils(caminhoJson);
            case "fundosmovimentacao" -> new MovimentacaoFdsUtils(caminhoJson);
            case "bloqueioliberacao" -> new BloqueioELiberacaoUtils(caminhoJson);
            case "cockpit" -> new CockPitUtils(caminhoJson);
            case "processamento" -> new ProcessamentoUtils(caminhoJson);
            case "processamentocontabil" -> new ProcessamentoContabilUtils(caminhoJson);
            case "rendafixaoperacoescompromissadas" -> new OperacoesCompromissadasFixUtils(caminhoJson);
            case "rendafixaoperacoesdefinitivas" -> new OperacoesDefinitivasFixUtils(caminhoJson);
            case "rendafixaoperacoesatermo" -> new OperacoesATermoFixUtils(caminhoJson);
            case "relatoriocarteiradiaria" -> new CarteiraDiariaUtils(caminhoJson);
            case "relatoriorendafixamovimentacao" -> new MovimentacaoRelFixUtils(caminhoJson);
            case "relatoriorendafixarendimentos" -> new RendimentosRelFixUtils(caminhoJson);
            // Adicionar outras entidades conforme necessário
            default -> throw new IllegalArgumentException("Entidade desconhecida ou não implementada: " + pagina);

        }
        return null;
    }
}
