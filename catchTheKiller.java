package com.example.fxproject.CatchTheKiller;


import java.util.*;

public class catchTheKiller extends Library{
    static Victim victim;
    static Investigator investigator;
    static Suspect killer;

    static List<Suspect> suspects = new ArrayList<>();
    static List<String> namesNotUsed = getNames();
    static Random random = new Random();

    public catchTheKiller() {
        investigator = whoIsOurInvestigator();
        victim = whoWasKilled();
        killer = whoIsTheKiller();
        suspects = getSuspects();
        suspects.add(killer);
        Collections.shuffle(suspects);
    }

    public static String getRandomUniqueName() {
        String name = namesNotUsed.get(random.nextInt(namesNotUsed.size()));
        namesNotUsed.remove(name);
        return name;
    }

    public static Investigator whoIsOurInvestigator() {
        return new Investigator(getRandomUniqueName(), random.nextInt(60 - 25) + 25);
    }

    public static Victim whoWasKilled() {
        int randomIndex1 = random.nextInt(getOccupation().size());
        int randomIndex2 = random.nextInt(getCausesOfDeath().size());
        victim = new Victim(getRandomUniqueName(), random.nextInt(95 - 16) + 16,
                getOccupation().get(randomIndex1), getCausesOfDeath().get(randomIndex2));
        return victim;
    }

    //one of the suspects is the killer
    public static Suspect whoIsTheKiller() {
        Suspect killer;
        int randomIndex1 = random.nextInt(getOccupation().size());
        int randomIndex2 = random.nextInt(getAlibi().size());
        int randomIndex3 = random.nextInt(getMurderMotive().size());
        int randomIndex4 = random.nextInt(getSuspiciousCharacterTraits().size());
        killer = new Suspect(getRandomUniqueName(), random.nextInt(95 - 16) + 16, getOccupation().get(randomIndex1),
                getAlibi().get(randomIndex2), false, evidence(true, victim.getCauseOfDeath()), true,
                getMurderMotive().get(randomIndex3), getSuspiciousCharacterTraits().get(randomIndex4));
        return killer;
    }

    public static List<Suspect> getSuspects() {
        Suspect suspect;
        //a suspect, who has some evidence against him and had some suspicious behaviour during the interrogation, but is not the killer
        int randomIndex1 = random.nextInt(getOccupation().size());
        int randomIndex2 = random.nextInt(getAlibi().size());
        int randomIndex3 = random.nextInt(getSuspiciousCharacterTraits().size());
        suspect = new Suspect(getRandomUniqueName(), random.nextInt(95 - 16) + 16, getOccupation().get(randomIndex1),
                getAlibi().get(randomIndex2), true, evidence(false, victim.getCauseOfDeath()), false,
                null, getSuspiciousCharacterTraits().get(randomIndex3));
        suspects.add(suspect);

        //a suspect, who has lied about his alibi and has a murder motive, but is not the killer
        int randomIndex4 = random.nextInt(getOccupation().size());
        int randomIndex5 = random.nextInt(getAlibi().size());
        int randomIndex6 = random.nextInt(getMurderMotive().size());
        int randomIndex7 = random.nextInt(getPositiveCharacterTraits().size());
        suspect = new Suspect(getRandomUniqueName(), random.nextInt(95 - 16) + 16, getOccupation().get(randomIndex4),
                getAlibi().get(randomIndex5), false, null, false,
                getMurderMotive().get(randomIndex6), getPositiveCharacterTraits().get(randomIndex7));
        suspects.add(suspect);

        //a suspect, that has some evidence against him and has lied about his alibi, but is not the killer
        int randomIndex8 = random.nextInt(getOccupation().size());
        int randomIndex9 = random.nextInt(getAlibi().size());
        int randomIndex10 = random.nextInt(getPositiveCharacterTraits().size());
        suspect = new Suspect(getRandomUniqueName(), random.nextInt(95 - 16) + 16, getOccupation().get(randomIndex8),
                getAlibi().get(randomIndex9), false, evidence(false, victim.getCauseOfDeath()), false,
                null, getPositiveCharacterTraits().get(randomIndex10));
        suspects.add(suspect);

        //a suspect, that has a murder motive and had some suspicious behaviour during the interrogation, but is not the killer
        int randomIndex11 = random.nextInt(getOccupation().size());
        int randomIndex12 = random.nextInt(getAlibi().size());
        int randomIndex13 = random.nextInt(getMurderMotive().size());
        int randomIndex14 = random.nextInt(getSuspiciousCharacterTraits().size());
        suspect = new Suspect(getRandomUniqueName(), random.nextInt(95 - 16) + 16, getOccupation().get(randomIndex11),
                getAlibi().get(randomIndex12), true, null, false,
                getMurderMotive().get(randomIndex13), getSuspiciousCharacterTraits().get(randomIndex14));
        suspects.add(suspect);

        return suspects;
    }


}
