/*
+ Crow Practice Project
+ idea: bees 
(later note: i lied, bugs)
	- different types of bugs with different abilities
	- oregon trail style
	- 4 bugs
		~ bee, ant, caterpillar, and worm
	- 6 stages
		~ 4 food (budgeting due to growth)
		~ 4 obstacles (success will determine how much food is won)
		~ 4 riddles (success will determine whether food is won)
		~ 4 enemies (non-bugs)
		~ ending (party or other)
		~ (riddle, enemy, obstacle, meal)*4 + victory/loss(if it doesn't work out)
+ plan: have it be in a window and not command line
+ start date: may-14-2024-12:56am 
*/

//i actually hate bugs
//starting out with java (textbook)

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

/*layout plan: 4 bugs along bottom with vector sprites, constant*/

public class journey extends Application{
	
	public boolean beeClick = false;
	public boolean caterpillarClick = false;
	public boolean antClick = false;
	public boolean wormClick = false;
	
	public Text largeWords = new Text("Welcome! Get to know the bugs.");
	public Text smallerWords = new Text("Click each bug button to see their info." +
		"\nYou'll be able to see the info later on during battle.");
		
	public bug wormStats = new bug();
	public bug caterpillarStats = new bug();
	public bug antStats = new bug();
	public bug beeStats = new bug();
	
	
	
	
		
	public static void main(String[] args){
		launch(args);
	}
	
	public static Image worm = new Image("file:files\\worm.png");
	public static Image caterpillar = new Image("file:files\\caterpillar.png");
	public static Image ant = new Image("file:files\\ant.png");
	public static Image bee = new Image("file:files\\bee.png");
	
	public static ImageView viewWorm = new ImageView(worm);
	public static ImageView viewCaterpillar = new ImageView(caterpillar);
	public static ImageView viewAnt = new ImageView(ant);
	public static ImageView viewBee = new ImageView(bee);
	
	public static HBox bugs = new HBox(10);
	
	public static Stage primaryStage = new Stage();
	
	//use borderpane for layout
	public static BorderPane borderPane = new BorderPane();
	
	
	public static Button wormPhoto = new Button();
	public static Button caterpillarPhoto = new Button();
	public static Button antPhoto = new Button();
	public static Button beePhoto = new Button();
	
	public static int riddleIndex = -1;
	public static int enemyIndex = -1;
	
	public static int seeds = 15;
	public static boolean lost = false;
	
	@Override
	public void start(Stage primaryStage){
		
		//each picture is 100, 10 between each 20 on each side
		//bottom section will have the photos with 100 height on each photo and 30 on top and 10 on bottom
		
		//original pngs will be 405x405
		
		viewWorm.setFitWidth(100);
		viewWorm.setPreserveRatio(true);
		wormPhoto.setGraphic(viewWorm);
		wormPhoto.setStyle("-fx-background-color: #ff000000");
		//registering worm button to method
		wormPhoto.setOnAction(new showWormInfo());
		
		viewCaterpillar.setFitWidth(100);
		viewCaterpillar.setPreserveRatio(true);
		caterpillarPhoto.setGraphic(viewCaterpillar);
		caterpillarPhoto.setStyle("-fx-background-color: #ff000000");
		caterpillarPhoto.setOnAction(new showCaterpillarInfo());
		
		viewAnt.setFitWidth(100);
		viewAnt.setPreserveRatio(true);
		antPhoto.setGraphic(viewAnt);
		antPhoto.setStyle("-fx-background-color: #ff000000");
		antPhoto.setOnAction(new showAntInfo());
		
		viewBee.setFitWidth(100);
		viewBee.setPreserveRatio(true);
		beePhoto.setGraphic(viewBee);
		beePhoto.setStyle("-fx-background-color: #ff000000");
		beePhoto.setOnAction(new showBeeInfo());
		
		/*
		left off plan (5:09am):
			x - make other vectors
			x - align hbox bottom center with padding
			x - start on bug credentials
				idea: have doc with abilities that reads
		*/
		
		borderPane.setStyle("-fx-background-color: #91FFFF");
		bugs.setStyle("-fx-background-color: #8D6236;");
		

		//retrieving the observable list of the bugs HBox 
		ObservableList list = bugs.getChildren();  
		
		//adding the buttons to the hbox
		list.addAll(wormPhoto, caterpillarPhoto, antPhoto, beePhoto);     
		
		bugs.setPadding(new Insets(10, 20, 10, 20));//top, right, bottom, left
		
		//everything will be in comic sans
		largeWords.setFont(Font.font ("Comic Sans MS", FontWeight.BOLD, 30));
		Color largeColor = Color.rgb(255, 195, 145);
		largeWords.setFill(largeColor);
		smallerWords.setFont(Font.font ("Comic Sans MS", 17.5));
		Color smallColor = Color.rgb(87, 153, 153);
		smallerWords.setFill(smallColor);
		smallerWords.setTextAlignment(TextAlignment.CENTER); 
		
		VBox words = new VBox(10, largeWords, smallerWords);
		
		borderPane.setCenter(words);
		borderPane.setBottom(bugs);
		
		Scene scene1 = new Scene(borderPane, 540, ((30+10+100)*3));
		
		bugs.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);
		words.setAlignment(javafx.geometry.Pos.CENTER);
      
		// Add the Scene to the Stage.
		primaryStage.setScene(scene1);
		
		// Set the stage title.
		primaryStage.setTitle("bug journey");
		
		// Show the window.
		primaryStage.show();
		
	}
	
	class showWormInfo implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			smallerWords.setText(displayInfo("files\\worm.txt", "worm"));
			wormStats.setInfo("files\\worm.txt");
			//System.out.println(wormStats.toString());
			wormClick = true;
			CheckAndChange(smallerWords,bugs,primaryStage,borderPane);
		}
	}
	
	class showBeeInfo implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			smallerWords.setText(displayInfo("files\\bee.txt", "bee"));
			beeStats.setInfo("files\\bee.txt");
			//System.out.println(beeStats.toString());
			beeClick = true;
			CheckAndChange(smallerWords,bugs,primaryStage,borderPane);
		}
	}
	
	class showCaterpillarInfo implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			smallerWords.setText(displayInfo("files\\caterpillar.txt", "caterpillar"));
			caterpillarStats.setInfo("files\\caterpillar.txt");
			//System.out.println(caterpillarStats.toString());
			caterpillarClick = true;
			CheckAndChange(smallerWords,bugs,primaryStage,borderPane);
		}
	}
	
	class showAntInfo implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			smallerWords.setText(displayInfo("files\\ant.txt", "ant"));
			antStats.setInfo("files\\ant.txt");
			//System.out.println(antStats.toString());
			antClick = true;
			CheckAndChange(smallerWords,bugs,primaryStage,borderPane);
		}
	}
	
	class moveOn implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			riddle.start(primaryStage);
			//close the window of the aspect being left behind
			Stage stage = (Stage) smallerWords.getScene().getWindow();
			stage.close();
		}
	}
	
	/*
		left off plan (3:39am):
			- format abilities and read text from docs to set text
			- make button press methods to set small text to info
			- make enemy vectors
			- think through other stage formats
	*/
	
	public String displayInfo(String fileName, String name){
		String[] lines = new String[7];
		try{
			File bugfile = new File(fileName);
			Scanner inputFile = new Scanner(bugfile);
			int i = 0;
			while(inputFile.hasNext()){
				lines[i] = inputFile.nextLine();
				i++;
			}
		}catch (FileNotFoundException e){
			System.out.println("it isn't working.");
		}
		
		return("The " + name + " has " + lines[1] + " health points!\n" + 
			"It has the abilities " + lines[3] + " and " + lines[4] + "\n" + 
			"It needs " + lines[6] + " seeds per meal.");
	}
	
	public void CheckAndChange(Text words, HBox bugs, Stage theStage, BorderPane pane){
		/*
		plan for this method:
			- remove vbox
			- but button in same place
		*/
		if((wormClick == true)&&(caterpillarClick == true)&&(antClick == true)&&(beeClick == true)){
			pane.getChildren().removeAll();
			Button startGame = new Button("Start Journey!");
			startGame.setMinHeight(35);
			startGame.setMinWidth(200);
			startGame.setFont(Font.font("Comic Sans MS", 30));
			startGame.setTextFill(Color.web("#ffffff"));
			startGame.setStyle("-fx-background-color: #FFC391");
			startGame.setOnAction(new moveOn());
			VBox wordsAndButton = new VBox(10, startGame, words);
			pane.setBottom(bugs);
			pane.setCenter(wordsAndButton);
			wordsAndButton.setAlignment(javafx.geometry.Pos.CENTER);
			
			//note to self (may16) use css for next project
		}
	}
	
	public static void win(){
		seeds += 9;
	}
	
	//bug is a class
	public static void feed(bug theBug){
		seeds -= theBug.hunger;
		theBug.HP += (theBug.HP/theBug.hunger);
	}
	
	public static void hit(bug theBug){
		theBug.HP -= (theBug.HP)*0.2;
	}
	
}

//it feels cruel to make more scenes from scratch in this file, so the riddles and enemies will be their own classes