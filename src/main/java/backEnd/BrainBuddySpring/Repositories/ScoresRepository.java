package backEnd.BrainBuddySpring.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import backEnd.BrainBuddySpring.Entities.Scores;
import backEnd.BrainBuddySpring.Entities.Users;

public interface ScoresRepository extends CrudRepository<Scores, Integer>{
	
	List<Scores> findScoresByUser(Users user);
    
}
