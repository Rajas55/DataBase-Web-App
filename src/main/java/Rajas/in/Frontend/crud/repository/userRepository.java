package Rajas.in.Frontend.crud.repository;

import Rajas.in.Frontend.crud.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
//To use database management functions like find by id ,delete, find all etc.
public interface userRepository extends JpaRepository<user, Long> {
}
