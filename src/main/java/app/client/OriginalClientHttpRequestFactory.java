package app.client;

import java.net.URI;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class OriginalClientHttpRequestFactory extends HttpComponentsClientHttpRequestFactory {

    /**
     * リクエストハンドリング<br>
     * このクラスで、GETとDELETEにおいて、インナークラスが呼び出されるようにする。
     */
    @Override
    protected HttpUriRequest createHttpUriRequest(HttpMethod httpMethod, URI uri) {
        switch (httpMethod) {
            case GET:
                return new HttpGet(uri);
            case HEAD:
                return new HttpHead(uri);
            case POST:
                return new HttpPost(uri);
            case PUT:
                return new HttpPut(uri);
            case PATCH:
                return new HttpPatch(uri);
            case DELETE:
                return new HttpDelete(uri);
            case OPTIONS:
                return new HttpOptions(uri);
            case TRACE:
                return new HttpTrace(uri);
            default:
                throw new IllegalArgumentException("Invalid HTTP method: " + httpMethod);
        }
    }
    
    /** Getメソッドでボディ部を許可するためのクラス */
    private static class HttpGet extends HttpEntityEnclosingRequestBase {

        public HttpGet(URI uri) {
            super();
            setURI(uri);
        }

        @Override
        public String getMethod() {
            return "GET";
        }
    }

    /** Deleteメソッドでボディ部を許可するためのクラス */
    private static class HttpDelete extends HttpEntityEnclosingRequestBase {

        public HttpDelete(URI uri) {
            super();
            setURI(uri);
        }

        @Override
        public String getMethod() {
            return "DELETE";
        }
    }
}
