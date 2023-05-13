package com.example.fxproject.CatchTheKiller;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Window extends Application implements EventHandler<MouseEvent> {
    private catchTheKiller game;
    private Stage stage = new Stage();
    private StackPane root;
    private Pane page1;
    private Pane page2;
    private Pane page3;
    private Pane page4;
    private Pane page5;
    private Pane page6;
    private BackgroundSize BackgroundSize = new BackgroundSize(javafx.scene.layout.BackgroundSize.AUTO, javafx.scene.layout.BackgroundSize.AUTO, true, true, true, true);
    private boolean buttonIclicked = false;
    private boolean buttonAclicked = false;
    private boolean buttonMclicked = false;
    private boolean buttonEclicked = false;
    private boolean buttonCclicked = false;
    private boolean buttonKclicked = false;
    private boolean pressed1 = false;
    private boolean pressed2 = false;
    private boolean pressed3 = false;
    private boolean pressed4 = false;
    private boolean pressed5 = false;
    Scene scene1;
    int numberOfActions = 0;
    Label num = new Label();
    int lastSuspect = 6;


    @Override
    public void start(Stage primaryStage) throws Exception {
        game = new catchTheKiller();
        stage = primaryStage;
        root = new StackPane();
        scene1 = new Scene(root, 1000, 700);
        page1 = createPage1();
        page2 = createPage2();
        page3 = createPage3();
        page4 = createPage4();
        page5 = createPage5();
        page6 = createPage6();


        root.getChildren().add(page1);
        stage.setScene(scene1);
        stage.setTitle("Catch the killer");
        stage.show();
    }

    private Pane createPage1() {
        Pane pane = new Pane();
        setImage(pane, "file:catchthekiller.png");
        Button button1 = new Button("Start");
        button1.setFont(Font.font("Impact", FontWeight.BOLD, 18));
        button1.setTextFill(Color.CRIMSON);
        button1.setPrefSize(190, 25);
        button1.layoutXProperty().bind(pane.widthProperty().subtract(button1.widthProperty()).divide(2));
        button1.layoutYProperty().bind(pane.heightProperty().subtract(60));
        button1.setOnAction(e -> showPage(page2));
        pane.getChildren().add(button1);

        return pane;
    }

    private Pane createPage2() {
        Pane pane = new Pane();
        setImage(pane, "file:crime.jpeg");
        Label intro = new Label();
        intro.setText("It was a peaceful morning until another body was found...\n                                    A crime was committed.\n              You can help the investigator find the criminal.");
        intro.setStyle("-fx-text-fill: DARKRED;");
        intro.setFont(Font.font("Impact", FontWeight.BOLD, 22));
        intro.layoutYProperty().bind(pane.heightProperty().subtract(intro.heightProperty().add(500)));
        intro.layoutXProperty().bind(pane.widthProperty().subtract(intro.widthProperty()).divide(2));
        pane.getChildren().add(intro);

        Button button2 = new Button("Rules");
        button2.setFont(Font.font("Impact", FontWeight.BOLD, 18));
        button2.setTextFill(Color.DARKRED);
        button2.setPrefSize(150, 25);
        button2.layoutXProperty().bind(pane.widthProperty().subtract(button2.widthProperty()).divide(2));
        button2.layoutYProperty().bind(pane.heightProperty().subtract(60));
        button2.setOnAction(e -> showPage(page3));
        pane.getChildren().add(button2);

        return pane;
    }

    private Pane createPage3() {
        Pane pane = new Pane();
        setImage(pane, "file:crime.jpeg");
        Label intro = new Label();
        intro.setText("""
                You have to find who the killer is. You are going to see all the suspects. One of them is the real killer.
                Killer is the only one, who has the fake alibi, evidence against him, murder motive and was acting suspicious 
                during the interrogation, while other suspects have only 2 of those things.\s



                You can:\s
                • Click the ‘interrogation’ button to conduct the interrogation and get to know their character traits
                • Click the ‘alibi’ button to know if the alibi is fake
                • Click the ‘motive’ button to know if the person had a motive to kill
                • Click the ‘evidence’ button to know if there is any evidence against the suspect and 
                  after if you are not sure you can click ’consult’ to ask the investigator if he believes the evidence is enough
                • Click 'the killer is' if you are ready to name the killer.

                After clicking any of those buttons you have to press the key on your keyboard - the number of suspect
                (For example - ‘alibi’ ‘4’ - and you know the alibi of the 4th suspect)


                Remember:\s
                 - you only have 9 available actions, then the game will end\s
                 - you also can not ask about the same suspect 2 times in a row
                """);
        intro.setStyle("-fx-text-fill: FIREBRICK;");
        intro.setFont(Font.font("Impact", FontWeight.BOLD, 20));
        intro.layoutYProperty().bind(pane.heightProperty().subtract(intro.heightProperty().add(140)));
        intro.layoutXProperty().bind(pane.widthProperty().subtract(intro.widthProperty()).divide(14));

        Button button3 = new Button("Next");
        button3.setFont(Font.font("Impact", FontWeight.BOLD, 18));
        button3.setTextFill(Color.DARKRED);
        button3.setPrefSize(110, 25);
        button3.layoutXProperty().bind(pane.widthProperty().subtract(button3.widthProperty()).subtract(20));
        button3.layoutYProperty().bind(pane.heightProperty().subtract(40));
        button3.setOnAction(e -> showPage(page4));

        pane.getChildren().add(intro);
        pane.getChildren().add(button3);
        return pane;
    }

    private Pane createPage4() {
        Pane pane = new Pane();
        setImage(pane, "file:investigator.JPG");
        Label investigator = new Label();
        investigator.setText("Meet the investigator:  " + catchTheKiller.investigator.getName() + "\n\nThe victim: " + catchTheKiller.victim);
        investigator.setStyle("-fx-text-fill: DARKRED;");
        investigator.setFont(Font.font("Impact", FontWeight.MEDIUM, 20));
        investigator.layoutYProperty().bind(pane.heightProperty().subtract(investigator.heightProperty()).subtract(600));
        investigator.layoutXProperty().bind(pane.widthProperty().subtract(investigator.widthProperty()).divide(2));

        Button button4 = new Button("See suspects");
        button4.setFont(Font.font("Impact", FontWeight.BOLD, 18));
        button4.setTextFill(Color.DARKRED);
        button4.setPrefSize(130, 20);
        button4.layoutXProperty().bind(pane.widthProperty().subtract(button4.widthProperty()).subtract(20));
        button4.layoutYProperty().bind(pane.heightProperty().subtract(40));
        button4.setOnAction(e -> showPage(page5));

        pane.getChildren().add(investigator);
        pane.getChildren().add(button4);
        return pane;
    }

    private Pane createPage5() {
        Pane pane = new Pane();
        setImage(pane, "file:crimeback.jpg");

        Label investigator = new Label();
        investigator.setText("Meet the investigator:  " + catchTheKiller.investigator.getName() + "\nThe victim: " + catchTheKiller.victim + "\n\nThe suspects: ");
        investigator.setStyle("-fx-text-fill: DARKORANGE;");
        investigator.setFont(Font.font("Impact", FontWeight.MEDIUM, 15));
        double xRatio1 = 0.26;
        double yRatio1 = 0.005;
        investigator.layoutXProperty().bind(pane.widthProperty().multiply(xRatio1));
        investigator.layoutYProperty().bind(pane.heightProperty().multiply(yRatio1));
        pane.getChildren().add(investigator);


        double xRatio = 0.03;
        double yRatio = 0.2;

        for (int i = 0; i < catchTheKiller.suspects.size(); i++) {
            if (i == 3) {
                xRatio = 0.2;
                yRatio = 0.6;
            }

            Label suspect = new Label();
            suspect.setText(i + 1 + ". " + catchTheKiller.suspects.get(i).getName() + ",\n" + catchTheKiller.suspects.get(i).getAge() +
                    ",\n" + catchTheKiller.suspects.get(i).getOccupation() + ",\n" + catchTheKiller.suspects.get(i).getAlibi());
            suspect.setStyle("-fx-text-fill: DARKORANGE;");
            suspect.setFont(Font.font("Impact", FontWeight.MEDIUM, 13));

            suspect.layoutXProperty().bind(pane.widthProperty().multiply(xRatio));
            suspect.layoutYProperty().bind(pane.heightProperty().multiply(yRatio));

            xRatio += 0.35;
            pane.getChildren().add(suspect);
        }

        num.setStyle("-fx-text-fill: WHITE;");
        num.setFont(Font.font("Impact", FontWeight.MEDIUM, 16));
        double xRatioN = 0.02;
        double yRatioN = 0.003;
        num.layoutXProperty().bind(pane.widthProperty().multiply(xRatioN));
        num.layoutYProperty().bind(pane.heightProperty().multiply(yRatioN));
        pane.getChildren().add(num);


        Button buttonI = new Button("interrogation");
        buttonI.setFont(Font.font("Impact", FontWeight.MEDIUM, 13));
        buttonI.setTextFill(Color.DARKRED);
        buttonI.setPrefSize(90, 20);
        buttonI.layoutXProperty().bind(pane.widthProperty().multiply(0.035));
        buttonI.layoutYProperty().bind(pane.heightProperty().multiply(0.94));
        pane.getChildren().add(buttonI);
        buttonI.setOnMouseClicked(event -> {
            buttonIclicked = true;
        });

        Button buttonA = new Button("alibi");
        buttonA.setFont(Font.font("Impact", FontWeight.MEDIUM, 13));
        buttonA.setTextFill(Color.DARKRED);
        buttonA.setPrefSize(60, 20);
        buttonA.layoutXProperty().bind(pane.widthProperty().multiply(0.18));
        buttonA.layoutYProperty().bind(pane.heightProperty().multiply(0.94));
        pane.getChildren().add(buttonA);
        buttonA.setOnMouseClicked(event -> buttonAclicked = true);

        Button buttonM = new Button("motive");
        buttonM.setFont(Font.font("Impact", FontWeight.MEDIUM, 13));
        buttonM.setTextFill(Color.DARKRED);
        buttonM.setPrefSize(60, 20);
        buttonM.layoutXProperty().bind(pane.widthProperty().multiply(0.32));
        buttonM.layoutYProperty().bind(pane.heightProperty().multiply(0.94));
        pane.getChildren().add(buttonM);
        buttonM.setOnMouseClicked(event -> {
            buttonMclicked = true;
        });

        Button buttonE = new Button("evidence");
        buttonE.setFont(Font.font("Impact", FontWeight.MEDIUM, 13));
        buttonE.setTextFill(Color.DARKRED);
        buttonE.setPrefSize(80, 20);
        buttonE.layoutXProperty().bind(pane.widthProperty().multiply(0.5));
        buttonE.layoutYProperty().bind(pane.heightProperty().multiply(0.94));
        pane.getChildren().add(buttonE);
        buttonE.setOnMouseClicked(event -> {
            buttonEclicked = true;
        });

        Button buttonC = new Button("consult");
        buttonC.setFont(Font.font("Impact", FontWeight.MEDIUM, 13));
        buttonC.setTextFill(Color.DARKRED);
        buttonC.setPrefSize(80, 20);
        buttonC.layoutXProperty().bind(pane.widthProperty().multiply(0.65));
        buttonC.layoutYProperty().bind(pane.heightProperty().multiply(0.94));
        pane.getChildren().add(buttonC);
        buttonC.setOnMouseClicked(event -> {
            buttonCclicked = true;
        });

        Button buttonK = new Button("the killer is");
        buttonK.setFont(Font.font("Impact", FontWeight.MEDIUM, 13));
        buttonK.setTextFill(Color.DARKRED);
        buttonK.setPrefSize(120, 20);
        buttonK.layoutXProperty().bind(pane.widthProperty().multiply(0.8));
        buttonK.layoutYProperty().bind(pane.heightProperty().multiply(0.94));
        pane.getChildren().add(buttonK);
        buttonK.setOnMouseClicked(event -> {
            buttonKclicked = true;
        });

        scene1.setOnKeyPressed(event -> {
            try {
                if (event.getCode() == KeyCode.DIGIT1) {
                    pressed1 = true;
                } else if (event.getCode() == KeyCode.DIGIT2) {
                    pressed2 = true;
                } else if (event.getCode() == KeyCode.DIGIT3) {
                    pressed3 = true;
                } else if (event.getCode() == KeyCode.DIGIT4) {
                    pressed4 = true;
                } else if (event.getCode() == KeyCode.DIGIT5) {
                    pressed5 = true;
                } else {
                    throw new WrongKeyException("Invalid key pressed!");
                }
                checkButtonCombination(pane);
            } catch (WrongKeyException e) {
                createPageException(e.getMessage());
            }
        });

        return pane;
    }

    public Pane createPage6() throws IOException {
        Pane pane = new Pane();
        pane.requestFocus();
        setImage(pane, "file:policeback3.jpg");
        Label answer = new Label();
        answer.setText("Do you know who the killer is?...");
        answer.setStyle("-fx-text-fill: WHITE;");
        answer.setFont(Font.font("Impact", FontWeight.MEDIUM, 22));
        double xRatio1 = 0.35;
        double yRatio1 = 0.06;
        answer.layoutXProperty().bind(pane.widthProperty().multiply(xRatio1));
        answer.layoutYProperty().bind(pane.heightProperty().multiply(yRatio1));
        pane.getChildren().add(answer);


        Label ourkiller = new Label();
        ourkiller.setStyle("-fx-text-fill: WHITE;");
        ourkiller.setFont(Font.font("Impact", FontWeight.MEDIUM, 18));
        ourkiller.layoutXProperty().bind(pane.widthProperty().multiply(0.15));
        ourkiller.layoutYProperty().bind(pane.heightProperty().multiply(0.3));

        int index = getIndex();
        String k = catchTheKiller.investigator.checkTheKiller(catchTheKiller.suspects.get(index).getName(), catchTheKiller.killer);
        ourkiller.setText(k);

        pane.getChildren().add(ourkiller);

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("crime.dat"))) {
            dos.writeInt(catchTheKiller.suspects.size());
            dos.writeUTF(catchTheKiller.whoWasKilled().toString());
            dos.writeUTF(catchTheKiller.whoIsOurInvestigator().toString());
            for (Suspect s : catchTheKiller.suspects) {
                dos.writeUTF(s.toString());
            }
        }

        return pane;
    }

    public Pane createPageException(String message) {
        Stage exceptionStage = new Stage();
        Pane pane = new Pane();
        Scene scene2 = new Scene(pane, 200, 200);
        pane.setBackground(Background.fill(Color.DARKBLUE));
        Label e = new Label();
        e.setText(message);
        e.setStyle("-fx-text-fill: WHITE;");
        e.setFont(Font.font("Impact", FontWeight.MEDIUM, 14));
        e.layoutXProperty().bind(pane.widthProperty().multiply(0.2));
        e.layoutYProperty().bind(pane.heightProperty().multiply(0.5));
        pane.getChildren().add(e);

        exceptionStage.setScene(scene2);
        exceptionStage.setTitle("Catch the killer - exception");
        exceptionStage.show();
        return pane;
    }

    private void checkButtonCombination(Pane pane) {
        int selectedSuspectIndex = getIndex();
        Label selectedSuspectLabel = findSuspectLabel(pane, selectedSuspectIndex);

        if (numberOfActions == 9) {
            showPage(page6);

        }

        if (lastSuspect!=selectedSuspectIndex) {
            if (numberOfActions <= 8) {
                if (buttonIclicked) {
                    if (selectedSuspectLabel != null) {
                        selectedSuspectLabel.setText(selectedSuspectLabel.getText() + "\n" + catchTheKiller.investigator.conductTheInterrogation(catchTheKiller.suspects.get(selectedSuspectIndex)));
                    }
                    buttonIclicked = false;
                }
                if (buttonAclicked) {
                    if (selectedSuspectLabel != null) {
                        selectedSuspectLabel.setText(selectedSuspectLabel.getText() + "\n" + catchTheKiller.investigator.checkTheAlibi(catchTheKiller.suspects.get(selectedSuspectIndex)));
                        buttonAclicked = false;
                    }
                }
                if (buttonMclicked) {
                    if (selectedSuspectLabel != null) {
                        String motive = catchTheKiller.investigator.isThereAMurderMotive(catchTheKiller.suspects.get(selectedSuspectIndex));
                        List<String> motives = new ArrayList<>();
                        int groupSize = 4;
                        String[] words = motive.split(" ");
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < words.length; i++) {
                            sb.append(words[i]).append(" ");
                            if ((i + 1) % groupSize == 0 || i == words.length - 1) {
                                motives.add(sb.toString().trim());
                                sb.setLength(0);
                            }
                        }
                        selectedSuspectLabel.setText(selectedSuspectLabel.getText() + "\n" + String.join("\n", motives));
                        buttonMclicked = false;
                    }
                }
                if (buttonEclicked) {
                    if (selectedSuspectLabel != null) {
                        String evidence = catchTheKiller.investigator.isThereAnyEvidence(catchTheKiller.suspects.get(selectedSuspectIndex));
                        List<String> ev = new ArrayList<>();
                        int groupSize = 4;
                        String[] words = evidence.split(" ");
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < words.length; i++) {
                            sb.append(words[i]).append(" ");
                            if ((i + 1) % groupSize == 0 || i == words.length - 1) {
                                ev.add(sb.toString().trim());
                                sb.setLength(0);
                            }
                        }
                        selectedSuspectLabel.setText(selectedSuspectLabel.getText() + "\n" + String.join("\n", ev));
                        buttonEclicked = false;
                    }
                }
                if (buttonCclicked) {
                    if (selectedSuspectLabel != null) {
                        selectedSuspectLabel.setText(selectedSuspectLabel.getText() + "\n" + catchTheKiller.investigator.isTheEvidenceEnough(catchTheKiller.suspects.get(selectedSuspectIndex)));
                        buttonCclicked = false;
                    }
                }
                if (buttonKclicked) {
                    showPage(page6);
                }
                numberOfActions++;
                num.setText("number of actions\n" + numberOfActions);

            }

            lastSuspect = selectedSuspectIndex;
        }

    }

    private int getIndex() {
        int selectedSuspectIndex = 0;
        if (pressed1) {
            pressed1 = false;
        } else if (pressed2) {
            selectedSuspectIndex = 1;
            pressed2 = false;
        } else if (pressed3) {
            selectedSuspectIndex = 2;
            pressed3 = false;
        } else if (pressed4) {
            selectedSuspectIndex = 3;
            pressed4 = false;
        } else if (pressed5) {
            selectedSuspectIndex = 4;
            pressed5 = false;
        }
        return selectedSuspectIndex;
    }

    private Label findSuspectLabel(Pane pane, int suspectIndex) {
        for (Node node : pane.getChildren()) {
            if (node instanceof Label) {
                String labelText = ((Label) node).getText();
                if (labelText.startsWith(suspectIndex + 1 + ". ")) {
                    return (Label) node;
                }
            }
        }
        return null;
    }



    private void setImage(Pane pane, String image) {
        Image backgroundI = new Image(image);
        BackgroundImage backgroundImg = new BackgroundImage(
                backgroundI,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize);
        Background background = new Background(backgroundImg);
        pane.setBackground(background);
    }

    private void showPage(Pane page) {
        root.getChildren().clear();
        root.getChildren().add(page);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Button) {
            Button clickedButton = (Button) mouseEvent.getSource();

            if (clickedButton.getText().equals("Start")) {
                showPage(page2);
            } else if (clickedButton.getText().equals("Rules")) {
                showPage(page3);
            } else if (clickedButton.getText().equals("Next")) {
                showPage(page4);
            } else if (clickedButton.getText().equals("See suspects")) {
                showPage(page5);
            } else if (clickedButton.getText().equals("interrogation")) {
                buttonIclicked = true;
                checkButtonCombination(page5);
            } else if (clickedButton.getText().equals("alibi")) {
                buttonAclicked = true;
                checkButtonCombination(page5);
            } else if (clickedButton.getText().equals("motive")) {
                buttonMclicked = true;
                checkButtonCombination(page5);
            } else if (clickedButton.getText().equals("evidence")) {
                buttonEclicked = true;
                checkButtonCombination(page5);
            } else if (clickedButton.getText().equals("consult")) {
                buttonCclicked = true;
                checkButtonCombination(page5);
            } else if (clickedButton.getText().equals("the killer is")) {
                buttonKclicked = true;
                showPage(page6);
            }

        }
    }
}
