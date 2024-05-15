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
		~ 3 riddles (success will determine how much food is won)
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
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
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
		//bottom section will have the photos with 100 height on each photo and 30 on top and 10 on bottom
		
		//original pngs will be 405x405
		
		Image worm = new Image("file:worm.png");
		Image caterpillar = new Image("file:caterpillar.png");
		Image ant = new Image("file:ant.png");
		Image bee = new Image("file:bee.png");
		
		ImageView viewWorm = new ImageView(worm);
		ImageView viewCaterpillar = new ImageView(caterpillar);
		ImageView viewAnt = new ImageView(ant);
		ImageView viewBee = new ImageView(bee);
		
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
		
		viewAnt.setFitWidth(100);
		viewAnt.setPreserveRatio(true);
		Button antPhoto = new Button();
		antPhoto.setGraphic(viewAnt);
		
		viewBee.setFitWidth(100);
		viewBee.setPreserveRatio(true);
		Button beePhoto = new Button();
		beePhoto.setGraphic(viewBee);
		
		/*
		left off plan (5:09am):
			x - make other vectors
			x - align hbox bottom center with padding
			- start on bug credentials
				idea: have doc with abilities that reads
		*/
		
		HBox bugs = new HBox(10, wormPhoto, caterpillarPhoto, antPhoto, beePhoto);
		bugs.setPadding(new Insets(30, 20, 10, 20));//top, right, bottom, left
		Scene scene = new Scene(bugs, 540, ((30+10+100)*3));
		bugs.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);
      
		// Add the Scene to the Stage.
		primaryStage.setScene(scene);
		
		// Set the stage title.
		primaryStage.setTitle("bug journey");
		
		// Show the window.
		primaryStage.show();
	}
	
	class showWormInfo implements EventHandler<actionevent>{
		@Override
		public void handle(ActionEvent event){
			
			
		}
	}
	
}