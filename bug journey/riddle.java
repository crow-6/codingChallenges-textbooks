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

public class riddle{
	
	
	public static void start(Stage primaryStage){
		
		BorderPane riddleBorderPane = new BorderPane();
		riddleBorderPane.setStyle("-fx-background-color: #91FFFF;");
		
		HBox bugs = new HBox(10);
		bugs.setStyle("-fx-background-color: #8D6236;");
		//more convenient to just make a new hbox
		
		//retrieving the observable list of the bugs HBox 
		ObservableList list = bugs.getChildren();  
		
		//adding the buttons to the hbox
		list.addAll(journey.wormPhoto, journey.caterpillarPhoto, journey.antPhoto, journey.beePhoto);     
		
		bugs.setPadding(new Insets(10, 20, 10, 20));//top, right, bottom, left
		bugs.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);
		
		riddleBorderPane.setBottom(bugs);
		
		journey.wormPhoto.setOnAction(null);
		journey.caterpillarPhoto.setOnAction(null);
		journey.antPhoto.setOnAction(null);
		journey.beePhoto.setOnAction(null);
		
		VBox riddleAndOptions = new VBox();
		
		Scene scene = new Scene(riddleBorderPane, 540, ((30+10+100)*3));
		
		// Add the Scene to the Stage.
		primaryStage.setScene(scene);
		
		// Set the stage title.
		primaryStage.setTitle("bug journey");
		
		// Show the window.
		primaryStage.show();
	}

}