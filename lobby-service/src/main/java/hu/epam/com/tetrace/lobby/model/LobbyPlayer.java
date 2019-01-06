package hu.epam.com.tetrace.lobby.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "lobby_player")
public class LobbyPlayer {
	@Id
	@Column(name = "lobby_player_id")
	private BigInteger id;
	private BigInteger lobbyId;
	private BigInteger playerId;
	private boolean ready;
}
