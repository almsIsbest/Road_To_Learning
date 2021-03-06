package mail;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TencentCloudAPITC3Demo {
    private final static Charset UTF8 = StandardCharsets.UTF_8;
    private final static String SECRET_ID = "AKIDiDSQTEJAE3erp890WkFVbXHo68tPtlc1";
    private final static String SECRET_KEY = "JadLr9GA3jBuOdbT6uWvHNl160e4ez5D";
    private final static String CT_JSON = "application/json; charset=utf-8";

    public static byte[] hmac256(byte[] key, String msg) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, mac.getAlgorithm());
        mac.init(secretKeySpec);
        return mac.doFinal(msg.getBytes(UTF8));
    }

    public static String sha256Hex(String s) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] d = md.digest(s.getBytes(UTF8));
        return DatatypeConverter.printHexBinary(d).toLowerCase();
    }

    public void main1(String[] args) throws Exception {
        String service = "cvm";
        String host = "cvm.tencentcloudapi.com";
        String region = "ap-guangzhou";
        String action = "DescribeInstances";
        String version = "2017-03-12";
        String algorithm = "TC3-HMAC-SHA256";
        String timestamp = "1551113065";
        //String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // ?????????????????????????????????
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String date = sdf.format(new Date(Long.valueOf(timestamp + "000")));

        // ************* ?????? 1???????????????????????? *************
        String httpRequestMethod = "POST";
        String canonicalUri = "/";
        String canonicalQueryString = "";
        String canonicalHeaders = "content-type:application/json; charset=utf-8\n" + "host:" + host + "\n";
        String signedHeaders = "content-type;host";

        String payload = "{\"Limit\": 1, \"Filters\": [{\"Values\": [\"\\u672a\\u547d\\u540d\"], \"Name\": \"instance-name\"}]}";
        String hashedRequestPayload = sha256Hex(payload);
        String canonicalRequest = httpRequestMethod + "\n" + canonicalUri + "\n" + canonicalQueryString + "\n"
                + canonicalHeaders + "\n" + signedHeaders + "\n" + hashedRequestPayload;
        System.out.println(canonicalRequest);

        // ************* ?????? 2??????????????????????????? *************
        String credentialScope = date + "/" + service + "/" + "tc3_request";
        String hashedCanonicalRequest = sha256Hex(canonicalRequest);
        String stringToSign = algorithm + "\n" + timestamp + "\n" + credentialScope + "\n" + hashedCanonicalRequest;
        System.out.println(stringToSign);

        // ************* ?????? 3??????????????? *************
        byte[] secretDate = hmac256(("TC3" + SECRET_KEY).getBytes(UTF8), date);
        byte[] secretService = hmac256(secretDate, service);
        byte[] secretSigning = hmac256(secretService, "tc3_request");
        String signature = DatatypeConverter.printHexBinary(hmac256(secretSigning, stringToSign)).toLowerCase();
        System.out.println(signature);

        // ************* ?????? 4????????? Authorization *************
        String authorization = algorithm + " " + "Credential=" + SECRET_ID + "/" + credentialScope + ", "
                + "SignedHeaders=" + signedHeaders + ", " + "Signature=" + signature;
        System.out.println(authorization);

        TreeMap<String, String> headers = new TreeMap<String, String>();
        headers.put("Authorization", authorization);
        headers.put("Content-Type", CT_JSON);
        headers.put("Host", host);
        headers.put("X-TC-Action", action);
        headers.put("X-TC-Timestamp", timestamp);
        headers.put("X-TC-Version", version);
        headers.put("X-TC-Region", region);

        StringBuilder sb = new StringBuilder();
        sb.append("curl -X POST https://").append(host)
                .append(" -H \"Authorization: ").append(authorization).append("\"")
                .append(" -H \"Content-Type: application/json; charset=utf-8\"")
                .append(" -H \"Host: ").append(host).append("\"")
                .append(" -H \"X-TC-Action: ").append(action).append("\"")
                .append(" -H \"X-TC-Timestamp: ").append(timestamp).append("\"")
                .append(" -H \"X-TC-Version: ").append(version).append("\"")
                .append(" -H \"X-TC-Region: ").append(region).append("\"")
                .append(" -d '").append(payload).append("'");
        System.out.println(sb.toString());
    }

    public static String makeAuthorization(String timestamp) throws Exception {
        String service = "ses";
        String host = "ses.tencentcloudapi.com";
        String algorithm = "TC3-HMAC-SHA256";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // ?????????????????????????????????
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String date = sdf.format(new Date(Long.valueOf(timestamp + "000")));
        // ************* ?????? 1???????????????????????? *************
        String httpRequestMethod = "POST";
        String canonicalUri = "/";
        String canonicalQueryString = "";
        String canonicalHeaders = "content-type:application/json; charset=utf-8\n" + "host:" + host + "\n";
        String signedHeaders = "content-type;host";
        String payload =  "{\"FromEmailAddress\":\"noreply@mail.poolrival.net\",\"ReplyToAddresses\":\" \"," +
                "\"Destination\":[\"acceleatorxlastorder@gmail.com\"],\"Template\":{\"TemplateID\":13274," +
                "\"TemplateData\":\"{\\\"code\\\":\\\"1234\\\"}\"},\"Subject\": \"YourTestSubject\"}";
        String hashedRequestPayload = sha256Hex(payload);
        String canonicalRequest = httpRequestMethod + "\n" + canonicalUri + "\n" + canonicalQueryString + "\n"
                + canonicalHeaders + "\n" + signedHeaders + "\n" + hashedRequestPayload;
         System.out.println(canonicalRequest);
        // ************* ?????? 2??????????????????????????? *************
        String credentialScope = date + "/" + service + "/" + "tc3_request";
        String hashedCanonicalRequest = sha256Hex(canonicalRequest);
        String stringToSign = algorithm + "\n" + timestamp + "\n" + credentialScope + "\n" + hashedCanonicalRequest;
        System.out.println(stringToSign);
        // ************* ?????? 3??????????????? *************
        byte[] secretDate = hmac256(("TC3" + SECRET_KEY).getBytes(UTF8), date);
        byte[] secretService = hmac256(secretDate, service);
        byte[] secretSigning = hmac256(secretService, "tc3_request");
        String signature = DatatypeConverter.printHexBinary(hmac256(secretSigning, stringToSign)).toLowerCase();
        System.out.println(signature);

        // ************* ?????? 4????????? Authorization *************
        String authorization = algorithm + " " + "Credential=" + SECRET_ID + "/" + credentialScope + ", "
                + "SignedHeaders=" + signedHeaders + ", " + "Signature=" + signature;
        return authorization;
    }
    public static void sendMail() throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000L);
        HttpPost httpPost = new HttpPost("https://ses.tencentcloudapi.com/");
        httpPost.setHeader("Authorization", makeAuthorization(timestamp));
        httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
        httpPost.setHeader("Host", "ses.tencentcloudapi.com");
        httpPost.setHeader("X-TC-Action", "SendEmail");
        httpPost.setHeader("X-TC-Version", "2020-10-02");
        httpPost.setHeader("X-TC-Timestamp", timestamp);
        httpPost.setHeader("X-TC-Region", "ap-hongkong");
        httpPost.setEntity(new StringEntity(
                "{\"FromEmailAddress\":\"noreply@mail.poolrival.net\",\"ReplyToAddresses\":\" \"," +
                        "\"Destination\":[\"acceleatorxlastorder@gmail.com\"],\"Template\":{\"TemplateID\":13274," +
                        "\"TemplateData\":\"{\\\"code\\\":\\\"1234\\\"}\"},\"Subject\": \"YourTestSubject\"}"));
        CloseableHttpResponse response = null;
        System.out.println(httpPost.getEntity().getContentEncoding());
        response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        System.out.println(response.getStatusLine());
        System.out.println(entity.getContentLength());
        System.out.println(EntityUtils.toString(entity));
    }
    public static void main(String[] args) throws Exception {
//        ExecutorService service  = Executors.newCachedThreadPool();
//        Thread thread = new Thread(()->{
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            try {
//                sendMail();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//        for (int i = 0; i < 10; i++) {
//            service.execute(thread);
//        }
//        System.out.println("end");
        sendMail();
    }
}