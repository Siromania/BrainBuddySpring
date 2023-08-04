package backEnd.BrainBuddySpring.Configurations;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
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
	
	@Autowired
	public DataSource dataSource;

    public SecurityConfig(RsaKeyProperties rsaKeys) {
        this.rsaKeys = rsaKeys;
    }
	
    
	 @Bean
	 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        return http
	                .csrf(csrf -> csrf.disable()) // Disable Cross-Site Request Forgery (CSRF)
	                .authorizeHttpRequests( auth -> auth
	                		.requestMatchers("/users").permitAll()
	                		.requestMatchers("/token").permitAll()
	                        .anyRequest().authenticated()
	                        )
	                .oauth2ResourceServer((oauth2)-> oauth2.jwt(Customizer.withDefaults()))
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Spring Security will never create an HttpSession and it will never use it to obtain the Security Context
//	                .httpBasic(Customizer.withDefaults()) // Spring Security’s HTTP Basic Authentication support is enabled by default, However, as soon as any servlet-based configuration is provided, HTTP Basic must be explicitly provided
	                .build();
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
	 
	 @Bean
		public PasswordEncoder passwordEncoder()
		{
			return new BCryptPasswordEncoder();
		}

}
