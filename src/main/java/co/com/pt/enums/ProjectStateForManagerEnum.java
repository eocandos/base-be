package co.com.pt.enums;

public enum ProjectStateForManagerEnum {
    UNLOCKED(0),
    LOCKED(1),
    REVIEW(2),
    CHECKED(3),
    DELETED(4),
    REMOVED(5),
    UNKNOWN(100);

    private Integer code;

    ProjectStateForManagerEnum(Integer code) {
        this.code = code;
    }

    public static ProjectStateForManagerEnum getValue(Integer id) {
        for(ProjectStateForManagerEnum e : values()) {
            if(e.code.equals(id)) return e;
        }
        return UNKNOWN;
    }

    public Integer getCode() {
        return code;
    }

}

