package app.client;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.springframework.http.client.SimpleClientHttpRequestFactory;

public class OriginalClientHttpRequestFactory extends SimpleClientHttpRequestFactory{

    @Override
    protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
        super.prepareConnection(connection, httpMethod);
        connection.setDoOutput(true);
    }
    
}
