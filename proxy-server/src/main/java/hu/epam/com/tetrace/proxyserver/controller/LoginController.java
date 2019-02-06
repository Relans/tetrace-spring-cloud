package hu.epam.com.tetrace.proxyserver.controller;


import hu.epam.com.tetrace.proxyserver.model.AuthResponse;
import hu.epam.com.tetrace.proxyserver.model.LoginRequest;
import hu.epam.com.tetrace.proxyserver.model.RegistrationRequest;
import hu.epam.com.tetrace.proxyserver.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @CrossOrigin("*")
    @PostMapping("/register")
    public void register(@RequestBody RegistrationRequest registrationRequest) {
        loginService.saveUser(registrationRequest.getUsername(),registrationRequest.getPassword());
    }

    @CrossOrigin("*")
    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        String token = loginService.login(loginRequest.getUsername(), loginRequest.getPassword());
        return getAuthResponseResponseEntity(token);
    }

    @CrossOrigin("*")
    @PostMapping("/signout")
    @ResponseBody
    public ResponseEntity<AuthResponse> logout(@RequestHeader(value = "Authorization") String token) {
        HttpHeaders headers = new HttpHeaders();
        if (loginService.logout(token)) {
            headers.remove("Authorization");
            return new ResponseEntity<>(new AuthResponse("logged out"), headers, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new AuthResponse("Logout Failed"), headers, HttpStatus.NOT_MODIFIED);
    }

    @PostMapping("/valid/token")
    @ResponseBody
    public Boolean isValidToken(@RequestHeader(value = "Authorization") String token) {
        return true;
    }


    @PostMapping("/signin/token")
    @CrossOrigin("*")
    @ResponseBody
    public ResponseEntity<AuthResponse> createNewToken(@RequestHeader(value = "Authorization") String token) {
        String newToken = loginService.createNewToken(token);
        return getAuthResponseResponseEntity(newToken);
    }

    private ResponseEntity<AuthResponse> getAuthResponseResponseEntity(String token) {
        HttpHeaders headers = new HttpHeaders();
        List<String> headerlist = new ArrayList<>();
        List<String> exposeList = new ArrayList<>();
        headerlist.add("Content-Type");
        headerlist.add(" Accept");
        headerlist.add("X-Requested-With");
        headerlist.add("Authorization");
        headers.setAccessControlAllowHeaders(headerlist);
        exposeList.add("Authorization");
        headers.setAccessControlExposeHeaders(exposeList);
        headers.set("Authorization", token);
        return new ResponseEntity<>(new AuthResponse(token), headers, HttpStatus.CREATED);
    }
}
