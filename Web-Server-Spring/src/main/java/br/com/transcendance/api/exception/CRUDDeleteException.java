package br.com.transcendance.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public final class CRUDDeleteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CRUDDeleteException() {
        super();
    }

    public CRUDDeleteException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CRUDDeleteException(final String message) {
        super(message);
    }

    public CRUDDeleteException(final Throwable cause) {
        super(cause);
    }

}