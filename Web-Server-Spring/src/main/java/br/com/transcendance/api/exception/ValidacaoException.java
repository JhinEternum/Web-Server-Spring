package br.com.transcendance.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public final class ValidacaoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValidacaoException() {
        super();
    }

    public ValidacaoException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ValidacaoException(final String message) {
        super(message);
    }

    public ValidacaoException(final Throwable cause) {
        super(cause);
    }

}