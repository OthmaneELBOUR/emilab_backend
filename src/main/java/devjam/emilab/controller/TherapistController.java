package devjam.emilab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devjam.emilab.model.Review;
import devjam.emilab.model.Session;
import devjam.emilab.model.Therapist;
import devjam.emilab.service.PersonService;
import devjam.emilab.service.ReviewService;
import devjam.emilab.service.SessionService;


@RestController
@RequestMapping("/therapists")
@CrossOrigin(origins = "http://172.28.240.1:8080/")
public class TherapistController {
    @Autowired
    private PersonService personService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{id}")
    public Therapist getPersonById(@PathVariable("id") Long id) {
        return personService.getTherapistById(id);
    }

    @GetMapping("/")
    public List<Therapist> getAllTherapists() {
        return personService.getAllTherapists();
    }

    @GetMapping("/sessions/{id}")
    public List<Session> getSessions(@PathVariable("id") Long id) {
        return sessionService.getSessionsByTherapist(id);
    }

    @GetMapping("/reviews/{id}")
    public List<Review> getReviewsByTherapist(@PathVariable("id") Long id) {
        return reviewService.getReviewsByTargetId(id);
    }

    @PostMapping("/new-list")
    public List<Therapist> createNewTherapists(@RequestBody List<Therapist> therapists) {
        return personService.addTherapists(therapists);
    }

    @PostMapping("new")
    public Therapist createNewTherapist(@RequestBody Therapist therapist) {
        return personService.createNewTherapist(therapist);
    }

}
