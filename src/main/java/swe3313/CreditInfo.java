package swe3313;

import java.awt.event.*;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class CreditInfo extends Page implements ActionListener {
    String cardNumber, name, exp, cvv, month, year;
    //Create textfields
    JTextField cardTxtIn, nameTxtIn, expTxtIn, cvvTxtIn;
    JPanel creditInfoPanel1, creditInfoPanel2;
    JLabel title, cardLabel, nameLabel, expLabel, cvvLabel, img1, img2, img3;
    Font font, textFont, titleFont, buttonFont;
    //Create buttons
    JButton payNow;
    public CreditInfo(){
        font = new Font("Impact", Font.PLAIN, 18);
        textFont = new Font("Roboto Serif", Font.PLAIN, 18);
        titleFont = new Font("Impact", Font.PLAIN, 28);
        buttonFont = new Font("Impact", Font.PLAIN, 20);

        
        try {
            InputStream stream1 = getClass().getResourceAsStream("/Lock.png");
            img1  = new JLabel(new ImageIcon(ImageIO.read(stream1)));
            img1.setBounds(9*w5p, 1*h1p, 150, 150);
            this.add(img1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try {
            InputStream stream2 = getClass().getResourceAsStream("/MasterCard.png");
            img2  = new JLabel(new ImageIcon(ImageIO.read(stream2)));
            img2.setBounds(2*w1p, 5*h1p, 150, 100);
            this.add(img2);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try {
            InputStream stream3 = getClass().getResourceAsStream("/Visa.png");
            img3  = new JLabel(new ImageIcon(ImageIO.read(stream3)));
            img3.setBounds(16*w1p, 5*h1p, 148, 96);
            this.add(img3);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //Create text fields to input data
        cardTxtIn = new JTextField();
        cardTxtIn.setFont(textFont);

        nameTxtIn = new JTextField();
        nameTxtIn.setFont(textFont);

        expTxtIn = new JTextField();
        expTxtIn.setFont(textFont);

        cvvTxtIn = new JTextField();
        cvvTxtIn.setFont(textFont);

        //Create labels
        title = new JLabel("Secure Credit Card Payment");
        title.setBounds(39*w1p, 13*h1p, 25*w1p, 20*h1p);
        title.setFont(titleFont);

        cardLabel = new JLabel("Credit Card Number");
        cardLabel.setBounds(33*w1p,31*h1p,10*w1p, 5*h1p);
        cardLabel.setFont(font);

        nameLabel = new JLabel("Name on Card");
        nameLabel.setBounds(53*w1p,31*h1p,10*w1p, 5*h1p);
        nameLabel.setFont(font);

        expLabel = new JLabel("Expiration Date");
        expLabel.setBounds(33*w1p,46*h1p,10*w1p, 5*h1p);
        expLabel.setFont(font);

        cvvLabel = new JLabel("Security Code");
        cvvLabel.setBounds(53*w1p, 46*h1p,10*w1p, 5*h1p);
        cvvLabel.setFont(font);

        //Create payNow button
        payNow = new JButton("Pay Now");
        payNow.setBounds(45*w1p, 65*h1p, 150, 50);//x axis, y axis, width, height
        payNow.setBackground(Color.decode("#e06666"));
        payNow.setFont(buttonFont); 
        payNow.addActionListener(this);   
                
        this.getContentPane().setLayout(null);

        creditInfoPanel1 = new JPanel(new GridLayout(1,1, 75, 0));
        creditInfoPanel1.setBounds(33*w1p, 35*h1p, 34*w1p, 5*h1p);
        creditInfoPanel1.setBackground(Color.decode("#cccccc"));

        creditInfoPanel2 = new JPanel(new GridLayout(1,1, 75, 0));
        creditInfoPanel2.setBounds(33*w1p, 50*h1p, 34*w1p, 5*h1p);
        creditInfoPanel2.setBackground(Color.decode("#cccccc"));

        creditInfoPanel1.add(cardTxtIn);
        creditInfoPanel1.add(nameTxtIn);
       
        creditInfoPanel2.add(expTxtIn);
        creditInfoPanel2.add(cvvTxtIn);

        this.add(creditInfoPanel1);
        this.add(creditInfoPanel2);
      
        //add all elements to JFrame
        this.add(title);
        this.add(cardLabel);
        this.add(nameLabel);
        this.add(expLabel);
        this.add(cvvLabel); 
        this.add(payNow);

        //Set layout
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        this.getContentPane().setBackground(Color.decode("#cccccc"));
    }

    public void showCreditInfo(boolean visible){
        if(visible){
           this.setVisible(true);
       }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //Pay Now button action
        if(e.getActionCommand().equals("Pay Now")){
            //set text values
            cardNumber = cardTxtIn.getText();
            name = nameTxtIn.getText();
            name = name.replaceAll("\\s", "");
            exp = expTxtIn.getText();
            exp = exp.replaceAll("\\s", "/");
            cvv = cvvTxtIn.getText();
            
            //credit card errors
            if(cardTxtIn.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Credit Card Number cannot be empty.", "Credit Card Number Error", JOptionPane.ERROR_MESSAGE);
            }else if(!isNumeric(cardNumber)){
                JOptionPane.showMessageDialog(this, "Credit Card Number must consist of only numbers.", "Credit Card Number Error", JOptionPane.ERROR_MESSAGE);
            }else if(cardNumber.length() != 16){ 
                JOptionPane.showMessageDialog(this, "Credit Card Number must be 16 digits.", "Credit Card Number Error", JOptionPane.ERROR_MESSAGE);
            //name errors
            }else if(nameTxtIn.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Name on Card cannot be empty.", "Name on Card Error", JOptionPane.ERROR_MESSAGE);
            }else if(!((name != null) && (!name.equals("")) && (name.matches("^[a-zA-Z]*$")))){ 
                JOptionPane.showMessageDialog(this, "Name on Card must only be characters A-Z.", "Name on Card Error", JOptionPane.ERROR_MESSAGE);
            //exp date errors
            }else if(expTxtIn.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Expiration Date cannot be empty", "Expiration Date Error", JOptionPane.ERROR_MESSAGE);
            // cvv errors
            }else if(cvvTxtIn.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Security Code cannot be empty", "Security Code Error", JOptionPane.ERROR_MESSAGE);
            }else if(!isNumeric(cvv)){ 
                JOptionPane.showMessageDialog(this, "Security Code must be a valid CVV", "Security Code Error", JOptionPane.ERROR_MESSAGE);
            }else if(cvv.length() != 3){ 
                JOptionPane.showMessageDialog(this, "Security Code must be a valid CVV", "Security Code Error", JOptionPane.ERROR_MESSAGE);
            }else{
                new Receipt().showReceipt(true);
                this.dispose();
            }
        } 
    }
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
}
