import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.Color;

public class SignupPage extends JFrame implements ActionListener{
    String phoneNumber, password;
    String[] user;
    //creat textfields
    JTextField t1, t2, t3, t4, t5, t6;
    //buttons
    JButton b1, b2;
    //constructor
    public SignupPage(){
        //Instaniate textfields
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        //Instatiate buttons
        b1 = new JButton("Continue");
        b2 = new JButton("Back");
        //Get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int h5p = (int)(screenSize.getHeight() * 0.05);
        int w5p = (int)(screenSize.getWidth() * 0.05);
        //set textField bounds        
        t1.setBounds(9*w5p, 4*h5p, 250, 50);
        t2.setBounds(9*w5p, 5*h5p, 170, 20);
        t3.setBounds(9*w5p, 6*h5p, 170, 20);
        t4.setBounds(9*w5p, 7*h5p, 170, 20);
        t5.setBounds(9*w5p, 8*h5p, 170, 20);
        t6.setBounds(9*w5p, 9*h5p, 170, 20);
        //set button sizes
        b1.setBounds((17*w5p),(17*h5p) ,120,30);//x axis, y axis, width, height 
        b1.setBackground(Color.decode("#e06666"));      
        b2.setBounds(w5p, h5p, 80, 30);
        b2.setBackground(Color.decode("#e06666")); 
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
        //Set layout of JFrame
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        setBackground(Color.decode("#cccccc"));
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
        if(e.getActionCommand().equals("Continue")){
            this.dispose();
        //Back button action
        }else if(e.getActionCommand().equals("Back")){
            new MainPage().showMain(true);
            this.dispose();
        }
    }
}
