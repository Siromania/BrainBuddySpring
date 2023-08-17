package backEnd.BrainBuddySpring.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import backEnd.BrainBuddySpring.Entities.UserTrophee;
import backEnd.BrainBuddySpring.Entities.Users;
import backEnd.BrainBuddySpring.Keys.UserTropheeKey;

@Repository
public interface UserTropheeRepository extends CrudRepository<UserTrophee, Integer> {
  List<UserTrophee> findByUser(Users user);
}
