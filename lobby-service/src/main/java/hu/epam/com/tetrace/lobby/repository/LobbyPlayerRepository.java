package hu.epam.com.tetrace.lobby.repository;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hu.epam.com.tetrace.lobby.model.LobbyPlayer;

@Repository
public interface LobbyPlayerRepository extends CrudRepository<LobbyPlayer, BigInteger> {
	@Transactional
	@Procedure
	BigInteger addPlayerToOpenLobby(@Param("player_id") BigInteger playerId);
}
