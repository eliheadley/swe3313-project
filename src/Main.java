import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.*;

class Main{
    public static void main(String[] args){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int h5p = (int)(screenSize.getHeight() * 0.05);
        int w5p = (int)(screenSize.getWidth() * 0.05);
        
        LoginPage lp = new LoginPage();
        JFrame main = new JFrame();
        //Signup button
        JButton b1 = new JButton("Signup");
        b1.setBounds((17*w5p),h5p,120,30);//x axis, y axis, width, height
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                lp.login(true);
                main.setVisible(false);
            }
        });

        //Login Button
        JButton b2 = new JButton("Login");
        b1.setBounds((14*w5p),h5p,150,50);//x axis, y axis, width, height
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                lp.login(true);;
            }
        });

        main.add(b1);
        main.setExtendedState(JFrame.MAXIMIZED_BOTH);
        main.setLayout(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }
}