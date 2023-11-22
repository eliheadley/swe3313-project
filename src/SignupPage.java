import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.Color;

public class SignupPage extends Page implements ActionListener{
    String phoneNumber, password;
    String[] user;
    //creat textfields
    JTextField t1, t2, t3, t4, t5, t6;
    JLabel l1, l2, l3, l4, l5, l6, title;
    //buttons
    JButton b1, b2;
    Font font, textFont;
    //constructor
    public SignupPage(){
        //Instaniate textfields
        t1 = new JTextField();
        l1 = new JLabel("Username");
        t2 = new JTextField();
        l2 = new JLabel("First Name");
        t3 = new JTextField();
        l3 = new JLabel("Password");
        t4 = new JTextField();
        l4 = new JLabel("Last Name");
        t5 = new JTextField();
        l5 = new JLabel("Address");
        t6 = new JTextField();
        l6 = new JLabel("Preferred Payment Method");
        title = new JLabel("Sign Up");
        font = new Font("Impact", Font.PLAIN, 18);
        textFont = new Font("Roboto Serif", Font.PLAIN, 18);
        //Instatiate buttons
        b1 = new JButton("Sign Up");
        b2 = new JButton("Back");
        //set textField bounds        
        t1.setBounds(6*w5p, 5*h5p, 250, 50);
        t1.setFont(textFont);
        l1.setBounds(6*w5p, (5*h5p)-20, 100, 20);
        l1.setFont(font);
        t2.setBounds(11*w5p, 5*h5p, 250, 50);
        t2.setFont(textFont);
        l2.setBounds(11*w5p, (5*h5p)-20, 100, 20);
        l2.setFont(font);
        t3.setBounds(6*w5p, 8*h5p, 250, 50);
        t3.setFont(textFont);
        l3.setBounds(6*w5p, (8*h5p)-20, 100, 20);
        l3.setFont(font);
        t4.setBounds(11*w5p, 8*h5p, 250, 50);
        t4.setFont(textFont);
        l4.setBounds(11*w5p, (8*h5p)-20, 100, 20);
        l4.setFont(font);
        t5.setBounds(6*w5p, 11*h5p, 250, 50);
        t5.setFont(textFont);
        l5.setBounds(6*w5p, (11*h5p)-20, 100, 20);
        l5.setFont(font);
        t6.setBounds(11*w5p, 11*h5p, 250, 50);
        t6.setFont(textFont);
        l6.setBounds(11*w5p, (11*h5p)-20, 250, 20);
        l6.setFont(font);
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
        this.add(t1);
        this.add(t2);
        this.add(t3);
        this.add(t4);
        this.add(t5);
        this.add(t6);
        this.add(b1);
        this.add(b2);

        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);
        this.add(l5);
        this.add(l6);
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
            this.dispose();
        //Back button action
        }else if(e.getActionCommand().equals("Back")){
            new MainPage().showMain(true);
            this.dispose();
        }
    }
}
