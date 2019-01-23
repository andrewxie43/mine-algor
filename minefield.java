public class minefield { //generate minefield

  boolean[][] field = { //field[x][y], y is vertical array, x is index in nested array?
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
  };

  public minefield(){
    fieldGen();
    for(int i = 0; i < 8; i++){ //iterate through rows
      for(int x = 0; x < 8; x++){ //iterate through "columns"
        System.out.print(field[i][x]);
      }
      System.out.print("\n");
    }
  }


  public void fieldGen(){
    for(int i = 0; i < 8; i++){ //iterate through rows
      for(int x = 0; x < 8; x++){ //iterate through "columns"
        field[x][i] = false;
      }
    }

  }



}
