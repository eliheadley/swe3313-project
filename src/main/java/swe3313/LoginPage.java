package swe3313;

import java.awt.event.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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
        textFont = new Font("Roboto Serif", Font.PLAIN, 20);
        //Create text fields to input data
        txtIn1 = new JTextField();
        txtIn1.setFont(textFont);
        txtIn1.setBounds(38*w1p, 7*h5p, 26*w1p, 7*h1p);

        txtIn2 = new JTextField();
        txtIn2.setFont(textFont);
        txtIn2.setBounds(38*w1p, 10*h5p, 26*w1p, 7*h1p);
        //Create labels
        title = new JLabel("Login");
        title.setBounds(46*w1p, h5p, 15*w1p, 9*h1p);
        title.setFont(new Font("Impact", Font.BOLD, 58));

        l1 = new JLabel("Phone Number");
        l1.setBounds(38*w1p, 33*h1p,17*w1p,6*h1p);
        l1.setFont(font);

        l2 = new JLabel("Password");
        l2.setBounds(38*w1p, 48*h1p,17*w1p,6*h1p);
        l2.setFont(font);

        //Create login button
        b1 = new JButton("Login");
        b1.setBounds(46*w1p, 13*h5p, 10*w1p,7*h1p);//x axis, y axis, width, height
        b1.setBackground(Color.decode("#e06666"));
        b1.setFont(new Font("Impact", Font.PLAIN, 20)); 
        b1.addActionListener(this);
        //Create back button
        b2 = new JButton("Back");
        b2.setBounds(w5p, h5p, 10*w1p,7*h1p);
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
            boolean matched = false;
            // throw exception if user does not exist
            try{
                user = db.getUser(phoneNumber);
                matched = Password.validatePassword(password, user[1]);
            }catch(NullPointerException npe){
                JOptionPane.showMessageDialog(null, "Invalid Phone Number","Invalid Login", JOptionPane.ERROR_MESSAGE);
            }catch(NoSuchAlgorithmException nae){
                nae.printStackTrace();
            }catch(InvalidKeySpecException ikse) {
                ikse.printStackTrace();
            }
            if(matched){
                if(user[6].toLowerCase().equals("customer")){
                    currentOrder.setPhoneNumber(user[0]);
                    new PizzaMenu().showPizzaMenu(true);
                    this.dispose();
                }else if(user[6].toLowerCase().equals("employee")){
                    new EmployeePage().showEmployee(true);
                    this.dispose();
                }else if(user[6].toLowerCase().equals("manager")){
                    new ManagerPage().showManager(true);
                    this.dispose();
                }
            }else if(user != null && matched == false){
                JOptionPane.showMessageDialog(null, "Invalid Password","Invalid Login", JOptionPane.ERROR_MESSAGE);
                txtIn1.setText("");
                txtIn2.setText("");
            }else{
                txtIn1.setText("");
                txtIn2.setText("");
            } 
        //Back button action
        }else if(e.getActionCommand().equals("Back")){
            new MainPage().showMain(true);
            this.dispose();
        }
    }
    
}