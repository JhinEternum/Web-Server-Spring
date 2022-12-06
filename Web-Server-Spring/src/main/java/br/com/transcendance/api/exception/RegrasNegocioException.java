package br.com.transcendance.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public final class RegrasNegocioException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RegrasNegocioException() {
        super();
    }

    public RegrasNegocioException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RegrasNegocioException(final String message) {
        super(message);
    }

    public RegrasNegocioException(final Throwable cause) {
        super(cause);
    }

}