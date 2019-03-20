import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//Test GUI

public class minesweepergui{

  //variables
  public static int clickedX;
  public static int clickedY;
  public static Boolean digBool = true;
  public static Boolean flagBool = false;
  public static JFrame f = new JFrame();

  static minefield mf = new minefield();
  public static boolean gameInProgress;


  int totalmines = mf.returnMines();



public static void main(String[] args){
  initGUI();
}

  public static void initGUI(){
      int xCoord = 0;
      int yCoord = 0;

      for(int x = 45; x < 755; x+=90){
        final int xCoordFinal = xCoord;
        for(int y = 45; y < 755; y+=90){
          final int yCoordFinal = yCoord;
          JButton fieldButton=new JButton(new AbstractAction("(" + Integer.toString(xCoord) + "," + Integer.toString(yCoord) + ")") {//creating instance of JButton
            @Override
            public void actionPerformed(ActionEvent event) { //field button clicked
              guiDig(event.getSource(),xCoordFinal,yCoordFinal);
              System.out.println("x= " + xCoordFinal); //debugging
              System.out.println("y= " + yCoordFinal + "\n");
              this.setEnabled(false); //disable button when clicked, NOT DEBUGGING

              //implement dig/flag button
            }
          });

          fieldButton.setBounds(x,y,90,90);//x axis, y axis, width, height
          f.add(fieldButton);//adding button in JFrame
          yCoord++;
        }
        yCoord = 0;
        xCoord++;
      }

      JButton actionButton = new JButton("Digging"); //dig
      actionButton.addActionListener( new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0) {

                  if (digBool == true && flagBool == false){
                    digBool = false;
                    flagBool = true;
                    actionButton.setText("Flagging");


                  } else if (digBool == false && flagBool == true){
                    digBool = true;
                    flagBool = false;
                    actionButton.setText("Digging");

                  }
                  System.out.println("Pressed:");
                  System.out.println("Dig: " + digBool);
                  System.out.println("flag: " + flagBool);
        }

      });
      actionButton.setBounds(900,45,90,45);
      f.add(actionButton);

      f.setSize(1000,1000);
      f.setLayout(null);//using no layout managers
      f.setVisible(true);//making the frame visible
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

  public static void initMF(){
    mf.boolFieldGen();
    mf.setMines();
    mf.playFieldGen();
    mf.digFieldGen();
    mf.displayFieldGen();

    gameInProgress = true;



  }

  public static void guiDig(Object buton, int xCoord, int yCoord){
      JButton button = (JButton) buton;
      boolean diggable = mf.getDigField(xCoord,yCoord);
      int value = mf.getPlayField(xCoord,yCoord);


      button.setEnabled(false);


/*
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
        */
      }



      public boolean checkWinning(){ //check if game won
          int flagged = 0;
          for(int i = 0; i < 8; i++){ //check if all mines flagged
            for(int x = 0; x < 8; x++){
              if(mf.playField[x][i] == 9){
                if((mf.displayField[x][i].equals("F"))){
                    flagged++;
                }
              }
            }
          }

          if (flagged == totalmines){
            return true;
          }

          return false;
        }


  }
