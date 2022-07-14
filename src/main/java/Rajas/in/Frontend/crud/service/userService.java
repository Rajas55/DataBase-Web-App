package Rajas.in.Frontend.crud.service;

import Rajas.in.Frontend.crud.model.user;
import Rajas.in.Frontend.crud.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService {
    @Autowired
    private userRepository userRepository;

    public List<user> listAll(){ // function to list all users called in user controller
        List<user> all = userRepository.findAll();
        return all;
    }
    public void save(user user){
        userRepository.save(user);
    }
    public user get(Integer id) throws UserNotFoundException {
        Optional<user> result = userRepository.findById(Long.valueOf(id));
        if (result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Invalid ID: " + id);
    }
    public user delete(Integer id){
        userRepository.deleteById(Long.valueOf(id));
        return null;
    }
}
