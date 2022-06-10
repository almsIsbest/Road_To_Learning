package lambda;

public class Lambda {
    public static String string = "qwewqewqe?";
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            string = string.replace("?",String.valueOf(i));
            long begin = System.currentTimeMillis();
            System.out.println("before   "+string);
            ConsumerMain.useConsumer(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()-begin);
                return string;
            });
        }

    }
}
