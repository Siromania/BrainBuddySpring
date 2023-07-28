package backEnd.BrainBuddySpring.Controllers;

import java.lang.StackWalker.Option;
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

import backEnd.BrainBuddySpring.Dtos.SaisonUserDto;
import backEnd.BrainBuddySpring.Entities.SaisonUser;
import backEnd.BrainBuddySpring.Services.SaisonUserService;

@RestController
public class SaisonUserController {
	@Autowired
	private SaisonUserService saisonUserService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// ToDto
    private SaisonUserDto turnToDto(SaisonUser saisonUser) {
        
        return modelMapper.map(saisonUser, SaisonUserDto.class);
    }
	
	// récupérer tous les SaisonUser
	@GetMapping("/saison-users")
	public List<SaisonUserDto> getSaisonUsers() {
		Iterable<SaisonUser> optionalSaisonUsers = this.saisonUserService.findAllSaisonUser();
		List<SaisonUserDto> dtoSaisonUser = new ArrayList<>();
		for(SaisonUser saisonUser : optionalSaisonUsers ) {
			dtoSaisonUser.add(turnToDto(saisonUser));
		}
		return dtoSaisonUser;
	}
	
	// Get SaisonUser by Id
	@GetMapping("/saison-users/{id}")
	public SaisonUser getSaisonUser(@PathVariable Integer id) {
		Optional<SaisonUser> optionalSaisonUser = this.saisonUserService.findSaisonUserById(id);
		if (!optionalSaisonUser.isPresent()) {
			return null;
			
		}
		return optionalSaisonUser.get();
	}
	
	// Create a SaisonUser
	@PostMapping("/saison-users")
	public SaisonUser createSaisonUser(@RequestBody SaisonUser saisonUser) {
		return this.saisonUserService.saveSaisonUser(saisonUser);
	}
	
	// Delete a SaisonUser
	@DeleteMapping("/saison-users/{id}")
	public SaisonUser deleteSaisonUser(@PathVariable Integer id) {
		Optional<SaisonUser> optionalSaisonUser = this.saisonUserService.findSaisonUserById(id);
		if(!optionalSaisonUser.isPresent()) {
			return null;
		}
		SaisonUser saisonUser = optionalSaisonUser.get();
		this.saisonUserService.deleteSaisonUser(saisonUser);
		return saisonUser;
	}
	
	// Modifier un SaisonUser
	@PutMapping("/users/{id}")
	public SaisonUser saisonUser(@PathVariable Integer id, @RequestBody SaisonUser saisonUser) {
		Optional<SaisonUser> optionalSaisonUser = this.saisonUserService.findSaisonUserById(id);
		if(!optionalSaisonUser.isPresent()) {
			return null;
		}
		
		SaisonUser saisonUserToUpdate = optionalSaisonUser.get();
		
		if (saisonUser.getPlacement() != null) {
			saisonUserToUpdate.setPlacement(saisonUser.getPlacement());	
		}
		if (saisonUser.getDateTime() != null) {
			saisonUserToUpdate.setDateTime(saisonUser.getDateTime())	;
		}
		if (saisonUser.getUser() != null) {
			saisonUserToUpdate.setPlacement(saisonUser.getPlacement());	
		}
		if (saisonUser.getPlacement() != null) {
			saisonUserToUpdate.setPlacement(saisonUser.getPlacement());	
		}
	}
}
