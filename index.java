// Author Pushkraj 
// Created on 12th October 2022

// import java.applet.Applet;  
import java.awt.*;  
import javax.swing.*;
import java.awt.geom.Line2D;
import java.applet.*;
import java.awt.event.*;
public class index extends Applet implements ActionListener, MouseListener{
    Button b1,b2,b3,b4;
    int btn = 0,x=0,y=0,flag=0,i=0,j=0,k=0,l=0;
    int[] arr = new int[1000];
    int[] rect = new int[1000];
    int[] cir = new int[1000];
    public void init(){
        b1 = new Button("CIRCLE");
        b2 = new Button("RECTANGLES");
        b3 = new Button("LINES");
        b4 = new Button("CLEAR");
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        addMouseListener(this); 
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }
    public void paint(Graphics g){
        if(flag == 1 && btn!=4){
            for(l=0; l<(i-1); l+=2){
                g.drawOval(cir[l],cir[l+1],80,80);
            }
            for(l=0; l<(j-1); l+=2){
                g.drawRect(rect[l],rect[l+1],80,80);
            }
            for(l=0; l<(k-2); l+=2){
                g.drawLine(arr[l],arr[l+1],arr[l+2],arr[l+3]);
            }
        }else if(btn == 4) {}
    }
    public void actionPerformed(ActionEvent e){
        flag = 1;
        if(e.getSource() == b1)
            btn = 1;
        else if(e.getSource() == b2)
            btn = 2;
        else if(e.getSource() == b3)
            btn = 3;
        else if(e.getSource() == b4){
            btn = 4;
            i = j = k = 0;
            repaint();
        }
    }
    public void mouseClicked(MouseEvent e) {  
        if(flag == 1){
            if(btn == 1){
                cir[i++] = e.getX();
                cir[i++] = e.getY();
            }else if(btn == 2){
                rect[j++] = e.getX();
                rect[j++] = e.getY();
            }else if(btn == 3){
                arr[k++] = e.getX();
                arr[k++] = e.getY();
            }
            repaint();
        }
    }  
    public void mousePressed(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}
