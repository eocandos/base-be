package co.com.pt.enums;

public enum MessageNotifyEnum implements CodeEnum {
    NEW(0),
    SOLVED(1),
    RELAUNCHED(2);

    private  int code;

    MessageNotifyEnum(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
