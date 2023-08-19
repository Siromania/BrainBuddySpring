package backEnd.BrainBuddySpring.Controllers;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import backEnd.BrainBuddySpring.Entities.Games;
import backEnd.BrainBuddySpring.Entities.Scores;
import backEnd.BrainBuddySpring.Entities.Trophee;
import backEnd.BrainBuddySpring.Entities.Users;
import backEnd.BrainBuddySpring.Repositories.GamesRepository;
import backEnd.BrainBuddySpring.Repositories.UsersRepository;
import backEnd.BrainBuddySpring.Services.ScoresService;

@CrossOrigin
@RestController
public class ScoresController {
    
    @Autowired
    private ScoresService scoreServ;
    
	@Autowired
	private UsersRepository userRepo;
	
	@Autowired
	private GamesRepository gameRepo;

    @GetMapping("/scores")
    public Iterable<Scores> findAllScores() {
        return this.scoreServ.findAllScores();
    }

    @GetMapping("/scores/{id}")
    public Scores findScoreById(@PathVariable Integer id) {
        return this.scoreServ.findScoreById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200",  allowedHeaders = "*")
    @PostMapping("/scores")
    public Scores createScores(Principal principal, @RequestBody Scores score) {
    	System.out.println("je passe dans score");
    	Users u = this.userRepo.findByUserName(principal.getName()).get();
    	score.setUser(u);
    	System.out.println(score.getGames().getName());
    	Games g = this.gameRepo.findByName(score.getGames().getName());
    	System.out.println(g.getName());
    	score.setGames(g);
        return this.scoreServ.saveScore(score);
    }
    

    @DeleteMapping("/scores/{id}")
    public Scores deleteScores(@PathVariable Integer id) {
        return this.scoreServ.deleteScore(id);
    }

    @PutMapping("/scores/{id}")
    public Scores updateScores(@PathVariable Integer id, @RequestBody Scores score) {
        return this.scoreServ.updateScore(id, score);
    }
}
