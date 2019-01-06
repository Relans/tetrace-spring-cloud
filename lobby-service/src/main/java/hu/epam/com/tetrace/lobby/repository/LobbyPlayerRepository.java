package hu.epam.com.tetrace.lobby.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.epam.com.tetrace.lobby.model.LobbyPlayer;

@Repository
public interface LobbyPlayerRepository extends CrudRepository<LobbyPlayer, BigInteger> {

}
