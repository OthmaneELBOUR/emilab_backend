package devjam.emilab.model;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double price;
    private String date;
    private LocalTime time;
    private String topics;
    @ManyToOne
    private Therapist therapist;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Patient> members;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Review> reviews;


    public Session() {
    }


    public Session(String title, String description, double price, String date, LocalTime time, String topics,
            Therapist therapist) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.date = date;
        this.time = time;
        this.topics = topics;
        this.therapist = therapist;
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

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return this.time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getTopics() {
        return this.topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public Therapist getTherapist() {
        return this.therapist;
    }

    public void setTherapist(Therapist therapist) {
        this.therapist = therapist;
    }

    public List<Patient> getMembers() {
        return this.members;
    }

    public void setMembers(List<Patient> members) {
        this.members = members;
    }

    public List<Review> getReviews() {
        return this.reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


    @Override
    public String toString() {
        return "Session [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
                + ", date=" + date + ", time=" + time + ", topics=" + topics + ", therapist=" + therapist + ", members="
                + members + ", reviews=" + reviews + "]";
    }

}
