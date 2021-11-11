package json;

import java.util.List;

/**
 * @ClassName Factory
 * @Description TODO
 * @Author Factory
 * @Data 2021/11/10 20:42
 **/
public class Factory {

    String fcName;
    List<Worker> l_worker;
    public String getFcName() {
        return fcName;
    }
    public void setFcName(String fcName) {
        this.fcName = fcName;
    }
    public List<Worker> getL_worker() {
        return l_worker;
    }
    public void setL_worker(List<Worker> l_worker) {
        this.l_worker = l_worker;
    }

}

