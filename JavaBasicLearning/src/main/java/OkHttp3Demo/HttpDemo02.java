package OkHttp3Demo;

import com.squareup.okhttp.*;

import java.io.IOException;

/**
 * @ClassName HttpDemo02
 * @Description TODO
 * @Author HttpDemo02
 * @Data 2021/11/16 20:55
 **/
public class HttpDemo02 {
    private static final OkHttpClient client = new OkHttpClient();

    public static void run() throws Exception {
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0; i < responseHeaders.size(); i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }

                System.out.println(response.body().string());
            }
        });
    }

    public static void main(String[] args) throws Exception {
        HttpDemo02.run();
    }

}
