package devjam.emilab.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import devjam.emilab.enums.Mood;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class Patient extends Person {
    private String pseudo;
    private int points = 100;
    @Enumerated(value = EnumType.STRING)
    private Mood mood;
    private int level = 1;
    // private List<Mood> previousMoods;
    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Session> sessions;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Challenge> challenges;


    public Patient() {
    }


    public Patient(String lastname, String firstname, String phoneNumber, String mail, String password, String pseudo,
            int points, Mood mood, int level) {
        super(lastname, firstname, phoneNumber, mail, password);
        this.pseudo = pseudo;
        this.points = points;
        this.mood = mood;
        this.level = level;
    }


    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Mood getMood() {
        return this.mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Session> getSessions() {
        return this.sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<Challenge> getChallenges() {
        return this.challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    


    @Override
    public String toString() {
        return "Patient [points=" + points + ", mood=" + mood + ", level=" + level + ", challenges=" + challenges
                + ", toString()=" + super.toString() + "]";
    }


    

    

    
}
