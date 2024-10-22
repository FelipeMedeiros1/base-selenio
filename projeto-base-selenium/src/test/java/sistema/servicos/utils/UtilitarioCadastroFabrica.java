package sistema.servicos.utils;

import sistema.amplis.relatorios.patrimonio.carteira_diaria.automacao.CarteiraDiariaUtils;
import sistema.amplis.relatorios.renda_fixa.movimentacao.automacao.MovimentacaoRelFixUtils;
import sistema.amplis.relatorios.renda_fixa.rendimentos.automacao.RendimentosRelFixUtils;
import sistema.amplis.transacoes.cadastrobasico.moedas.automacao.MoedasUtils;
import sistema.amplis.transacoes.cadastropessoas.fundamental.automacao.FundamentalUtils;
import sistema.amplis.transacoes.cadastropessoas.fundos.automacao.CadastroFundosUtils;
import sistema.amplis.transacoes.cadastropessoas.patrimonio.automacao.CadastroPatrimonioUtils;
import sistema.amplis.transacoes.cadastropessoas.pessoa.automacao.PessoaUtils;
import sistema.amplis.transacoes.cadastropessoas.renda_fixa.automacao.CadastroRendaFixaUtils;
import sistema.amplis.transacoes.fundos.movimentacao.automacao.MovimentacaoFdsUtils;
import sistema.amplis.transacoes.processamento.bloqueio_liberacao.automacao.BloqueioELiberacaoUtils;
import sistema.amplis.transacoes.processamento.cockpit.automacao.CockPitUtils;
import sistema.amplis.transacoes.processamento.processamento.automacao.ProcessamentoUtils;
import sistema.amplis.transacoes.processamento.processamentoContabil.automacao.ProcessamentoContabilUtils;
import sistema.amplis.transacoes.rendafixa.operacoe_compromisadas.automacao.OperacoesCompromissadasFixUtils;
import sistema.amplis.transacoes.rendafixa.operacoes_definitivas.automacao.OperacoesDefinitivasFixUtils;
import sistema.amplis.transacoes.rendafixa.operacoes_termo.automacao.OperacoesATermoFixUtils;

public class UtilitarioCadastroFabrica {
    public static UtilitarioCadastro<?> getUtilitarioCadastro(String pagina, String caminhoJson) {
        switch (pagina.toLowerCase()) {
            case "moedas" -> new MoedasUtils(caminhoJson);
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
