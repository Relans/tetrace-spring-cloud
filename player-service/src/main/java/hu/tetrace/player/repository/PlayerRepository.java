package hu.tetrace.player.repository;

import hu.tetrace.player.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<Player, BigInteger> {
	Optional<Player> findByUsername(String username);
}
