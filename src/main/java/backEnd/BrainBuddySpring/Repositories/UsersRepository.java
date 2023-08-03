package backEnd.BrainBuddySpring.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import backEnd.BrainBuddySpring.Entities.Users;
@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {

	Optional<Users> findByUserName(String username);
    
}
