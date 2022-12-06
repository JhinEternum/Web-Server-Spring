package br.com.transcendance.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "teste")
public final class IPNaoAutorizadoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IPNaoAutorizadoException() {
        super();
    }

    public IPNaoAutorizadoException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public IPNaoAutorizadoException(final String message) {
        super(message);
    }

    public IPNaoAutorizadoException(final Throwable cause) {
        super(cause);
    }

}