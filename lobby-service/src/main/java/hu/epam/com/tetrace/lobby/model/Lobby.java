package hu.epam.com.tetrace.lobby.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "lobby")
public class Lobby {
	@Id
	@Column(name = "lobby_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;
	private int maxPlayers;
	private boolean started;
}
