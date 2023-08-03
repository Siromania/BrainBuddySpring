package backEnd.BrainBuddySpring.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import backEnd.BrainBuddySpring.Entities.Roles;

@Repository
public interface RoleRepository extends CrudRepository<Roles, Integer>{
	Roles findRoleByRoleName(String name);
}
