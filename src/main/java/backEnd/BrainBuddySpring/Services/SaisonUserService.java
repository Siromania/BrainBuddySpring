package backEnd.BrainBuddySpring.Services;

import org.springframework.beans.factory.annotation.Autowired;

import backEnd.BrainBuddySpring.Entities.SaisonUser;
import backEnd.BrainBuddySpring.Repositories.SaisonUserRepository;

public class SaisonUserService {
	
	@Autowired
	private SaisonUserRepository saisonUserRepository;

	public Iterable<SaisonUser> findAllSaisonUser() {
		return this.saisonUserRepository.findAll();
	}
	
}
