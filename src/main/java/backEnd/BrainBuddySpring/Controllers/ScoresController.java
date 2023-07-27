package backEnd.BrainBuddySpring.Controllers;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backEnd.BrainBuddySpring.Entities.Scores;
import backEnd.BrainBuddySpring.Services.ScoresService;

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

    @PostMapping("/scores")
    public Scores createScores(@RequestBody Scores score) {
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
