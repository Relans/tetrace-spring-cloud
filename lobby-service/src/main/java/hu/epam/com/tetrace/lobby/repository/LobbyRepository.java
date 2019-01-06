package hu.epam.com.tetrace.lobby.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.epam.com.tetrace.lobby.model.Lobby;

@Repository
public interface LobbyRepository extends CrudRepository<Lobby, BigInteger> {

}
