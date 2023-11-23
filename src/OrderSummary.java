import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;

public class OrderSummary extends Page implements ActionListener{
    JLabel title, pizzaLabel, extrasLabel, qty1, each1, total1, space, line;
    JButton back, checkOut, edit1, edit2, edit3;
    Font buttonFont, textFont, titleFont;

    public OrderSummary(){
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        textFont = new Font("Impact", Font.PLAIN, 24);
        titleFont = new Font("Impact", Font.BOLD, 64);

        // create title
        title = new JLabel("Order Summary");
        title.setBounds((7*w5p), h5p, 700, 60);
        title.setFont(titleFont);

        //Make separator line
        line = new JLabel();
        line.setBounds(2*w5p, 6*h5p, 1200, 2);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 10);
        line.setBorder(border);

        // make pizza label for pizza order summary
        pizzaLabel = new JLabel("Pizza");
        pizzaLabel.setFont(textFont);
        pizzaLabel.setBounds((2*w5p), (5*h5p)+10, 50, 30);

        // make qty, each, and total labels
        qty1 = new JLabel("Qty");
        qty1.setFont(textFont);
        qty1.setBounds((13*w5p), (5*h5p)+10, 50, 30);

        each1 = new JLabel("Each");
        each1.setFont(textFont);
        each1.setBounds((14*w5p), (5*h5p)+10, 50, 30);

        total1 = new JLabel("Total");
        total1.setFont(textFont);
        total1.setBounds((15*w5p)+15, (5*h5p)+10, 50, 30);
        
        

        // create back button
        back = new JButton("Back");
        back.setBounds(w5p, h5p, 150, 50);
        back.setBackground(Color.decode("#e06666"));
        back.setFont(buttonFont);
        back.addActionListener(this);
        // create confirm button
        checkOut = new JButton("Check Out");
        checkOut.setBounds((17*w5p)+10,h5p,150,50);
        checkOut.setBackground(Color.decode("#e06666"));
        checkOut.setFont(buttonFont);
        checkOut.addActionListener(this);

        // add buttons to frame
        this.add(back);
        this.add(checkOut);
        // add labels to the frame
        this.add(title);
        this.add(line);
        this.add(pizzaLabel); this.add(qty1); this.add(each1); this.add(total1);

        // set the layout for the frame
        this.getContentPane().setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        this.getContentPane().setBackground(Color.decode("#cccccc"));
    }

    public void showOrdrSmry(boolean visible){
        if(visible){
           this.setVisible(true);
       }
    }

    @Override
     public void actionPerformed(ActionEvent e){
        // back button
        if(e.getActionCommand().equals("Back")){
            new PizzaMenu().showPizzaMenu(true);
            this.dispose();
         // check out button
        }else if(e.getActionCommand().equals("Back")){
            this.dispose();
        }
     }

}