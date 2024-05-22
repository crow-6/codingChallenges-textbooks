//bug class

import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class bug{
	public double HP = 0;
	public String[] abilities = {"", ""};
	public double hunger = 0;
	
	public bug(){
		this.HP = 0;
		this.abilities[0] = "";
		this.abilities[1] = "";
		this.hunger = 0;
		
	}

	public void setInfo(String fileName){
		String[] lines = new String[7];
		try{
			File bugfile = new File(fileName);
			Scanner inputFile = new Scanner(bugfile);
			int i = 0;
			while(inputFile.hasNext()){
				lines[i] = inputFile.nextLine();
				i++;
			}
			
			this.HP = Double.parseDouble(lines[1]);
			this.abilities[0] = lines[3];
			this.abilities[1] = lines[4];
			this.hunger = Double.parseDouble(lines[6]);
			
		}catch (FileNotFoundException e){
			System.out.println("it isn't working.(bug)");
		}
	}
	
	public String toString(){
		return (this.HP +"\n"+this.abilities[0]+"\n"+this.abilities[1]+"\n"+this.hunger);
		
	}

}