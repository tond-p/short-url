package com.laundrygo.shorturl.common.exception.handler;


import com.laundrygo.shorturl.common.enums.Errors;
import com.laundrygo.shorturl.common.exception.BaseRuntimeException;
import com.laundrygo.shorturl.common.exception.dto.ErrorResponse;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 전역 예외 핸들러
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 런타임 예외는 {@link Errors}에 정의된 예외 코드와 메시지로 처리한다.
     *
     * @param response HTTP 서블릿 응답객체
     * @param e        예외
     */
    @ExceptionHandler(BaseRuntimeException.class)
    public ResponseEntity<ErrorResponse> BaseRunTimeExceptionHandler(HttpServletResponse response,
        BaseRuntimeException e) {
        log.error("런타임 오류가 발생했습니다.", e);
        return ErrorResponse.toResponseEntity(e);
    }

}
