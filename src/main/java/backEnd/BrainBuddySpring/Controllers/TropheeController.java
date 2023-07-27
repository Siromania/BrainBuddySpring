package backEnd.BrainBuddySpring.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backEnd.BrainBuddySpring.Entities.Trophee;
import backEnd.BrainBuddySpring.Repositories.TropheeRepository;

@RestController
public class TropheeController {

	@Autowired
	private TropheeRepository tropheeRepository;
	
	// getAllTrophee
	@GetMapping("/trophees")
	public Iterable<Trophee> getTrophees() {
		return this.tropheeRepository.findAll();
	}
	
	// get a Trophee from an ID
	@GetMapping("/trophees/{id}")
	public Trophee getTrophee(@PathVariable Integer id) {
		Optional<Trophee> optionalTrophee = this.tropheeRepository.findById(id);
		if (!optionalTrophee.isPresent()) {
			return null;
		}
		return optionalTrophee.get();
	}

	// create 
	@PostMapping("/trophees")
	public Trophee createTrophee(@RequestBody Trophee trophee) {
		return this.tropheeRepository.save(trophee);
	}
	
	@PutMapping("/trophees/{id}")
	public Trophee updateTrophee(@PathVariable("id") Integer id, @RequestBody Trophee trophee) {
		Optional<Trophee> tropheeToUpdateOptional = this.tropheeRepository.findById(id);
		if (!tropheeToUpdateOptional.isPresent()) {
			return null;
		}
		
		Trophee tropheeToUpdate = tropheeToUpdateOptional.get();
		
		// Update the name if it already exists
		if (tropheeToUpdate.getName() !=null) {
			tropheeToUpdate.setName(trophee.getName());
		}
		
		if (tropheeToUpdate.getDescription() != null) {
			tropheeToUpdate.setDescription(trophee.getDescription());			
		}
		
		if (tropheeToUpdate.getImage() != null) {
			tropheeToUpdate.setImage(trophee.getImage());			
		}
		
		if (tropheeToUpdate.getImage() != null) {
			tropheeToUpdate.setImage(trophee.getImage());			
		}
		// Update the game's informations of a Trophee
		if (tropheeToUpdate.getGame().getGameId() != null) {
			tropheeToUpdate.getGame().setGameId(trophee.getGame().getGameId());
		}
		if (tropheeToUpdate.getGame().getName() != null) {
			tropheeToUpdate.getGame().setName(trophee.getGame().getName());
		}
		if (tropheeToUpdate.getGame().getDescription() != null) {
			tropheeToUpdate.getGame().setDescription(trophee.getGame().getDescription());
		}
		if (tropheeToUpdate.getGame().getInstructions() != null) {
			tropheeToUpdate.getGame().setInstructions(trophee.getGame().getInstructions());
		}
		
		// Retourne un objet trophee actualisé grâce aux if précédents
		return this.tropheeRepository.save(tropheeToUpdate);
	}

}
