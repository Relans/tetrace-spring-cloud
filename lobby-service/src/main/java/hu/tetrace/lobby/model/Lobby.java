package hu.tetrace.lobby.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "lobby")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lobby {
	@Id
	@Column(name = "lobby_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	@Column(name = "max_players")
	private int maxPlayers;
	private boolean started;
	@OneToMany(mappedBy = "lobbyId")
	@Builder.Default
	List<LobbyPlayer> players = new ArrayList<>();
}
