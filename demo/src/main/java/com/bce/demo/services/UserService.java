

package com.bce.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bce.demo.dao.UserRepository;
import com.bce.demo.entities.User;




@Service
public class UserService {

@Autowired
private UserRepository userRepository;


public List<User> findAll(){
return  userRepository.findAll();


}

public User nuevo (User user){
    return userRepository.save(user);
 

}


public User getUserById(Integer userId){
    return userRepository.findById(userId).orElse(null);
}


public User actualizar(User user) {
    User existente = userRepository.findById(user.getId())
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + user.getId()));

    existente.setName(user.getName());
    existente.setAddres(user.getAddres());
    existente.setPhone(user.getPhone());
    // otros campos...

    return userRepository.save(existente);
}


public List<User> createUsers(List<User> users) {
    return userRepository.saveAll(users);
}

public User deleteUser(Integer userId) {
 Optional<User> userOptional = userRepository.findById(userId);
    
    if (userOptional.isPresent()) {
        User user = userOptional.get();
        userRepository.deleteById(userId);
        return user;
    } else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado con ID: " + userId);
    }
}




}
