package br.com.transcendance.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public final class FindException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FindException() {
        super();
    }

    public FindException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public FindException(final String message) {
        super(message);
    }

    public FindException(final Throwable cause) {
        super(cause);
    }

}