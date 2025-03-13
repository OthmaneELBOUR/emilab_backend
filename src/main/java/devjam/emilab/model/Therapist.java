package devjam.emilab.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class Therapist extends Person{
    private String speciality;
    private double rating;
    private String nextAvailiable;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Session> sessions;
    private int numberOfSessions;


    public Therapist() {
    }


    public Therapist(String lastname, String firstname, String phoneNumber, String mail, String speciality,
            double rating, String nextAvailiable, String password) {
        super(lastname, firstname, phoneNumber, mail, password);
        this.speciality = speciality;
        this.rating = rating;
        this.nextAvailiable = nextAvailiable;
    }

    


    public Therapist(String lastname, String firstname, String phoneNumber, String mail, String password,
            String speciality, double rating, String nextAvailiable, int numberOfSessions) {
        super(lastname, firstname, phoneNumber, mail, password);
        this.speciality = speciality;
        this.rating = rating;
        this.nextAvailiable = nextAvailiable;
        this.numberOfSessions = numberOfSessions;
    }


    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getNextAvailiable() {
        return this.nextAvailiable;
    }

    public void setNextAvailiable(String nextAvailiable) {
        this.nextAvailiable = nextAvailiable;
    }

    public List<Session> getSessions() {
        return this.sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }


    public int getNumberOfSessions() {
        return this.numberOfSessions;
    }

    public void setNumberOfSessions(int numberOfSessions) {
        this.numberOfSessions = numberOfSessions;
    }


    @Override
    public String toString() {
        return "Therapist [speciality=" + speciality + ", rating=" + rating + ", nextAvailiable=" + nextAvailiable
                + ", numberOfSessions=" + numberOfSessions + ", toString()=" + super.toString() + "]";
    }





    

}
