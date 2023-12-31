package swe3313;

import java.awt.event.*;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.imageio.ImageIO;

public class ManagerPage extends Page implements ActionListener {   
    //Make buttons
    JButton b1, b2, b3;
    JLabel img, title;
    Font buttonFont;

    public ManagerPage (){
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        //Instaniate buttons
        b1 = new JButton("Go to Employee Data");
        b1.setBounds((2*w5p),16*h5p,15*w1p,7*h1p);//x axis, y axis, width, height
        b1.setBackground(Color.decode("#e06666"));
        b1.setFont(buttonFont); 

        b2 = new JButton("Go to Sales Data");
        b2.setBounds((16*w5p),16*h5p,15*w1p,7*h1p);
        b2.setBackground(Color.decode("#e06666"));
        b2.setFont(buttonFont);

        b3 = new JButton("Home");
        b3.setBounds(w5p, h5p, 10*w1p, 7*h1p);
        b3.setBackground(Color.decode("#e06666"));
        b3.setFont(buttonFont);

        //Make page title
        title = new JLabel("Welcome Manager!");
        title.setBounds((35*w1p), 2*h1p, 40*w1p, 10*h1p);
        title.setFont(new Font("Impact", Font.BOLD, 58));
    
        //Add actions
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        //Create logo using a icon
        try {
        InputStream stream = getClass().getResourceAsStream("/MomAndPizza.png");
        img = new JLabel(new ImageIcon(ImageIO.read(stream)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        img.setBounds((7*w5p), 4*h5p, 438, 438);
        //add elements to page
        this.add(img);
        this.add(title);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        this.getContentPane().setBackground(Color.decode("#cccccc"));
    }

    public void showManager(boolean visible){
        if(visible){
           this.setVisible(true);
       }
    }

     //Implement action listener
     @Override
     public void actionPerformed(ActionEvent e){
        //Employee data button
        if(e.getActionCommand().equals("Go to Employee Data")){
            new EmployeeData().showEmployeeData(true);
            this.dispose();
         //Sales data button
        }else if(e.getActionCommand().equals("Go to Sales Data")){
            new SalesData().showSalesData(true);
            this.dispose();
        //Home button
        }else if(e.getActionCommand().equals("Home")){
            new MainPage().showMain(true);
            this.dispose();
        }
     }
}
