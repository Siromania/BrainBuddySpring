package backEnd.BrainBuddySpring.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import backEnd.BrainBuddySpring.Entities.Scores;
import backEnd.BrainBuddySpring.Services.ScoresService;

@CrossOrigin
@RestController
public class ScoresController {
    
    @Autowired
    private ScoresService scoreServ;

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
    public Scores createScores(@RequestBody Scores score) {
    	System.out.println("je passe dans score");
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
