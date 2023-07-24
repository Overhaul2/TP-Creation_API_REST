package com.quizapi.ApiQuiz.service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
public class JsonJwt {


    private static final String SECRET_KEY = "Tu_connais_la_Sillicone_Valley_?";

    private static final long EXPIRATION_TIME = 1576800000; //Date expiration a revoir sinon je l'ai donnee aleatoirement
    public static String generateToken(String username) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
