package com.quizapi.ApiQuiz.Config;

import com.quizapi.ApiQuiz.service.UserApp;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtservice;
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request ,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        //authheader contiendra le request contenu dans notre requete et chaque jeton commence par Bearer et Authorization c
        // c'est pour indique la partie du header qu'on veut avoir
        final String AuthHeader = request.getHeader("Authorization");
        final String jeton;
        final String userEmail;
        if (AuthHeader == null || !AuthHeader.startsWith("Bearer ") ){
            filterChain.doFilter(request , response);
            return;
        }
        jeton = AuthHeader.substring(7);
        userEmail = jwtservice.extraireEmail(jeton);
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            if (jwtservice.IsTokenValid(jeton,userDetails)){
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                auth.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        UserApp.setEmail(userEmail);

        filterChain.doFilter(request, response);
    }
}
