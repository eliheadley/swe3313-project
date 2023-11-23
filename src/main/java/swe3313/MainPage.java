package swe3313;

import java.awt.event.*;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainPage extends Page implements ActionListener {      
    //Make buttons
    JButton b1, b2;
    JLabel img, title, hours1, hours2, slogan, adr1, adr2, adr3;
    Font buttonFont, textFont;

    public MainPage (){
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        textFont = new Font("Impact", Font.PLAIN, 24);
        //Instaniate buttons
        b1 = new JButton("Signup");
        b1.setBounds((17*w5p)+10,h5p,150,50);//x axis, y axis, width, height
        b1.setBackground(Color.decode("#e06666"));
        b1.setFont(buttonFont); 
        b2 = new JButton("Login");
        b2.setBounds((15*w5p)-10,h5p,150,50);
        b2.setBackground(Color.decode("#e06666"));
        b2.setFont(buttonFont);
        //Make page title
        title = new JLabel("Mom and Pop's Pizza Shop");
        title.setBounds((5*w5p), h5p, 700, 50);
        title.setFont(new Font("Impact", Font.BOLD, 58));
        //Make hours of opperation 
        hours1 = new JLabel("Hours:");
        hours1.setBounds((3*w5p)+25, (15*h5p)+30, 100, 50);
        hours1.setFont(textFont);

        hours2 = new JLabel("Sun-Thur. 9am-11pm    Fri-Sat. 11am-midnight");
        hours2.setBounds(w5p, 17*h5p, 500, 50);
        hours2.setFont(textFont);
        //Make slogan
        slogan = new JLabel("Pizza Just How Mama Mia Used to Make");
        slogan.setBounds((8*w5p)-40, 13*h5p, 500, 50);
        slogan.setFont(textFont);
        //Make address label
        adr1 = new JLabel("680 Arntson Rd, Suite 161 Marietta, GA 30060");
        adr1.setBounds(14*w5p, 16*h5p, 500, 50);
        adr1.setFont(textFont);

        adr2 = new JLabel("MomAndPopPizzeria.com");
        adr2.setBounds((15*w5p)+10, (16*h5p)+35, 500, 50);
        adr2.setFont(textFont);

        adr3 = new JLabel("770 555-1212");
        adr3.setBounds((16*w5p), (17*h5p)+30, 300, 50);
        adr3.setFont(textFont);
        //Add actions
        b1.addActionListener(this);
        b2.addActionListener(this);
        //Create logo using a icon
        try {
        InputStream stream = getClass().getResourceAsStream("/Mom & Pizza.png");
        img = new JLabel(new ImageIcon(ImageIO.read(stream)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //img = new JLabel(new ImageIcon("C:/Users/elihe/OneDrive/projects/swe3313-project/images/Mom & Pizza.png"));
        img.setBounds((7*w5p), 3*h5p, 438, 438);
        //add elements to page
        this.add(img);
        this.add(title);
        this.add(hours1);
        this.add(hours2);
        this.add(slogan);
        this.add(adr1);
        this.add(adr2);
        this.add(adr3);
        this.add(b1);
        this.add(b2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        this.getContentPane().setBackground(Color.decode("#cccccc"));
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
