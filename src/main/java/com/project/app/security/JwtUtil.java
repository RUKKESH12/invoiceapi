package com.project.app.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	
	private static SecretKey secretKey= Keys.secretKeyFor(SignatureAlgorithm.HS256);

	
	public String getToken(String username)
	{
		return	 Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))
				.signWith(secretKey)
				.compact()
		;
	}
	
	public String extractUsername(String token)
	{
		return Jwts.parserBuilder().setSigningKey(secretKey).build()
				.parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean isTokenExpired(String token) {
		
		Date expireDate= Jwts.parserBuilder().setSigningKey(secretKey).build()
				.parseClaimsJws(token).getBody().getExpiration();
		
		return expireDate.before(new Date());
	}
	
	public boolean isValidToken(String token, String username)
	{
		return extractUsername(token).equals(username) && !isTokenExpired(token);
	}
	
}
