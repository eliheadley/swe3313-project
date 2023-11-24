package swe3313;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Calendar;

public class CreditInfo extends Page implements ActionListener {
    String cardNumber, name, exp, cvv;
    //Create textfields
    JTextField cardTxtIn, nameTxtIn, expTxtIn, cvvTxtIn;
    JPanel creditInfoPanel1, creditInfoPanel2;
    JLabel title, cardLabel, nameLabel, expLabel, cvvLabel;
    Font font, textFont, titleFont, buttonFont;
    //Create buttons
    JButton payNow;
    public CreditInfo(){
        font = new Font("Impact", Font.PLAIN, 18);
        textFont = new Font("Roboto Serif", Font.PLAIN, 18);
        titleFont = new Font("Impact", Font.PLAIN, 28);
        buttonFont = new Font("Impact", Font.PLAIN, 20);

        /*  !!! Create logo using a icon
        img = new JLabel(new ImageIcon("C:/Users/elihe/OneDrive/projects/swe3313-project/images/Mom & Pizza.png"));
        img.setBounds((7*w5p), 3*h5p, 438, 438);
        this.add(img); */

        //Create text fields to input data
        cardTxtIn = new JTextField();
        cardTxtIn.setFont(textFont);
        //cardTxtIn.setBounds((7*w5p)+40, 7*h5p, 400, 50);

        nameTxtIn = new JTextField();
        nameTxtIn.setFont(textFont);
        //nameTxtIn.setBounds((7*w5p)+40, 10*h5p, 400, 50);

        expTxtIn = new JTextField();
        expTxtIn.setFont(textFont);
        //expTxtIn.setBounds((7*w5p)+40, 10*h5p, 400, 50);

        cvvTxtIn = new JTextField();
        cvvTxtIn.setFont(textFont);
        //cvvTxtIn.setBounds((7*w5p)+40, 10*h5p, 400, 50);

        //Create labels
        title = new JLabel("Secure Credit Card Payment");
        title.setBounds((8*w5p)+15, 3*h5p, 400, 50);
        title.setFont(titleFont);

        cardLabel = new JLabel("Credit Card Number");
        cardLabel.setBounds((6*w5p)+5,6*h5p,250,50);
        cardLabel.setFont(font);

        nameLabel = new JLabel("Name on Card");
        nameLabel.setBounds((11*w5p)+5, 6*h5p,250,50);
        nameLabel.setFont(font);

        expLabel = new JLabel("Expiration Date");
        expLabel.setBounds((6*w5p)+5,9*h5p,250,50);
        expLabel.setFont(font);

        cvvLabel = new JLabel("Security Code");
        cvvLabel.setBounds((11*w5p)+5,9*h5p,250,50);
        cvvLabel.setFont(font);

        //Create payNow button
        payNow = new JButton("Pay Now");
        payNow.setBounds((9*w5p)+20, 13*h5p, 150, 50);//x axis, y axis, width, height
        payNow.setBackground(Color.decode("#e06666"));
        payNow.setFont(buttonFont); 
        payNow.addActionListener(this);   
                
        this.getContentPane().setLayout(null);

        creditInfoPanel1 = new JPanel(new GridLayout(1,1, 75, 0));
        creditInfoPanel1.setBounds(6*w5p, 7*h5p, 650, 50);
        creditInfoPanel1.setBackground(Color.decode("#cccccc"));

        creditInfoPanel2 = new JPanel(new GridLayout(1,1, 75, 0));
        creditInfoPanel2.setBounds(6*w5p, 10*h5p, 650, 50);
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
            
            int month = Integer.parseInt(exp.substring(exp.indexOf("/")-2,exp.indexOf("/")));
            int year = Integer.parseInt(exp.substring(exp.indexOf("/"), exp.indexOf("/")+2));
            Calendar today = Calendar.getInstance();
            int todaysMonth = today.MONTH;
            cvv = cvvTxtIn.getText();

            //null errors
            if(cardTxtIn.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Credit Card Number cannot be empty.", "Credit Card Number Error", JOptionPane.ERROR_MESSAGE);
            }else if(!isNumeric(cardNumber)){
                JOptionPane.showMessageDialog(this, "Credit Card Number must consist of only numbers.", "Credit Card Number Error", JOptionPane.ERROR_MESSAGE);
            }else if(nameTxtIn.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Name on Card cannot be empty.", "Name on Card Error", JOptionPane.ERROR_MESSAGE);
            } else if(expTxtIn.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Expiration Date cannot be empty", "Expiration Date Error", JOptionPane.ERROR_MESSAGE);
            } else if(cvvTxtIn.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Security Code cannot be empty", "Securit Code Error", JOptionPane.ERROR_MESSAGE);
            }  //card length error
            else if(cardNumber.length() != 16){ 
                JOptionPane.showMessageDialog(this, "Credit Card Number must be 16 digits.", "Credit Card Number Error", JOptionPane.ERROR_MESSAGE);
            } //invalid name error
            else if(!((name != null) && (!name.equals("")) && (name.matches("^[a-zA-Z]*$")))){ 
                JOptionPane.showMessageDialog(this, "Name on Card must only be characters A-Z.", "Name on Card Error", JOptionPane.ERROR_MESSAGE);
            } // invalid exp date error
            else if(month < 1 || month > 12){ 
                JOptionPane.showMessageDialog(this, "Expiration Date must be a valid date", "Expiration Date Error", JOptionPane.ERROR_MESSAGE);
             // invalid cvv error
            }else if(month < todaysMonth && year < 2023){ 
                JOptionPane.showMessageDialog(this, "Card is Expired.", "Expiration Date Error", JOptionPane.ERROR_MESSAGE);
             // invalid cvv error
            }else if(cvv == null){ 
                JOptionPane.showMessageDialog(this, "Security Code must be a valid CVV", "Securit Code Error", JOptionPane.ERROR_MESSAGE);
            } // go to receipt
            else{ 
                new PaymentMethod().showPaymentMethod(true);
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
