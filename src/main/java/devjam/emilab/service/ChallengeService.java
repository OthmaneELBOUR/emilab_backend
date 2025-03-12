package devjam.emilab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devjam.emilab.model.Challenge;
import devjam.emilab.model.Patient;
import devjam.emilab.repo.ChallengeRepo;
import devjam.emilab.repo.PatientRepo;

@Service
public class ChallengeService {
    @Autowired
    private ChallengeRepo challengeRepo;
    @Autowired
    private PatientRepo patientRepo;

    public Challenge getChallengeById(Long id) {
        return challengeRepo.findById(id).orElse(null);
    }

    public Challenge createNewChallenge(Challenge challenge) {
        return challengeRepo.save(challenge);
    }

    public void deleteChallenge(Long id) {
        if(challengeRepo.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Challenge not found");
        }
        challengeRepo.deleteById(id);
    }

    public Challenge updateChallenge(Challenge challenge) {
        return challengeRepo.save(challenge);
    }

    public Patient assignToPatient(Long challengeId, Long patientId) {
        Challenge challenge = challengeRepo.findById(challengeId).orElse(null);
        Patient patient = patientRepo.findById(patientId).orElse(null);
        if(challenge == null || patient == null) {
            return null;
        }
        patient.getChallenges().add(challenge);
        return patientRepo.save(patient);
    }
    
}
