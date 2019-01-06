package hu.epam.com.tetrace.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hu.epam.com.tetrace.player.exception.UsernameTakenException;
import hu.epam.com.tetrace.player.model.Player;
import hu.epam.com.tetrace.player.model.PlayerStatus;
import hu.epam.com.tetrace.player.repository.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void register(String username, String password) {
		if (usernameInUse(username)) {
			throw new UsernameTakenException(username);
		} else {
			playerRepository.save(Player.builder().username(username).playername(username)
					.password(passwordEncoder.encode(password)).status(PlayerStatus.OFFLINE).build());
		}
	}

	private boolean usernameInUse(String username) {
		return playerRepository.findByUsername(username).isPresent();
	}
}
