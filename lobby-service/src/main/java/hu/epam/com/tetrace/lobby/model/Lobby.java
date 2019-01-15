package hu.epam.com.tetrace.lobby.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
