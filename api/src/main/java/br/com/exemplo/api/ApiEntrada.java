package br.com.exemplo.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class ApiEntrada {
	public static void main( String[] args ) {
		try {
			int port = 8084;
			ServerSocket socket = new ServerSocket( port );
			System.out.println( "App rodando em http://localhost:" + port );
			while( true ) {
				Socket client = socket.accept();
				handleRequest( client );
			}
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	private static void handleRequest( Socket client ) {
		try {
			InputStream inputStream = client.getInputStream();
			OutputStream outputStream = client.getOutputStream();

			StringBuilder stringBuilder = new StringBuilder();
			byte[] buffer = new byte[4096];
			int bytesRead;
			while( ( bytesRead = inputStream.read( buffer ) ) != -1 ) {
				stringBuilder.append( new String( buffer, 0, bytesRead ) );
				if ( stringBuilder.toString().contains( "\r\n\r\n" )) {
					break;
				}
			}

			String request = stringBuilder.toString();
			String response;

			if ( request.contains( "GET /meunome" ) ) {
				response = "HTTP/1.1 200 OK\r\n\r\nHello for GET meunome!";
			} else if ( request.contains( "POST" ) ) {
				response = "HTTP/1.1 200 OK\r\n\r\nHello for POST!";
			} else {
				response = "HTTP/1.1 400 Bad Request\r\n\r\nMétodo não implementado!";
			}


			outputStream.write( response.getBytes() );
			outputStream.flush();
			client.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	};
}
