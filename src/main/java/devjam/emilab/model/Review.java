package devjam.emilab.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int rating;
    private LocalDate date;
    @ManyToOne
    private Person author;
    @ManyToOne
    private Person target;


    public Review() {
    }


    public Review(String title, String description, int rating, LocalDate date, Person author, Person target) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.date = date;
        this.author = author;
        this.target = target;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Person getAuthor() {
        return this.author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public Person getTarget() {
        return this.target;
    }

    public void setTarget(Person target) {
        this.target = target;
    }


    @Override
    public String toString() {
        return "Review [id=" + id + ", title=" + title + ", description=" + description + ", rating=" + rating
                + ", date=" + date + ", author=" + author + ", target=" + target + "]";
    }

}
