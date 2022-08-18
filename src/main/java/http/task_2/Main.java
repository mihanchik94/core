package http.task_2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;

public class Main {
    private static final String URI = "https://api.nasa.gov/planetary/apod?api_key=MfAkalTi0LqAUx0htF7jjpDkMZQOLRxfMzJ0JCi0";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(URI);
        try (CloseableHttpResponse response = client.execute(request)) {
            ResponseNasa nasa = MAPPER.readValue(response.getEntity().getContent(), new TypeReference<>() {
            });
            download(nasa);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String parseURI(String uri) {
        String[] parts = uri.split("/");
        return parts[parts.length - 1];
    }

    public static void download(ResponseNasa resp) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(resp.getUrl());
        try (CloseableHttpResponse response = client.execute(request);
        FileOutputStream writer = new FileOutputStream(parseURI(resp.getUrl()))) {
            writer.write(response.getEntity().getContent().readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}