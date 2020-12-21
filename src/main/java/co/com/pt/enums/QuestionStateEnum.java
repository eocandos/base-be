package co.com.pt.enums;

public enum QuestionStateEnum implements CodeEnum {
    REVIEW(0),
    APPROVED(1),
    NOT_APPROVED(2);

    private  int code;

    QuestionStateEnum(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
