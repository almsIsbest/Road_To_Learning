package OkHttp3Demo;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @ClassName HttpDemo
 * @Description TODO
 * @Author HttpDemo
 * @Data 2021/11/16 20:46
 **/
public class HttpDemo {
   public static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws Exception {
          run();
    }

    public static void run() throws Exception {
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        Headers responseHeaders = response.headers();
        for (int i = 0; i < responseHeaders.size(); i++) {
            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }

        System.out.println(response.body().string());
    }
}
