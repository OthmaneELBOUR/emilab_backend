package devjam.emilab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devjam.emilab.model.Person;
import devjam.emilab.service.AuthService;

@RestController
@RequestMapping("/authenticate")
@CrossOrigin(origins = "http://172.28.240.1:8080/")
public class LoginController {
    @Autowired
    private AuthService authService;

    @PostMapping("")
    public boolean authenticate(@RequestBody Person authObject) {
        return authService.login(authObject.getMail(), authObject.getPassword());
    }
}
