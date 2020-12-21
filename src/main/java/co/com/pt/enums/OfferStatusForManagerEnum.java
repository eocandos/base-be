package co.com.pt.enums;

public enum OfferStatusForManagerEnum implements CodeEnum {
    UNLOCKED(0),
    LOCKED(1),
    REVIEW(2),
    CHECKED(3),
    DELETED(4),
    REMOVED(5);

    private  int code;

    OfferStatusForManagerEnum(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
