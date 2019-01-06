package hu.epam.com.tetrace.player.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Builder
@Table(name = "player")
@NoArgsConstructor
@AllArgsConstructor
public class Player {
	@Id
	@Column(name = "player_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	private String playername;
	private String username;
	private String password;
	@Enumerated(EnumType.STRING)
	private PlayerStatus status;

}
