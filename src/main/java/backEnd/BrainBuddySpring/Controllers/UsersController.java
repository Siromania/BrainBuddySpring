package backEnd.BrainBuddySpring.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import backEnd.BrainBuddySpring.Dtos.UsersDto;
import backEnd.BrainBuddySpring.Entities.Users;
import backEnd.BrainBuddySpring.Services.UsersService;

@RestController
public class UsersController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsersService  userService;


    // --------------- Methode pour recuperer tout les users --------------------
    @GetMapping("/users")
    public List<UsersDto> getUsers() {
        Iterable<Users> list = this.userService.findAllUsers();
        List<UsersDto> dtoList = new ArrayList<>();
        for(Users user: list) {
            dtoList.add(turnToDto(user));
        }
        return dtoList;
    }
    // --------------- Methode pour recuperer un user par id --------------------
    @GetMapping("/users/{id}")
    public Users getUser(@PathVariable Integer id) {

        Optional<Users> optionalUser = this.userService.findUserById(id);
        if(!optionalUser.isPresent()) {
            return null;
        }

        Users userToReturn = optionalUser.get();
        return userToReturn;
    }
    // --------------- Methode pour ajouter une donneé --------------------
    @PostMapping("/users")
    public Users createUser(@RequestBody Users user) {
        return this.userService.saveUser(user);
    }

    // --------------- Methode pour delete une donneé --------------------
    @DeleteMapping("/users/{id}")
    public Users deleteUser(@PathVariable Integer id) {

        Optional<Users> optionalUser = this.userService.findUserById(id);
        if(!optionalUser.isPresent()){
            return null;
        }

        Users userToDelete = optionalUser.get();
        this.userService.deleteUser(userToDelete);
        return userToDelete;
    }
    // --------------- Methode pour modifier une donneé --------------------
    @PutMapping("/users/{id}")
    public Users updateUser(@PathVariable Integer id, @RequestBody Users user) {

        Optional<Users> optionalUser = this.userService.findUserById(id);
        if(!optionalUser.isPresent()) {
            return null;
        }

        Users userToUpdate = optionalUser.get();

        if(user.getUserName() != null) {
            userToUpdate.setUserName(user.getUserName());
        }
         if(user.getEmail() != null) {
            userToUpdate.setEmail(user.getEmail());
        }
         if(user.getPassword() != null) {
            userToUpdate.setPassword(user.getPassword());
        }
         if(user.getAdmin() != userToUpdate.getAdmin()) {
            userToUpdate.setAdmin(user.getAdmin());
        }

        Users updatedUser = this.userService.saveUser(userToUpdate);
        return updatedUser;
    }
    // ---------------------- Methode pour transformer les users en userDto -------------------------------

    private UsersDto turnToDto(Users user) {
       
        return modelMapper.map(user, UsersDto.class);
    }
}
