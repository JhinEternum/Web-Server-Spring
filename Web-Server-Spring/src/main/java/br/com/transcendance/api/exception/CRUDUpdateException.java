package br.com.transcendance.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public final class CRUDUpdateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CRUDUpdateException() {
        super();
    }

    public CRUDUpdateException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CRUDUpdateException(final String message) {
        super(message);
    }

    public CRUDUpdateException(final Throwable cause) {
        super(cause);
    }

}