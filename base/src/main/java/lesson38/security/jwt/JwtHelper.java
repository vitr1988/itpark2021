package lesson38.security.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lesson38.security.dto.AuthorizedUser;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Component
public class JwtHelper {

    private static final JWSHeader JWT_HEADER = new JWSHeader(JWSAlgorithm.HS256);

    private final JWSSigner jwtSigner;
    private final JWSVerifier jwsVerifier;

    public JwtHelper() throws JOSEException {
        this.jwtSigner = new MACSigner("theStrongestPasswordAllOverTheWorld");
        this.jwsVerifier = new MACVerifier("theStrongestPasswordAllOverTheWorld");
    }

    @SneakyThrows
    public String generateToken(String issuer, String login, String[] rights) {
        Pair<Date, Date> issueAndExpirationTimes = getIssueAndExpirationTimes();
        // Prepare JWT with claims set
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .issuer(issuer)
                .subject(login)
                .claim("login", login)
                .claim("rights", rights)
                .issueTime(issueAndExpirationTimes.getLeft())
                .expirationTime(issueAndExpirationTimes.getRight())
                .build();

        SignedJWT signedJWT = new SignedJWT(JWT_HEADER, claimsSet);

        // Apply the HMAC protection
        signedJWT.sign(jwtSigner);

        // Serialize to compact form, produces something like that (jwt sample is below)
        // eyJhbGciOiJIUzI1NiJ9.SGVsbG8sIHdvcmxkIQ.onO9Ihudz3WkiauDO2Uhyuz0Y18UASXlSc1eS0NkWyA
        return signedJWT.serialize();
    }

    private Pair<Date, Date> getIssueAndExpirationTimes() {
        Instant issuedAt = Instant.now().truncatedTo(ChronoUnit.MILLIS);
        Instant expirationAt = issuedAt.plus(Duration.ofDays(1));
        return Pair.of(Date.from(issuedAt), Date.from(expirationAt));
    }

    @SneakyThrows
    public AuthorizedUser parseToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        final JWTClaimsSet jwtClaims;
        final SignedJWT decodedJWT = SignedJWT.parse(token);
        if (decodedJWT.verify(jwsVerifier) && isValid(jwtClaims = decodedJWT.getJWTClaimsSet())) {
            final String login = this.<String>getClaim(jwtClaims, "login")
                    .filter(StringUtils::isNotEmpty).orElseThrow();
            final String[] userRights = this.<JSONArray>getClaim(jwtClaims, "rights")
                    .map(list -> list.stream().toArray(String[]::new)).orElse(new String[]{});
            return new AuthorizedUser(login, userRights);
        }
        throw new IllegalArgumentException();
    }

    private <T> Optional<T> getClaim(JWTClaimsSet jwtClaims, String claim) {
        return Optional.ofNullable((T) jwtClaims.getClaim(claim));
    }

    public boolean isValid(JWTClaimsSet jwtClaims) {
        Date referenceTime = new Date();
        Date expirationTime = jwtClaims.getExpirationTime();
        Date notBeforeTime = jwtClaims.getNotBeforeTime();
        boolean expired = expirationTime != null && expirationTime.before(referenceTime);
        boolean yetValid = notBeforeTime == null || notBeforeTime.before(referenceTime);
        return !expired && yetValid;
    }

}
