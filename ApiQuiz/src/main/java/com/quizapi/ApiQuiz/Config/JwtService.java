package com.quizapi.ApiQuiz.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
public class JwtService {
    public static final String SECRET_KEY = "667636504432754435596f74793956485858614b69642b4a78425a48675963382f6946364c6d48366a6861654d366b763564647031447a4b41343630584f4931";
    //cette fonction extraite comme son nom l'indique extrait Email d'une jeton si le claim Subjet est l'email
    public String extraireEmail(String jeton) {
        return extraireClaim(jeton, Claims::getSubject);
    }
    //cette methode extrait une claim specifique dans un jeton dependant de la methode passe en parametre comme Claims::getSubject qui est une methode pour extraire le claim subject
    public <T> T extraireClaim(String jeton, Function<Claims, T>  Claimscollector){
        final Claims claims = extraireToutLesClaims(jeton);
        return Claimscollector.apply(claims);

    }
    //generer Un jetons partant du parametre UserDetails
    public String generatetoken(UserDetails userDetails){
        return generatetoken(new HashMap<>(), userDetails);
    }
    //generate un token ou jeton
    public String generatetoken (
            Map<String , Objects> extraclaims, UserDetails userDetails
    ){
            return Jwts
                    .builder()
                    .setClaims(extraclaims)
                    .setSubject(userDetails.getUsername())
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*24))
                    .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                    .compact();
    }
    //cette fonction prend un jeton et verifie sa validite avec la signature et ensuite extrait toutes les revendications
    private Claims extraireToutLesClaims(String jeton){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(jeton)
                .getBody();
    }

    private Key getSigninKey() {
        byte[] mykey = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(mykey);
    }
    public Boolean IsTokenValid(String jeton, UserDetails userDetails){
        final String username=extraireEmail(jeton);
        return (username.equals(userDetails.getUsername())) && !IsTokenExpired(jeton) ;
    }

    private boolean IsTokenExpired(String jeton) {
        return extractExpiration(jeton).before(new Date());
    }

    private Date extractExpiration(String jeton) {
        return extraireClaim(jeton,Claims::getExpiration);
    }
}
