package hu.tetrace.proxyserver.service;

import hu.tetrace.proxyserver.exception.UnauthorizedAccessException;
import hu.tetrace.proxyserver.exception.UsernameUnavaliableException;
import hu.tetrace.proxyserver.model.JwtToken;
import hu.tetrace.proxyserver.model.User;
import hu.tetrace.proxyserver.repostiory.JwtTokenRepository;
import hu.tetrace.proxyserver.repostiory.UserRepository;
import hu.tetrace.proxyserver.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenRepository jwtTokenRepository;
    private final UserService userService;

    public String login(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
                    password));
            UserDetails user = userService.loadUserByUsername(username);
            return jwtTokenProvider.createToken(username, user.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority).collect(Collectors.toList()));

        } catch (AuthenticationException e) {
            throw new UnauthorizedAccessException("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }

    public void saveUser(String username, String password) {
        if (userService.usernameAvaliable(username)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
        } else {
            throw new UsernameUnavaliableException(String.format("Username %s unavaliable", username), HttpStatus.CONFLICT);
        }
    }

    public boolean logout(String token) {
        jwtTokenRepository.delete(new JwtToken(token));
        return true;
    }

    public Boolean isValidToken(String token) {
        return jwtTokenProvider.validateToken(token);
    }

    public String createNewToken(String token) {
        String username = jwtTokenProvider.getUsername(token);
        List<String> roleList = jwtTokenProvider.getRoleList(token);
        return jwtTokenProvider.createToken(username, roleList);
    }
}
