package DecodeXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName DemoDecodeXml
 * @Description TODO
 * @Author DemoDecodeXml
 * @Data 2021/11/18 16:01
 **/
public class DemoDecodeXml {
    public static void main(String[] args) {
        //创建DOM工厂
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        InputStream input = null;
        try {
            //通过DOM工厂获得DOM解析器
            DocumentBuilder domBuilder = domFactory.newDocumentBuilder();
            //把XML文档转化为输入流
            input = new FileInputStream("test.xml");
            //解析XML文档的输入流，得到一个Document
            Document doc = domBuilder.parse(input);

            //得到XML文档的根节点，只有根节点是Element类型
            Element root = doc.getDocumentElement();
            // 得到子节点
            NodeList books = root.getChildNodes();
            if (books != null) {
                for (int i = 0; i < books.getLength(); i++) {
                    Node book = books.item(i);
                    //获取id属性
                    if (book.getNodeType() == Node.ELEMENT_NODE) {
                        String id = book.getAttributes().getNamedItem("id").getNodeValue();
                        System.out.println("id is:" + id);
                        //遍历book下的子节点
                        for (Node node = book.getFirstChild(); node != null; node = node.getNextSibling()) {
                            if (node.getNodeType() == Node.ELEMENT_NODE) {
                                //依次读取book里的name,price和memo三个子元素
                                if (node.getNodeName().equals("name")) {
                                    String name = node.getFirstChild().getNodeValue();
                                    System.out.println("name is:" + name);
                                }
                                if (node.getNodeName().equals("price")) {
                                    String price = node.getFirstChild().getNodeValue();
                                    System.out.println("price is:" + price);
                                }
                                if (node.getNodeName().equals("memo")) {
                                    String memo = node.getFirstChild().getNodeValue();
                                    System.out.println("memo is:" + memo);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
