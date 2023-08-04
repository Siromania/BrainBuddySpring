package backEnd.BrainBuddySpring.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import backEnd.BrainBuddySpring.Entities.Users;
import backEnd.BrainBuddySpring.Repositories.UsersRepository;

@CrossOrigin
@RestController
public class HomeController {
	
	@Autowired
	private UsersRepository userRepo;

	@GetMapping
    public String home(Principal principal) {
        return "Hello, " + principal.getName();
    }
	
	
	@GetMapping("userdata")
	@CrossOrigin(origins = "http://localhost:4200",  allowedHeaders = "*")
	public Users userData(Principal principal) {
		
		return this.userRepo.findByUserName(principal.getName()).get();
	}
	
}
