package hu.tetrace.player.controller;

import hu.tetrace.player.request.RegistrationRequest;
import hu.tetrace.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
	@Autowired
	private PlayerService playerService;

	@PostMapping(name = "register")
	public void register(@RequestBody RegistrationRequest request) {
		playerService.register(request.getUsername(), request.getPassword());
	}
}
