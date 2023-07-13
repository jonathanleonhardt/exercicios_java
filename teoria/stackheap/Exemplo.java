package teoria.stackheap;

import java.util.ArrayList;
import java.util.List;

public class Exemplo {

	public static void main(String[] args) {
		// instruções ficam na stack
		metodoSimples( "Exemplo " );

		
		// primitivos ficam na stack
		int x = 0;
		double y = 2;

		// referencia de 'list' fica na stack
		List< String > list = new ArrayList<>();
		list.add( "curso" ); // Objetos complexos ficam na heap

		System.out.println( y ); // instruções ficam na stack
	}

	private static void metodoSimples( String teste ) {
		String syo = "syo";
		int z = 3;
		teste = teste + syo + z;
	}
	
}
