package hu.tetrace.lobby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TetraceLobbyServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TetraceLobbyServiceApplication.class, args);
	}
}