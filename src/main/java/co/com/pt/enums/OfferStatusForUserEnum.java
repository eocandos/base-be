package co.com.pt.enums;

public enum OfferStatusForUserEnum implements CodeEnum {
    ACTIVE(0),
    INACTIVE(1),
    CANCELED(2),
    DELETED(3);

    private  int code;

    OfferStatusForUserEnum(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
