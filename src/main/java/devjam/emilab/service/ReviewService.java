package devjam.emilab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devjam.emilab.model.Person;
import devjam.emilab.model.Review;
import devjam.emilab.repo.PatientRepo;
import devjam.emilab.repo.ReviewRepo;
import devjam.emilab.repo.TherapistRepo;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private TherapistRepo therapistRepo;

    public Review getReviewById(Long id) {
        return reviewRepo.findById(id).orElse(null);
    }

    public List<Review> getReviewsByAuthorId(Long id) {
        Person author = patientRepo.findById(id).orElse(null);
        if(author == null) {
            throw new IllegalArgumentException("Patient not found");
        }
        return reviewRepo.findByAuthor(author);
    }

    public List<Review> getReviewsByTargetId(Long id) {
        Person target = therapistRepo.findById(id).orElse(null);
        if(target == null) {
            throw new IllegalArgumentException("Therapist not found");
        }
        return reviewRepo.findByTarget(target);
    }

    public Review createNewReview(Review review, Long patientId, Long therapistId) {
        review.setAuthor(patientRepo.findById(patientId).
            orElse(null));
        review.setTarget(therapistRepo.findById(therapistId).
            orElse(null));
        if(review.getAuthor() == null || review.getTarget() == null) {
            throw new IllegalArgumentException("Patient or therapist not found");
        }
        return reviewRepo.save(review);
    }

    public void deleteReview(Long id) {
        if(reviewRepo.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Review not found");
        }
        reviewRepo.deleteById(id);
    }

    public Review updateReview(Review review) {

        return reviewRepo.save(review);
    }
}
