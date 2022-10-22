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
    CheckboxGroup g1; 
    Checkbox r1,r2,r3,r4;
    int btn = 0,x=0,y=0,flag=0,i=0,j=0,k=0,l=0,foo;
    int[] arr = new int[1000];
    int[] rect = new int[1000];
    int[] cir = new int[1000];
    public void init(){
        setLayout(null);
        b1 = new Button("CIRCLE");
        b2 = new Button("RECTANGLES");
        b3 = new Button("LINES");
        b4 = new Button("CLEAR");
        g1 = new CheckboxGroup();
        r1 = new Checkbox("RED",g1,false);
        r2 = new Checkbox("GREEN",g1,false);
        r3 = new Checkbox("BLUE",g1,false);
        r4 = new Checkbox("BLACK",g1,true);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(r1);
        add(r2);
        add(r3);
        addMouseListener(this); 
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        b1.setBounds(100,10,100,30);
        b2.setBounds(210,10,100,30);
        b3.setBounds(320,10,100,30);
        b4.setBounds(430,10,100,30);
        r1.setBounds(100,50,100,30);
        r2.setBounds(210,50,100,30);
        r3.setBounds(320,50,100,30);
    }
    public void paint(Graphics g){
        if(flag == 1 && btn!=4){
            for(l=0; l<(i-1); l+=3){
                if(cir[l] == 1) g.setColor(Color.red);
                else if(cir[l] == 2) g.setColor(Color.green);
                else if(cir[l] == 3) g.setColor(Color.blue);
                else if(cir[l] == 4) g.setColor(Color.black);
                g.drawOval(cir[l+1],cir[l+2],80,80);
            }
            for(l=0; l<(j-1); l+=3){
                if(rect[l] == 1) g.setColor(Color.red);
                else if(rect[l] == 2) g.setColor(Color.green);
                else if(rect[l] == 3) g.setColor(Color.blue);
                else if(rect[l] == 4) g.setColor(Color.black);
                g.drawRect(rect[l+1],rect[l+2],80,80);
            }
            for(l=0; l<(k-3); l+=3){
                if(arr[l+3] == 1) g.setColor(Color.red);
                else if(arr[l+3] == 2) g.setColor(Color.green);
                else if(arr[l+3] == 3) g.setColor(Color.blue);
                else if(arr[l+3] == 4) g.setColor(Color.black);
                g.drawLine(arr[l+1],arr[l+2],arr[l+4],arr[l+5]);
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
            r4.setState(true);
            repaint();
        }
    }
    public void mouseClicked(MouseEvent e) {
        foo = check();  
        if(flag == 1){
            if(btn == 1){
                cir[i++] = foo;
                cir[i++] = e.getX();
                cir[i++] = e.getY();
            }else if(btn == 2){
                rect[j++] = foo;
                rect[j++] = e.getX();
                rect[j++] = e.getY();
            }else if(btn == 3){
                arr[k++] = foo;
                arr[k++] = e.getX();
                arr[k++] = e.getY();
            }
            repaint();
        }
    }  
    public int check(){
        if(r1.getState() == true) return 1;
        else if(r2.getState() == true) return 2;
        else if(r3.getState() == true) return 3;
        return 4;
    }
    public void mousePressed(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}
