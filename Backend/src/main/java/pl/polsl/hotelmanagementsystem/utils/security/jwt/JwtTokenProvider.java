package pl.polsl.hotelmanagementsystem.utils.security.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;
    private Key key;

    @Value("${security.jwt.token.expire-length:3600000}")
    private long validityInMilliseconds;

    private final MyUserDetails myUserDetails;

    @PostConstruct
    protected void init() {
        key = new SecretKeySpec(DatatypeConverter.parseBase64Binary(secretKey),
                SignatureAlgorithm.HS384.getJcaName());
    }
}
