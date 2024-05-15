package api.componente;

/**
 * Interface com o sistema que permite filtrar uma informação Leitor partir da
 * seleção de uma opção em uma lista pré-definida.
 * 
 */
public interface FiltroSelecionaUm {

	public void todos();

	public void igual(String valor);

	public void diferente(String valor);

}
