package hu.tetrace.lobby.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

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
