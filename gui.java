import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//Test GUI

public class gui{

  public static int clickedX;
  public static int clickedY;

  public static Boolean digBool = true;
  public static Boolean flagBool = false;

  public static JFrame f = new JFrame();

  public static void main(String[] args) { //does 8x8 only, configure for modularity
    //creating instance of JFrame

    int xCoord = 0;
    int yCoord = 0;



    for(int x = 45; x < 755; x+=90){
      final int xCoordFinal = xCoord;
      for(int y = 45; y < 755; y+=90){
        final int yCoordFinal = yCoord;
        JButton b=new JButton(new AbstractAction("(" + Integer.toString(xCoord) + "," + Integer.toString(yCoord) + ")") {//creating instance of JButton
          @Override
          public void actionPerformed(ActionEvent e) { //field button clicked
            setClicked(xCoordFinal,yCoordFinal);
            System.out.println("x= " + xCoordFinal); //debugging
            System.out.println("y= " + yCoordFinal + "\n");
            this.setEnabled(false); //disable button when clicked, NOT DEBUGGING

            //implement dig/flag button
          }
        });

        b.setBounds(x,y,90,90);//x axis, y axis, width, height



        f.add(b);//adding button in JFrame
        yCoord++;
      }
      yCoord = 0;
      xCoord++;
    }

    /*
    JLabel xlab = new JLabel("X Coord: " + clickedX); //Used to test buttons, implemented in setClickedX/Y
    xlab.setBounds(900,135,90,45);
    f.add(xlab);

    JLabel ylab = new JLabel("Y Coord: " + clickedY);
    ylab.setBounds(900,180,90,45);
    f.add(ylab);
    */


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
    f.add(actionButton); //make mutually exclusive

  /*  JButton fl=new JButton(new AbstractAction("Flag") {
      @Override
      public void actionPerformed(ActionEvent e){
        digBool = false;
        flagBool = true;

        System.out.println("Flag pressed:");
        System.out.println(digBool);
        System.out.println(flagBool);

      }


    }); //flag button
    fl.setBounds(900,90,90,45);
    f.add(fl);
 */






    f.setSize(1000,1000);
    f.setLayout(null);//using no layout managers
    f.setVisible(true);//making the frame visible
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }



  public String clicked(){
    return Integer.toString(clickedX) + " " + Integer.toString(clickedY);
  }

  public static void setClicked(int x, int y){
    clickedX = x;
    clickedY = y;
;  }







}
