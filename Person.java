package com.example.fxproject.CatchTheKiller;



public class Person {
    private String name;
    private int age;
    private String occupation;

    public Person(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getOccupation() {
        return occupation;
    }

    public String toString() {
        return getName() + ", "+ getAge() + " years old, " + getOccupation();
    }
}

//
//        double x = 540;
//        double  y = 340;
//        for (int i = 0; i < catchTheKiller.suspects.size(); i++) {
//            if (i==3) {
//                x = 380;
//                y = 240;
//            }
//
//            Label suspect = new Label();
//            suspect.setText(i+1 + ". " + catchTheKiller.suspects.get(i).getName() + ",\n" + catchTheKiller.suspects.get(i).getAge() +
//                    ",\n" + catchTheKiller.suspects.get(i).getOccupation() + ",\n" + catchTheKiller.suspects.get(i).getAlibi());
//            suspect.setStyle("-fx-text-fill: WHITE;");
//            suspect.setFont(Font.font("Impact", FontWeight.MEDIUM, 13));
//            suspect.layoutYProperty().bind(pane.heightProperty().subtract(suspect.heightProperty()).subtract(y));
//            suspect.layoutXProperty().bind(pane.widthProperty().subtract(suspect.widthProperty()).subtract(x));
//            x -= pane.widthProperty().doubleValue() + 230;
//        pane.getChildren().add(suspect);