package mathtest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName mathtest
 * @Description TODO
 * @Author alms
 * @Data 2022/2/25 17:39
 **/
public class mathtest {
    public static AtomicInteger atomicInteger=new AtomicInteger(0);
    public static void main(String[] args) {
        bingbao(1000);
    }

    public static void bingbao(int n){
        if(n%2==0){
            n=n/2;
        }else {
            n=n*3+1;
        }
        System.out.println(n);
        if(n==4){
            atomicInteger.incrementAndGet();
        }
        if(atomicInteger.get()==2){
            return;
        }
        bingbao(n);
    }
}
