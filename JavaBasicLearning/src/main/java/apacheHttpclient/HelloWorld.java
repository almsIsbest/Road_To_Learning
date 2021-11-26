package apacheHttpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @ClassName HelloWorld
 * @Description TODO
 * @Author HelloWorld
 * @Data 2021/11/19 14:40
 **/
public class HelloWorld {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.tuicool.com/");
        CloseableHttpResponse response=null;
        try {
            response=httpClient.execute(httpGet);

        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity(); //获取实体
        try {
            System.out.println("网页内容"+EntityUtils.toString(entity,"UTF-8"));//获取网页内容
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
