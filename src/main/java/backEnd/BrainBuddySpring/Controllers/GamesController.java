package backEnd.BrainBuddySpring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import backEnd.BrainBuddySpring.Entities.Games;
import backEnd.BrainBuddySpring.Services.GamesService;

@RestController
public class GamesController {

    @Autowired
    private GamesService gameServ;
    
    @GetMapping("/games")
    public Iterable<Games> getAllGames() {
        return this.gameServ.getAllGames();
    }

    @GetMapping("/games/{id}")
    public Games getGameById(@PathVariable Integer id) {
        return this.gameServ.getGameById(id);
    }

    @PostMapping("/games")
    public Games saveNewGame(@RequestBody Games game) {
        return this.gameServ.saveGame(game);
    }

    @DeleteMapping("/games/{id}")
    public Games deleteGames(@PathVariable Integer id) {
        return this.gameServ.deleteGames(id);
    }

    @PutMapping("/games/{id}")
    public Games updateGames(@PathVariable Integer id, @RequestBody Games game) {
        return this.gameServ.updateGames(id, game);
    }
    
}
