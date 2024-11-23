package com.laundrygo.shorturl.common.exception;

import com.laundrygo.shorturl.common.enums.Errors;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 기본 최상위 예외
 */
@Getter
public class BaseRuntimeException extends RuntimeException {

    private static final Errors DEFAULT_ERROR = Errors.INTERNAL_SERVER_ERROR;
    private static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    private final int errorCode;
    private final String errorMessage;
    private final int errorStatus;

    public BaseRuntimeException(Errors errors, HttpStatus httpStatus) {
        super(errors.getMessage());

        this.errorCode = errors.getCode();
        this.errorMessage = errors.getMessage();
        this.errorStatus = httpStatus.value();
    }

}
