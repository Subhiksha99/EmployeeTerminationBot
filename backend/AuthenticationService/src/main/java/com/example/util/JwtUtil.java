package com.example.util;

import com.example.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private static String secret="secret";

    public String generateJwt(User user){
        Date date=new Date();
        Claims claims= Jwts.claims().setIssuer(user.getEmail()).setIssuedAt(date);

        return Jwts.builder().setClaims(claims).
                signWith(SignatureAlgorithm.HS512,secret).compact();
    }

    public Claims verify(String authorization) throws Exception {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
            return claims;
        } catch(Exception e) {
            throw new Exception();
        }

    }

}
