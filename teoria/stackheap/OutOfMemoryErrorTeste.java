package teoria.stackheap;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorTeste {

	public static void main(String[] args) {
		List< Object > lista = new ArrayList<>();
		int x = 1;

		try {
			while( true ) {
				lista.add( new Object() );
				System.out.println( ++x );
			}
		} catch ( OutOfMemoryError e) {
			System.out.println( "Chegou em " + x );
		}
		
	}
	
}
