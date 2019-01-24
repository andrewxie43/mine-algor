import java.util.Scanner;


public class minesweeper
{
minefield mf;
public static boolean gameInProgress;


public static void main(String[] args){
  minefield mf = new minefield();

  //Setup the field
  mf.boolFieldGen();
  mf.setMines();
  mf.playFieldGen();
  mf.digFieldGen();
  mf.displayFieldGen();

//Begin Play

//Display Info
System.out.println("\n \n \n");
System.out.println("Welcome to Minesweeper.");
System.out.println("Input actions as follows:");
System.out.println("[Action] [x coord] [y coord]");
System.out.println("For example, to flag (4,5), type 'F 4 5'. To dig (4,5), type 'D 4 5'.");
gameInProgress = true;


 //Display the blank playing Field
  mf.refreshDisplay();

//Give option to dig or flag

if (gameInProgress == true){ //check if in game
  Scanner reader = new Scanner(System.in);  // Reading from System
  String user_action = reader.next(); //need to close scanner?
  reader.close();




} else { //game over


}






}

public minesweeper(){
  minefield mf = new minefield();

  //Setup the field
  mf.boolFieldGen();
  mf.setMines();
  mf.playFieldGen();
  mf.digFieldGen();

  }




//User Actions during play
public void dig(int x, int y){

  boolean diggable = mf.getDigField(x,y);
  int value = mf.getPlayField(x,y);

  if (diggable == false){
    System.out.println("Grid already dug or flagged.");
  } else if (value == 9){
    System.out.println("You hit a mine! Game Over.");
    gameInProgress = false;
  } else {

    if (value != 0){
      mf.displayField[x][y] = Integer.toString(value);
    } else if (value == 0){
      mf.displayField[x][y] = " ";
    } //set display to be space for zero, number otherwise.

    if (value == 0){
      for(int j = -1; j <= 1; j++){
        for(int k = -1; k <= 1; k++){
          try { //edges do not have all sides to detect
            if (mf.playField[x+j][y+k] == 0)
              dig(x+j,y+k);
            }
          catch (IndexOutOfBoundsException e) {
            }
          }
        }
      } //check for zero, dig zero

    mf.setDigField(x,y,false);
  }



}
public void flag(int x, int y){
  boolean diggable = mf.getDigField(x,y);
  if (diggable == false){
    System.out.println("Grid already dug or flagged.");
  }
    mf.displayField[x][y] = "F";

}

public void parseUserAction(String ua){ //parse user action to dig/flag
  int first = ua.indexOf(" ");
  int second = ua.indexOf(" ", first);
  int third = ua.indexOf(" ", second);

  String first 



}


}
