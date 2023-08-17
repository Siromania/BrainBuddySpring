package backEnd.BrainBuddySpring.Controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import backEnd.BrainBuddySpring.Entities.SaisonUser;
import backEnd.BrainBuddySpring.Entities.Scores;
import backEnd.BrainBuddySpring.Entities.UserTrophee;
import backEnd.BrainBuddySpring.Entities.Users;
import backEnd.BrainBuddySpring.Repositories.SaisonUserRepository;
import backEnd.BrainBuddySpring.Repositories.ScoresRepository;
import backEnd.BrainBuddySpring.Repositories.UsersRepository;
import backEnd.BrainBuddySpring.Repositories.UserTropheeRepository;

@CrossOrigin
@RestController
public class HomeController {
	
	@Autowired
	private UsersRepository userRepo;
	
	@Autowired
	private ScoresRepository scoreRepo;
	
	@Autowired
	private UserTropheeRepository userTropheeRepo;
	
	@Autowired
	private SaisonUserRepository saisonRepo;
	
	/*@Autowired
	private UserTropheeRepository userTropheeRepo;*/

	@GetMapping
    public String home(Principal principal) {
        return "Hello, " + principal.getName();
    }
	
	
	@GetMapping("userdata")
	@CrossOrigin(origins = "http://localhost:4200",  allowedHeaders = "*")
	public Users userData(Principal principal) {
		
		return this.userRepo.findByUserName(principal.getName()).get();
		
	}
	
	@GetMapping("userhistory")
	@CrossOrigin(origins = "http://localhost:4200",  allowedHeaders = "*")
	public List<Scores> userHistory(Principal principal) {
		
		 Users user = this.userRepo.findByUserName(principal.getName()).get();
		 return this.scoreRepo.findScoresByUser(user);
		
	}
	
	/*@GetMapping("usertrophies")
	@CrossOrigin(origins = "http://localhost:4200",  allowedHeaders = "*")
	public List<Trophee> userTrophy(Principal principal) {
		
		 Users user = this.userRepo.findByUserName(principal.getName()).get();
		 List<UserTrophee> trophyList = this.userTropheeRepo.findByUser(user);
		 System.out.println(trophyList);
		 return this.tropheeRepo.findByUserTrophee(trophyList);
		
	}*/
	
	@DeleteMapping("delete")
	@CrossOrigin(origins = "http://localhost:4200",  allowedHeaders = "*")
	public Users deleteUser(Principal principal) {
		Users userToDelete = this.userRepo.findByUserName(principal.getName()).get();
		
		// delete all score records of the user
		List<Scores> listOfScores = this.scoreRepo.findScoresByUser(userToDelete);
		for(Scores score : listOfScores) {
			this.scoreRepo.delete(score);
		}
		// delete all saison records of the user
		List<SaisonUser> listOfSaisons = this.saisonRepo.findScoresByUser(userToDelete);
		for(SaisonUser saison : listOfSaisons) {
			this.saisonRepo.delete(saison);
		}
		// delete all trophees records of the user
		List<UserTrophee> listOfTrophees = this.userTropheeRepo.findByUser(userToDelete);
		for(UserTrophee trophee : listOfTrophees) {
			this.userTropheeRepo.delete(trophee);
		}
		// delete user
		this.userRepo.delete(this.userRepo.findByUserName(principal.getName()).get());
		return userToDelete;
	}
	
}
