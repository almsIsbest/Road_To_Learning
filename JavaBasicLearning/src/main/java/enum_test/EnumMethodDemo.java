package enum_test;

/**
 * @ClassName EnumMethodDemo
 * @Description
 * @Author alms
 * @Data 2022/5/19 20:52
 **/
public class EnumMethodDemo  {

    enum Size {BIG,MIDDLE,SMALL;}
    public static void main(String[] args) {
        System.out.println("=========== Print all Color ===========");
        for(Color c : Color.values()){
            System.out.println(c + " ordinal: " + c.ordinal());
        }

        System.out.println("=========== Print all Size ===========");
        for (Size s : Size.values()) {
            System.out.println(s + " ordinal: " + s.ordinal());
        }
        Color green = Color.Green;
        System.out.println("green name(): " + green.toString());
        System.out.println("green getDeclaringClass(): " + green.getDeclaringClass());
        System.out.println("green hashCode(): " + green.hashCode());
        System.out.println("green compareTo Color.GREEN: " + green.compareTo(Color.Green));
        System.out.println("green equals Color.GREEN: " + green.equals(Color.Green));
        System.out.println("green equals Size.MIDDLE: " + green.equals(Size.MIDDLE));
        System.out.println("green equals 1: " + green.equals(1));
        System.out.format("green == Color.BLUE: %b\n", green == Color.Blue);
    }
}
