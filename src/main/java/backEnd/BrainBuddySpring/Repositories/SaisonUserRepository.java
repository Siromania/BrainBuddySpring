package backEnd.BrainBuddySpring.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import backEnd.BrainBuddySpring.Entities.SaisonUser;
import backEnd.BrainBuddySpring.Entities.Users;

@Repository
public interface SaisonUserRepository extends CrudRepository<SaisonUser, Integer> {

	List<SaisonUser> findScoresByUser(Users userToDelete);

}
