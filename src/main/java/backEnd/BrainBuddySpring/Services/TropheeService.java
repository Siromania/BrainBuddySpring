package backEnd.BrainBuddySpring.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backEnd.BrainBuddySpring.Entities.Trophee;
import backEnd.BrainBuddySpring.Repositories.TropheeRepository;

@Service
public class TropheeService {
	@Autowired
	private TropheeRepository tropheeRepository;

	public Iterable<Trophee> findAllTrophees() {
		return  this.tropheeRepository.findAll();
	}

	public Optional<Trophee> findTropheeById(Integer id) {
		return tropheeRepository.findById(id);
	}

	public Trophee saveTrophee(Trophee trophee) {
		return tropheeRepository.save(trophee);
	}

	public void deleteTrophee(Trophee trophee) {
		this.tropheeRepository.delete(trophee);
	}
}
