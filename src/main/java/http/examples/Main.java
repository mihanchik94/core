package http.examples;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String REMOTE_SERVICE_URI = "https://jsonplaceholder.typicode.com/posts";
    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        CloseableHttpClient client = HttpClientBuilder.create()
                .setUserAgent("My test service")
                        .setDefaultRequestConfig(RequestConfig.custom()
                                .setConnectTimeout(5000)
                                .setSocketTimeout(30000)
                                .setRedirectsEnabled(false)
                                .build()).build();

        HttpGet request = new HttpGet(REMOTE_SERVICE_URI);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

 /*       try (CloseableHttpResponse response = client.execute(request)) {
            //Arrays.stream(response.getAllHeaders()).forEach(System.out::println);
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try (CloseableHttpResponse response = client.execute(request)) {
            List<Post> posts = mapper.readValue(response.getEntity().getContent(), new TypeReference<>() {});
            posts.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
