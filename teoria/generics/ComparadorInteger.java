package teoria.generics;

public class ComparadorInteger implements Comparador< Integer > {

	@Override
	public Boolean isBiggerThan( Integer objeto1, Integer objeto2 ) {
		return objeto1 > objeto2;
	}
	
}
