package backEnd.BrainBuddySpring.Configurations;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final RsaKeyProperties rsaKeys;

    public SecurityConfig(RsaKeyProperties rsaKeys) {
        this.rsaKeys = rsaKeys;
    }
	
	 @Bean
	 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        return http
	                .csrf(csrf -> csrf.disable()) // Disable Cross-Site Request Forgery (CSRF)
	                .authorizeHttpRequests( auth -> auth
	                        .anyRequest().authenticated() // The user should be authenticated for any request in the application.
	                )
	                //.oauth2ResourceServer((oauth2) -> oauth2.jwt(jwt->jwt.jwkSetUri("http://localhost:8080/.well-known/jwks.json")))
	                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Spring Security will never create an HttpSession and it will never use it to obtain the Security Context
	                .httpBasic(Customizer.withDefaults()) // Spring Security’s HTTP Basic Authentication support is enabled by default, However, as soon as any servlet-based configuration is provided, HTTP Basic must be explicitly provided
	                .build();
	    }
	 
	 @Bean
	 public InMemoryUserDetailsManager users() {
	     return new InMemoryUserDetailsManager(
	             User.withUsername("karim")
	                     .password("{noop}1234")
	                     .authorities("read")
	                     .build()
	     );
	 }
	 
	 @Bean
	 JwtDecoder jwtDecoder() {
	     return NimbusJwtDecoder.withPublicKey(rsaKeys.publicKey()).build();
	 }
	 
	 @Bean
	 JwtEncoder jwtEncoder() {
	     JWK jwk = new RSAKey.Builder(rsaKeys.publicKey()).privateKey(rsaKeys.privateKey()).build();
	     JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
	     return new NimbusJwtEncoder(jwks);
	 }

}
