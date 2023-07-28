package backEnd.BrainBuddySpring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import backEnd.BrainBuddySpring.Entities.Saison;
import backEnd.BrainBuddySpring.Services.SaisonService;

@RestController
public class SaisonController {

	 @Autowired
	    private SaisonService saisonServ;

	 @GetMapping("/saison")
	 public Iterable<Saison> findAllSaison() {
	        return this.saisonServ.getAllSaison();
	    }
	 
	 @GetMapping("/saison/{id}")
	 public Saison findSaisonById(@PathVariable Integer id) {
		 return this.saisonServ.getSaisonById(id);
	 }
	 
	 @PostMapping("/saison")
	 public Saison saveSaison(@RequestBody Saison saison) {
		 return this.saisonServ.saveSaison(saison);
	 }
	 
	 @DeleteMapping("/saison/{id}")
	 public Saison deleteSaison(@PathVariable Integer id) {
		 return this.saisonServ.deleteSaison(id);
	 }
	 
	 @PutMapping("/saison/{id}")
	 public Saison updateSaison(@PathVariable Integer id, @RequestBody Saison saison) {
		 return this.saisonServ.updateSaison(id, saison);
	 }
}

