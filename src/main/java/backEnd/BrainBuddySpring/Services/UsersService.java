package backEnd.BrainBuddySpring.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backEnd.BrainBuddySpring.Entities.Users;
import backEnd.BrainBuddySpring.Repositories.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepo;

    public Iterable<Users> findAllUsers() {
        return this.userRepo.findAll();
    }
    
    public Optional<Users> findUserById(Integer id) {
        return this.userRepo.findById(id);
    }

    public Users saveUser(Users user) {
        return this.userRepo.save(user);
    }

    public void deleteUser(Users user) {
        this.userRepo.delete(user);
    }
}
