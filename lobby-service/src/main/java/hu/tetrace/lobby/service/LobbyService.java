package hu.tetrace.lobby.service;

import hu.tetrace.lobby.model.Lobby;
import hu.tetrace.lobby.repository.LobbyPlayerRepository;
import hu.tetrace.lobby.repository.LobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class LobbyService {

	@Autowired
	private LobbyRepository lobbyRepository;

	@Autowired
	private LobbyPlayerRepository lobbyPlayerRepository;

	public Iterable<Lobby> getLobbies() {
		return lobbyRepository.findAll();
	}

	public BigInteger addPlayerToRandomOpenLobby(BigInteger playerId) {
		return lobbyPlayerRepository.addPlayerToOpenLobby(playerId);
	}
}
