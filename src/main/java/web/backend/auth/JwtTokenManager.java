package web.backend.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenManager {

    private static final String secret = "nomu";

    // 토큰 유효 기간
    public static final long JWT_TOKEN_VALIDITY = 60 * 60 * 24 * 1000L; //하루

    /**
     *  토큰 생성
     */
    public String generateToken(String id, Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)  // 정보 저장
                .setId(id)
                .setIssuedAt(new Date(System.currentTimeMillis()))  // 토큰 발행 시간 정보
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY)) // set Expire Time
                .signWith(SignatureAlgorithm.HS512, secret)// 사용할 암호화 알고리즘과
                // signature 에 들어갈 secret값 세팅
                .compact();
    }

    /**
     *  토큰 id 반환
     */
    public String getTokenIdFromToken(String token) {
        return getClaimFromToken(token, Claims::getId);
    }

    /**
     *  토큰이 만료되었는지 Boolean 반환
     */
    public Boolean isTokenExpired(String token) {
        final Date expiration = getClaimFromToken(token, Claims::getExpiration);
        return expiration.before(new Date());
    }

    /**
     *  토큰 자체에 대한 정보 추출(id, expire 등)
     */
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token).getBody();// JWT payload 에 저장되는 정보단위
        return claimsResolver.apply(claims);
    }

    /**
     *  토큰 안의 모든 정보 추출
     */
    public Claims getClaimsFromToken(String token) {
        final Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token).getBody();// JWT payload 에 저장되는 정보단위
        return claims;
    }

}