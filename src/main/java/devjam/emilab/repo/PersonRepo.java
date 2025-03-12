package devjam.emilab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import devjam.emilab.model.Person;



public interface PersonRepo extends JpaRepository<Person, Long>{
    Person findByMail(String mail);
    Person findByPhoneNumber(String phoneNumber);
}
