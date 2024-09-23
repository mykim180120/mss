package com.mss.fashion.api.price;

import com.mss.fashion.api.price.dto.PriceNotFoundErrorResponse;
import com.mss.fashion.api.price.error.PriceNotFoundError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class PriceServiceErrorHandler {
    @ExceptionHandler(PriceNotFoundError.class)
    public ResponseEntity<PriceNotFoundErrorResponse> handleStudentNotFoundError(
            PriceNotFoundError priceNotFoundError) {
        log.info("PriceNotFoundError happened.", priceNotFoundError);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new PriceNotFoundErrorResponse(priceNotFoundError.getBrandId()));
    }
}
