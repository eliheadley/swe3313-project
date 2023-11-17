import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.Color;

public class LoginPage extends JFrame implements ActionListener {
    String phoneNumber, password;
    String[] user;
    Database db;
    //Create textfields
    JTextField txtIn1, txtIn2;
    //Create buttons
    JButton b1, b2, b3;
    public LoginPage(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int h5p = (int)(screenSize.getHeight() * 0.05);
        int w5p = (int)(screenSize.getWidth() * 0.05);
        db = new Database();
        //Create text fields to input data
        txtIn1 = new JTextField();
        txtIn1.setBounds(9*w5p, 4*h5p, 170, 20);

        txtIn2 = new JTextField();
        txtIn2.setBounds(9*w5p, 5*h5p, 170, 20);

        //Create login button
        b1 = new JButton("Login");
        b1.setBounds((9*w5p)+40, 6*h5p, 80, 30);//x axis, y axis, width, height
        b1.setBackground(Color.decode("#e06666"));  
        b1.addActionListener(this);
        //Creat clear button
        b2 = new JButton("Clear");
        b2.setBounds((9*w5p)+40, 7*h5p,80,30);
        b2.setBackground(Color.decode("#e06666"));  
        b2.addActionListener(this);
        //Create back button
        b3 = new JButton("Back");
        b3.setBounds(w5p, h5p, 80, 30);
        b3.setBackground(Color.decode("#e06666"));
        b3.addActionListener(this);
        //add all elements to JFrame
        this.add(txtIn1);
        this.add(txtIn2);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        //Set layout
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        setBackground(Color.decode("#cccccc"));
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
        //Clear button action
        }else if(e.getActionCommand().equals("Clear")){
            txtIn1.setText("");
            txtIn2.setText("");
        }else if(e.getActionCommand().equals("Back")){
            new MainPage().showMain(true);
            this.dispose();
        }
    }
    
}
