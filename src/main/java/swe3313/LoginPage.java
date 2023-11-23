package swe3313;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class LoginPage extends Page implements ActionListener {
    String phoneNumber, password;
    String[] user;
    Database db;
    //Create textfields
    JTextField txtIn1, txtIn2;
    JLabel title, l1, l2;
    Font font, textFont;
    //Create buttons
    JButton b1, b2;
    public LoginPage(){
        db = new Database();
        font = new Font("Impact", Font.PLAIN, 18);
        textFont = new Font("Roboto Serif", Font.PLAIN, 18);
        //Create text fields to input data
        txtIn1 = new JTextField();
        txtIn1.setFont(textFont);
        txtIn1.setBounds((7*w5p)+40, 7*h5p, 400, 50);

        txtIn2 = new JTextField();
        txtIn2.setFont(textFont);
        txtIn2.setBounds((7*w5p)+40, 10*h5p, 400, 50);
        //Create labels
        title = new JLabel("Login");
        title.setBounds((10*w5p)-50, h5p, 150, 50);
        title.setFont(new Font("Impact", Font.BOLD, 48));

        l1 = new JLabel("Username");
        l1.setBounds((7*w5p)+40, (7*h5p)-40,250,50);
        l1.setFont(font);

        l2 = new JLabel("Password");
        l2.setBounds((7*w5p)+40, (10*h5p)-40,250,50);
        l2.setFont(font);

        //Create login button
        b1 = new JButton("Login");
        b1.setBounds((9*w5p)+10, 13*h5p, 150, 50);//x axis, y axis, width, height
        b1.setBackground(Color.decode("#e06666"));
        b1.setFont(new Font("Impact", Font.PLAIN, 20)); 
        b1.addActionListener(this);
        //Create back button
        b2 = new JButton("Back");
        b2.setBounds(w5p, h5p, 150, 50);
        b2.setBackground(Color.decode("#e06666"));
        b2.setFont(new Font("Impact", Font.PLAIN, 20));
        b2.addActionListener(this);
        //add all elements to JFrame
        this.add(txtIn1);
        this.add(txtIn2);
        this.add(b1);
        this.add(b2);
        this.add(title);
        this.add(l1);
        this.add(l2);
        //Set layout
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        this.getContentPane().setBackground(Color.decode("#cccccc"));
    }

    public void showLogin(boolean visible){
        if(visible){
           this.setVisible(true);
       }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //Login button action
        if(e.getActionCommand().equals("Login")){
            phoneNumber = txtIn1.getText();
            password = txtIn2.getText();
            user = db.getUser(phoneNumber, password);
            if(user[0] != null){
                txtIn1.setText("Correct!");
            }else{
                txtIn1.setText("Invalid Username or Password");
                txtIn2.setText("Invalid Username or Password");
            } 
        //Back button action
        }else if(e.getActionCommand().equals("Back")){
            new MainPage().showMain(true);
            this.dispose();
        }
    }
    
}
