package devjam.emilab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import devjam.emilab.model.Therapist;

public interface TherapistRepo extends JpaRepository<Therapist, Long> {

}
