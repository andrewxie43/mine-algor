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
    
    mf.setDigField(x,y,false);
  }



  }




public void flag(int x, int y){


}



//generate minefield - DONE
//generate playing minefield - DONE



//method to flag grid - DOING
//method to dig grid - DOING
//must display number if not mine

//generate number for grid based on surrounding mines

//dig method, if no number, dig all surrounding with no number until number.

//getspace method for "key" minefield


}
