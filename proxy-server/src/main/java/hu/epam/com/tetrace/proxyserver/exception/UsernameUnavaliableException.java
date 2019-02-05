package hu.epam.com.tetrace.proxyserver.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class UsernameUnavaliableException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String message;
    private final HttpStatus httpStatus;

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
