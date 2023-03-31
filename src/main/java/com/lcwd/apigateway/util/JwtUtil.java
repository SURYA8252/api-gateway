package com.lcwd.apigateway.util;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	public static final String SECRET= "576D5A7134743777397A24432646294A404E635266556A586E3272357538782F";
	public void validateToken(final String token) {
		Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
	}
	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
