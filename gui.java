import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class gui{

  public static int clickedX;
  public static int clickedY;

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
            System.out.println("x= " + xCoordFinal);
            System.out.println("y= " + yCoordFinal);
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


    JToggleButton d=new JToggleButton("Dig"); //dig button
    d.setBounds(900,45,90,45);
    f.add(d); //make mutually exclusive

    JToggleButton fl=new JToggleButton("Flag"); //flag button
    fl.setBounds(900,90,90,45);
    f.add(fl);







    f.setSize(1000,1000);
    f.setLayout(null);//using no layout managers
    f.setVisible(true);//making the frame visible
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }



  public String clicked(){
    return Integer.toString(clickedX) + " " + Integer.toString(clickedY);
  }

  public static void setClicked(int x, int y){
    //clickedX = x;
    //clickedY = y;
    JLabel xlab = new JLabel("X Coord: " + x); //Used to test buttons
    xlab.setBounds(900,135,90,45);
    f.add(xlab);

    JLabel ylab = new JLabel("Y Coord: " + y);
    ylab.setBounds(900,180,90,45);
    f.add(ylab);

    f.repaint()
;  }







}
