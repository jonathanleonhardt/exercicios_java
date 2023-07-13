package teoria.exceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		testeUnchecked();

		try {
			testeChecked();
		} catch ( MinhaCheckedException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private static void testeUnchecked() {
		try {
			Scanner scanner = new Scanner( System.in );
			scanner.nextShort();
		} catch( InputMismatchException e ) {
			throw new MinhaUncheckedException( e );
		}
	}

	private static void testeChecked() throws MinhaCheckedException {
		try {
			Scanner scanner = new Scanner( System.in );
			scanner.nextShort();
		} catch( InputMismatchException e ) {
			throw new MinhaCheckedException( e );
		}
	}

	private static void testeUncheckedSemThrow(){

		try {
			Scanner scanner = new Scanner( System.in );
			scanner.nextShort();
		} catch( NullPointerException e ) {
			// segue a vida
		} catch( InputMismatchException e ) {
			Scanner scanner = new Scanner( System.in );
			scanner.nextLine();
		}

		try {
			Scanner scanner = new Scanner( System.in );
			scanner.nextShort();
		} catch( NullPointerException e ) {
			// segue a vida
		} catch( NoSuchElementException | IllegalStateException | OutOfMemoryError e ) {
			Scanner scanner = new Scanner( System.in );
			scanner.nextLine();
		}
	}

	private static void testeThrowIf( String name ) {
		if ( Objects.isNull(name) ) {
			throw new IllegalArgumentException( "Processo finalizado, nome vazio" );
		}
	}

	private static void testeMultyThrow( String name ) throws MinhaCheckedException, IllegalArgumentException {
		if ( Objects.isNull(name) ) {
			throw new IllegalArgumentException( "Processo finalizado, nome vazio" );
		}
		try {
			Scanner scanner = new Scanner( System.in );
			scanner.nextShort();
		} catch( InputMismatchException e ) {
			throw new MinhaCheckedException( e );
		}
	}

	private static void testeComFinally( String name ) throws MinhaCheckedException, IllegalArgumentException {
		String teste;
		try {
			Scanner scanner = new Scanner( System.in );
			teste = scanner.nextLine();
		} catch( InputMismatchException e ) {
			throw new MinhaCheckedException( e );
		} finally {
			System.out.println( "Leitura realizada" );
		}

	}

	private static void testeTryWithResource( String name ) throws MinhaCheckedException, IllegalArgumentException {
		Scanner scanner = null;
		try {
			scanner = new Scanner( System.in );
			scanner.nextShort();
		} catch( InputMismatchException e ) {
			throw new MinhaCheckedException( e );
		} finally {
			scanner.close();
		}

		try ( Scanner scannerAutoClose = new Scanner( System.in ) ) {
			scannerAutoClose.nextShort();
		} catch( InputMismatchException e ) {
			throw new MinhaCheckedException( e );
		}
	}

}
