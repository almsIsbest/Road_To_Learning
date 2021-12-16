package callback;

/**
 * @ClassName Basyn
 * @Description TODO
 * @Author Basyn
 * @Data 2021/12/15 11:23
 **/
public class Basyn {
    private OnGeekEventListener mListener; // listener field

    // setting the listener
    public void registerOnGeekEventListener(OnGeekEventListener mListener)
    {
        this.mListener = mListener;
    }

    // My Asynchronous task
    public void doGeekStuff()
    {

        // An Async task always executes in new thread
        new Thread(new Runnable() {
            public void run()
            {

                // perform any operation
                System.out.println("Performing operation in Asynchronous Task");

                // check if listener is registered.
                if (mListener != null) {

                    // invoke the callback method of class A
                    mListener.onGeekEvent();
                }
            }
        }).start();
    }

    // Driver Program
    public static void main(String[] args)
    {
        System.out.println(Thread.currentThread().getName());
        Basyn obj = new Basyn();
        OnGeekEventListener mListener = new A1();
        obj.registerOnGeekEventListener(mListener);
        obj.doGeekStuff();
        System.out.println(Thread.currentThread().getName());
    }
}

class A1 implements OnGeekEventListener {

    @Override
    public void onGeekEvent()
    {
        System.out.println("Performing callback after Asynchronous Task");
        // perform some routine operation
    }
    // some class A methods
}