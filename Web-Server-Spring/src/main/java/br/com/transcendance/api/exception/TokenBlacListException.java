package br.com.transcendance.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public final class TokenBlacListException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TokenBlacListException() {
        super();
    }

    public TokenBlacListException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TokenBlacListException(final String message) {
        super(message);
    }

    public TokenBlacListException(final Throwable cause) {
        super(cause);
    }

}