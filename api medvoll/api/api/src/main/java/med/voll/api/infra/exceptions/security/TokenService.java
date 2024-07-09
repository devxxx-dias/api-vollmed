package med.voll.api.infra.exceptions.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import med.voll.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    @Value("api.security.toke.secret")
    private String secret;

    public String gerarToken(Usuario usuario) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("api_vol_Med")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token jwt");
        }
    }

    public String getSubject(String tokenJWT){
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("api_vol_Med")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();


        } catch (JWTVerificationException exception){
         throw  new RuntimeException("TokenJWT invalido ou expirado");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-3"));
    }
}
