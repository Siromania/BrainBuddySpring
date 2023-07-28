package backEnd.BrainBuddySpring.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backEnd.BrainBuddySpring.Entities.Games;
import backEnd.BrainBuddySpring.Repositories.GamesRepository;

@Service
public class GamesService {

    @Autowired
    private GamesRepository gamesRepo;

    public Iterable<Games> getAllGames() {
        return this.gamesRepo.findAll();
    }

    public Games getGameById(Integer id) {
        Optional<Games> optionalGame = this.gamesRepo.findById(id);
        if(!optionalGame.isPresent()) {
            return null;
        }

        Games gameToGet = optionalGame.get();
        return gameToGet;
    }

    public Games saveGame(Games game) {
        return this.gamesRepo.save(game);
    }

    public Games deleteGames(Integer id) {
        Optional<Games> optionalGame = this.gamesRepo.findById(id);
        if(!optionalGame.isPresent()) {
            return null;
        }

        Games gameToDelete = optionalGame.get();
        this.gamesRepo.delete(gameToDelete);
        return gameToDelete;
    }

    public Games updateGames(Integer id, Games game) {
        Optional<Games> optionalGame = this.gamesRepo.findById(id);
        if(!optionalGame.isPresent()) {
            return null;
        }

        Games gameToUpdate = optionalGame.get();
        if(game.getName() != null) {
            gameToUpdate.setName(game.getName());
        }
        if(game.getDescription() != null) {
            gameToUpdate.setDescription(game.getDescription());
        }
        if(game.getInstructions() != null) {
            gameToUpdate.setInstructions(game.getInstructions());
        }

        return this.gamesRepo.save(gameToUpdate);
    }
}
