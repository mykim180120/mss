package com.mss.fashion.common.error;

import com.mss.fashion.common.error.dto.BadRequestErrorResponse;
import com.mss.fashion.common.error.dto.MalformedUrlErrorResponse;
import com.mss.fashion.common.error.dto.MethodNotAllowedErrorResponse;
import com.mss.fashion.common.error.dto.NotFoundErrorResponse;
import com.mss.fashion.common.error.dto.NotImplementedErrorResponse;
import com.mss.fashion.common.error.dto.UnknownErrorResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import org.apache.commons.lang3.NotImplementedException;

@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
@Slf4j
public class CommonErrorHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<BadRequestErrorResponse> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception) {
        log.info("MethodArgumentTypeMismatchException happened.", exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestErrorResponse());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BadRequestErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        log.info("MethodArgumentNotValidException happened.", exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestErrorResponse());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<BadRequestErrorResponse> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException exception) {
        log.info("HttpMessageNotReadableException happened.", exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestErrorResponse());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<NotFoundErrorResponse> handleNoHandlerFoundException(
            NoHandlerFoundException exception) {
        log.info("NoHandlerFoundException happened.", exception);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundErrorResponse());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<MethodNotAllowedErrorResponse> handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException exception) {
        log.info("HttpRequestMethodNotSupportedException happened.", exception);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(new MethodNotAllowedErrorResponse());
    }

    @ExceptionHandler(NotImplementedException.class)
    public ResponseEntity<NotImplementedErrorResponse> handleNotImplementedException(
            NotImplementedException exception) {
        log.error("NotImplementedException happened.", exception);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body(new NotImplementedErrorResponse());
    }

    @ExceptionHandler(MalformedUrlError.class)
    public ResponseEntity<MalformedUrlErrorResponse> handleMalformedUrlError(
            MalformedUrlError malformedUrlError) {
        log.info("MalformedUrlError happened.", malformedUrlError);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MalformedUrlErrorResponse());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<UnknownErrorResponse> handleAllUncaughtException(Exception exception) {
        log.error("Uncaught error happened.", exception);
        return ResponseEntity.internalServerError().body(new UnknownErrorResponse());
    }
}
