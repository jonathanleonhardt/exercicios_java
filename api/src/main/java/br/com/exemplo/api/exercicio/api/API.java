package br.com.exemplo.api.exercicio.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class API {
	public int port;

	public API ( int port ) {
		this.port = port;
	}

	public void createAPI( Router router ) {
		try {
			ServerSocket serverSocket = new ServerSocket( port );
			System.out.println( "App rodando em http://localhost:" + port );
			while( true ) {
				Socket clientSocket = serverSocket.accept();
				handleRequest( clientSocket, router );
			}
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	private void handleRequest( Socket clientSocket, Router router ) {
		try {
			InputStream inputStream = clientSocket.getInputStream();
			OutputStream outputStream = clientSocket.getOutputStream();
			String request = this.extractRequest( inputStream );

			if ( request != null && !request.isEmpty()) {
				String response = router.route( request );
				this.sendResponse( outputStream, response );
			}

			clientSocket.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	private String extractRequest( InputStream inputStream ) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		byte[] buffer = new byte[ 4096 ];
		int bytesRead;
		while ( ( bytesRead = inputStream.read( buffer ) ) != -1 ) {
			stringBuilder.append( new String( buffer, 0, bytesRead ) );
			if ( stringBuilder.toString().contains( "\r\n\r\n" ) ) {
				break;
			}
		}

		return stringBuilder.toString();
	}

	private void sendResponse( OutputStream outputStream, String response ) throws IOException {
		String respostaCompleta = "HTTP/1.1 200 OK\r\n\r\n" + response;
		outputStream.write( respostaCompleta.getBytes() );
		outputStream.flush();
	}
	
}
