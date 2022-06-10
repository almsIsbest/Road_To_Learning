import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        return 3;
    }
}
