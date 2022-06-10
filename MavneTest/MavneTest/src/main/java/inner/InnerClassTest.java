package inner;

public class InnerClassTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InnerClassTest.Inner inner = new InnerClassTest().new Inner();
        inner.show();
        InnerClassTest.StaticInner staticInner = new InnerClassTest.StaticInner();
        staticInner.show();
    }

    private class Inner{
        public void show(){
            System.out.println("inner class show");
        }
    }

    private static class StaticInner{
        public void show(){
            System.out.println("static inner class show");
        }
    }

}
