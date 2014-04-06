package jtema7;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;

public class JTema7 extends Application {

    @Override
    public void start(Stage primaryStage) {
	Button frogButton = new Button();
	Label frogNumberLabel = new Label("Numarul de broscute:");
	HBox textBox = new HBox();
	Scene scene;
	StackPane root = new StackPane();
	final TextField frogNumber = new TextField() {
	    @Override
	    public void replaceText(int start, int end, String text) {
		if (text.matches("[0-9]")) {
		    super.replaceText(start, end, text);
		}
	    }
	};

	textBox.getChildren().addAll(frogNumberLabel, frogNumber, frogButton);
	textBox.setSpacing(10);
	frogButton.setText("RACE!");
	frogButton.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		int value;
		try {
		    value = Integer.parseInt(frogNumber.getText());
		    if (value > 20) {
			value = 20;
		    } else if (value < 2) {
			value = 2;
		    }
		} catch (NumberFormatException e) {
		    value = 3;
		}
		FrogRaceFrame broaste = new FrogRaceFrame("Broaste", value);
		broaste.setVisible(true);

		// FrogRaceWindow newwindow = new FrogRaceWindow(value);
		// newwindow.frogs();
	    }
	});

	root.getChildren().add(textBox);
	scene = new Scene(root, 350, 70);
	primaryStage.setTitle("Concurs broscute!");
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    public static void main(String[] args) {
	launch(args);
    }
}
