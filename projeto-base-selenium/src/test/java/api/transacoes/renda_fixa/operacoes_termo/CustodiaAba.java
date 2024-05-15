package api.transacoes.renda_fixa.operacoes_termo;

import api.componente.Aba;
import api.componente.SelecionaUm;

public interface CustodiaAba extends Aba {

    SelecionaUm custodiante(String valor);

    SelecionaUm localDeCustodia(String valor);

    SelecionaUm contaDeCustodia(String valor);

}
