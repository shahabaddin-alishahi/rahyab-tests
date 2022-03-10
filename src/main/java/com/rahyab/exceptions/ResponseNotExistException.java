package com.rahyab.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResponseNotExistException extends RuntimeException {

    public ResponseNotExistException() {
    }

    public ResponseNotExistException(String message) {
        super(message);
    }
}
