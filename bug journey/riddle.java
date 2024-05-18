import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.collections.ObservableList; 



public class riddle{
	
	public static String[] riddles = {"A bearer of life, in a delicate balance,\nI dance between blooms, in a silent alliance.\nWhat am I?",
	"Armless, legless, I crawl around when I’m young.\nThen the time of changing sleep will come.\nI will awake like a newborn, flying beast,\n'till then on the remains of the dead I feast.\nWhat am I?",
	"I’m sometimes a soldier that’s part of an army.\nI’m also an insect that’s in a colony\nWhat am I?", 
	"I wiggle and cannot see,\nsometimes underground and sometimes on a tree.\nI really don't want to be on a hook,\nand I become a person when combined with book.\nWhat am I?"};
	
	public static String[] answers = {"bee", "caterpillar", "ant", "worm"};
	
	public static String userAnswer = "";
	
	
	public static BorderPane riddleBorderPane = new BorderPane();
	
	public static HBox bugs = new HBox(10);
	
	public static Text largeWords = new Text("Riddle");
	
	public static void start(Stage primaryStage){
		
		journey.riddleIndex++;
		
		riddleBorderPane.setStyle("-fx-background-color: #91FFFF;");
		
		bugs.setStyle("-fx-background-color: #8D6236;");
		//more convenient to just make a new hbox
		
		//retrieving the observable list of the bugs HBox 
		ObservableList list = bugs.getChildren();  
		
		//adding the buttons to the hbox
		list.addAll(journey.wormPhoto, journey.caterpillarPhoto, journey.antPhoto, journey.beePhoto);     
		
		bugs.setPadding(new Insets(10, 20, 10, 20));//top, right, bottom, left
		bugs.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);
		
		riddleBorderPane.setBottom(bugs);
		
		journey.wormPhoto.setOnAction(new answerWorm());
		journey.caterpillarPhoto.setOnAction(new answerCaterpillar());
		journey.antPhoto.setOnAction(new answerAnt());
		journey.beePhoto.setOnAction(new answerBee());
		
		Text smallerWords = new Text(riddles[journey.riddleIndex]);
		
		VBox riddleAndTitle = new VBox(10, largeWords, smallerWords);
		
		largeWords.setFont(Font.font ("Comic Sans MS", FontWeight.BOLD, 30));
		Color largeColor = Color.rgb(255, 195, 145);
		largeWords.setFill(largeColor);
		smallerWords.setFont(Font.font ("Comic Sans MS", 17.5));
		Color smallColor = Color.rgb(87, 153, 153);
		smallerWords.setFill(smallColor);
		smallerWords.setTextAlignment(TextAlignment.CENTER); 
		
		riddleBorderPane.setCenter(riddleAndTitle);
		riddleAndTitle.setAlignment(javafx.geometry.Pos.CENTER);
		
		
		Scene scene = new Scene(riddleBorderPane, 540, ((30+10+100)*3));
		
		// Add the Scene to the Stage.
		primaryStage.setScene(scene);
		
		// Set the stage title.
		primaryStage.setTitle("bug journey");
		
		// Show the window.
		primaryStage.show();
	}

	static class answerBee implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			userAnswer = "bee";
			rightOrWrong(largeWords, riddleBorderPane, bugs);
		}
	}
	
	static class answerAnt implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			userAnswer = "ant";
			rightOrWrong(largeWords, riddleBorderPane, bugs);
		}
	}
	
	static class answerCaterpillar implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			userAnswer = "caterpillar";
			rightOrWrong(largeWords, riddleBorderPane, bugs);
		}
	}
	
	static class answerWorm implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			userAnswer = "worm";
			rightOrWrong(largeWords, riddleBorderPane, bugs);
		}
	}
	
	public static void rightOrWrong(Text largeWords, BorderPane pane, HBox bugs){
		disableTheButtons();
		if(userAnswer.equalsIgnoreCase(answers[journey.riddleIndex])){
			//they got it right
			journey.win();
			largeWords.setText("Correct!");
		}else{
			//they got it wrong
			largeWords.setText("The answer was " + answers[journey.riddleIndex] + " :(");
		}
		pane.getChildren().removeAll();
		Button moveOn = new Button("Continue");
		moveOn.setMinHeight(35);
		moveOn.setMinWidth(175);
		moveOn.setFont(Font.font("Comic Sans MS", 30));
		moveOn.setTextFill(Color.web("#FFFFFF"));
		moveOn.setStyle("-fx-background-color: #579999");
		
		VBox wordsAndButton = new VBox(10, largeWords, moveOn);
		
		pane.setBottom(bugs);
		pane.setCenter(wordsAndButton);
		
		wordsAndButton.setAlignment(javafx.geometry.Pos.CENTER);
	}
	
	public static void disableTheButtons(){
		journey.wormPhoto.setOnAction(null);
		journey.caterpillarPhoto.setOnAction(null);
		journey.antPhoto.setOnAction(null);
		journey.beePhoto.setOnAction(null);
	}
}