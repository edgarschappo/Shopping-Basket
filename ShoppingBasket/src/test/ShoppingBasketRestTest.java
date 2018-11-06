package test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

public class ShoppingBasketRestTest {

	private String BASE_URL = "http://localhost:8080/shopping-basket/service/showBasket";
	
	private String postcode_1 = "?postcode=1111";
	private String postcode_2 = "?postcode=2222";
	private String postcode_3 = "?postcode=3333";
	private String postcode_4 = "?postcode=4444";
	private String postcode_wrong = "?postcode=5555";
	
	/*
	 * Tests Rest API Service
	 */
	@Test
	public void restAPIService() {

		Boolean expected = true;
		Boolean connectionResult = false;

		try {
			//Test Response Status OK
			request(200, BASE_URL + postcode_1, "GET");
			request(200, BASE_URL + postcode_2, "GET");
			request(200, BASE_URL + postcode_3, "GET");
			request(200, BASE_URL + postcode_4, "GET");
			
			//Test Response Status Internal Server Error
			request(500, BASE_URL + postcode_wrong, "GET");

			connectionResult = true;

		} catch (IOException e) {
			connectionResult = false;
		}

		// Test server unavailable
		assertEquals(expected, connectionResult);
	}
	
	private String request(int code, String urlapi, String method) throws IOException {

		BufferedReader br;

		URL url = new URL(urlapi);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(method);
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setDoOutput(true);

		conn.getResponseMessage();

		int responseCode = conn.getResponseCode();

		if (responseCode >= 200 && responseCode <= 399)
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		else
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));

		String s = br.readLine();

		if (code != 0)
			assertEquals(code, responseCode);

		return s;
	}

}
