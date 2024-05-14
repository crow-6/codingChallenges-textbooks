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
import javax.swing.*;

/*layout plan: 4 bugs along bottom with vector sprites, constant*/

public class journey{
	public static void main(String[] args){
		JFrame frame = new JFrame();//create window
		
		frame.setSize(470, 420);//x axis, y axis, width, height  
		//each picture is 100, 10 between each 20 on each side
		//width adds up to 400 + 30 + 40 = 470
		//bottom section will have the photos with 100 height on each photo and 30 on top and 10 on bottom
		//adds up to 140, top section will be double. total height is 140*3= 420
		
		
		
		
		
		frame.setVisible(true);//show window
		
	}
}