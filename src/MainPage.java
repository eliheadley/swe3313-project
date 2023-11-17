import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class MainPage extends JFrame implements ActionListener {
    Dimension screenSize;
    int h5p, w5p;        
    //Make buttons
    JButton b1, b2;
    JLabel img;

    public MainPage (){
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        h5p = (int)(screenSize.getHeight() * 0.05); 
        w5p = (int)(screenSize.getWidth() * 0.05);
        //Instaniate buttons
        b1 = new JButton("Signup");
        b1.setBounds((17*w5p),h5p,150,50);//x axis, y axis, width, height
        b1.setBackground(Color.decode("#e06666"));
        b2 = new JButton("Login");
        b2.setBounds((14*w5p),h5p,150,50);
        b2.setBackground(Color.decode("#e06666"));
        //Add actions
        b1.addActionListener(this);
        b2.addActionListener(this);
        //add elements to page
        img = new JLabel(new ImageIcon("C:/Users/elihe/OneDrive/projects/swe3313-project/images/Mom & Pizza.png"));
        img.setBounds(5*w5p, h5p, 700, 600);
        this.add(img);
        this.add(b1);
        this.add(b2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        setBackground(Color.decode("#cccccc"));
    }
    public void showMain(boolean visible){
         if(visible){
            this.setVisible(true);
        }
     }

     //Implement action listener
     @Override
     public void actionPerformed(ActionEvent e){
        //Signup button
        if(e.getActionCommand().equals("Signup")){
            new SignupPage().showSignup(true);
            this.dispose();
         //Login Button
        }else if(e.getActionCommand().equals("Login")){
            new LoginPage().showLogin(true);
            this.dispose();
        }
     }
}
