package hu.tetrace.proxyserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "jwt_token")
@NoArgsConstructor
@AllArgsConstructor
public class JwtToken {
    @Id
    private String token;
}
