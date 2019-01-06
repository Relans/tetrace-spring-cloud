package hu.epam.com.tetrace.proxyserver.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hu.epam.com.tetrace.proxyserver.service.PlayerProxyService;

@RestController(value = "player")
public class PlayerProxyController {

	@Autowired
	private PlayerProxyService playerProxy;

	@PostMapping("register")
	public ResponseEntity<?> register(@RequestBody Map<String, Object> request) {
		return playerProxy.runPostRequest("register", request, String.class);
	}

}
