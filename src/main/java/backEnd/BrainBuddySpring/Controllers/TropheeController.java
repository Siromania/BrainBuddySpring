package backEnd.BrainBuddySpring.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backEnd.BrainBuddySpring.Entities.Trophee;
import backEnd.BrainBuddySpring.Repositories.TropheeRepository;

@RestController
public class TropheeController {

	@Autowired
	private TropheeRepository tropheeRepository;

	@GetMapping("/trophees")
	public Iterable<Trophee> getTrophees() {
		return this.tropheeRepository.findAll();
	}

	@GetMapping("/trophees/{id}")
	public Trophee getTrophee(@PathVariable Integer id) {
		Optional<Trophee> optionalTrophee = this.tropheeRepository.findById(id);
		if (!optionalTrophee.isPresent()) {
			return null;
		}
		return optionalTrophee.get();
	}

	@PostMapping("/trophees")
	public Trophee createUser(@RequestBody Trophee trophee) {
		return this.tropheeRepository.save(trophee);
	}

}
