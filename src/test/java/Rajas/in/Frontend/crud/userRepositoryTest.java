package Rajas.in.Frontend.crud;

import Rajas.in.Frontend.crud.model.user;
import Rajas.in.Frontend.crud.repository.userRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class userRepositoryTest {
    @Autowired
    private userRepository userRepository;
    @Test
    public void testAddNew(){
        user user = new user();
        user.setUser_id(2L);
        user.setEmail("leo.yardi@gmail.com");
        user.setFName("Leo");
        user.setLName("Yardi");
        user.setStatus(true);
        user savedUser = userRepository.save(user);


    }
    @Test
    public void testListAll(){

        List<user> users = userRepository.findAll();
        for (user user:users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate(){
        Integer user_id = 1;
        Optional<user> optionalUser = userRepository.findById(Long.valueOf(user_id));
       user user = optionalUser.get();
       user.setEmail("rajasyardi18@gmail.com");
       userRepository.save(user);
       user updateUser = userRepository.findById(Long.valueOf(user_id)).get();
    }

}
