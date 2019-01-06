package hu.epam.com.tetrace.lobby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.epam.com.tetrace.lobby.model.Lobby;
import hu.epam.com.tetrace.lobby.service.LobbyService;

@RestController
public class LobbyController {
	@Autowired
	private LobbyService lobbyService;

	@GetMapping(name = "all")
	public Iterable<Lobby> getLobbies() {
		return lobbyService.getLobbies();
	}
}
