package API.transacoes.renda_fixa.operacoestermo;

import API.componente.Aba;
import API.componente.SelecionaUm;

public interface CustodiaAba extends Aba {

    SelecionaUm custodiante(String valor);

    SelecionaUm localDeCustodia(String valor);

    SelecionaUm contaDeCustodia(String valor);

}
