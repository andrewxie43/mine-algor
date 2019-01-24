import java.util.Scanner;
//NOT IDIOT PROOFED

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


 //Display the playing Field
  mf.refreshDisplay();

//Give option to dig or flag

while (gameInProgress == true) { //check if in game
  Scanner reader = new Scanner(System.in);  // Reading from System
  String user_action = reader.nextLine(); //need to close scanner?
  reader.close();

  new minesweeper().parseUserAction(user_action, " ");

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

  System.out.println(mf.getDigField(x,y));

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





public void parseUserAction(String ua, String div){ //parse user action to dig/flag
  int first = ua.indexOf(div);
  int second = ua.lastIndexOf(div); //change based on input format

  String action = ua.substring(0,first);
  String x_coord = ua.substring(first + 1, second);
  String y_coord = ua.substring(second + 1, ua.length());

  if (action.equals("F")){ //remember to parse to uppercase when IPing!
    try{
      System.out.println(mf.getDigField(x,y));
      flag(Integer.parseInt(x_coord),Integer.parseInt(y_coord));
    } catch (IndexOutOfBoundsException e) {
    System.out.println("Invalid coords");
  }
} if (action.equals("D")) {
  try{
    System.out.println(mf.getDigField(x,y));
    dig(Integer.parseInt(x_coord),Integer.parseInt(y_coord));
  } catch (IndexOutOfBoundsException e) {
  System.out.println("Invalid coords");
}
} else {
  System.out.println("Invalid action");
}

}

}
