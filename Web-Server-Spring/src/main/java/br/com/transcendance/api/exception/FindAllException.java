package br.com.transcendance.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public final class FindAllException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FindAllException() {
        super();
    }

    public FindAllException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public FindAllException(final String message) {
        super(message);
    }

    public FindAllException(final Throwable cause) {
        super(cause);
    }

}