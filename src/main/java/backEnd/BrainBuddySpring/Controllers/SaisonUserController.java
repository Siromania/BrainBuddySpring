package backEnd.BrainBuddySpring.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<SaisonUserDto> getUserSaison() {
		Iterable<SaisonUser> optionalSaisonUsers = this.saisonUserService.findAllSaisonUser();
		List<SaisonUserDto> dtoSaisonUser = new ArrayList<>();
		for(SaisonUser saisonUser : optionalSaisonUsers ) {
			dtoSaisonUser.add(turnToDto(saisonUser));
		}
		return dtoSaisonUser;
	}
	
	
}
