package API.componente;

/**
 * Interface com o sistema que permite filtrar uma informação a partir da
 * seleção de uma opção em uma lista pré-definida.
 * 
 */
public interface FiltroSelecionaUm {

	public void todos();

	public void igual(String valor);

	public void diferente(String valor);

}
