package teoria.generics;

public class TesteCaixa {

	public static void main(String[] args) {
		Caixa< Double > caixaDeDouble = new Caixa<Double>();
		caixaDeDouble.adicionar( 10.0 );
		Double numero = caixaDeDouble.obter();
		System.out.println( numero );
	}
	
}
