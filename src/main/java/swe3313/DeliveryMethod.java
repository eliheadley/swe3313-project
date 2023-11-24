package swe3313;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class DeliveryMethod extends Page implements ActionListener{
    JLabel title, label1, label2, line1, line2;
    JPanel carryOutPanel, pickUpPanel;
    JCheckBox carryOut, pickup;
    JButton confirm;
    Font buttonFont, textFont, titleFont, checkBoxFont;

    public DeliveryMethod(){
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        textFont = new Font("Impact", Font.PLAIN, 24);
        titleFont = new Font("Impact", Font.BOLD, 64);
        checkBoxFont = new Font("Impact", Font.PLAIN, 24);

        // create title
        title = new JLabel("Choose Delivery Method");
        title.setBounds((6*w5p), h5p, 700, 60);
        title.setFont(titleFont);

        /*  !!! Create logo using a icon
        img = new JLabel(new ImageIcon("C:/Users/elihe/OneDrive/projects/swe3313-project/images/Mom & Pizza.png"));
        img.setBounds((7*w5p), 3*h5p, 438, 438);
        this.add(img); */

        //Make first separator line
        line1 = new JLabel();
        line1.setBounds(2*w5p, 6*h5p, 1200, 2);
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 10);
        line1.setBorder(border1);

        // make pay online label
        label1 = new JLabel("Carry Out");
        label1.setFont(textFont);
        label1.setBounds((2*w5p), (5*h5p)+10, 150, 30);

        //credit/debit checkbox
        carryOut = new JCheckBox("                                                                                                                      Carry Out");
        carryOut.setFont(checkBoxFont);
        
        // make pay in person label
        label2 = new JLabel("Pick Up");
        label2.setFont(textFont);
        label2.setBounds((2*w5p), (10*h5p)+10, 150, 30);

        //Make second separator line
        line2 = new JLabel();
        line2.setBounds(2*w5p, 11*h5p, 1200, 2);
        Border border2 = BorderFactory.createLineBorder(Color.BLACK, 10);
        line2.setBorder(border2);

        // check and cash checkboxes
        pickup = new JCheckBox("                                                                                                                     Pickup");
        pickup.setFont(checkBoxFont);

        // create confirm button
        confirm = new JButton("Confirm");
        confirm.setBounds((17*w5p)+10,15*h5p,150,50);
        confirm.setBackground(Color.decode("#e06666"));
        confirm.setFont(buttonFont);
        confirm.addActionListener(this);

        //create panels
        carryOutPanel = new JPanel(new GridLayout(1,1));
        carryOutPanel.setBounds(2*w5p, (6*h5p)+15, 650, 50);
        carryOutPanel.setBackground(Color.decode("#cccccc"));

        pickUpPanel = new JPanel(new GridLayout(1,1));
        pickUpPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        pickUpPanel.setBounds(2*w5p, (11*h5p)+10, 600, 150);
        pickUpPanel.setBackground(Color.decode("#cccccc"));

        //add carry out checkbox
        carryOutPanel.add(carryOut);
        // add pick up
        pickUpPanel.add(pickup);

        //add title
        this.add(title);
        // add buttons to frame
        this.add(confirm);
        // add alements for first option
        this.add(carryOutPanel);
        this.add(label1);
        this.add(line1);
        // add elements for second and third options
        this.add(pickUpPanel);
        this.add(label2);
        this.add(line2);
        // add confirm button
        this.add(confirm);

        // set the layout for the frame
        this.getContentPane().setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        this.getContentPane().setBackground(Color.decode("#cccccc"));
    }

    public void showDeliveryMethod(boolean visible){
        if(visible){
           this.setVisible(true);
       }
    }

    @Override
     public void actionPerformed(ActionEvent e){
         // continue button
            if(e.getActionCommand().equals("Confirm")){
                new CreditInfo().showCreditInfo(true);
                this.dispose();
        }
     }

    }
