package swe3313;

import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class PrintedReceipt extends Page implements ActionListener{
    String myTip;
    JLabel img, title, mainInfo, address, otherInfo, label1, label2, label3, name, number, userAddress, dMethod, etod, username, phoneNumber, userDMethod, userEtod, line1, line2, line3, tip, total, signature, date;
    JPanel infoPanel, userInfoPanel, myUserInfoPanel, orderPanel;
    Font subTitleFont, textFont, titleFont, infoFont;
    JTextArea pizzaItem, drinkItem, sidesItem, pizzaQty, pizzaPrice, pizzaTotal, sideQty, sidePrice, sideTotal,
    drinkQty, drinkPrice, drinkTotal;
    Drink drinks;
    Sides sides;
    Pizza pizza;
    String[] user;
    Database db;

    public PrintedReceipt(){
        subTitleFont = new Font("Impact", Font.PLAIN, 24);
        textFont = new Font("Impact", Font.PLAIN, 20);
        titleFont = new Font("Impact", Font.BOLD, 52);
        infoFont = new Font("Impact", Font.PLAIN, 14);

        // create title
        title = new JLabel("Mom and Pop's Pizza Shop Receipt");
        title.setBounds(30*w1p, 5*h1p, 60*w1p, 8*h1p);
        title.setFont(titleFont);

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

        //make user info panel
        userInfoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 225, 0));
        userInfoPanel.setBounds(4*w1p, 20*h1p, 90*w1p, 3*h1p);
        userInfoPanel.setBackground(Color.decode("#cccccc")); 
        name = new JLabel("Name");
        name.setFont(textFont);
        number = new JLabel("Phone Number");
        number.setFont(textFont);
        address = new JLabel("Address");
        address.setFont(textFont);
        dMethod = new JLabel("Delivery Method");
        dMethod.setFont(textFont);
        etod = new JLabel("Estimated Time of Delivery");
        etod .setFont(textFont);
        //add labels to panel
        userInfoPanel.add(name);
        userInfoPanel.add(number);
        userInfoPanel.add(address);
        userInfoPanel.add(dMethod);
        userInfoPanel.add(etod);

        //make myUser info panel
        myUserInfoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 275, 0));
        myUserInfoPanel.setBounds(w1p, 25*h1p, 90*w1p, 3*h1p);
        myUserInfoPanel.setBackground(Color.decode("#cccccc"));
        //make labels for myUser info 
        try{
            user = new Database().getUser("6789534496"/*currentOrder.getPhoneNumber()*/);
            username = new JLabel("Test");
            phoneNumber = new JLabel("Test");
            userAddress = new JLabel("Test");

        }catch(NullPointerException npe){
            username = new JLabel("");
            phoneNumber = new JLabel("");
            userAddress = new JLabel("");
        }
        userDMethod = new JLabel(currentOrder.deliveryMethod);
        userEtod = new JLabel("30 Minutes");
        //set font for myUser labels
        username.setFont(textFont);
        phoneNumber.setFont(textFont);
        userAddress.setFont(textFont);
        userDMethod.setFont(textFont);
        userEtod.setFont(textFont);
        //add labels to panel
        myUserInfoPanel.add(username);
        myUserInfoPanel.add(phoneNumber);
        myUserInfoPanel.add(userAddress);
        myUserInfoPanel.add(userDMethod);
        myUserInfoPanel.add(userEtod);

        // make Order item label
        label2 = new JLabel("Order Item(s)");
        label2.setFont(subTitleFont);
        label2.setBounds(2*w1p, 6*h1p, w1p, h1p);

        //make quantity info label
        label3 = new JLabel("Qty                        Each                       Total");
        label3.setFont(subTitleFont);
        label3.setBounds(14*w1p, 6*h1p, w1p, h1p);
        
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
        tip = new JLabel("Tip: $" + currentOrder.tip);
        tip.setFont(subTitleFont);
        tip.setBounds(81*w1p, 76*h1p, 9*w1p, 4*h1p);
        
        //make order total label
        total = new JLabel("Current Total: $" + currentOrder.calcCost());
        total.setFont(subTitleFont);
        total.setBounds(76*w1p, 81*h1p, 30*w1p, 3*h1p);

        //make signature label
        signature = new JLabel("Signature    " + currentOrder.signature);
        signature.setFont(subTitleFont);
        signature.setBounds(10*w1p, 85*h1p, 20*w1p, 3*h1p);

        //Make signature line
        line3 = new JLabel();
        line3.setBounds(16*w1p, 88*h1p, 58*w1p, 2);
        line3.setBorder(border);

        //make date and time label
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/uuuu HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        date = new JLabel("Date: " + dtf.format(now));
        date.setFont(subTitleFont);
        date.setBounds(75*w1p, 85*h1p, 30*w1p, 3*h1p);

        
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
            
            drinks = currentOrder.getDrinks();
            //make drink text
            String drinkDesc = "";
            drinkDesc += drinks.getDrinks();
            drinkItem.setText(drinkDesc);
            drinkQty.setText(drinks.getDrinkQty());
            drinkPrice.setText(drinks.getDrinkCost());
            drinkTotal.setText(drinks.getDrinkCost());
        }catch(NullPointerException npe){
            sidesItem.setText("");
            drinkItem.setText("");
        }
        
        //add elements for Receipt
        this.add(title);
        this.add(infoPanel);
        this.add(label1);
        this.add(line1);
        this.add(userInfoPanel);
        this.add(myUserInfoPanel);
        this.add(label2);
        this.add(label3);
        this.add(line2);
        this.add(pizzaItem);
        this.add(sidesItem);
        this.add(drinkItem);
        this.add(total);
        this.add(tip);
        this.add(signature);
        this.add(line3);
        this.add(date);

        // set the layout for the frame
        this.getContentPane().setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        this.getContentPane().setBackground(Color.decode("#cccccc"));
    }

    public void showPrintedReceipt(boolean visible){
        if(visible){
           this.setVisible(true);
       }
    }

    @Override
     public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Print Receipt")){
           
            
        }

    }
}