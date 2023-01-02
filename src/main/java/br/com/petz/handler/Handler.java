package br.com.petz.handler;

import br.com.petz.handler.exception.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Handler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IdNotFoundException.class)
    @ResponseBody ErrorMessage
    businessException() {
        return new ErrorMessage(ExceptionName.ID_NOT_FOUND_EXCEPTION.name(), ExceptionName.ID_NOT_FOUND_EXCEPTION.message);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody ErrorMessage
    exception() {
        return new ErrorMessage(ExceptionName.EXCEPTION.name(), ExceptionName.EXCEPTION.message);
    }
}