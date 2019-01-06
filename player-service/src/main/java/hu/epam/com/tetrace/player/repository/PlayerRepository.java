package hu.epam.com.tetrace.player.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.epam.com.tetrace.player.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, BigInteger> {
	Optional<Player> findByUsername(String username);
}
