package hu.epam.com.tetrace.proxyserver.service;

import hu.epam.com.tetrace.proxyserver.model.PostgresUserDetails;
import hu.epam.com.tetrace.proxyserver.model.User;
import hu.epam.com.tetrace.proxyserver.exception.UnauthorizedAccessException;
import hu.epam.com.tetrace.proxyserver.repostiory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            throw new UnauthorizedAccessException("Access denied", HttpStatus.UNAUTHORIZED);
        }
        String[] authorities = user.getRoles().stream().map(role -> "ROLE_" + role.getRole().toUpperCase()).toArray(String[]::new);
        PostgresUserDetails userDetails = new PostgresUserDetails(user.getUsername(), user.getPassword(),
                user.getActive(), user.isLocked(), user.isExpired(), user.isEnabled(), authorities);
        return userDetails;
    }

    public boolean usernameAvaliable(String username){
        return !userRepository.findByUsername(username).isPresent();
    }
}
