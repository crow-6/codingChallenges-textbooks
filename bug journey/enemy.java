//enemy class

import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class enemy{
	public static Image lizard = new Image("file:files\\lizard.png");
	//what is the enemy of a bee, caterpillar, and ant
		/*i figured it out. other than each other, it 
		includes snails(shell was hard to draw), lizards,
		dragonflies, and ladybugs*/
	public static Image ladybug = new Image("file:files\\ladybug.png");
	public static Image dragonfly = new Image("file:files\\dragonfly.png");
	public static Image slugWithArms = new Image("file:files\\slugWithArms.png");
	
	public static ImageView viewLizard = new ImageView(lizard);
	public static ImageView viewLadybug = new ImageView(ladybug);
	public static ImageView viewDragonfly = new ImageView(dragonfly);
	public static ImageView viewSlugWithArms = new ImageView(slugWithArms);
	//slug with arms will be final boss
	
	public static ImageView[] enemyPhotos = {viewLadybug, viewLizard, viewDragonfly, viewSlugWithArms};
	public static String[] enemyNames = {"ladybug", "lizard", "dragonfly", "SLUG WITH ARMS"};
	public static String[] fileNames = {"files\\ladybug.txt","files\\lizard.txt","files\\dragonfly.txt","files\\slugWithArms.txt"};
	//it'll go in the order of ladybug, lizard, dragonfly, and slug with arms
	
	//stats for current enemy
	public static double HP = 0;
	public static String powerful = "";
	public static double attack = 0;//all temporary stats
	
	public static enemy ladybugStats = new enemy();
	public static enemy lizardStats = new enemy();
	public static enemy dragonflyStats = new enemy();
	public static enemy slugWithArmsStats = new enemy();
	
	public static enemy[] enemiesList = {ladybugStats, lizardStats, dragonflyStats, slugWithArmsStats};
	
	public static BorderPane enemyPane = new BorderPane();
	/*layout idea:
		- top: name
		- left: stats (hp)
		- center: enemy
		- right: moves
		- bottom: bugs
	*/
	
	
	//no arg constructos
	public enemy(){
		this.HP = 0;
		this.powerful = "";
		this.attack = 0;
		
	}
	
	public static void setInfo(enemy current, String fileName){
		String[] lines = new String[6];
		try{
			File enemyFile = new File(fileName);
			Scanner inputFile = new Scanner(enemyFile);
			int i = 0;
			while(inputFile.hasNext()){
				lines[i] = inputFile.nextLine();
				i++;
			}
			
			current.HP = Double.parseDouble(lines[1]);
			current.attack = Double.parseDouble(lines[3]);
			current.powerful = lines[5];
			
			
		}catch (FileNotFoundException e){
			System.out.println("it isn't working(enemy).");
		}
		
	}
	
	public static void start(Stage primaryStage){
		journey.enemyIndex++;
		setInfo(enemiesList[journey.enemyIndex], fileNames[journey.enemyIndex]);
		
		
		System.out.println("small enemy spider");
		
		
	}

}