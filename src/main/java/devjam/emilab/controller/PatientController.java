package devjam.emilab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devjam.emilab.model.Patient;
import devjam.emilab.model.Person;
import devjam.emilab.model.Pet;
import devjam.emilab.model.Review;
import devjam.emilab.service.ChallengeService;
import devjam.emilab.service.PersonService;
import devjam.emilab.service.PetService;
import devjam.emilab.service.ReviewService;
import devjam.emilab.service.SessionService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://172.28.240.1:8080/")
public class PatientController {
    @Autowired
    private PersonService personService;
    @Autowired
    private ChallengeService challengeService;
    @Autowired
    private PetService petService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private SessionService sessionService;

    @GetMapping("/{id}")
    public Patient getPersonById(@PathVariable("id") Long id) {
        return personService.getPatientById(id);
    }

    @PostMapping("/new")
    public Patient createNewPatient(@RequestBody Patient patient) {
        return personService.createNewPatient(patient);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(Long id) {
        personService.deletePerson(id);
    }

    @PutMapping("update/{id}")
    public Person updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        return personService.updatePerson(patient);
    }

    @PostMapping("/assign/{patientId}/{challengeId}")
    public Patient assignChallengeToPatient(@PathVariable Long patientId, @PathVariable Long challengeId) {
        return challengeService.assignToPatient(challengeId, patientId);
    }

    @PostMapping("/assign/{patientId}/{petId}")
    public Pet assignPetToPatient(@PathVariable Long patientId, @PathVariable Long petId) {
        return petService.assignToPatient(petId, patientId);
    }

    @PostMapping("post/{patientId}/{therapistId}")
    public Review postReview(@PathVariable Long patientId, @PathVariable Long therapistId, @RequestBody Review review) {
        return reviewService.createNewReview(review, patientId, therapistId);
    }

    @DeleteMapping("/review/delete/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    @PutMapping("/review/update")
    public Review updateReview(@RequestBody Review review) {
        return reviewService.updateReview(review);
    }

    @PostMapping("/session/booking/{patientId}/{therapistId}")
    public void bookSession(@PathVariable Long patientId, @PathVariable Long therapistId) {
        sessionService.enrollIntoSession(patientId, therapistId);
    }

    @PostMapping("/session/cancel/{patientId}/{therapistId}")
    public void cancelSession(@PathVariable Long patientId, @PathVariable Long therapistId) {
        sessionService.disenrollFromSession(patientId, therapistId);
    }


}
