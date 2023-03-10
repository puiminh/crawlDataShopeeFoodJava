package stackjava.com.httpcomponentsget.demo;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class HttpClientGet {
	public static void main(String[] args) throws ClientProtocolException, IOException {

		int shop_id = 110061;

		HttpGet httpGet = new HttpGet("https://gappapi.deliverynow.vn/api/dish/get_delivery_dishes?id_type=2&request_id="+shop_id);

		httpGet.addHeader("accept","application/json, text/plain, */*");
		httpGet.addHeader("accept-language","en-US,en;q=0.9,ja;q=0.8,vi;q=0.7");
		httpGet.addHeader("sec-ch-ua","\"Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108\"");
		httpGet.addHeader("sec-ch-ua-mobile","?0");
		httpGet.addHeader("sec-ch-ua-platform","\"Windows\"");
		httpGet.addHeader("sec-fetch-dest", "empty");
		httpGet.addHeader("sec-fetch-mode", "cors");
		httpGet.addHeader("sec-fetch-site", "cross-site");
		httpGet.addHeader("x-foody-access-token", "");
		httpGet.addHeader("x-foody-api-version", "1");
		httpGet.addHeader("x-foody-access-token", "");
		httpGet.addHeader("x-foody-app-type", "1004");
		httpGet.addHeader("x-foody-client-id", "");
		httpGet.addHeader("x-foody-client-language", "vi");
		httpGet.addHeader("x-foody-client-type", "1");
		httpGet.addHeader("x-foody-client-version", "3.0.0");
		httpGet.addHeader("referrer", "https://shopeefood.vn/");
		httpGet.addHeader("referrerPolicy", "strict-origin-when-cross-origin");
		httpGet.addHeader("x-foody-access-token", "");
		httpGet.addHeader("body", null);
		httpGet.addHeader("method", "GET");
		httpGet.addHeader("mode", "cors");
		httpGet.addHeader("credentials",  "omit");

		HttpClient client = HttpClients.createDefault();
		HttpResponse httpResponse = client.execute(httpGet);
		System.out.println("Protocol: " + httpResponse.getProtocolVersion());
		System.out.println("Status:" + httpResponse.getStatusLine().toString());
		System.out.println("Content type:" + httpResponse.getEntity().getContentType());
		System.out.println("Locale:" + httpResponse.getLocale());
		System.out.println("Headers:");


		for(Header header : httpResponse.getAllHeaders()) {
			System.out.println("          " + header.getName()+": " + header.getValue());
		}
		System.out.println("Content:");
		String content = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
		System.out.println(content);
	}
}
