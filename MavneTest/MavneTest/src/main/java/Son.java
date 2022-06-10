public class Son implements Father,Mother{
    @Override
    public void see() {
        System.out.println("see");
        System.out.println(Father.MONEY);
    }
    
    @Override
    public void say() {
        System.out.println(Mother.MONEY);
        System.out.println("say");
    }
}
