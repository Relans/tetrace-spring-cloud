package hu.epam.com.tetrace.proxyserver.repostiory;

import hu.epam.com.tetrace.proxyserver.model.JwtToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtTokenRepository extends CrudRepository<JwtToken,String> {
}
