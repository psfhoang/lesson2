package com.example.SpringBeginner.utils;



import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class JWTUtils {
    private final Logger logger = LoggerFactory.getLogger(JWTUtils.class);
    private final String JWT_SECRET = "hoang";
    private final long JWT_EXPIRATION = 604800000L;

    public String createToken(String username){
        Date dateIssued = new Date(System.currentTimeMillis());
        Long expiration = JWT_EXPIRATION;
        Date dateExpiration = new Date(System.currentTimeMillis()+expiration);
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setSubject(username);
        jwtBuilder.setIssuedAt(dateIssued);
        jwtBuilder.setExpiration(dateExpiration);
        jwtBuilder.signWith(SignatureAlgorithm.HS256,JWT_SECRET);
        String jwt = jwtBuilder.compact();
        return jwt;


    }
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            this.logger.info("SignatureException. The claimsJws JWS signature validation fails.");
        } catch (MalformedJwtException e) {
            this.logger.info("MalformedJwtException. The claimsJws string is not a valid JWS.");
        } catch (ExpiredJwtException e) {
            this.logger.info(
                    "ExpiredJwtException. The specified JWT is a Claims JWT and the Claims has an expiration time before the time this method is invoked.");
        } catch (UnsupportedJwtException e) {
            this.logger.info("UnsupportedJwtException. The claimsJws argument does not represent an Claims JWS.");
        } catch (IllegalArgumentException e) {
            this.logger.info("IllegalArgumentException. The claimsJws string is null or empty or only whitespace.");
        }
        return false;
    }
    private Claims getAllClaimsFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
        return claims;
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }




}
