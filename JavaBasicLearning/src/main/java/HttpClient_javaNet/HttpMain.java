package HttpClient_javaNet;


import java.io.*;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpMain {
    public static ConcurrentHashMap<String, Integer> hashMap;

    public static void main(String[] args) throws InterruptedException, IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("text.txt"));
        final String keji = "鲸";
        final String keji1="科技";
        ExecutorService service = Executors.newFixedThreadPool(20);

        BufferedReader br = new BufferedReader(new FileReader(new File("text.txt")));
        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line.trim());
        }

        //System.out.println(sb.toString());
        br.close();
        String str = sb.toString();
        //  str = str.replace("\n", "");
        //System.out.println(str);
        for (int i = 0; i < str.length(); i++) {
            String finalString =keji+str.charAt(i)+keji1;
//            service.submit(() -> {
//                try {
            //System.out.println(finalString);
            request(finalString, i);
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//            });
            Thread.sleep(1000);

        }

        Thread.sleep(Integer.MAX_VALUE);
    }

    public static void request(String str, int i) throws UnsupportedEncodingException {
        if (i % 100 == 0) {
            System.out.println("i : " + i);
        }
        String urlEncoder1 = URLEncoder.encode("北京", "gb2312");
        String urlEncoder2 = URLEncoder.encode(str, "gb2312");
        String urlEncoder3 = URLEncoder.encode("有限公司", "gb2312");
        HttpClient httpClient = HttpClient.newBuilder().executor(Executors.newCachedThreadPool()).build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "http://life.httpcn.com/sm_name_company.asp?isbz=0&gslx=0&gsname=&gsname1=" + urlEncoder1 +
                                "&gsname2=" + urlEncoder2 + "&gsname3=" + urlEncoder3 + "&data_type=0&year=1980&month=11&day=17&hour" +
                                "=17&minute=10&pid=&cid=&sex=1&act=submit#main"))
                .GET().build();
        //(HttpRequest.BodyPublishers.ofString("gsname1=北京,gsname2=四书五鲸科技,gsname3=有限公司"));
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body)
                .whenComplete((s, e) -> {
                    if (e != null) {
                        e.printStackTrace();

                    } else {
                        // String res = null;
                        // res = new String(s.getBytes("GBK"), StandardCharsets.UTF_8);
                        //System.out.println(s);
                        String point = s.substring(s.indexOf("style=\"font-size:18px;\"") + 24, s.indexOf(
                                "style=\"font-size:18px;\"") + 26);
                        if (point.charAt(0) == '1') {
                            point = s.substring(s.indexOf("style=\"font-size:18px;\"") + 24, s.indexOf(
                                    "style=\"font-size:18px;\"") + 27);
                        }
                        int num = Integer.parseInt(point);
                      //  System.out.println(num);
                        if (num >= 90) {
                            System.out.print("point : " + num);
                            System.out.println("  name : " + str);
                        }
                    }
                });
    }


}
