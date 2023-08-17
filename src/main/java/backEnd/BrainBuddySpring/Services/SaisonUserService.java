package backEnd.BrainBuddySpring.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backEnd.BrainBuddySpring.Entities.SaisonUser;
import backEnd.BrainBuddySpring.Repositories.SaisonUserRepository;

@Service
public class SaisonUserService {
	
	@Autowired
	private SaisonUserRepository saisonUserRepository;

	public Iterable<SaisonUser> findAllSaisonUser() {
		return this.saisonUserRepository.findAll();
	}

	public Optional<SaisonUser> findSaisonUserById(Integer id) {
		return this.saisonUserRepository.findById(id);
	}

	public SaisonUser saveSaisonUser(SaisonUser saisonUser) {
		// TODO Auto-generated method stub
		return this.saisonUserRepository.save(saisonUser);
	}

	public void deleteSaisonUser(SaisonUser saisonUser) {
		this.saisonUserRepository.delete(saisonUser);
	}
	
	
	
	
}
