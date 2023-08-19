package backEnd.BrainBuddySpring.Services;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import backEnd.BrainBuddySpring.Entities.Scores;
import backEnd.BrainBuddySpring.Entities.Users;
import backEnd.BrainBuddySpring.Repositories.ScoresRepository;
import backEnd.BrainBuddySpring.Repositories.UsersRepository;

@Service
public class ScoresService {
    
    @Autowired
    private ScoresRepository scoresRepo;
    
	@Autowired
	private UsersRepository userRepo;

    public Iterable<Scores> findAllScores() {
        return this.scoresRepo.findAll();
    }

    public Scores findScoreById(Integer id) {

        Optional<Scores> optionalScores = this.scoresRepo.findById(id);
        if(!optionalScores.isPresent()) {
            return null;
        }

        Scores scoreToFind = optionalScores.get();
        return scoreToFind;
    }

    public Scores saveScore( Scores score) {
        return this.scoresRepo.save(score);
    }

    public Scores updateScore(Integer id, Scores score) {
        
        Optional<Scores> optionalScores = this.scoresRepo.findById(id);
        if(!optionalScores.isPresent()) {
            return null;
        }

        Scores scoreToUpdate = optionalScores.get();
        if(score.getLevel() != null) {
            scoreToUpdate.setLevel(score.getLevel());
        }
        if(score.getTimer() != null) {
            scoreToUpdate.setTimer(score.getTimer());
        }
        if(score.getNbMistake() != null) {
            scoreToUpdate.setNbMistake(score.getNbMistake() );
        }
        if(score.getUser() != null) {
            scoreToUpdate.setUser(score.getUser());
        }
        if(score.getGames() != null) {
            scoreToUpdate.setGames(score.getGames());
        }

        return this.scoresRepo.save(scoreToUpdate);

    }

    public Scores deleteScore(Integer id) {
        
        Optional<Scores> optionalScores = this.scoresRepo.findById(id);
        if(!optionalScores.isPresent()) {
            return null;
        }

        Scores scoreToDelete = optionalScores.get();
        this.scoresRepo.delete(scoreToDelete);
        return scoreToDelete;

    }
}
