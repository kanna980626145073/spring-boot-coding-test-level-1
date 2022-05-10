package com.codejam.demo.util;

import com.codejam.demo.dto.ErrorResponseDTO;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
class RequestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ResponseEntity<Object> handleEntityNotFound(HttpClientErrorException exception, HttpServletRequest httpServletRequest) {

        String errorMessage = "Data for id  " + httpServletRequest.getParameter("id") + " does not exist: " + httpServletRequest.getRequestURI();
        return responseEntityBuilder(new ErrorResponseDTO(HttpStatus.NOT_FOUND, LocalDateTime.now(), errorMessage));
    }


    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> handleArgumentTypeMismatch(MethodArgumentTypeMismatchException exception, HttpServletRequest httpServletRequest) {

        String errorMessage = "Unable to submit request: " + exception.getLocalizedMessage();
        return responseEntityBuilder(new ErrorResponseDTO(HttpStatus.BAD_REQUEST, LocalDateTime.now(), errorMessage));
    }


    @Override
    public ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String errorMessage = "Missing request parameter: " + exception.getLocalizedMessage();
        return responseEntityBuilder(new ErrorResponseDTO(HttpStatus.BAD_REQUEST, LocalDateTime.now(), errorMessage));
    }


    private ResponseEntity<Object> responseEntityBuilder(ErrorResponseDTO errorResponseDTO) {
        return new ResponseEntity<>(errorResponseDTO, errorResponseDTO.getHttpStatus());
    }

}
