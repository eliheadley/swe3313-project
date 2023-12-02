package swe3313;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class PaymentMethod extends Page implements ActionListener{
    JLabel img, title, label1, label2, line1, line2;
    JPanel payOnlinePanel, payInPersonPanel;
    JCheckBox credit, check, cash;
    JButton confirm, backButton;
    Font buttonFont, textFont, titleFont, checkBoxFont;

    public PaymentMethod(){
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        textFont = new Font("Impact", Font.PLAIN, 24);
        titleFont = new Font("Impact", Font.BOLD, 64);
        checkBoxFont = new Font("Impact", Font.PLAIN, 24);

        // create title
        title = new JLabel("Confirm Payment Method");
        title.setBounds((6*w5p), h5p, 800, 60);
        title.setFont(titleFont);

        //back button
        backButton = new JButton("Back");
        backButton.setBounds(w5p, h5p, 10*w1p,7*h1p);
        backButton.setBackground(Color.decode("#e06666"));
        backButton.setFont(buttonFont);
        backButton.addActionListener(this);
        this.add(backButton);

        //Make first separator line
        line1 = new JLabel();
        line1.setBounds(2*w5p, 6*h5p, 1200, 2);
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 10);
        line1.setBorder(border1);

        // make pay online label
        label1 = new JLabel("Pay Online");
        label1.setFont(textFont);
        label1.setBounds((2*w5p), (5*h5p)+10, 150, 30);

        //credit/debit checkbox
        credit = new JCheckBox("                                                                                                                      Credit/Debit");
        credit.setFont(checkBoxFont);
        credit.addActionListener(this);
        credit.setBackground(Color.decode("#cccccc"));
        
        // make pay in person label
        label2 = new JLabel("Pay In Person");
        label2.setFont(textFont);
        label2.setBounds((2*w5p), (10*h5p)+10, 150, 30);

        //Make second separator line
        line2 = new JLabel();
        line2.setBounds(2*w5p, 11*h5p, 1200, 2);
        Border border2 = BorderFactory.createLineBorder(Color.BLACK, 10);
        line2.setBorder(border2);

        // check and cash checkboxes
        check = new JCheckBox("                                                                                                                     Check");
        check.setFont(checkBoxFont);
        check.addActionListener(this);
        check.setBackground(Color.decode("#cccccc"));
        cash = new JCheckBox("                                                                                                                     Cash");
        cash.setBackground(Color.decode("#cccccc"));
        cash.setFont(checkBoxFont);
        cash.addActionListener(this);

        // create confirm button
        confirm = new JButton("Confirm");
        confirm.setBounds((17*w5p)+10,15*h5p,150,50);
        confirm.setBackground(Color.decode("#e06666"));
        confirm.setFont(buttonFont);
        confirm.addActionListener(this);

        //create panels
        payOnlinePanel = new JPanel(new GridLayout(1,1));
        payOnlinePanel.setBounds(2*w5p, (6*h5p)+15, 650, 50);
        payOnlinePanel.setBackground(Color.decode("#cccccc"));

        payInPersonPanel = new JPanel(new GridLayout(2,1));
        payInPersonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        payInPersonPanel.setBounds(2*w5p, (11*h5p)+10, 600, 150);
        payInPersonPanel.setBackground(Color.decode("#cccccc"));


        //add credit/debit checkbox
        payOnlinePanel.add(credit);
        // add check adn cash checkboxes
        payInPersonPanel.add(check);
        //payInPersonPanel.add(new JLabel());
        payInPersonPanel.add(cash);


        //add title
        this.add(title);
        // add buttons to frame
        this.add(confirm);
        // add alements for first option
        this.add(payOnlinePanel);
        this.add(label1);
        this.add(line1);
        // add elements for second and third options
        this.add(payInPersonPanel);
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

    public void showPaymentMethod(boolean visible){
        if(visible){
           this.setVisible(true);
       }
    }

    @Override
     public void actionPerformed(ActionEvent e){
         // continue button
        if(e.getActionCommand().equals("Back")){
            new OrderSummary().showOrderSummary(true);
            this.dispose();
        }else if(e.getSource().equals(credit)){
            if(credit.isSelected()){
                check.setSelected(false);
                cash.setSelected(false);
            }
        }else if(e.getActionCommand().equals(check)){
            if(check.isSelected()){
                credit.setSelected(false);
                cash.setSelected(false);
            }
        }else if(e.getActionCommand().equals("                                                                                                                     Cash")){
            if(cash.isSelected()){
                credit.setSelected(false);
                check.setSelected(false);
            }
        }else if(e.getActionCommand().equals("Confirm")){
            if(credit.isSelected() == false && check.isSelected() == false && cash.isSelected() == false){
                JOptionPane.showMessageDialog(this, "Please Select a Payment Method", "Oops!", JOptionPane.ERROR_MESSAGE);
            }else{
                if(credit.isSelected()){
                    currentOrder.setPaymentMethod("Credit");
                } else if (check.isSelected()){
                     currentOrder.setPaymentMethod("Check");
                } else if (check.isSelected()){
                     currentOrder.setPaymentMethod("Cash");
                }
                new DeliveryMethod().showDeliveryMethod(true);
                this.dispose();
            }
        }
     }

}