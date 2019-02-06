package hu.epam.com.tetrace.proxyserver.repostiory;

import hu.epam.com.tetrace.proxyserver.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, BigInteger> {
    Optional<User> findByUsername(String username);
}
