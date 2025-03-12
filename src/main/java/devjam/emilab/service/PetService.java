package devjam.emilab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devjam.emilab.model.Patient;
import devjam.emilab.model.Pet;
import devjam.emilab.repo.PatientRepo;
import devjam.emilab.repo.PetRepo;

@Service
public class PetService {

    @Autowired
    private PetRepo petRepo;
    @Autowired
    private PatientRepo patientRepo;

    public Pet getPetById(Long id) {
        return petRepo.findById(id).orElse(null);
    }
    
    public Pet getPetByName(String name) {
        return petRepo.findByName(name);
    }

    public Pet createNewPet(Pet pet) {
        return petRepo.save(pet);
    }

    public void deletePet(Long id) {
        petRepo.deleteById(id);
    }

    public Pet updatePet(Pet pet) {
        return petRepo.save(pet);
    }

    public Pet feed(Long id, int happiness, int hunger) {
        Pet pet = petRepo.findById(id).orElse(null);
        if(pet == null) {
            throw new IllegalArgumentException("Pet not found");
        }
        Patient patient = patientRepo.findById(pet.getOwner().getId()).orElse(null);
        if(patient == null) {
            throw new IllegalArgumentException("Patient not found");
        }
        pet.setHunger(hunger);
        pet.setHappiness(happiness);
        pet.setExperience(pet.getExperience() + 20);
        if(pet.getExperience() >= pet.getExperienceToNextLevel()) {
            pet.setLevel(pet.getLevel() + 1);
            pet.setExperience(0);
            pet.setExperienceToNextLevel((int)Math.round(pet.getExperienceToNextLevel() * 1.5));
        }
        patient.setPoints(patient.getPoints() + 10);
        patientRepo.save(patient);
        return petRepo.save(pet);
    }

    public Pet play(Long id, int happiness, int hunger, int energy) {
        Pet pet = petRepo.findById(id).orElse(null);
        
        if(pet == null) {
            throw new IllegalArgumentException("Pet not found");
        }
        Patient patient = patientRepo.findById(pet.getOwner().getId()).orElse(null);
        if(patient == null) {
            throw new IllegalArgumentException("Patient not found");
        }
        pet.setHunger(hunger);
        pet.setHappiness(happiness);
        pet.setEnergy(energy);
        pet.setExperience(pet.getExperience() + 20);
        this.levelUp(pet);
        patient.setPoints(patient.getPoints() + 10);
        patientRepo.save(patient);
        return petRepo.save(pet);
    }

    private void levelUp(Pet pet) {
        if(pet.getExperience() >= pet.getExperienceToNextLevel()) {
            pet.setLevel(pet.getLevel() + 1);
            pet.setExperience(0);
            pet.setExperienceToNextLevel((int)Math.round(pet.getExperienceToNextLevel() * 1.5));
        }
    }

    public Pet rest(Long id, int energy) {
        Pet pet = petRepo.findById(id).orElse(null);
        if(pet == null) {
            throw new IllegalArgumentException("Pet not found");
        }
        Patient patient = patientRepo.findById(pet.getOwner().getId()).orElse(null);
        if(patient == null) {
            throw new IllegalArgumentException("Patient not found");
        }
        pet.setEnergy(energy);
        pet.setExperience(pet.getExperience() + 20);
        if(pet.getExperience() >= pet.getExperienceToNextLevel()) {
            pet.setLevel(pet.getLevel() + 1);
            pet.setExperience(0);
            pet.setExperienceToNextLevel((int)Math.round(pet.getExperienceToNextLevel() * 1.5));
        }
        patient.setPoints(patient.getPoints() + 10);
        patientRepo.save(patient);
        return petRepo.save(pet);
    }

    public Pet assignToPatient(Long petId, Long patientId) {
        Pet pet = petRepo.findById(petId).orElse(null);
        Patient patient = patientRepo
            .findById(patientId)
            .orElse(null);
        if(pet == null || patient == null) {
            throw new IllegalArgumentException("Pet or patient not found");
        }
        pet.setOwner(patient);
        return petRepo.save(pet);
    }
}
