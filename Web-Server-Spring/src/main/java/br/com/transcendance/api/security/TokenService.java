package br.com.transcendance.api.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.transcendance.api.models.security.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${jwt.expiration}")
	private String expiration;

	@Value("${jwt.secret}")
	private String secret;

	private Map<String, Integer> tokenBlackList = new HashMap<String, Integer>();

	public String generateToken(Authentication authentication) {

		User user = (User) authentication.getPrincipal();

		Date now = new Date();
		Date exp = new Date(now.getTime() + Long.parseLong(expiration));
		System.out.println(exp.toString());
		return Jwts.builder().setIssuer("IRS").setSubject(String.valueOf(user.getId())).setIssuedAt(new Date())
				.setExpiration(exp).signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Integer getTokenId(String token) {
		Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return Integer.valueOf(body.getSubject());
	}

	public String getTokenFromHeader(HttpServletRequest request) {
		return substringToken(request.getHeader("Authorization"));

	}

	public String substringToken(String token) {
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}

		return token.substring(7, token.length());
	}

	public void addTokenToBlackList(String token, Integer id) {
		System.out.println("Adicionando token na black list: " + substringToken(token));
		tokenBlackList.put(substringToken(token), id);
	}

	public boolean tokenInBlackList(String token) {
		System.out.println("tokenInBlackList: " + tokenBlackList.containsKey(token));
		return tokenBlackList.containsKey(token);
	}

}
