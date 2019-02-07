package hu.tetrace.proxyserver.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Data
@Entity
public class Role {
    @Id
    private BigInteger id;
    private String role;
}
