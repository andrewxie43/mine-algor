import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class gui implements ActionListener {
  public static void main(String[] args) { //does 8x8 only, configure for modularity
    JFrame f=new JFrame();//creating instance of JFrame

    int xCoord = 0;
    int yCoord = 0;
    for(int x = 45; x < 755; x+=90){
      for(int y = 45; y < 755; y+=90){
        JButton b=new JButton("(" + Integer.toString(xCoord) + "," + Integer.toString(yCoord) + ")");//creating instance of JButton
        b.setBounds(x,y,90,90);//x axis, y axis, width, height

        

        f.add(b);//adding button in JFrame
        yCoord++;
      }
      yCoord = 0;
      xCoord++;
    }
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
}
