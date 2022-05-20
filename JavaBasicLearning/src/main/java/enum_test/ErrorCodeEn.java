package enum_test;

public enum ErrorCodeEn {
    OK(0, "�ɹ�"),
    ERROR_A(100, "����A"),
    ERROR_B(200, "����B");

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
