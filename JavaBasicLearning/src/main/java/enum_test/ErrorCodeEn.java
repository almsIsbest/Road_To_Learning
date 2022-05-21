package enum_test;

public enum ErrorCodeEn {
    OK(0, "≥…π¶"),
    ERROR_A(100, "¥ÌŒÛA"),
    ERROR_B(200, "¥ÌŒÛB");

    private int code ;
    private String msg;

    ErrorCodeEn(int code,String msg ){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ErrorCodeEn{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
