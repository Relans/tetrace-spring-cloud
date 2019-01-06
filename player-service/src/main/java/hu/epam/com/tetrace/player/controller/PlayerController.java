package hu.epam.com.tetrace.player.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hu.epam.com.tetrace.player.request.RegistrationRequest;
import hu.epam.com.tetrace.player.service.PlayerService;

@RestController
public class PlayerController {
	@Autowired
	private PlayerService playerService;

	@PostMapping(name = "register")
	public void register(@RequestBody RegistrationRequest request) {
		playerService.register(request.getUsername(), request.getPassword());
	}
}
