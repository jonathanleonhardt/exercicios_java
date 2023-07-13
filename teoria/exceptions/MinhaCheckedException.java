package teoria.exceptions;

public class MinhaCheckedException extends Exception {
	public MinhaCheckedException( Throwable e ) {
		System.out.println( "Teste de mensagem exception " + e );
	}
}
