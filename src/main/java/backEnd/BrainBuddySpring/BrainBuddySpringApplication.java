package backEnd.BrainBuddySpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import backEnd.BrainBuddySpring.Configurations.RsaKeyProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class BrainBuddySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrainBuddySpringApplication.class, args);
	}

}
