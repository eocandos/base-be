package co.com.pt.enums;

public enum AnswerStateEnum implements CodeEnum {
    UN_ANSWERED(0),
    REVIEW(1),
    APPROVED(2),
    NOT_APPROVED(3);

    private  int code;

    AnswerStateEnum(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
