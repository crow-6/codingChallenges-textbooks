/*
+ Crow Practice Project
+ idea: bees 
(later note: i lied, bugs)
	- different types of bugs with different abilities
	- oregon trail style
	- 4 bugs
		~ bee, ant, caterpillar, and worm
	- 6 stages
		~ 3 food (budgeting due to growth)
		~ 3 obstacles (success will determine how much food is won)
		~ 3 riddles (success will determine whether food is won)
		~ 2 enemies (non-bugs)
		~ ending (party or other)
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
import javafx.collections.ObservableList; 

/*layout plan: 4 bugs along bottom with vector sprites, constant*/

public class journey extends Application{
	
	public boolean beeClick = false;
	public boolean caterpillarClick = false;
	public boolean antClick = false;
	public boolean wormClick = false;
	
	public Text largeWords = new Text("Welcome! Get to know the bugs.");
	public Text smallerWords = new Text("Click each bug button to see their info." +
		"\nYou'll be able to see the info later on");
		
	public bug wormStats = new bug();
	public bug caterpillarStats = new bug();
	public bug antStats = new bug();
	public bug beeStats = new bug();
		
	public static void main(String[] args){
		launch(args);
	}
	
	public Image worm = new Image("file:files\\worm.png");
	public Image caterpillar = new Image("file:files\\caterpillar.png");
	public Image ant = new Image("file:files\\ant.png");
	public Image bee = new Image("file:files\\bee.png");
	
	public ImageView viewWorm = new ImageView(worm);
	public ImageView viewCaterpillar = new ImageView(caterpillar);
	public ImageView viewAnt = new ImageView(ant);
	public ImageView viewBee = new ImageView(bee);
	
	public HBox bugs = new HBox(10);
	
	public Stage primaryStage = new Stage();
	
	@Override
	public void start(Stage primaryStage){
		
		//each picture is 100, 10 between each 20 on each side
		//bottom section will have the photos with 100 height on each photo and 30 on top and 10 on bottom
		
		//original pngs will be 405x405
		
		viewWorm.setFitWidth(100);
		viewWorm.setPreserveRatio(true);
		Button wormPhoto = new Button();
		wormPhoto.setGraphic(viewWorm);
		
		//registering worm button to method
		wormPhoto.setOnAction(new showWormInfo());
		
		viewCaterpillar.setFitWidth(100);
		viewCaterpillar.setPreserveRatio(true);
		Button caterpillarPhoto = new Button();
		caterpillarPhoto.setGraphic(viewCaterpillar);
		
		caterpillarPhoto.setOnAction(new showCaterpillarInfo());
		
		viewAnt.setFitWidth(100);
		viewAnt.setPreserveRatio(true);
		Button antPhoto = new Button();
		antPhoto.setGraphic(viewAnt);
		
		antPhoto.setOnAction(new showAntInfo());
		
		viewBee.setFitWidth(100);
		viewBee.setPreserveRatio(true);
		Button beePhoto = new Button();
		beePhoto.setGraphic(viewBee);
		
		beePhoto.setOnAction(new showBeeInfo());
		
		/*
		left off plan (5:09am):
			x - make other vectors
			x - align hbox bottom center with padding
			x - start on bug credentials
				idea: have doc with abilities that reads
		*/
		
		//use borderpane for layout
		BorderPane borderPane = new BorderPane();

		//retrieving the observable list of the bugs HBox 
		ObservableList list = bugs.getChildren();  
		
		//adding the buttons to the hbox
		list.addAll(wormPhoto, caterpillarPhoto, antPhoto, beePhoto);     
		
		bugs.setPadding(new Insets(30, 20, 10, 20));//top, right, bottom, left
		
		largeWords.setFont(Font.font ("Comic Sans MS", 35));
		
		smallerWords.setFont(Font.font ("Comic Sans MS", 17.5));
		
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
			CheckAndChange(bugs,primaryStage);
		}
	}
	
	class showBeeInfo implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			smallerWords.setText(displayInfo("files\\bee.txt", "bee"));
			beeStats.setInfo("files\\bee.txt");
			//System.out.println(beeStats.toString());
			beeClick = true;
			CheckAndChange(bugs,primaryStage);
		}
	}
	
	class showCaterpillarInfo implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			smallerWords.setText(displayInfo("files\\caterpillar.txt", "caterpillar"));
			caterpillarStats.setInfo("files\\caterpillar.txt");
			//System.out.println(caterpillarStats.toString());
			caterpillarClick = true;
			CheckAndChange(bugs,primaryStage);
		}
	}
	
	class showAntInfo implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			smallerWords.setText(displayInfo("files\\ant.txt", "ant"));
			antStats.setInfo("files\\ant.txt");
			//System.out.println(antStats.toString());
			antClick = true;
			CheckAndChange(bugs,primaryStage);
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
	
	public void CheckAndChange(HBox bugs, Stage theStage){
		/*
		plan for this method:
			- remove vbox
			- but button in same place
		*/
		if((wormClick == true)&&(caterpillarClick == true)&&(antClick == true)&&(beeClick == true)){
			BorderPane borderPane2 = new BorderPane();
			borderPane2.setBottom(bugs);
			Button startGame = new Button("Start Journey!");
			VBox wordsAndButton = new VBox(10, startGame, smallerWords);
			//note to self (may16) use css for next project
			borderPane2.setCenter(wordsAndButton);
			Scene scene2 = new Scene(borderPane2, 540, ((30+10+100)*3));
			theStage.setScene(scene2);
		}
	}
	
}