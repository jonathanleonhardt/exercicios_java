package teoria.generics;

public class TesteComparador {
	public static void main(String[] args) {
		Comparador< Integer > comparadorInt = new ComparadorInteger();
		Boolean isBigger = comparadorInt.isBiggerThan( 10, 20 );
	}
}
