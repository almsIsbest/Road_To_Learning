package enum_test;

import java.util.function.Supplier;

/**
 * @ClassName selfEnum
 * @Description
 * @Author alms
 * @Data 2022/6/23 14:57
 **/
public enum selfEnum {
    ok(1),
    warning(2),
    error(3);

    private int code;
    selfEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static void main(String[] args) {
        selfEnum[] values = selfEnum.values();
        for(selfEnum tmp:values){
            System.out.println("name :"+tmp.name()+"old code :"+tmp.getCode());
            tmp.setCode(200);
            System.out.println("name :"+tmp.name()+"new code :"+tmp.getCode());
        }
    }
}
