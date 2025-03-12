package devjam.emilab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devjam.emilab.model.Person;
import devjam.emilab.model.Therapist;
import devjam.emilab.exceptions.UserAlreadyExistsException;
import devjam.emilab.model.Patient;
import devjam.emilab.repo.PatientRepo;
import devjam.emilab.repo.PersonRepo;
import devjam.emilab.repo.TherapistRepo;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private TherapistRepo therapistRepo;
    @Autowired
    private PatientRepo patientRepo;

    public Patient getPatientById(Long id) {
        return patientRepo.findById(id).orElse(null);
    }

    public Therapist getTherapistById(Long id) {
        return therapistRepo.findById(id).orElse(null);
    }

    public Person getPersonById(Long id) {
        return personRepo.findById(id).orElse(null);
    }

    public Person getPersonByEmail(String email) {
        return personRepo.findByMail(email);
    }

    public Person getPersonByPhoneNumber(String phoneNumber) {
        return personRepo.findByPhoneNumber(phoneNumber);
    }

    public Therapist createNewTherapist(Therapist therapist) {
        if(this.getPersonById(therapist.getId()) != null) {
            throw new UserAlreadyExistsException("User with id " + therapist.getId() + " already exists");
        }
        if(this.getPersonByEmail(null) != null) {
            throw new UserAlreadyExistsException("User with email " + therapist.getMail() + " already exists");
        }
        if(this.getPersonByPhoneNumber(null) != null) {
            throw new UserAlreadyExistsException("User with phone number " + therapist.getPhoneNumber() + " already exists");
        }

        return therapistRepo.save(therapist);
    }
    
    public Patient createNewPatient(Patient patient) {
        if(this.getPersonById(patient.getId()) != null) {
            throw new UserAlreadyExistsException("User with id " + patient.getId() + " already exists");
        }
        if(this.getPersonByEmail(null) != null) {
            throw new UserAlreadyExistsException("User with email " + patient.getMail() + " already exists");
        }
        if(this.getPersonByPhoneNumber(null) != null) {
            throw new UserAlreadyExistsException("User with phone number " + patient.getPhoneNumber() + " already exists");
        }
        return patientRepo.save(patient);
    }

    public void deletePerson(Long id) {
        personRepo.deleteById(id);
    }

    public Person updatePerson(Person person) {
        if(this.getPersonByEmail(null) != null) {
            throw new UserAlreadyExistsException("User with email " + person.getMail() + " already exists");
        }
        if(this.getPersonByPhoneNumber(null) != null) {
            throw new UserAlreadyExistsException("User with phone number " + person.getPhoneNumber() + " already exists");
        }

        return personRepo.save(person);
    }
    

    
}
