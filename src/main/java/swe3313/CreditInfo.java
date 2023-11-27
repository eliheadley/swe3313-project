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

        
        //Create logo using a icon
        try {
            InputStream stream1 = getClass().getResourceAsStream("/Lock.png");
                img1 = new JLabel(new ImageIcon(ImageIO.read(stream1)));
                img1.setBounds(44*w1p, h1p, 250, 250);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try {
           InputStream stream = getClass().getResourceAsStream("/Visa.png");
            img2 = new JLabel(new ImageIcon(ImageIO.read(stream)));
            img2.setBounds(21*w1p, 10*h1p, 250, 100);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try {
           InputStream stream = getClass().getResourceAsStream("/MasterCard.png");
            img3 = new JLabel(new ImageIcon(ImageIO.read(stream)));
            img3.setBounds(w1p, h1p, 250, 250);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

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
        title.setBounds((41*w1p), 25*h1p, 400, 50);
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
        this.add(img1);
        this.add(img2);
        this.add(img3);

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
            
            try{
                validateInput();
                new Receipt().showReceipt(true);
                this.dispose();
            }catch(InvalidInputException iie){
                JOptionPane.showMessageDialog(null, iie.getMessage(),"Ivalide input", JOptionPane.ERROR_MESSAGE);
            }catch(Exception ex){

            }
                
        } 
    }
    
    private boolean isNumeric(String strNum) {
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

    private void validateInput() throws InvalidInputException{
        cardNumber = cardTxtIn.getText();
        name = nameTxtIn.getText();
        name = name.replaceAll("\\s", "");
        exp = expTxtIn.getText();
        exp = exp.replaceAll("\\s", "/");
        cvv = cvvTxtIn.getText();
        
        if(cardTxtIn.getText().isEmpty()){
            throw new InvalidInputException("Credit Card Number cannot be empty.");
        }else if(!isNumeric(cardNumber)){
            throw new InvalidInputException("Credit Card Number must consist of only numbers.");
        }else if(cardNumber.length() != 16){
            throw new InvalidInputException("Name on Card cannot be empty.");
        }else if(nameTxtIn.getText().isEmpty()){
            throw new InvalidInputException("Name on Card cannot be empty.");
        }else if(!((name != null) && (!name.equals("")) && (name.matches("^[a-zA-Z]*$")))){
            throw new InvalidInputException("Name on Card must only be characters A-Z.");
        }else if(expTxtIn.getText().isEmpty()){
            throw new InvalidInputException("Expiration Date cannot be empty");
        }else if(cvvTxtIn.getText().isEmpty()){
            throw new InvalidInputException("Security Code cannot be empty");
        }else if(!isNumeric(cvv)){
            throw new InvalidInputException("Security Code must be a valid CVV");
        }else if(cvv.length() != 3){
            throw new InvalidInputException("Security Code must be a valid CVV");
        }else if(exp.length() != 5){
            throw new InvalidInputException("Expiration data must be 5 character data mm/yy");
        }
        for(int i = 0; i < exp.length(); i++){
            if(!(exp.charAt(i) >= 47 && exp.charAt(i) <= 57)){
                throw new InvalidInputException("Expiration data must only be 0-9 and /");
            }
        }
        
    }


    
}