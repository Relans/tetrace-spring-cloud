package hu.tetrace.player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TetracePlayerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TetracePlayerServiceApplication.class, args);
	}
}
