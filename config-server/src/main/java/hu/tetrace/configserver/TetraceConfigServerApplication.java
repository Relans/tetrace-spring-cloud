package hu.tetrace.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class TetraceConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TetraceConfigServerApplication.class, args);
	}

}
