package HttpClient_javaNet;

import com.squareup.okhttp.Request;
import org.apache.http.HttpHost;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.time.Duration;

/**
 * @ClassName HttpPostDemo
 * @Description TODO
 * @Author HttpPostDemo
 * @Data 2021/11/18 11:30
 **/
public class HttpPostDemo {

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, IllegalAccessException {
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request=HttpRequest.newBuilder().GET().uri(new URI("http://life.httpcn.com/"))
                .build();

        HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString(Charset.forName("GBK")));
        System.out.println(response.body());

    }
}
