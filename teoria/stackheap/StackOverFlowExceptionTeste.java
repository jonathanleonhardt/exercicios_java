package teoria.stackheap;

public class StackOverFlowExceptionTeste {

	public static void main(String[] args) {
		// -Xss1m
		// -Xss1000m

		// java -Xss3m teoria/stackheap/StackOverFlowExceptionTeste

		teste( 1 );
	}

	private static void teste( int x ) {
		System.out.println( x );

		try {
			teste( ++x );
		} catch ( StackOverflowError e ) {
			System.out.println( "Travou quando chegou em " + x );
		}
	}

}
