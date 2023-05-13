package com.example.fxproject.CatchTheKiller;

public class Investigator extends Person{

    private static final String occupation = "investigator";
    public Investigator(String name, int age) {
        super(name, age, occupation);

    }
    public String checkTheAlibi(Suspect suspect) {
        if (suspect.isTheAlibiTrue()) {
            return "alibi checked out";
        } else {
            return "has lied about the alibi";
        }
    }
    public String isThereAnyEvidence(Suspect suspect) {
        if (suspect.getEvidence() != null) {
            return suspect.getEvidence();
        } else {
            return "no particular evidence";
        }
    }
    public String isTheEvidenceEnough(Suspect suspect) {
        if (suspect.isTheEvidenceTrue()) {
            return "investigator believes the person is guilty";
        } else {
            return "investigator is not sure if this is the killer";
        }
    }
    public String isThereAMurderMotive(Suspect suspect) {
        if (suspect.getMurderMotive() != null) {
            return suspect.getMurderMotive();
        } else {
            return "We don't know if this\nperson had any murder motive";
        }
    }
    public String conductTheInterrogation(Suspect suspect) {
        return suspect.getCharacterTrait();
    }
    public String checkTheKiller(String suspectName, Suspect killer) {
        if (suspectName.equals(killer.getName())) {
            return getName() + ": Let's check......" + "\n\n" + "Oh yes, you caught the killer, congratulations!\n" +
                    "Now this person will be arrested and the case will soon be submitted to the court." +
                    "\nThe killer: \n" + killer.getName() + "\n" + killer.getAge() + "\n" + killer.getOccupation() + "\n"
                    + killer.getAlibi() + "\n" + conductTheInterrogation(killer) + "\n" + checkTheAlibi(killer) + "\n" +
                    isThereAMurderMotive(killer) + "\n" + isThereAnyEvidence(killer);
        } else {
            return getName() + ": Oh no, that's not the culprit. The real killer avoided punishment. \n It was: " +
                    "\n" + killer.getName() + "\n" + killer.getAge() + "\n" + killer.getOccupation() + "\n"
                    + killer.getAlibi() + "\n" + conductTheInterrogation(killer) + "\n" +
                    isThereAMurderMotive(killer) + "\n" + isThereAnyEvidence(killer);
        }
    }

    public String toString() {
        return getName();
    }

}
