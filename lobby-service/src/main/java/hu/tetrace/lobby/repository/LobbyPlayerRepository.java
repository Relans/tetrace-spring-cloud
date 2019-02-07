package hu.tetrace.lobby.repository;

import hu.tetrace.lobby.model.LobbyPlayer;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Repository
public interface LobbyPlayerRepository extends CrudRepository<LobbyPlayer, BigInteger> {
	@Transactional
	@Procedure
	BigInteger addPlayerToOpenLobby(@Param("player_id") BigInteger playerId);
}
