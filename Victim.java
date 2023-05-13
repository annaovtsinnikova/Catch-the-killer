package com.example.fxproject.CatchTheKiller;


public class Victim extends Person{

    private final String causeOfDeath;

    public Victim(String name, int age, String occupation, String causeOfDeath) {
        super(name, age, occupation);
        this.causeOfDeath = causeOfDeath;
    }
    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public String toString() {
        return getName() + ", " + getAge() + ", " + getOccupation() + ", " + getCauseOfDeath();
    }

}
