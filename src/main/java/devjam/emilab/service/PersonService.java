package devjam.emilab.service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Therapist> getAllTherapists() {
        return therapistRepo.findAll();
    }

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

    public List<Therapist> addTherapists(List<Therapist> listTherapist) {
        List<Therapist> result = new ArrayList<>();
        listTherapist.forEach(t-> {
            if(this.getPersonById(t.getId()) != null) {
                throw new UserAlreadyExistsException("User with id " + t.getId() + " already exists");
            }
            if(this.getPersonByEmail(null) != null) {
                throw new UserAlreadyExistsException("User with email " + t.getMail() + " already exists");
            }
            if(this.getPersonByPhoneNumber(null) != null) {
                throw new UserAlreadyExistsException("User with phone number " + t.getPhoneNumber() + " already exists");
            }
            result.add(this.personRepo.save(t));
        });
        return result;
    }

    public Therapist createNewTherapist(Therapist therapist) {
        if(this.getPersonById(therapist.getId())
            != null) {
            // throw new UserAlreadyExistsException("User with id " + therapist.getId() + " already exists");
            System.out.println("if statement for id");
            return null;
        }
        if(this.getPersonByEmail(therapist.getMail()) != null) {
            System.out.println("if statement for email");
           return null;
        }
        if(this.getPersonByPhoneNumber(therapist.getPhoneNumber()) != null) {
            // throw new UserAlreadyExistsException("User with phone number " + therapist.getPhoneNumber() + " already exists");
            System.out.println("if statement for phone number");
            return null;
        }
        therapist.setId(null);
        therapist.setLastname(therapist.getLastname().toUpperCase());
        therapist.setMail(therapist.getLastname() + "." + therapist.getFirstname() + "@emilab.com");
        therapist.setPhoneNumber("000" + therapist.getNumberOfSessions());

        return therapistRepo.save(therapist);
    }
    
    public Patient createNewPatient(Patient patient) {
        if(this.getPersonById(patient.getId()) != null) {
            throw new UserAlreadyExistsException("User with id " + patient.getId() + " already exists");
        }
        if(this.getPersonByEmail(null) != null) {
            throw new UserAlreadyExistsException("User with email " + patient.getMail() + " already exists");
        }
        patient.setId(null);
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
