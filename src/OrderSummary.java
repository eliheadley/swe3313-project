import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;

public class OrderSummary extends Page implements ActionListener{
    JLabel title, pizzaLabel, extrasLabel, qty1, each1, total1, line1, line2, 
    qty2, each2, total2;
    JButton back, checkOut, edit1, edit2, edit3, inc1, inc2, inc3, dec1, dec2, dec3;
    Font buttonFont, textFont, titleFont;

    public OrderSummary(){
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        textFont = new Font("Impact", Font.PLAIN, 24);
        titleFont = new Font("Impact", Font.BOLD, 64);

        // create title
        title = new JLabel("Order Summary");
        title.setBounds((7*w5p), h5p, 700, 60);
        title.setFont(titleFont);

        //Make first separator line
        line1 = new JLabel();
        line1.setBounds(2*w5p, 6*h5p, 1200, 2);
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 10);
        line1.setBorder(border1);

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

        // make buttons for first summary
        edit1 = new JButton("Edit");
        edit1.setBounds((10*w5p)-10, (6*h5p)+20, 70, 30);
        edit1.setBackground(Color.decode("#e06666"));
        edit1.setFont(buttonFont);
        edit1.addActionListener(this);
        
        inc1 = new JButton("+");
        inc1.setBounds((11*w5p)+10, (6*h5p)+20, 50, 30);
        inc1.setBackground(Color.decode("#e06666"));
        inc1.setFont(buttonFont);
        inc1.addActionListener(this);

        dec1 = new JButton("-");
        dec1.setBounds((12*w5p)-10, (6*h5p)+20, 50, 30);
        dec1.setBackground(Color.decode("#e06666"));
        dec1.setFont(buttonFont);
        dec1.addActionListener(this);

        //Make second separator line
        line2 = new JLabel();
        line2.setBounds(2*w5p, 13*h5p, 1200, 2);
        Border border2 = BorderFactory.createLineBorder(Color.BLACK, 10);
        line2.setBorder(border2);
        
        // make extras label for extras order summary
        extrasLabel = new JLabel("Extras");
        extrasLabel.setFont(textFont);
        extrasLabel.setBounds((2*w5p), (12*h5p)+10, 70, 30);

        // make qty, each, and total labels
        qty2 = new JLabel("Qty");
        qty2.setFont(textFont);
        qty2.setBounds((13*w5p), (12*h5p)+10, 50, 30);

        each2 = new JLabel("Each");
        each2.setFont(textFont);
        each2.setBounds((14*w5p), (12*h5p)+10, 50, 30);

        total2 = new JLabel("Total");
        total2.setFont(textFont);
        total2.setBounds((15*w5p)+15, (12*h5p)+10, 50, 30);

        // make buttons for second summary
        edit2 = new JButton("Edit");
        edit2.setBounds((10*w5p)-10, (13*h5p)+20, 70, 30);
        edit2.setBackground(Color.decode("#e06666"));
        edit2.setFont(buttonFont);
        edit2.addActionListener(this);
        
        inc2 = new JButton("+");
        inc2.setBounds((11*w5p)+10, (13*h5p)+20, 50, 30);
        inc2.setBackground(Color.decode("#e06666"));
        inc2.setFont(buttonFont);
        inc2.addActionListener(this);

        dec2 = new JButton("-");
        dec2.setBounds((12*w5p)-10, (13*h5p)+20, 50, 30);
        dec2.setBackground(Color.decode("#e06666"));
        dec2.setFont(buttonFont);
        dec2.addActionListener(this);

        // make buttons for third summary
        edit3 = new JButton("Edit");
        edit3.setBounds((10*w5p)-10, (16*h5p)+20, 70, 30);
        edit3.setBackground(Color.decode("#e06666"));
        edit3.setFont(buttonFont);
        edit3.addActionListener(this);
        
        inc3 = new JButton("+");
        inc3.setBounds((11*w5p)+10, (16*h5p)+20, 50, 30);
        inc3.setBackground(Color.decode("#e06666"));
        inc3.setFont(buttonFont);
        inc3.addActionListener(this);

        dec3 = new JButton("-");
        dec3.setBounds((12*w5p)-10, (16*h5p)+20, 50, 30);
        dec3.setBackground(Color.decode("#e06666"));
        dec3.setFont(buttonFont);
        dec3.addActionListener(this);
        

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
        // add labels for first summary
        this.add(title);
        this.add(line1);
        this.add(pizzaLabel); this.add(qty1); this.add(each1); this.add(total1);
        this.add(edit1); this.add(inc1); this.add(dec1);
        // add labels for second summary
        this.add(line2);
        this.add(extrasLabel); this.add(qty2); this.add(each2); this.add(total2);
        this.add(edit2); this.add(inc2); this.add(dec2);
        // add buttons for thirds summary
         this.add(edit3); this.add(inc3); this.add(dec3);

        // set the layout for the frame
        this.getContentPane().setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        }else if(e.getActionCommand().equals("Check Out")){
            this.dispose();
        }
     }

}