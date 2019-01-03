package hu.epam.com.tetrace.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class TetraceEurekaSereverApplication {

	public static void main(String[] args) {
		SpringApplication.run(TetraceEurekaSereverApplication.class, args);
	}

}
