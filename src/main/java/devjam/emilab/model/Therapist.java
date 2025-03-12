package devjam.emilab.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Therapist extends Person{
    private String specialities;
    private double rating;
    private LocalDate nextDateAvailiable;
    @OneToMany
    private List<Session> sessions;


    public Therapist() {
    }


    public Therapist(String lastname, String firstname, String phoneNumber, String mail, String specialities,
            double rating, LocalDate nextDateAvailiable, String password) {
        super(lastname, firstname, phoneNumber, mail, password);
        this.specialities = specialities;
        this.rating = rating;
        this.nextDateAvailiable = nextDateAvailiable;
    }


    public String getSpecialities() {
        return this.specialities;
    }

    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDate getNextDateAvailiable() {
        return this.nextDateAvailiable;
    }

    public void setNextDateAvailiable(LocalDate nextDateAvailiable) {
        this.nextDateAvailiable = nextDateAvailiable;
    }

    public List<Session> getSessions() {
        return this.sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }


    @Override
    public String toString() {
        return "Therapist [specialities=" + specialities + ", rating=" + rating + ", nextDateAvailiable="
                + nextDateAvailiable + ", toString()=" + super.toString() + "]";
    }

    

}
