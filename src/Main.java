import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

class Main{
    public static void main(String[] args){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int h5p = (int)(screenSize.getHeight() * 0.05);
        int w5p = (int)(screenSize.getWidth() * 0.05);

        UserPage up = new UserPage();
        
        LoginPage lp = new LoginPage();
        JFrame main = new JFrame();

        //company title 
        JLabel title = new JLabel("MOM AND POP'S PIZZA SHOP");
        JPanel tp = new JPanel();
        title.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 30));
        tp.setBounds(7*w5p, h5p, 550, 100);//x axis, y axis, width, height
        tp.add(title);
        main.add(tp);
        
        //company hours
        JLabel hours = new JLabel("Hours: Sunday - Thursday 9am - 11pm  |   Friday - Saturday 11am - Midnight");
        JPanel hp = new JPanel();
        hours.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
        hp.setBounds(w5p - 75, 17*h5p,900, 75);;
        hp.add(hours);
        main.add(hp);

        //Signup button
        JButton b1 = new JButton("Signup");
        b1.setBounds((18*w5p),h5p,150,50);//x axis, y axis, width, height
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                up.userInfo(true);
                main.setVisible(false);
            }
        });

        //Login Button
        JButton b2 = new JButton("Login");
        b2.setBounds((16*w5p),h5p,150,50);//x axis, y axis, width, height
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                lp.login(true);;
                main.setVisible(false);
            }
        });

        main.add(b1); main.add(b2); 
        main.setExtendedState(JFrame.MAXIMIZED_BOTH);
        main.setLayout(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }
}