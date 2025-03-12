package devjam.emilab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devjam.emilab.model.Patient;
import devjam.emilab.model.Session;
import devjam.emilab.model.Therapist;
import devjam.emilab.repo.PatientRepo;
import devjam.emilab.repo.SessionRepo;
import devjam.emilab.repo.TherapistRepo;

@Service
public class SessionService {
    @Autowired
    private SessionRepo sessionRepo;
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private TherapistRepo therapistRepo;

    public Session getSessionById(Long id) {
        return sessionRepo.findById(id).orElse(null);
    }

    public List<Session> getSessionsByTherapist(Long id) {
        Therapist therapist = therapistRepo.findById(id).orElse(null);
        if(therapist == null) {
            throw new IllegalArgumentException("Therapist not found");
        }
        return sessionRepo.findByTherapist(therapist);
    }

    public Session createNewSession(Session session) {
        return sessionRepo.save(session);
    }

    public void deleteSession(Long id) {
        if(sessionRepo.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Session not found");
        }
        sessionRepo.deleteById(id);
    }

    public Session updateSession(Session session) {
        return sessionRepo.save(session);
    }

    public Session enrollIntoSession(Long sessionId, Long patientId) {
        Session session = sessionRepo.findById(sessionId).orElse(null);
        Patient patient = patientRepo.findById(patientId).orElse(null);
        if(session == null || patient == null) {
            throw new IllegalArgumentException("Session or patient not found");
        }
        session.getMembers().add(patient);
        return sessionRepo.save(session);
    }

    public Session disenrollFromSession(Long sessionId, Long patientId) {
        Session session = sessionRepo.findById(sessionId).orElse(null);
        Patient patient = patientRepo.findById(patientId).orElse(null);
        if(session == null || patient == null) {
            throw new IllegalArgumentException("Session or patient not found");
        }
        session.getMembers().remove(patient);
        return sessionRepo.save(session);
    }
}
