package hu.epam.com.tetrace.lobby.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import hu.epam.com.tetrace.lobby.model.Lobby;
import hu.epam.com.tetrace.lobby.service.LobbyService;

@RefreshScope
@RestController
public class LobbyController {
	@Autowired
	private LobbyService lobbyService;

	@GetMapping(value = "join/{playerId}")
	public BigInteger joinRandomLobby(@PathVariable BigInteger playerId) {
		return lobbyService.addPlayerToRandomOpenLobby(playerId);
	}

	@GetMapping(value = "all")
	public Iterable<Lobby> getLobbies() {
		return lobbyService.getLobbies();
	}
}
