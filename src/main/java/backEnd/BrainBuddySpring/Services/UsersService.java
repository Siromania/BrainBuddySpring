package backEnd.BrainBuddySpring.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import backEnd.BrainBuddySpring.Entities.Users;
import backEnd.BrainBuddySpring.Repositories.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepo;
    
//    @Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Iterable<Users> findAllUsers() {
        return this.userRepo.findAll();
    }
    
    public Optional<Users> findUserById(Integer id) {
        return this.userRepo.findById(id);
    }

    public Users saveUser(Users user) {
//    	String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
//    	user.setPassword(encodedPassword);
        return this.userRepo.save(user);
    }

    public void deleteUser(Users user) {
        this.userRepo.delete(user);
    }
}
