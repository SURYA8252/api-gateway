//package com.lcwd.apigateway.controller;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
//import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.lcwd.apigateway.model.AuthResponse;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//    private Logger logger = LoggerFactory.getLogger(AuthController.class);
//    @GetMapping("/login")
//    public ResponseEntity<AuthResponse> login(
//    		@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
//    		@AuthenticationPrincipal OidcUser user,
//    		Model model
//    		) {
//    	logger.info("user email id : {} ",user.getEmail());
//    	//creating auth response object
//    	AuthResponse authResponse = new AuthResponse();
//    	//Setting email to auth response
//    	authResponse.setUserId(user.getEmail());
//    	//Setting token to auth response
//    	authResponse.setAccessToken(client.getAccessToken().getTokenValue());
//    	//Setting refresh token to auth response
//    	authResponse.setRefreshToken(client.getRefreshToken().getTokenValue());
//    	//Setting expiryAt to auth response
//    	authResponse.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());
//    	//Setting authority to auth response
//    	List<String> authroities = user.getAuthorities().stream().map(grantedAuthority -> {
//    		return grantedAuthority.getAuthority();
//    	}).collect(Collectors.toList());
//    	authResponse.setAuthories(authroities);
//    	return new ResponseEntity<AuthResponse>(authResponse,HttpStatus.OK);
//    }
//}
