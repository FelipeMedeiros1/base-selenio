package API.transacoes.renda_fixa.operacoes_compromissadas;

import API.componente.Aba;
import API.componente.EntradaSimples;
import API.componente.SelecionaUm;

public interface LastroDeCompraAba extends Aba {
    EntradaSimples tituloSelicPu550Titulo(String valor);

    SelecionaUm titulo(String valor);

    SelecionaUm emissao(String valor);

    EntradaSimples dataDaEmissao(String valor);

    EntradaSimples dataDeVencimento(String valor);

    SelecionaUm calcular(String valor);

    EntradaSimples financeiroIda(String valor);

    EntradaSimples pu550Pu(String valor);

    EntradaSimples quantidade(String valor);

    EntradaSimples financeiroDeIdaCalculado(String valor);

    EntradaSimples isin(String valor);

    EntradaSimples codigoSelicCetipCompra(String valor);

    SelecionaUm esferaDaEmissao(String valor);

    SelecionaUm empresaLigada(String valor);

    SelecionaUm descricaoBacen(String valor);

    EntradaSimples codigoCBLCCompra(String valor);

    SelecionaUm localidade(String valor);

    SelecionaUm emissorParaPerfilMensal(String valor);

}
