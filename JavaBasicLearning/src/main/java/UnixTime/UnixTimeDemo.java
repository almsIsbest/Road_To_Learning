package UnixTime;

/**
 * @ClassName UnixTimeDemo
 * @Description TODO
 * @Author UnixTimeDemo
 * @Data 2021/11/23 14:09
 **/
public class UnixTimeDemo {
    public  static  long duration=3*24*3600;

    public static void main(String[] args) {
        long currtime=System.currentTimeMillis()/1000;
        long time1=currtime+duration;
        System.out.println(time1);
        System.out.println((time1-currtime)/3600);;

    }
}
