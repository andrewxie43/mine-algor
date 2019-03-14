import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class fieldButton implements ActionListener{

  int fieldX;
  int fieldY;

  int coordX;
  int coordY;



  public fieldButton(int cx, int cy, int fx, int fy){
    coordX = cx;
    coordY = cy;

    fieldX = fx;
    fieldY = fy;

    JButton b=new JButton("(" + Integer.toString(fieldX) + "," + Integer.toString(fieldY) + ")");//creating instance of JButton
    b.setBounds(coordX,coordY,90,90);//x axis, y axis, width, height
  }

  



}
