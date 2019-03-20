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

  public static JButton[][] fieldButton = new JButton[10][10];


  int totalmines = mf.returnMines();


  //universal label for status report
  static JLabel label = new JLabel();


public static void main(String[] args){
  initGUI();
  initMF();
}

  public static void initGUI(){
      int xCoord = 0;
      int yCoord = 0;

      for(int x = 45; x < 755; x+=90){
        final int xCoordFinal = xCoord;
        for(int y = 45; y < 755; y+=90){
          final int yCoordFinal = yCoord;
          String name = (Integer.toString(xCoord) + "," + Integer.toString(yCoord));

          fieldButton[xCoordFinal][yCoordFinal] = new JButton(new AbstractAction("") {//creating instance of JButton
            @Override
            public void actionPerformed(ActionEvent event) { //field button clicked
              if (digBool == true){
              guiDig(event.getSource(),xCoordFinal,yCoordFinal);
            } else {
              guiFlag(event.getSource(),xCoordFinal,yCoordFinal);
            }


              this.setEnabled(false); //disable button when clicked, NOT DEBUGGING

              //implement dig/flag button
            }
          });
          fieldButton[xCoordFinal][yCoordFinal].setName(name);

          fieldButton[xCoordFinal][yCoordFinal].setBounds(x,y,90,90);//x axis, y axis, width, height
          f.add(fieldButton[xCoordFinal][yCoordFinal]);//adding button in JFrame
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

      //label
      label.setBounds(800, 90, 300, 45);
      f.add(label);

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





  public static void guiDig(Object buton, int x, int y){
      JButton button = (JButton) buton;
      boolean diggable = mf.getDigField(x,y);
      int value = mf.getPlayField(x,y);




      if (diggable == false){

      } else if (value == 9){
        button.setText("Mine");
        label.setText("You hit a mine! Game Over.");
        gameInProgress = false;
      } else if (value != 0){
          button.setText(Integer.toString(value));
        } else if (value == 0){

          button.setText(Integer.toString(value));
          mf.setDigField(x,y,false);
          button.setEnabled(false);


          for(int j = -1; j <= 1; j++){ //check for zero, dig zero
            for(int k = -1; k <= 1; k++){
              try { //edges do not have all sides to detect
                if (mf.playField[x][y] == 0 && mf.digField[x+j][y+k] == true){
                 guiDig(fieldButton[x+j][y+k],x+j,y+k); //slight problem with changing button references. Manual button names?
                }
              }
              catch (IndexOutOfBoundsException e) {
              }
          }
        } //set display to be space for zero, number otherwise.
      }
      }

      public static void guiFlag(Object buton, int x, int y){
        JButton button = (JButton) buton;

        if (button.getText().equals("F")){
          button.setText("");
          mf.setDigField(x,y,true);
        } else {
            button.setText("Flag");
          mf.setDigField(x,y,false);
        }

      }

      /*
      public JButton getButtonByName(String name){
        int divide = name.indexOf(",");

        String x_coord = name.substring(0, divide);
        String y_coord = name.substring(divide, name.length());

        return JButton
      }
      */

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




      public void endgame(){ //set all buttons to disable, display entire field

      }
  }
