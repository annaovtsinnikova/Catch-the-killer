package com.example.fxproject.CatchTheKiller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {

    public static List<String> getNames() {
        return getInfo1("namesCTK.txt");
    }

    public static List<String> getOccupation() {
        return getInfo1("occupationCTK.txt");
    }

    public static List<String> getCausesOfDeath() {
        return getInfo1("causesofdeathCTK.txt");
    }

    public static List<String> getMurderMotive() {
        return getInfo2("murdermotiveCTK.txt");
    }

    public static String evidence(boolean ifEvidenceFromTheKiller, String causeOfDeath) {
        String evidence = "";
        if (ifEvidenceFromTheKiller) {
            switch (causeOfDeath) {
                case "was poisoned" -> evidence = "the bottle of cyanide was found in person's possession";
                case "was shot dead" -> evidence = "Browning 1911-22, which was used to kill, belongs to the person";
                case "got a drug overdose" ->
                        evidence = "fingerprints on the 'Cymbalta' bottle, antidepressants, the overdose of which caused death";
                case "was hit by a car" ->
                        evidence = "the person was caught on camera at the gas station with the car that a witness saw at the crime scene.";
                case "fell or was pushed off the bridge was drowned in the river" ->
                        evidence = "the shoe of the victim was found in person's possession";
                case "was drowned in the bath" ->
                        evidence = "there was a fight and person's dna was found under the victim's fingernails";
                case "got stabbed" -> evidence = "a knife with victim's blood was found at person's house";
                case "was buried alive" ->
                        evidence = "person's hair and blood drops with the same blood type were found on the victim";
                case "blunt force trauma to the head" -> evidence = "baseball bat with victim's blood";
                case "was robbed and beaten" -> evidence = "victim's possessions found at person's house";
                case "was found hanged in his/her flat" ->
                        evidence = "clothing fibers and a partial shoe print found at the crime scene that belonged to that person";
                case "was suffocated" ->
                        evidence = "the scarf, with which the crime was committed, was found in person's possession";
            }
        } else {
            evidence = switch (causeOfDeath) {
                case "was poisoned" -> "person has been working with chemicals for a while";
                case "was shot dead" -> "person has sent a threatening message to the victim 2 weeks ago";
                case "got a drug overdose" -> "the person was a drug addict in the past";
                case "was hit by a car" -> "a witness saw a car with a license plate number that belongs to the person";
                case "fell or was pushed off the bridge was drowned in the river" ->
                        "the person works close to the crime scene";
                case "was drowned in the bath", "was suffocated" ->
                        "person's fingerprints were found at victim's house";
                case "got stabbed" -> "the person had a meeting with the victim planned on the day of the murder";
                case "was buried alive" -> "a witness claimed that has seen somebody who looked like that person";
                case "blunt force trauma to the head" -> "the person is a baseball player";
                case "was robbed and beaten" -> "the person really needed money";
                case "was found hanged in his/her flat" -> "the person had recently had an argument with the victim";
                default -> evidence;
            };
        }
        return evidence;
    }

    public static List<String> getAlibi() {
        return getInfo1("alibiCTK.txt");
    }

    public static List<String> getSuspiciousCharacterTraits() {
        return getInfo1("suspiciouscharactertraitsCTK.txt");
    }

    public static  List<String> getPositiveCharacterTraits() {
        return getInfo1("positivecharactertraitsCTK.txt");
    }


    public static List<String> getInfo1(String failinimi) {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(failinimi), StandardCharsets.UTF_8))) {
            String rida;
            while ((rida = br.readLine()) != null) {
                data.add(rida);
            }

        } catch (IOException e) {
            System.out.println("Faili erind.");
            System.exit(0);
        }

        return data;
    }

    public static List<String> getInfo2(String failinimi) {
        List<String> data = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(failinimi), StandardCharsets.UTF_8))) {
            String rida;
            while ((rida = br.readLine()) != null) {
                sb.append(rida);
            }
            String fileContent = sb.toString();
            String[] splitData = fileContent.split(";");
            data.addAll(Arrays.asList(splitData));

        } catch (IOException e) {
            System.out.println("Probleem failiga.");
            System.exit(0);
        }

        return data;
    }


}
