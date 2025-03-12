package devjam.emilab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import devjam.emilab.model.Challenge;

public interface ChallengeRepo extends JpaRepository<Challenge, Long> {

}
