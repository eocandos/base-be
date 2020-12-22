package com.apiux.tasklists.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PARAM_ERROR(1, "Parameter Error!"),
    TASK_NOT_EXIST(10, "Task does not exit!"),

    PROJECT_NOT_ENOUGH(11, "Not enough projects in stock!"),
    PROJECT_STATUS_ERROR(12, "Status is incorrect!"),
    PROJECT_OFF_SALE(13,"Project is off sale!"),
    PROJECT_NOT_IN_FAVORITE(14,"Project is not in the Favorite!"),
    FAVORITE_CHECKOUT_SUCCESS(20, "Checkout successfully! "),

    QUESTION_NOT_EXIST(25, "No existe la pregunta a responder"),

    CATEGORY_NOT_FOUND(30, "Category does not exit!"),

    WITHOUT_AUTH(40, "No autorizado para esta operación"),
    ACTION_NOT_PERMITTED(41, "Acción no permitida"),

    OFFER_NOT_FOUND(60, "Offer is not exit!"),
    OFFER_STATUS_ERROR(61, "Status is not correct"),

    VALID_ERROR(50, "Wrong information"),
    USER_NOT_FOUNT(40,"User is not found!")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
