import java.util.concurrent.ThreadLocalRandom; //for random num via "int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);"

public class minefield { //generate 8x8 minefield with 10 mines.
  //TO DO: MAKE MINEFIELD CUSTOMIZABLE.

  boolean[][] boolField = new boolean[8][8];
  int[][] playField = new int[8][8];
  boolean[][] digField = new boolean[8][8]; //check if diggable
  

  public minefield(){
    /* //Testing Block
    boolFieldGen();
    setMines();
    playFieldGen();
    digFieldGen();

     //Print boolean grid
    for(int i = 0; i < 8; i++){ //iterate through rows
      for(int x = 0; x < 8; x++){ //iterate through "columns"
        System.out.print(boolField[x][i]);
        System.out.print(' ');
      }
      System.out.print("\n");
    }


     //Print number grid
    for(int i = 0; i < 8; i++){ //iterate through rows
      for(int x = 0; x < 8; x++){ //iterate through "columns"
        System.out.print(playField[x][i]);
        System.out.print(' ');
      }
      System.out.print("\n");
    }
    */

  }


  public void boolFieldGen(){ //makes blank field
    for(int i = 0; i < 8; i++){ //iterate through rows
      for(int x = 0; x < 8; x++){ //iterate through "columns"
        boolField[x][i] = false;
      }
    }
  }
  public void setMines(){ //sets 10 mines
    for(int i = 0; i < 10; i++){ //10 mines
        boolField[ThreadLocalRandom.current().nextInt(0, 8)][ThreadLocalRandom.current().nextInt(0, 8)] = true;
      }
    }
  public void playFieldGen(){
    for(int i = 0; i < 8; i++){ //iterate through rows
      for(int x = 0; x < 8; x++){ //iterate through "columns"
        if(boolField[x][i] == true){
          playField[x][i] = 9;
        } else {
          playField[x][i] = setNumber(x,i);
        }
      }
    }
  }
  public int setNumber(int x, int i){ //detects the amount of surrounding mines
    /*

    X  X  X
    X  O  X
    X  X  X


    (-1,+1) (0, +1) (+1, +1)
    (-1,0) (0, 0) (+1, 0)
    (-1,-1) (0, -1) (+1, -1)

    */
    int number = 0;
    for(int j = -1; j <= 1; j++){
      for(int k = -1; k <= 1; k++){
        try { //edges do not have all sides to detect
          if (boolField[x+j][i+k] == true)
            number ++;
          } catch (IndexOutOfBoundsException e) {
          }
        }
      }
    return number;
  }

  public void digFieldGen(){ //makes blank field
    for(int i = 0; i < 8; i++){ //iterate through rows
      for(int x = 0; x < 8; x++){ //iterate through "columns"
        digField[x][i] = true;
      }
    }
  }

  public int getPlayField(int x, int y){
    return this.playField[x][y];
  }
  public boolean getDigField(int x, int y){
    return this.digField[x][y];
  }

  public void setPlayField(int x, int y, int g){
    this.playField[x][y] = g;
  }
  public void setDigField(int x, int y, boolean b){
    this.digField[x][y] = b;
  }




}
