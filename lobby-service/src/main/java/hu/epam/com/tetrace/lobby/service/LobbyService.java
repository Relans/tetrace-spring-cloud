package hu.epam.com.tetrace.lobby.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.epam.com.tetrace.lobby.model.Lobby;
import hu.epam.com.tetrace.lobby.repository.LobbyPlayerRepository;
import hu.epam.com.tetrace.lobby.repository.LobbyRepository;

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
