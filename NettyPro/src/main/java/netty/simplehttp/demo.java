package netty.simplehttp;

/**
 * @ClassName demo
 * @Description TODO
 * @Author demo
 * @Data 2021/12/14 15:51
 **/
public class demo {
   static String classPath ;
   static {
       classPath = ClassLoader.getSystemResource("static").toString().replace("file:/","");

   }

    public static void main(String[] args) {
        demo demo=new demo();
        demo.testPath();
        System.out.println(classPath);
    }

    public void testPath() {
        try {
            String projectPath = System.getProperty("user.dir");					//获取当前eclipse工程路径
//            String classPath = String.valueOf(demo.getClass().getResource("/static/")).replace("file:/","")+"test.html";			//获取当前classPath
//			String classPath = this.getClass().getClassLoader().getResource("");	//获取当前classPath等同上一行代码
            String classFullPath = this.getClass().getResource("").toString();		//获取当前类基于classPath的完整路径

          //  System.out.println(projectPath);
            System.out.println(classPath);
            System.out.println(classFullPath);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
