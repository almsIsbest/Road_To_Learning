package Thread;

import java.time.Year;
import java.util.concurrent.Executors;

public class WangShuangXi {
    void zhuiTangXiao() throws FailException,ObjectNotFoundException{}
    public WangShuangXi() throws ObjectNotFoundException {
        try {
            zhuiTangXiao();
        }catch (FailException e){
            e.getStackTrace();
        }
        finally {
            throw new ObjectNotFoundException();
        }
    }

}
