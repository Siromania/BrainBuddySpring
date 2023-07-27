package backEnd.BrainBuddySpring.Repositories;

import org.springframework.data.repository.CrudRepository;

import backEnd.BrainBuddySpring.Entities.Scores;

public interface ScoresRepository extends CrudRepository<Scores, Integer>{
    
}
