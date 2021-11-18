package DecodeXML;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName JDOmDemo
 * @Description TODO
 * @Author JDOmDemo
 * @Data 2021/11/18 17:24
 **/
public class JDOmDemo {
    public static void main(String[] args) {
        SAXBuilder saxBuilder=new SAXBuilder();
        InputStream in;
        try {
            //读文件流
            in=new FileInputStream("books.xml");
            //读入的文件流加载到SaxBuilder中
            Document document=saxBuilder.build(in);
            //获取root元素
            Element element=document.getRootElement();
            //获取根元素的所有的子元素
            List<Element> childlist=element.getChildren();
            for (Element child:childlist){
                System.out.println("===开始读取第" + (childlist.indexOf(child) + 1) + "本书的信息===");
                //r如果不知道有哪些属性可以
                List<Attribute> attributes=child.getAttributes();
                for (Attribute attribute:attributes){
                    System.out.println("属性名：" + attribute.getName() + "-->属性值：" + attribute.getValue());
                }
                //7-2、如果知道属性有哪些，可以直接调用Element.getAttributeValue(String name)获取对应的属性值
                System.out.println("已知有id属性，id属性的值为" + child.getAttributeValue("id"));
                //8、获取所有子节点，并调用Element.getName()方法获取节点名，调用Element.getVlaue()方法获取节点值
                List<Element> list = child.getChildren();
                for(Element ele : list) {
                    System.out.println("子节点：" + ele.getName() + "--->子节点的值：" + ele.getValue());
                }
                System.out.println("===读取第" + (childlist.indexOf(child) + 1) + "本书的信息结束===");


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        }
    }
}
