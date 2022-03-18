package SPI;

import java.util.List;

/**
 * @ClassName DatabaseSearch
 * @Description TODO
 * @Author alms
 * @Data 2022/3/16 18:35
 **/
public class DatabaseSearch implements Search {

    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("数据搜索 "+keyword);
        return null;
    }
}
