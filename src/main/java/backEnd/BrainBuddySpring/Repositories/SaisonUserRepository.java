package backEnd.BrainBuddySpring.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import backEnd.BrainBuddySpring.Entities.SaisonUser;

@Repository
public interface SaisonUserRepository extends CrudRepository<SaisonUser, Integer> {

}
