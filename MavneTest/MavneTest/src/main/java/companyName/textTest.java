package companyName;

public class textTest {
    public static void main(String[] args) {

        String string  = "</b><font class=\"green\" style=\"font-size:18px;\">72";
        System.out.println("style=\"font-size:18px;\"".length());
        System.out.println(string.indexOf("style=\"font-size:18px;\""));
        System.out.println(string.substring(string.indexOf("style=\"font-size:18px;\"")+24,string.indexOf("style" +
                "=\"font-size:18px;\"")+26));
    }
}
