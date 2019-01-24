public class minesweeper
{
minefield mf;

public minesweeper(){
  minefield mf = new minefield();

  //Setup the field
  mf.boolFieldGen();
  mf.setMines();
  mf.playFieldGen();
  mf.digFieldGen();

}


public void dig(int x, int y){

  boolean diggable = mf.getDigField(x,y);
  int value = mf.getPlayField(x,y);

  if (diggable == false){
    System.out.println("Grid already dug or flagged.");
  } else if (value == 9){
    System.out.println("You hit a mine! Game Over.");
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
            } catch (IndexOutOfBoundsException e) {
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



//generate minefield - DONE
//generate playing minefield - DONE



//method to flag grid - DONE
//method to dig grid - DONE
//must display number if not mine - DONE

//generate number for grid based on surrounding mines

//dig method, if no number, dig all surrounding with no number until number.

//getspace method for "key" minefield


}
