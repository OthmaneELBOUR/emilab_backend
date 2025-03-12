package devjam.emilab.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import devjam.emilab.model.Person;
import devjam.emilab.model.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findByAuthor(Person author);

    List<Review> findByTarget(Person target);
}
