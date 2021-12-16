package callback;

/**
 * @ClassName B
 * @Description TODO
 * @Author B
 * @Data 2021/12/15 11:20
 **/
public class B {

    private OnGeekEventListener mListener; // listener field

    // setting the listener
    public void registerOnGeekEventListener(OnGeekEventListener mListener)
    {
        this.mListener = mListener;
    }

    // my synchronous task
    public void doGeekStuff()
    {

        // perform any operation
        System.out.println("Performing callback before synchronous Task");

        // check if listener is registered.
        if (this.mListener != null) {

            // invoke the callback method of class A
            mListener.onGeekEvent();
        }
    }

    // Driver Function
    public static void main(String[] args)
    {
        System.out.println(Thread.currentThread().getName());
        B obj = new B();
        OnGeekEventListener mListener = new A();
        obj.registerOnGeekEventListener(mListener);
        obj.doGeekStuff();
        System.out.println(Thread.currentThread().getName());
    }
}

class A implements OnGeekEventListener {

    @Override
    public void onGeekEvent()
    {
        System.out.println("Performing callback after synchronous Task");
        // perform some routine operation
    }
    // some class A methods
}
