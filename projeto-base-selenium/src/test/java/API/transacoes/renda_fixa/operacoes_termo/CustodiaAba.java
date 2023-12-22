package API.transacoes.renda_fixa.operacoes_termo;

import API.componente.Aba;
import API.componente.SelecionaUm;

public interface CustodiaAba extends Aba {

    SelecionaUm custodiante(String valor);

    SelecionaUm localDeCustodia(String valor);

    SelecionaUm contaDeCustodia(String valor);

}
