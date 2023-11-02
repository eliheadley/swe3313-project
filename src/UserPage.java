import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.*;

public class UserPage {

    String phoneNumber;
    String password;
    String[] user;
    LoginPage lp;
    JFrame userPage;

    //creat textfields
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    JTextField t6;

    //buttons
    JButton b1;
    JButton b2;

    //constructor
    public UserPage(){
        //Instaniate JFrame
        userPage = new JFrame();
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
        //create loginPage instance to link to
        lp = new LoginPage();
        //Get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int h5p = (int)(screenSize.getHeight() * 0.05);
        int w5p = (int)(screenSize.getWidth() * 0.05);
        //set textField bounds        
        t1.setBounds(9*w5p, 4*h5p, 170, 20);
        t2.setBounds(9*w5p, 5*h5p, 170, 20);
        t3.setBounds(9*w5p, 6*h5p, 170, 20);
        t4.setBounds(9*w5p, 7*h5p, 170, 20);
        t5.setBounds(9*w5p, 8*h5p, 170, 20);
        t6.setBounds(9*w5p, 9*h5p, 170, 20);
        //set button sizes
        b1.setBounds((17*w5p),(17*h5p) ,120,30);//x axis, y axis, width, height       
        b2.setBounds(w5p,17*h5p,80,30);
         //add all elements to JFrame
        userPage.add(b1);
        userPage.add(b2);
        userPage.add(t1);
        userPage.add(t2);
        userPage.add(t3);
        userPage.add(t4);
        userPage.add(t5);
        userPage.add(t6);
        userPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        userPage.setLayout(null);
        userPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userPage.setVisible(false);
    }

    public void userInfo(boolean visible){
        //Database db = new Database();
        
        //Continue button action
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                userPage.setVisible(false);
            }
        }
        );
        //Back button action
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                lp.login(true);
                userPage.setVisible(false);
            }
        });
        if(visible){
            userPage.setVisible(true);
        }
    }
}
