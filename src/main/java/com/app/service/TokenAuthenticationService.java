package com.app.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static com.app.security.SecurityConstants.*;

public class TokenAuthenticationService {

    public static void addAuthentication(HttpServletResponse response, Authentication authentication) {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>(authentication.getAuthorities());
        String JWT = Jwts.builder().setSubject(authentication.getName())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .claim("authorities", grantedAuthorityList.get(0).getAuthority())
                .compact();
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            DefaultClaims defaultClaims = (DefaultClaims) Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
            String authority = defaultClaims.get("authorities", String.class);
            String user = defaultClaims.getSubject();
            Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>(Collections.singletonList(new SimpleGrantedAuthority(authority)));
            return user != null ? new UsernamePasswordAuthenticationToken(user, null, grantedAuthorities) : null;
        }
        return null;
    }
}
