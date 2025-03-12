package devjam.emilab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String pictureURL;
    private int happiness;
    private int energy;
    private int hunger;
    private int level;
    private int dailyStreak;
    private int experience = 0;
    private int experienceToNextLevel = 100;
    @OneToOne
    private Person owner;


    public Pet() {
    }


    public Pet(String name, int happiness, int energy, int hunger, int level, int dailyStreak, Person owner) {
        this.name = name;
        this.happiness = happiness;
        this.energy = energy;
        this.hunger = hunger;
        this.level = level;
        this.dailyStreak = dailyStreak;
        this.owner = owner;
    }

    


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHappiness() {
        return this.happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getHunger() {
        return this.hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDailyStreak() {
        return this.dailyStreak;
    }

    public void setDailyStreak(int dailyStreak) {
        this.dailyStreak = dailyStreak;
    }

    public Person getOwner() {
        return this.owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperienceToNextLevel() {
        return this.experienceToNextLevel;
    }

    public void setExperienceToNextLevel(int experienceToNextLevel) {
        this.experienceToNextLevel = experienceToNextLevel;
    }

    public String getPictureURL() {
        return this.pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }



    @Override
    public String toString() {
        return "Pet [id=" + id + ", name=" + name + ", happiness=" + happiness + ", energy=" + energy + ", hunger="
                + hunger + ", level=" + level + ", dailyStreak=" + dailyStreak + ", experience=" + experience
                + ", experienceToNextLevel=" + experienceToNextLevel + ", owner=" + owner + "]";
    }



    




}
