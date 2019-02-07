package hu.tetrace.lobby.repository;

import hu.tetrace.lobby.model.Lobby;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface LobbyRepository extends CrudRepository<Lobby, BigInteger> {
}
