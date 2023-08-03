package backEnd.BrainBuddySpring.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import backEnd.BrainBuddySpring.Entities.Roles;
import backEnd.BrainBuddySpring.Entities.Users;
import backEnd.BrainBuddySpring.Repositories.RoleRepository;
import backEnd.BrainBuddySpring.Repositories.UsersRepository;

@Service
public class UsersService implements UserDetailsService{

    @Autowired
    private UsersRepository userRepo;
    
   @Autowired
	private PasswordEncoder PasswordEncoder;
   
   @Autowired
   private RoleRepository roleRepository;

    public Iterable<Users> findAllUsers() {
        return this.userRepo.findAll();
    }
    
    public Optional<Users> findUserById(Integer id) {
        return this.userRepo.findById(id);
    }

    public Users saveUser(Users user) {
    	String encodedPassword = PasswordEncoder.encode(user.getPassword());
    	user.setPassword(encodedPassword);
    	
    	List<Roles> roles = new ArrayList<>();
    	roles.add(this.roleRepository.findRoleByRoleName("USER"));
    	user.setRoles(roles);
        return this.userRepo.save(user);
    }

    public void deleteUser(Users user) {
        this.userRepo.delete(user);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findByUserName(username) 
				.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " Not found"));
	}
}
