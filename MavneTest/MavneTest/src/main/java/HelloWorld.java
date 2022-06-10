public class HelloWorld {
    public static void main(String[] args) {
        int a = 0;
        Integer i =1;
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.add(a);
        System.out.println(a);
        helloWorld.add(i);
        System.out.println(i);
    }
    void add (int a ){
        a=a+1;
    }
    void add(Integer a){
        a= a+1;
    }
}
