package br.com.exemplo.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsumirApi {
	public static void main(String[] args) {
		String urlApi = "https://rickandmortyapi.com/api/character/";

		try {
			URL url = new URL( urlApi );
			HttpURLConnection  connection = ( HttpURLConnection ) url.openConnection();
			connection.setRequestMethod( "GET" );

			int resposeStatus = connection.getResponseCode();
			System.out.println( "Request GET " + urlApi + " - " + resposeStatus );

			if ( resposeStatus == HttpURLConnection.HTTP_OK ) {
				BufferedReader reader = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
				String input;
				StringBuffer response = new StringBuffer();

				while( ( input = reader.readLine() ) != null  ) {
					response.append( input );
				}
				reader.close();

				System.out.println( "Response API: " );
				System.out.println( response.toString() );

			} else {
				System.out.println( "Erro while reading response!" );
			}

		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
	
}
