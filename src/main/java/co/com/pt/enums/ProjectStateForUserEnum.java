package co.com.pt.enums;

public enum ProjectStateForUserEnum {
    ACTIVE(0),
    INACTIVE(1),
    DELETED(2),
    UNKNOWN(100);

    private Integer code;

    ProjectStateForUserEnum(Integer code) {
        this.code = code;
    }

    public static ProjectStateForUserEnum getValue(Integer id) {
        for(ProjectStateForUserEnum e : values()) {
            if(e.code.equals(id)) return e;
        }
        return UNKNOWN;
    }

    public Integer getCode() {
        return code;
    }

}
