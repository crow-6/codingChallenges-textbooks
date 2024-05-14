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
		~ 2 riddles
		~ 2 enemies (non-bugs)
		~ ending (party or other)
+ plan: have it be in a window and not command line
+ start date: may-14-2024-12:56am 
*/

//i actually hate bugs

import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/*layout plan: 4 bugs along bottom with vector sprites, constant*/

public class journey extends Application{
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage){
		//each picture is 100, 10 between each 20 on each side
		//width adds up to 400 + 30 + 40 = 470
		//bottom section will have the photos with 100 height on each photo and 30 on top and 10 on bottom
		//adds up to 140, top section will be double. total height is 140*3= 420
		
		//use flow layout for bottom photos
		
		//original pngs will be 405x405
		
		Image worm = new Image("file:worm.png");
		ImageView viewWorm = new ImageView(worm);
		viewWorm.setFitWidth(100);
		viewWorm.setPreserveRatio(true);
		Button wormPhoto = new Button();
		wormPhoto.setGraphic(viewWorm);
		
		/*
		left off plan (5:09am):
			- make other vectors
			- align hbox bottom center with padding
			- start on bug credentials
		*/
		
		HBox bugs = new HBox(viewWorm);
		Scene scene = new Scene(bugs, 470, 420);
      
		// Add the Scene to the Stage.
		primaryStage.setScene(scene);
		
		// Set the stage title.
		primaryStage.setTitle("bug journey");
		
		// Show the window.
		primaryStage.show();
	}
}