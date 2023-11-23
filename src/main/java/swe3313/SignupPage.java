package swe3313;

import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;

import swe3313.Database;
import swe3313.PizzaMenu;

import java.awt.Color;

public class SignupPage extends Page implements ActionListener{
    String phoneNumber, password;
    String[] user;
    //creat textfields
    JTextField tUsername, tFirstName, tPassword, tLastName, tAddress, tPayment;
    JLabel lUsername, lFirstName, lPassword, lLastName, lAddress, lPayment, title;
    //buttons
    JButton b1, b2;
    Font font, textFont;
    //constructor
    public SignupPage(){
        //Instaniate textfields
        tUsername = new JTextField();
        lUsername = new JLabel("Username");
        tFirstName = new JTextField();
        lFirstName = new JLabel("First Name");
        tPassword = new JTextField();
        lPassword = new JLabel("Password");
        tLastName = new JTextField();
        lLastName = new JLabel("Last Name");
        tAddress = new JTextField();
        lAddress = new JLabel("Address");
        tPayment = new JTextField();
        lPayment = new JLabel("Preferred Payment Method");
        title = new JLabel("Sign Up");
        font = new Font("Impact", Font.PLAIN, 18);
        textFont = new Font("Roboto Serif", Font.PLAIN, 18);
        //Instatiate buttons
        b1 = new JButton("Sign Up");
        b2 = new JButton("Back");
        //set textField bounds        
        tUsername.setBounds(6*w5p, 5*h5p, 250, 50);
        tUsername.setFont(textFont);
        lUsername.setBounds(6*w5p, (5*h5p)-20, 100, 20);
        lUsername.setFont(font);
        tFirstName.setBounds(11*w5p, 5*h5p, 250, 50);
        tFirstName.setFont(textFont);
        lFirstName.setBounds(11*w5p, (5*h5p)-20, 100, 20);
        lFirstName.setFont(font);
        tPassword.setBounds(6*w5p, 8*h5p, 250, 50);
        tPassword.setFont(textFont);
        lPassword.setBounds(6*w5p, (8*h5p)-20, 100, 20);
        lPassword.setFont(font);
        tLastName.setBounds(11*w5p, 8*h5p, 250, 50);
        tLastName.setFont(textFont);
        lLastName.setBounds(11*w5p, (8*h5p)-20, 100, 20);
        lLastName.setFont(font);
        tAddress.setBounds(6*w5p, 11*h5p, 250, 50);
        tAddress.setFont(textFont);
        lAddress.setBounds(6*w5p, (11*h5p)-20, 100, 20);
        lAddress.setFont(font);
        tPayment.setBounds(11*w5p, 11*h5p, 250, 50);
        tPayment.setFont(textFont);
        lPayment.setBounds(11*w5p, (11*h5p)-20, 250, 20);
        lPayment.setFont(font);
        title.setBounds((10*w5p)-60, h5p, 200, 50);
        title.setFont(new Font("Impact", Font.BOLD, 48));
        //set button sizes
        b1.setBounds((9*w5p)+10,14*h5p ,150,50);//x axis, y axis, width, height 
        b1.setBackground(Color.decode("#e06666"));
        b1.setFont(new Font("Impact", Font.PLAIN, 20));       
        b2.setBounds(w5p, h5p, 150,50);
        b2.setBackground(Color.decode("#e06666"));
        b2.setFont(new Font("Impact", Font.PLAIN, 20));  
        //Add actions to buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
        //Add all elements
        this.add(tUsername);
        this.add(tFirstName);
        this.add(tPassword);
        this.add(tLastName);
        this.add(tAddress);
        this.add(tPayment);
        this.add(b1);
        this.add(b2);

        this.add(lUsername);
        this.add(lFirstName);
        this.add(lPassword);
        this.add(lLastName);
        this.add(lAddress);
        this.add(lPayment);
        this.add(title);
        //Set layout of JFrame
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        this.getContentPane().setBackground(Color.decode("#cccccc"));
    }

    public void showSignup(boolean visible){
        if(visible){
           this.setVisible(true);
       }
    }

    //Implement actionPerformed
    @Override
    public void actionPerformed(ActionEvent e){
        //Continue button action
        if(e.getActionCommand().equals("Sign Up")){
            new Database().insertUser(tUsername.getText(), tPassword.getText(), tFirstName.getText(), tLastName.getText(), tPayment.getText(), tAddress.getText());
            new PizzaMenu().showPizzaMenu(true);
            this.dispose();
        //Back button action
        }else if(e.getActionCommand().equals("Back")){
            new MainPage().showMain(true);
            this.dispose();
        }
    }
}
