package backEnd.BrainBuddySpring.Controllers;


import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backEnd.BrainBuddySpring.Dtos.LoginDto;

import backEnd.BrainBuddySpring.Services.TokenService;


@RestController
public class AuthController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }
    
    @CrossOrigin(origins = "http://localhost:4200",  allowedHeaders = "*")
    @PostMapping("/token")
    public HashMap<String, String> token(@RequestBody LoginDto authentication) {
        LOG.debug("Token requested for user: '{}'", authentication.toString());
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token granted: {}", token);
        // Workaround for Angular: it need an object, not just a String
        HashMap<String, String> tokenObject = new HashMap<String, String>(); 
        tokenObject.put("token", token);
        return tokenObject;
    }

}
