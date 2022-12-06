package br.com.transcendance.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public final class CRUDInactiveException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CRUDInactiveException() {
        super();
    }

    public CRUDInactiveException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CRUDInactiveException(final String message) {
        super(message);
    }

    public CRUDInactiveException(final Throwable cause) {
        super(cause);
    }

}