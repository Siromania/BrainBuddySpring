package backEnd.BrainBuddySpring.Repositories;

import org.springframework.data.repository.CrudRepository;

import backEnd.BrainBuddySpring.Entities.Games;

public interface GamesRepository extends CrudRepository<Games, Integer> {
	
	Games findByName(String name);
    
}
