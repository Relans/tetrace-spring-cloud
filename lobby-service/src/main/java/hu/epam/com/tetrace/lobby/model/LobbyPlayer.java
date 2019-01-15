package hu.epam.com.tetrace.lobby.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "lobby_player")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LobbyPlayer {
	@Id
	@Column(name = "lobby_player_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	@Column(name = "lobby_id")
	private BigInteger lobbyId;
	@Column(name = "player_id")
	private BigInteger playerId;
	private boolean ready;
}
