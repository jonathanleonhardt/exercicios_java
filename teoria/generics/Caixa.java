package teoria.generics;

public class Caixa< T > {

	private T objeto;

	public void adicionar( T obj ) {
		this.objeto = obj;
	}

	public T obter() {
		return objeto;
	}

}
