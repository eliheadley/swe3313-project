import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class EmployeePage extends Page implements ActionListener {
         
    //Make buttons
    JButton b1, b2;
    JLabel img, title;
    Font buttonFont;

    public EmployeePage (){
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        //Instaniate buttons
        b1 = new JButton("Go to Current Orders");
        b1.setBounds((8*w5p)+10,16*h5p,250,50);//x axis, y axis, width, height
        b1.setBackground(Color.decode("#e06666"));
        b1.setFont(buttonFont); 

        b2 = new JButton("Home");
        b2.setBounds(w5p, h5p, 150, 50);
        b2.setBackground(Color.decode("#e06666"));
        b2.setFont(buttonFont);

        //Make page title
        title = new JLabel("Welcome Employee!");
        title.setBounds((7*w5p)-10, h5p, 700, 70);
        title.setFont(new Font("Impact", Font.BOLD, 58));
    
        //Add actions
        b1.addActionListener(this);
        b2.addActionListener(this);
        //Create logo using a icon
        img = new JLabel(new ImageIcon("C:/Users/elihe/OneDrive/projects/swe3313-project/images/Mom & Pizza.png"));
        img.setBounds((7*w5p), 4*h5p, 438, 438);
        //add elements to page
        this.add(img);
        this.add(title);
        this.add(b1);
        this.add(b2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        this.getContentPane().setBackground(Color.decode("#cccccc"));
    }

    public void showEmployee(boolean visible){
        if(visible){
           this.setVisible(true);
       }
    }

     //Implement action listener
     @Override
     public void actionPerformed(ActionEvent e){
        //Current Orders button
        if(e.getActionCommand().equals("Go to Current Orders")){
            this.dispose();
         //Home button
        }else if(e.getActionCommand().equals("Home")){
            new MainPage().showMain(true);
            this.dispose();
        }
     }
}
