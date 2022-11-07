package web.backend.advice;

import lombok.extern.slf4j.Slf4j;
import web.backend.exception.CustomRuntimeException;
import web.backend.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ExControllerAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler
    public CommonResponse<String> exHandle(Exception e) {
        log.error("[exceptionHandle] ex", e);
        return new CommonResponse<String>(false, "시스템 오류");
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler
    public CommonResponse<String> customExHandler(CustomRuntimeException e) {
        log.error("[exceptionHandle] ex", e);
        return new CommonResponse<>(false, e.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler
    public CommonResponse<String> customExHandler(NoSuchElementException e) {
        log.error("[exceptionHandle] ex", e);
        return new CommonResponse<>(true, null);
    }
}
