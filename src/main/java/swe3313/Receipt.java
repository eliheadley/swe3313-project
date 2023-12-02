package swe3313;

import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class Receipt extends Page implements ActionListener{
    Double myTip;
    JLabel img, title, mainInfo, address, otherInfo, label1, label2, label3, name, number, dMethod, etod, username, phoneNumber, userDMethod, userEtod, line1, line2, line3, tip, total, signature, date;
    JTextArea userAddress;
    JPanel infoPanel, orderPanel;
    Font buttonFont, subTitleFont, textFont, titleFont, infoFont;
    JTextArea pizzaItem, drinkItem, sidesItem, pizzaQty, pizzaPrice, pizzaTotal, sideQty, sidePrice, sideTotal,
    drinkQty, drinkPrice, drinkTotal;
    JTextField tipTxt, sigTxt;
    JButton backButton, tipButton;
    Drink drinks;
    Sides sides;
    Pizza pizza;
    String[] user;
    Database db;

    public Receipt(){
        subTitleFont = new Font("Impact", Font.PLAIN, 24);
        textFont = new Font("Impact", Font.PLAIN, 20);
        titleFont = new Font("Impact", Font.BOLD, 52);
        infoFont = new Font("Impact", Font.PLAIN, 14);
        buttonFont = new Font("Impact", Font.PLAIN, 20);

        // create title
        title = new JLabel("Mom and Pop's Pizza Shop Receipt");
        title.setBounds(30*w1p, 5*h1p, 60*w1p, 8*h1p);
        title.setFont(titleFont);

        //back button
        backButton = new JButton("Back");
        backButton.setBounds(w5p, h5p, 10*w1p,7*h1p);
        backButton.setBackground(Color.decode("#e06666"));
        backButton.setFont(buttonFont);
        backButton.addActionListener(this);
        this.add(backButton);

        // make labels for restuaurant info
        mainInfo = new JLabel("680 Arntson Rd, Suite 161 Marietta, GA 30060");
        mainInfo.setFont(infoFont);
        otherInfo = new JLabel("MomAndPopPizzeria.com  |  770 555-1212");
        otherInfo.setFont(infoFont);

        // make Address Info panel
        infoPanel = new JPanel();
        infoPanel.setBounds(40*w1p, 12*h1p, 20*w1p, 7*h1p);
        infoPanel.setBackground(Color.decode("#cccccc"));
        infoPanel.add(mainInfo);
        infoPanel.add(otherInfo);

        //Make first separator line
        line1 = new JLabel();
        line1.setBounds(10*w1p, 23*h1p, 79*w1p, 3);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 10);
        line1.setBorder(border);
        
        // make customer info label
        label1 = new JLabel("Customer Info");
        label1.setFont(subTitleFont);
        label1.setBounds(10*w1p, 15*h1p, 10*w1p, 3*w1p);

        // make headers for all customer info
        name = new JLabel("Name");
        name.setBounds(12*w1p, 18*h1p, 6*w1p, 6*h1p);
        name.setFont(textFont);

        number = new JLabel("Phone Number");
        number.setBounds(24*w1p, 18*h1p, 10*w1p, 6*h1p);
        number.setFont(textFont);
        address = new JLabel("Address");
        address.setBounds(44*w1p, 18*h1p, 15*w1p, 6*h1p);
        address.setFont(textFont);
        dMethod = new JLabel("Delivery Method");
        dMethod.setBounds(58*w1p, 18*h1p, 10*w1p, 6*h1p);
        dMethod.setFont(textFont);
        String s = "Estimated Time of Delivery";
        try{
            if(currentOrder.deliveryMethod.equalsIgnoreCase("pickup")){
                s = "Estimated Time for Pickup";
            }
        } catch(NullPointerException npe)
        {
            s = "";
        }
        
        etod = new JLabel(s);
        etod.setBounds(74*w1p, 18*h1p, 15*w1p, 6*h1p);
        etod .setFont(textFont);
        //add labels to panel
        this.add(name);
        this.add(number);
        this.add(address);
        this.add(dMethod);
        this.add(etod);

        //make labels for myUser info 
        try{
            user = new Database().getUser(currentOrder.getPhoneNumber());
            String name = "";
            name += user[2] + " ";
            name += user[3];
            username = new JLabel(name);
            username.setBounds(12*w1p, 26*h1p, 10*w1p, 6*h1p);
            phoneNumber = new JLabel(user[0]);
            phoneNumber.setBounds(24*w1p, 26*h1p, 10*w1p, 6*h1p);
            userAddress = new JTextArea(user[5]);
            userAddress.setLineWrap(true);
            userAddress.setBackground(Color.decode("#cccccc"));
            userAddress.setBounds(36*w1p, 27*h1p, 20*w1p, 8*h1p);

        }catch(NullPointerException npe){
            username = new JLabel("");
            phoneNumber = new JLabel("");
            userAddress = new JTextArea("");
        }
        userDMethod = new JLabel(currentOrder.deliveryMethod);
        userDMethod.setBounds(60*w1p, 26*h1p, 15*w1p, 6*h1p);
        userEtod = new JLabel("30 Minutes");
        userEtod.setBounds(76*w1p, 26*h1p, 15*w1p, 6*h1p);
        //set font for myUser labels
        username.setFont(textFont);
        phoneNumber.setFont(textFont);
        userAddress.setFont(textFont);
        userDMethod.setFont(textFont);
        userEtod.setFont(textFont);

        this.add(username);
        this.add(phoneNumber);
        this.add(userAddress);
        this.add(userDMethod);
        this.add(userEtod);



        // make Order item label
        label2 = new JLabel("Order Item(s)");
        label2.setFont(subTitleFont);
        label2.setBounds(2*w1p, 6*h1p, w1p, h1p);

        //make quantity info label
        label3 = new JLabel("Qty                        Each                       Total");
        label3.setFont(subTitleFont);
        label3.setBounds(14*w1p, 6*h1p, w1p, h1p);
        this.add(label3);
        
        //Make second separator line
        line2 = new JLabel();
        line2.setBounds(10*w1p, 36*h1p, 79*w1p, 3);
        line2.setBorder(border);

        // make text areas to display order items on the screen
        //pizza text area
        pizzaItem = new JTextArea();
        pizzaItem.setLineWrap(true);
        pizzaItem.setBounds(10*w1p, 40*h1p, 40*w1p, 7*h1p);
        pizzaItem.setFont(textFont);
        pizzaItem.setBackground(Color.decode("#cccccc"));
            //make smaller text areas to hold numbers
            pizzaQty = new JTextArea("");
            pizzaQty.setBounds(71*w1p, 40*h1p, 2*w1p, 4*h1p);
            pizzaQty.setFont(textFont);
            pizzaQty.setBackground(Color.decode("#cccccc"));
            this.add(pizzaQty);

            pizzaPrice = new JTextArea("");
            pizzaPrice.setBounds(77*w1p, 40*h1p, 6*w1p, 4*h1p);
            pizzaPrice.setFont(textFont);
            pizzaPrice.setBackground(Color.decode("#cccccc"));
            this.add(pizzaPrice);

            pizzaTotal = new JTextArea("");
            pizzaTotal.setBounds(85*w1p, 40*h1p, 9*w1p, 4*h1p);
            pizzaTotal.setFont(textFont);
            pizzaTotal.setBackground(Color.decode("#cccccc"));
            this.add(pizzaTotal);
        //side text area
        sidesItem = new JTextArea();
        sidesItem.setBounds(10*w1p, 50*h1p, 38*w1p, 7*h1p);
        sidesItem.setFont(textFont);
        sidesItem.setBackground(Color.decode("#cccccc"));
            //make smaller text areas to hold numbers
            sideQty = new JTextArea("");
            sideQty.setBounds(71*w1p, 50*h1p, 2*w1p, 4*h1p);
            sideQty.setFont(textFont);
            sideQty.setBackground(Color.decode("#cccccc"));
            this.add(sideQty);

            sidePrice = new JTextArea("");
            sidePrice.setBounds(77*w1p, 50*h1p, 6*w1p, 4*h1p);
            sidePrice.setFont(textFont);
            sidePrice.setBackground(Color.decode("#cccccc"));
            this.add(sidePrice);

            sideTotal = new JTextArea("");
            sideTotal.setBounds(85*w1p, 50*h1p, 9*w1p, 4*h1p);
            sideTotal.setFont(textFont);
            sideTotal.setBackground(Color.decode("#cccccc"));
            this.add(sideTotal);


        //drink text area
        drinkItem = new JTextArea();
        drinkItem.setBounds(10*w1p, 60*h1p, 38*w1p, 7*h1p);
        drinkItem.setFont(textFont);
        drinkItem.setBackground(Color.decode("#cccccc"));
            //make smaller text areas to hold numbers
            drinkQty = new JTextArea("");
            drinkQty.setBounds(71*w1p, 60*h1p, 2*w1p, 4*h1p);
            drinkQty.setFont(textFont);
            drinkQty.setBackground(Color.decode("#cccccc"));
            this.add(drinkQty);

            drinkPrice = new JTextArea("");
            drinkPrice.setBounds(77*w1p, 60*h1p, 6*w1p, 4*h1p);
            drinkPrice.setFont(textFont);
            drinkPrice.setBackground(Color.decode("#cccccc"));
            this.add(drinkPrice);

            drinkTotal = new JTextArea("");
            drinkTotal.setBounds(85*w1p, 60*h1p, 9*w1p, 4*h1p);
            drinkTotal.setFont(textFont);
            drinkTotal.setBackground(Color.decode("#cccccc"));
            this.add(drinkTotal);

        //make tip label
        tip = new JLabel("Tip: $");
        tip.setFont(subTitleFont);
        tip.setBounds(76*w1p, 76*h1p, 9*w1p, 4*h1p);

        //make tip text field
        tipTxt = new JTextField();
        tipTxt.setFont(textFont);
        tipTxt.setBounds(80*w1p, 76*h1p, 9*w1p, 4*h1p);

        //add print receipt button
        tipButton = new JButton("Print Receipt");
        tipButton.setBounds(77*w1p, 90*h1p, 12*w1p, 6*h1p);//x axis, y axis, width, height
        tipButton.setBackground(Color.decode("#e06666"));
        tipButton.setFont(new Font("Impact", Font.PLAIN, 20)); 
        tipButton.addActionListener(this);
        
        //make order total label
        try{
            total = new JLabel("Current Total: " + currentOrder.getCost());
        } catch(NullPointerException npe){
            total = new JLabel("");
        }

        total.setFont(subTitleFont);
        total.setBounds(76*w1p, 81*h1p, 30*w1p, 3*h1p);

        //make signature label
        signature = new JLabel("Signature");
        signature.setFont(subTitleFont);
        signature.setBounds(8*w1p, 85*h1p, 7*w1p, 3*h1p);

        //make singature text field
        sigTxt = new JTextField();
        sigTxt.setFont(textFont);
        sigTxt.setBounds(16*w1p, 84*h1p, 58*w1p, 4*h1p);
        sigTxt.setBackground(Color.decode("#cccccc"));

        //Make signature line
        line3 = new JLabel();
        line3.setBounds(16*w1p, 88*h1p, 58*w1p, 2);
        line3.setBorder(border);

        //make date and time label
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/uuuu HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        date = new JLabel("Date: " + dtf.format(now));
        date.setFont(subTitleFont);
        date.setBounds(76*w1p, 85*h1p, 30*w1p, 3*h1p);

        
        // make pizza object to be displayed on the screen
        try{           
            pizza = currentOrder.getPizzas();
            String pizzaDesc = "";
            pizzaDesc += pizza.toString();
            pizzaItem.setText(pizzaDesc);
            pizzaQty.setText(pizza.getQty());
            pizzaPrice.setText(pizza.getCost());
            pizzaTotal.setText(pizza.getCost());

        }catch(NullPointerException npe){
            pizzaItem.setText("");
        }
        
         // make extras object to be displayed on the screen
         try{
            sides = currentOrder.getSides();
            //make sides text
            String sideDesc = "";
            sideDesc += sides.getSides();
            sidesItem.setText(sideDesc);
            sideQty.setText(sides.getSideQty());
            sidePrice.setText(sides.getSideCost());
            sideTotal.setText(sides.getSideCost());
            
            
        }catch(NullPointerException npe){
            sidesItem.setText("");
        }

        try{
            drinks = currentOrder.getDrinks();
            //make drink text
            String drinkDesc = "";
            drinkDesc += drinks.getDrinks();
            drinkItem.setText(drinkDesc);
            drinkQty.setText(drinks.getDrinkQty());
            drinkPrice.setText(drinks.getDrinkCost());
            drinkTotal.setText(drinks.getDrinkCost());
        }catch(NullPointerException npe){
            drinkItem.setText("");
        }
        
        //add elements for Receipt
        this.add(title);
        this.add(infoPanel);
        this.add(label1);
        this.add(line1);
        this.add(label2);
        this.add(line2);
        this.add(pizzaItem);
        this.add(sidesItem);
        this.add(drinkItem);
        this.add(total);
        this.add(tip);
        this.add(tipTxt);
        this.add(tipButton);
        this.add(signature);
        this.add(sigTxt);
        this.add(line3);
        this.add(date);

        // set the layout for the frame
        this.getContentPane().setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        this.getContentPane().setBackground(Color.decode("#cccccc"));
    }

    public void showReceipt(boolean visible){
        if(visible){
           this.setVisible(true);
       }
    }

    @Override
     public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Print Receipt")){
            try{
                validate(tipTxt.getText());
                currentOrder.setSignature(sigTxt.getText());
                myTip =  Double.parseDouble(tipTxt.getText());
                currentOrder.setTip(myTip);
                new PrintedReceipt().showPrintedReceipt(true);
                this.dispose();

            }catch(InvalidInputException iie){
                JOptionPane.showMessageDialog(this, iie.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
            
        }else if(e.getActionCommand().equals("Back")){
            new DeliveryMethod().showDeliveryMethod(true);
            this.dispose();
        }

    }

    // validate tip input
    private void validate(String tip) throws InvalidInputException {
        for(int i = 0; i < tip.length(); i++){
            if(!(tip.charAt(i) >= 48 && tip.charAt(i) <= 57 || tip.charAt(i) == 46)){
                throw new InvalidInputException("Tip should be a decimal number: 00.00");
            }
        }
        double numTip = Double.parseDouble(tip);
        if(numTip < 0){
            throw new InvalidInputException("Tip must be positive: 00.00");
        }
        if(sigTxt.getText().isEmpty()){
            throw new InvalidInputException("Please Sign");
        }
    }
}