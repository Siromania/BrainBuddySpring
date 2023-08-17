package backEnd.BrainBuddySpring.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backEnd.BrainBuddySpring.Dtos.TropheeDto;
import backEnd.BrainBuddySpring.Entities.Trophee;
import backEnd.BrainBuddySpring.Services.TropheeService;

@RestController
public class TropheeController {

	@Autowired
	private TropheeService tropheeService;
	
    @Autowired
    private ModelMapper modelMapper;
    
    // DTO
    private TropheeDto turnToDto(Trophee trophee) {
       
        return modelMapper.map(trophee, TropheeDto.class);
    }

	// getAllTrophee
	@GetMapping("/trophees")
	public List<TropheeDto> getTrophees() {
		Iterable<Trophee> trophees= this.tropheeService.findAllTrophees();
		List<TropheeDto> tropheesDto = new ArrayList<>();
		for (Trophee trophee : trophees) {
			tropheesDto.add(turnToDto(trophee));
		}
		return tropheesDto;
	}

	// get a Trophee from an ID
	@GetMapping("/trophees/{id}")
	public Trophee getTrophee(@PathVariable Integer id) {
		Optional<Trophee> optionalTrophee = this.tropheeService.findTropheeById(id);
		if (!optionalTrophee.isPresent()) {
			return null;
		}
		return optionalTrophee.get();
	}

	// create
	@PostMapping("/trophees")
	public Trophee createTrophee(@RequestBody Trophee trophee) {
		return this.tropheeService.saveTrophee(trophee);
	}

	@PutMapping("/trophees/{id}")
	public Trophee updateTrophee(@PathVariable("id") Integer tropheeId, @RequestBody Trophee trophee) {
		Optional<Trophee> tropheeToUpdateOptional = this.tropheeService.findTropheeById(tropheeId);
		if (!tropheeToUpdateOptional.isPresent()) {
			return null;
		}

		Trophee tropheeToUpdate = tropheeToUpdateOptional.get();

		// Update the name if it already exists
		if (tropheeToUpdate.getName() != null) {
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
		return this.tropheeService.saveTrophee(tropheeToUpdate);
	}

	@DeleteMapping("/trophees/{id}")
	public Trophee deleteTrophee(@PathVariable("id") Integer tropheeId) {
		Optional<Trophee> tropheeToUpdateOptional = this.tropheeService.findTropheeById(tropheeId);

		if (!tropheeToUpdateOptional.isPresent()) {
			return null;
		}
		
		Trophee tropheeToDelete = tropheeToUpdateOptional.get();
		this.tropheeService.deleteTrophee(tropheeToDelete);
		return tropheeToDelete;
	}

}
