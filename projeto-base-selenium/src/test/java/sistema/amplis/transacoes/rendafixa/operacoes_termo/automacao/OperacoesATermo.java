package sistema.amplis.transacoes.rendafixa.operacoes_termo.automacao;

import lombok.Data;
import lombok.NoArgsConstructor;


public record OperacoesATermo(
        int id,
        String modalidadeDoMovimento,
        String dataDoMovimento,
        String dataDaCompra,
        String dataDoVencimentoDoTermo,
        String carteira,
        String titulo,
        String emissao,
        String subsegmentoPrevic,
        String estoque,
        String nivelDeRisco,
        String ativaPassiva,
        String categoria,
        String riscoBeneficio,
        String condicaoDeNegociacao,
        String taxaDeNegociacao,
        String pu,
        String quantidade,
        String rendimento,
        String irDaOperacao,
        String iofDaOperacao,
        String eventoEmAtraso,
        String custodiante,
        String localDeCustodia,
        String contaDeCustodia

) {


}
