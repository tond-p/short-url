package com.laundrygo.shorturl.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 오류 정의
 */
@Getter
@AllArgsConstructor
public enum Errors {
    NOT_FOUND_URL_MAPPING(4001, "원본URL이 존재하지 않습니다."),

    EXTERNAL_API_ERROR(1, "요청을 처리하던 중 예상하지 못한 오류가 발생했습니다"),
    INTERNAL_SERVER_ERROR(9999, "요청을 처리하던 중 예상하지 못한 오류가 발생했습니다"),
    ;

    private final int code;
    private final String message;

    public String getCodeMessage() {
        return String.format("%s, %s", this.code, this.message);
    }

}
