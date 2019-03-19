import java.util.Scanner;
//NOT IDIOT PROOFED

/*
For testing only.
*/




public class minesweeper
{
static minefield mf = new minefield();
public static boolean gameInProgress;
public static int temp = 0; //control dig overflow

public static void main(String[] args){


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




//Give option to dig or flag

while (gameInProgress == true) { //check if in game
  mf.refreshDisplay();  //Display the playing Field
System.out.print("\n");
  for(int i = 0; i < 8; i++){ //iterate through rows
    for(int x = 0; x < 8; x++){ //iterate through "columns"
      System.out.print(mf.playField[x][i]);
      System.out.print(' ');
    }
    System.out.print("\n");
  }


  Scanner reader = new Scanner(System.in); //if scanner closed, error.
  String user_action = reader.nextLine();

  new minesweeper().parseUserAction(user_action, " ");
}



}


//Add cases for the following: All mines dug, unflag square, questionable flag



//User Actions during play
public void dig(int x, int y){

  boolean diggable = mf.getDigField(x,y);
  int value = mf.getPlayField(x,y);


  if (diggable == false){
    System.out.println("Grid already dug or flagged.");
  } else if (value == 9){ //works
    System.out.println("You hit a mine! Game Over.");
    //Display field, mine locations
    gameInProgress = false;
  } else if (value != 0){ //works
      mf.displayField[x][y] = Integer.toString(value);
    } else if (value == 0){ //stack overflows
      mf.displayField[x][y] = Integer.toString(value);
      mf.setDigField(x,y,false);

      for(int j = -1; j <= 1; j++){ //check for zero, dig zero
        for(int k = -1; k <= 1; k++){
          try { //edges do not have all sides to detect
            if (mf.playField[x][y] == 0 && mf.digField[x+j][y+k] == true){
             dig(x+j,y+k);
            }
          }
          catch (IndexOutOfBoundsException e) {
          }
	        catch (StackOverflowError e){
          }
      }
    } //set display to be space for zero, number otherwise.


  }
}
public void flag(int x, int y){
  boolean diggable = mf.getDigField(x,y);
  if (diggable == false){
    System.out.println("Grid already dug or flagged.");
  }
    mf.displayField[x][y] = "F";
    mf.setDigField(x,y,false);

}

public void parseUserAction(String ua, String div){ //parse user action to dig/flag
  int first = ua.indexOf(div);
  int second = ua.lastIndexOf(div); //change based on input format

  String action = ua.substring(0,first);
  String x_coord = ua.substring(first + 1, second);
  String y_coord = ua.substring(second + 1, ua.length());
  if (action.equals("F")) { //remember to parse to uppercase when IPing!
    try{
      flag(Integer.parseInt(x_coord),Integer.parseInt(y_coord));
      return;
    } catch (IndexOutOfBoundsException e) {
    System.out.println("Invalid coords");
  }
} if (action.equals("D")) {
    try{
    dig(Integer.parseInt(x_coord),Integer.parseInt(y_coord));
    temp = 0;
    return;
  } catch (IndexOutOfBoundsException e) {
  System.out.println("Invalid coords");
}
} else {
  System.out.println("Invalid action");
  return;
}

}

}
