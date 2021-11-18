package HttpClient_javaNet;

import com.squareup.okhttp.Request;
import org.apache.http.HttpHost;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;

/**
 * @ClassName HttpPostDemo
 * @Description TODO
 * @Author HttpPostDemo
 * @Data 2021/11/18 11:30
 **/
public class HttpPostDemo {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request=HttpRequest.newBuilder().GET().uri(new URI("https://javaherobrine.github.io"))
                .build();

        HttpResponse<byte[]> response=client.send(request, HttpResponse.BodyHandlers.ofByteArray());
        System.out.println(response.headers().map());
    }
}
