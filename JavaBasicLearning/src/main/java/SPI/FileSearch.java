package SPI;

import java.util.List;

/**
 * @ClassName FileSearch
 * @Description TODO
 * @Author alms
 * @Data 2022/3/16 18:33
 **/
public class FileSearch implements Search {

    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("文件搜索"+keyword);
        return null;
    }
}
