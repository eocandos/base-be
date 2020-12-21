package co.com.pt.enums;

import lombok.Getter;


@Getter
public enum ProjectStatusEnum implements CodeEnum{
    UP(0, "Available"),
    DOWN(1, "Unavailable");

    private Integer code;
    private String message;

    ProjectStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getStatus(Integer code) {

        for(ProjectStatusEnum statusEnum : ProjectStatusEnum.values()) {
            if(statusEnum.getCode() == code) return statusEnum.getMessage();
        }
        return "";
    }

    public Integer getCode() {
        return code;
    }
}
