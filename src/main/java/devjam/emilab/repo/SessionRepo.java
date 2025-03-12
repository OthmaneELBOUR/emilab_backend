package devjam.emilab.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import devjam.emilab.model.Session;
import devjam.emilab.model.Therapist;

public interface SessionRepo extends JpaRepository<Session, Long> {

    List<Session> findByTherapist(Therapist therapist);
}
