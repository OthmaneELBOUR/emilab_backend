package devjam.emilab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devjam.emilab.model.Person;

@Service
public class AuthService {
    @Autowired
    private PersonService personService;

    // private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Person login(String email, String password) {
        Person person = personService.getPersonByEmail(email);
        if(person == null || password == null) {
            throw new IllegalArgumentException("Person or password not found");
        }
        // return passwordEncoder.matches(password, person.getPassword());
        if(password.equals(person.getPassword())) {
            return person;
        } else {
            throw new IllegalArgumentException("Password does not match");
        }
    }
    
}
