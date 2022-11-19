package com.wallace.productservice.exception;

import com.wallace.productservice.dto.ErrorDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    public ErrorDto handleNotFoundException(NotFoundException exception){
        return ErrorDto.of(NOT_FOUND.value(), exception.getMessage());
    }
}
