package hu.epam.com.tetrace.player.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Username already in use")
public class UsernameTakenException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsernameTakenException(String username) {
		super(String.format("Username %s is already taken", username));
	}
}
