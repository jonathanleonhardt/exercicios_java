package teoria.exceptions;

public class MinhaUncheckedException extends RuntimeException {

	public MinhaUncheckedException( Throwable e ) {
		System.out.println( "Teste de mensagem exception " + e );
	}
	
}
