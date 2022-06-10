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

public class GetMailStatus {
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
    public static String makeAuthorization(String timestamp) throws Exception {
        String service = "ses";
        String host = "ses.tencentcloudapi.com";
        String algorithm = "TC3-HMAC-SHA256";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 注意时区，否则容易出错
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String date = sdf.format(new Date(Long.valueOf(timestamp + "000")));
        // ************* 步骤 1：拼接规范请求串 *************
        String httpRequestMethod = "POST";
        String canonicalUri = "/";
        String canonicalQueryString = "";
        String canonicalHeaders = "content-type:application/json; charset=utf-8\n" + "host:" + host + "\n";
        String signedHeaders = "content-type;host";

        String payload =  "{\"Limit\": 100,\"Offset\": 0,\"RequestDate\": \"2021-2-22\"}";
        String hashedRequestPayload = sha256Hex(payload);
        String canonicalRequest = httpRequestMethod + "\n" + canonicalUri + "\n" + canonicalQueryString + "\n"
                + canonicalHeaders + "\n" + signedHeaders + "\n" + hashedRequestPayload;
        System.out.println(canonicalRequest);

        // ************* 步骤 2：拼接待签名字符串 *************
        String credentialScope = date + "/" + service + "/" + "tc3_request";
        String hashedCanonicalRequest = sha256Hex(canonicalRequest);
        String stringToSign = algorithm + "\n" + timestamp + "\n" + credentialScope + "\n" + hashedCanonicalRequest;
        System.out.println(stringToSign);

        // ************* 步骤 3：计算签名 *************
        byte[] secretDate = hmac256(("TC3" + SECRET_KEY).getBytes(UTF8), date);
        byte[] secretService = hmac256(secretDate, service);
        byte[] secretSigning = hmac256(secretService, "tc3_request");
        String signature = DatatypeConverter.printHexBinary(hmac256(secretSigning, stringToSign)).toLowerCase();
        System.out.println(signature);

        // ************* 步骤 4：拼接 Authorization *************
        String authorization = algorithm + " " + "Credential=" + SECRET_ID + "/" + credentialScope + ", "
                + "SignedHeaders=" + signedHeaders + ", " + "Signature=" + signature;
        return authorization;
    }

    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000L);
        HttpPost httpPost = new HttpPost("https://ses.tencentcloudapi.com/");
        httpPost.setHeader("Authorization", makeAuthorization(timestamp));
        httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
        httpPost.setHeader("Host", "ses.tencentcloudapi.com");
        httpPost.setHeader("X-TC-Action", "GetSendEmailStatus");
        httpPost.setHeader("X-TC-Version", "2020-10-02");
        httpPost.setHeader("X-TC-Timestamp", timestamp);
        httpPost.setHeader("X-TC-Region", "ap-hongkong");
        httpPost.setHeader("X-TC-RequestDate","2021-2-22");
        httpPost.setHeader("X-TC-Offset","0");
        httpPost.setHeader("X-TC-Limit","100");
        httpPost.setEntity(new StringEntity(
                "{\"Limit\": 100,\"Offset\": 0,\"RequestDate\": \"2021-2-22\" }"));
        CloseableHttpResponse response = null;
        System.out.println(httpPost.getEntity().getContentEncoding());
        response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        System.out.println(response.getStatusLine());
        System.out.println(entity.getContentLength());
        System.out.println(EntityUtils.toString(entity));
    }
}
