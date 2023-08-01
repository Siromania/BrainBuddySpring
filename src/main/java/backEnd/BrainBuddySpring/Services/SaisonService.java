package backEnd.BrainBuddySpring.Services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backEnd.BrainBuddySpring.Entities.Saison;
import backEnd.BrainBuddySpring.Repositories.SaisonRepository;

@Service
public class SaisonService {
	
	@Autowired
    private SaisonRepository saisonRepo;

    public Iterable<Saison> getAllSaison() {
        return this.saisonRepo.findAll();
    }

    public Saison getSaisonById(Integer id) {
        Optional<Saison> optionalSaison = this.saisonRepo.findById(id);
        if(!optionalSaison.isPresent()) {
            return null;
        }

        Saison saisonToReturn = optionalSaison.get();
        return saisonToReturn;
    }

    public Saison saveSaison(Saison saison) {
        return this.saisonRepo.save(saison);
    }

    public Saison deleteSaison(Integer id) {
        Optional<Saison> optionalSaison = this.saisonRepo.findById(id);
        if(!optionalSaison.isPresent()) {
            return null;
        }

        Saison saisonToDelete = optionalSaison.get();
        this.saisonRepo.delete(saisonToDelete);
        return saisonToDelete;
    }
    
    public Saison updateSaison(Integer id, Saison saison) {
          Optional<Saison> optionalSaison = this.saisonRepo.findById(id);
        if(!optionalSaison.isPresent()) {
            return null;
        }

        Saison saisonToUpdate = optionalSaison.get();

        /*if(saison.getDateDebut() != null) {
            saisonToUpdate.setDateDebut(saison.getDateDebut());
        }
        if(saison.getDateFin() != null) {
            saisonToUpdate.setDateFin(saison.getDateFin());
        }*/
        if(saison.getName() != null) {
            saisonToUpdate.setName(saison.getName());
        }
        if(saison.getGame() != null) {
            saisonToUpdate.setGame(saison.getGame());
        }

        return this.saisonRepo.save(saisonToUpdate);
    }
}


