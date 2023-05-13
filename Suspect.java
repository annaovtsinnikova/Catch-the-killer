package com.example.fxproject.CatchTheKiller;

public class Suspect extends Person{
    String alibi;
    boolean isTheAlibiTrue;
    String evidence;
    boolean isTheEvidenceTrue;
    String murderMotive;
    String characterTrait;
    public Suspect(String name, int age, String occupation, String alibi, boolean isTheAlibiTrue,
                   String evidence, boolean isTheEvidenceTrue, String murderMotive, String characterTrait) {

        super(name, age, occupation);
        this.alibi = alibi;
        this.isTheAlibiTrue = isTheAlibiTrue;
        this.evidence = evidence;
        this.isTheEvidenceTrue = isTheEvidenceTrue;
        this.murderMotive = murderMotive;
        this.characterTrait = characterTrait;
    }
    public String getAlibi() {
        return alibi;
    }
    public boolean isTheAlibiTrue() {
        return isTheAlibiTrue;
    }
    public String getEvidence() {
        return evidence;
    }
    public boolean isTheEvidenceTrue() {
        return isTheEvidenceTrue;
    }
    public String getMurderMotive() {
        return murderMotive;
    }
    public String getCharacterTrait() {
        return characterTrait;
    }

    public String toString() {
        return getName() + ", " + getAge() + ", " + getOccupation() + ", " + getAlibi();
    }


}
