package companyName;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class PostHttp {
    public static int cache_size = 1024;

    public static byte[] compressGZIP(byte[] input) {
        if (input == null || input.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(input);
            gzip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    public static byte[] decompressGZIP(byte[] input) {
        if (input == null || input.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input);
        try {
            GZIPInputStream gis = new GZIPInputStream(in);
            byte[] buffer = new byte[cache_size];
            int n;
            while ((n = gis.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    public static void main(String[] args) throws InterruptedException {
        //HttpHost proxy = new HttpHost("127.0.0.1",8888);

        //CloseableHttpClient httpClient = HttpClients.custom().setProxy(proxy).build();
        ProxySelector proxySelector = ProxySelector.of(new InetSocketAddress("127.0.0.1", 8888));
        HttpClient httpClient = HttpClient.newBuilder().proxy(proxySelector).build();
        Map<String, List<String>> hashMap = new HashMap<>();
        hashMap.put("Accept-Encoding", List.of("gzip,deflate"));
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://life.httpcn.com/sm_name_company.asp"))
                .POST(HttpRequest.BodyPublishers.ofString(
                        "isbz=0&gslx=0&gsname=&gsname1=%B1%B1%BE%A9&gsname2=%B1%B1%BE%A8%BF%C6%BC%BC&gsname3=%D3%D0%CF%DE%B9%AB%CB%BE&data_type=0&year=1980&month=11&day=18&hour=10&minute=10&pid=&cid=&sex=1&act=submit"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                //.header("Accept-Encoding", "gzip,deflate")
//                .header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp," +
//                        "image/apng,*/*;" +
//                "q=0.8,application/signed-exchange;v=b3;q=0.9\n" +
//                        "Referer: http://life.httpcn.com/sm_name_company.asp\n")
                .header("Accept-Language","zh-CN,zh;q=0.9,bg;q=0.8,hmn;q=0.7,mn;q=0.6,jv;q=0.5")
                .build();
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString(Charset.forName("GBK"))).thenApply(HttpResponse::body)
                .whenComplete((s, e) -> {
                    if (e != null) {
                        e.printStackTrace();

                    } else {
                        // String res = null;
                        // res = new String(s.getBytes("GBK"), StandardCharsets.UTF_8);
                      //  String content = new String(decompressGZIP(s.getBytes()));
                        //System.out.println(new String(s.getBytes(), StandardCharsets.ISO_8859_1));
                        System.out.println(s);
                        String point = s.substring(s.indexOf("style=\"font-size:18px;\"") + 24, s.indexOf(
                                "style=\"font-size:18px;\"") + 26);
                        if (point.charAt(0) == '1') {
                            point = s.substring(s.indexOf("style=\"font-size:18px;\"") + 24, s.indexOf(
                                    "style=\"font-size:18px;\"") + 27);
                        }
                        int num = Integer.parseInt(point);
                        //  System.out.println(num);

                        System.out.print("point : " + num);
                        //System.out.println("  name : " + str);

                    }
                });
        Thread.sleep(100000);
    }
}
