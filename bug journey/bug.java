//bug superclass

import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class bug{
	private int HP = 0;
	private String[] abilities = {"", ""};
	private int hunger = 0;
	
	public bug(){
		this.HP = 0;
		this.abilities[0] = "";
		this.abilities[1] = "";
		this.hunger = 0;
		
	}

	public void setInfo(String fileName){
		String[] lines = {};
		try{
			File bugfile = new File(fileName);
			Scanner inputFile = new Scanner(bugfile);
			int i = 0;
			while(inputFile.hasNext()){
				lines[i] = inputFile.nextLine();
				i++;
			}
			
			this.HP = Integer.parseInt(lines[1]);
			this.abilities[0] = lines[3];
			this.abilities[1] = lines[4];
			this.hunger = Integer.parseInt(lines[6]);
			
		}catch (FileNotFoundException e){
			System.out.println("it isn't working.");
		}
	}

}