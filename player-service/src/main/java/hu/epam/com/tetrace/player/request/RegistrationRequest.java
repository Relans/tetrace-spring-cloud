package hu.epam.com.tetrace.player.request;

import lombok.Data;

@Data
public class RegistrationRequest {
	private String username;
	private String password;
}
