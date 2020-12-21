package co.com.pt.enums;

public enum UserStateEnum {
    NEW(0),
    ACTIVE(1),
    LOCKED(2),
    REVIEW(3),
    DELETED(4),
    REMOVED(5),
    UNKNOWN(100);

    private Integer code;

    UserStateEnum(Integer code) {
        this.code = code;
    }

    public static UserStateEnum getValue(Integer id) {
        for(UserStateEnum e : values()) {
            if(e.code.equals(id)) return e;
        }
        return UNKNOWN;
    }

    public Integer getCode() {
        return code;
    }

}

