package swe3313;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PizzaMenu extends Page implements ActionListener {
    JPanel toppingsPanel, leftPanel, vegetablesPanel, meatPanel, otherPanel;
    JLabel title, toppingsLabel, vegLabel, meatLabel, otherLabel, sizeLabel,  crustLabel, pricing1, pricing2;
    JCheckBox onionCheckbox, tomatoesCheckbox, mushroomCheckbox, pineapplesCheckbox, pepperoniCheckbox, sausageCheckbox, hamCheckbox,
    extraCheeseCheckbox, extraSauceCheckbox, smallCheckbox, mediumCheckbox, largeCheckbox, exLargeCheckbox, thinCheckbox,
    regularCheckbox, panCheckbox;
    Font font1, font2, titleFont, buttonFont, checkBoxFont;
    JButton continueButton, backButton, addToOrderButton;
    Pizza pizza;
    int pizzaCount;

    public PizzaMenu(){
        // intialize pizza counter
        pizzaCount = 0;
        //Create fonts for buttons and text
        font1 = new Font("Impact", Font.BOLD, 44);
        font2 = new Font("Impact", Font.BOLD, 34);
        titleFont = new Font("Impact", Font.BOLD, 64);
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        checkBoxFont = new Font("Impact", Font.PLAIN, 24);

        // create title
        title = new JLabel("Pizza Menu");
        title.setBounds((8*w5p), h5p, 30*w1p, 7*h1p);
        title.setFont(titleFont);
        
        //create the toppingsPanel and the leftPanel for crust and size
        toppingsLabel = new JLabel("Toppings:");
        toppingsLabel.setBounds(11*w5p, 6*h5p, 15*w1p, 7*h1p);
        toppingsPanel = new JPanel(new GridLayout(1, 3)); // Use a 1x3 grid layout
        toppingsPanel.setBounds(8*w5p, 7*h5p, 50*w1p, 30*h1p);
        leftPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); // Vertical layout
        leftPanel.setBounds(4*w5p, 6*h5p, 20*w1p, 55*h1p);


        // Create sub-panels for "Vegetables," "Meat," and "Other" using BoxLayout
        vegetablesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        vegetablesPanel.setPreferredSize(new Dimension(30*w1p, 10*h1p));
        vegetablesPanel.setBackground(Color.decode("#cccccc"));
        vegetablesPanel.setLayout(new BoxLayout(vegetablesPanel, BoxLayout.Y_AXIS)); // Vertical layout
        vegetablesPanel.setBorder(BorderFactory.createTitledBorder("Vegetables"));
        vegetablesPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10)); // Add some space

        meatPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        meatPanel.setPreferredSize(new Dimension(30*w1p, 10*h1p));
        meatPanel.setBackground(Color.decode("#cccccc"));
        meatPanel.setLayout(new BoxLayout(meatPanel, BoxLayout.Y_AXIS)); // Vertical layout
        meatPanel.setBorder(BorderFactory.createTitledBorder("Meat"));
        meatPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10)); // Add some space

        otherPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        otherPanel.setPreferredSize(new Dimension(30*w1p, 10*h1p));
        otherPanel.setBackground(Color.decode("#cccccc"));
        otherPanel.setLayout(new BoxLayout(otherPanel, BoxLayout.Y_AXIS)); // Vertical layout
        otherPanel.setBorder(BorderFactory.createTitledBorder("Other"));
        otherPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10)); // Add some space

         // Vegetables label
        vegLabel = new JLabel("Vegetables");
        vegetablesPanel.add(vegLabel);


         // Vegetables checkboxes
        onionCheckbox = new JCheckBox("Onion");
        onionCheckbox.setFont(checkBoxFont);
        tomatoesCheckbox = new JCheckBox("Tomatoes");
        tomatoesCheckbox.setFont(checkBoxFont);
        mushroomCheckbox = new JCheckBox("Mushroom");
        mushroomCheckbox.setFont(checkBoxFont);
        pineapplesCheckbox = new JCheckBox("Pineapples");
        pineapplesCheckbox.setFont(checkBoxFont);
        vegetablesPanel.add(onionCheckbox);
        vegetablesPanel.add(tomatoesCheckbox);
        vegetablesPanel.add(mushroomCheckbox);
        vegetablesPanel.add(pineapplesCheckbox);

        // Meat label
        meatLabel = new JLabel("Meat");
        meatPanel.add(meatLabel);

         // Meat checkboxes
        pepperoniCheckbox = new JCheckBox("Pepperoni");
        pepperoniCheckbox.setFont(checkBoxFont);
        sausageCheckbox = new JCheckBox("Sausage");
        sausageCheckbox.setFont(checkBoxFont);
        hamCheckbox = new JCheckBox("Ham");
        hamCheckbox.setFont(checkBoxFont);
        meatPanel.add(pepperoniCheckbox);
        meatPanel.add(sausageCheckbox);
        meatPanel.add(hamCheckbox);


        // Other label
        otherLabel = new JLabel("Other");
        otherPanel.add(otherLabel);

        // Other checkboxes
        extraCheeseCheckbox = new JCheckBox("Extra Cheese");
        extraCheeseCheckbox.setFont(checkBoxFont);
        extraSauceCheckbox = new JCheckBox("Extra Sauce");
        extraSauceCheckbox.setFont(checkBoxFont);
        otherPanel.add(extraCheeseCheckbox);
        otherPanel.add(extraSauceCheckbox);

        // Add the sub-panels to the right panel
        toppingsPanel.add(vegetablesPanel);
        toppingsPanel.add(meatPanel);
        toppingsPanel.add(otherPanel);

        // Size label
        sizeLabel = new JLabel("Size:");
        leftPanel.add(sizeLabel);

        //pricing labels
        pricing1 = new JLabel("- Pricing: $0.50, $0.75, $1, or $1.25 for 1+ toppings");
        pricing1.setFont(new Font("Impact", Font.PLAIN, 24));
        pricing1.setBounds(41*w1p, 72*h1p, 40*w1p, 7*h1p);

        pricing2 = new JLabel("depending on size");
        pricing2.setFont(new Font("Impact", Font.PLAIN, 24));
        pricing2.setBounds(42*w1p, 76*h1p, 20*w1p, 7*h1p);

        // Size checkboxes
        smallCheckbox = new JCheckBox("Small");
        smallCheckbox.setFont(checkBoxFont);
        smallCheckbox.addActionListener(this);
        mediumCheckbox = new JCheckBox("Medium");
        mediumCheckbox.setFont(checkBoxFont);
        mediumCheckbox.addActionListener(this);
        largeCheckbox = new JCheckBox("Large");
        largeCheckbox.setFont(checkBoxFont);
        largeCheckbox.addActionListener(this);
        exLargeCheckbox = new JCheckBox("Extra Large");
        exLargeCheckbox.addActionListener(this);
        exLargeCheckbox.setFont(checkBoxFont);
        leftPanel.add(smallCheckbox);
        leftPanel.add(mediumCheckbox);
        leftPanel.add(largeCheckbox);
        leftPanel.add(exLargeCheckbox);

        // Crust label
        crustLabel = new JLabel("Crust:");
        leftPanel.add(crustLabel);

        // Crust checkboxes
        thinCheckbox = new JCheckBox("Thin");
        thinCheckbox.setFont(checkBoxFont);
        thinCheckbox.addActionListener(this);
        regularCheckbox = new JCheckBox("Regular");
        regularCheckbox.setFont(checkBoxFont);
        regularCheckbox.addActionListener(this);
        panCheckbox = new JCheckBox("Pan");
        panCheckbox.setFont(checkBoxFont);
        panCheckbox.addActionListener(this);
        leftPanel.add(thinCheckbox);
        leftPanel.add(regularCheckbox);
        leftPanel.add(panCheckbox);

        // Changes the font name, style, and size for the labels
        crustLabel.setFont(font1);
        meatLabel.setFont(font2);
        otherLabel.setFont(font2);
        sizeLabel.setFont(font1);
        vegLabel.setFont(font2);
        //Change Toppings Label font
        toppingsLabel.setFont(font1);

        //create back button and set layout
        backButton = new JButton("Back");
        backButton.setBounds(w5p, h5p, 10*w1p,7*h1p);
        backButton.setBackground(Color.decode("#e06666"));
        backButton.setFont(buttonFont);
        backButton.addActionListener(this);
        //create continue button and set layout
        continueButton = new JButton("Continue");
        continueButton.setBounds(87*w1p,h5p,10*w1p, 7*h1p);
        continueButton.setBackground(Color.decode("#e06666"));
        continueButton.setFont(buttonFont);
        continueButton.addActionListener(this);
        //create addToOrderButton and set layout
        addToOrderButton = new JButton("Add to Order");
        addToOrderButton.setBounds(87*w1p,17*h5p,10*w1p, 7*h1p);
        addToOrderButton.setBackground(Color.decode("#e06666"));
        addToOrderButton.setFont(buttonFont);
        addToOrderButton.addActionListener(this);


        // set background for panels
        toppingsPanel.setBackground(Color.decode("#cccccc"));
        leftPanel.setBackground(Color.decode("#cccccc"));
        vegetablesPanel.setBackground(Color.decode("#cccccc"));
        meatPanel.setBackground(Color.decode("#cccccc"));
        otherPanel.setBackground(Color.decode("#cccccc"));

        //set back ground for checkboxes
        onionCheckbox.setBackground(Color.decode("#cccccc"));
        tomatoesCheckbox.setBackground(Color.decode("#cccccc"));
        mushroomCheckbox.setBackground(Color.decode("#cccccc"));
        pineapplesCheckbox.setBackground(Color.decode("#cccccc"));
        pepperoniCheckbox.setBackground(Color.decode("#cccccc"));
        sausageCheckbox.setBackground(Color.decode("#cccccc"));
        hamCheckbox.setBackground(Color.decode("#cccccc"));
        extraCheeseCheckbox.setBackground(Color.decode("#cccccc"));
        extraSauceCheckbox.setBackground(Color.decode("#cccccc"));
        smallCheckbox.setBackground(Color.decode("#cccccc"));
        mediumCheckbox.setBackground(Color.decode("#cccccc"));
        largeCheckbox.setBackground(Color.decode("#cccccc"));
        exLargeCheckbox.setBackground(Color.decode("#cccccc"));
        thinCheckbox.setBackground(Color.decode("#cccccc"));
        regularCheckbox.setBackground(Color.decode("#cccccc"));
        panCheckbox.setBackground(Color.decode("#cccccc"));

        // set content panel layout to null
        this.getContentPane().setLayout(null);
        //Adding contents to the frame
        this.add(title);
        this.add(toppingsLabel);
        this.add(pricing1);
        this.add(pricing2);
        this.add(toppingsPanel);
        this.add(leftPanel);
        this.add(backButton);
        this.add(continueButton);
        this.add(addToOrderButton);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        this.getContentPane().setBackground(Color.decode("#cccccc"));
    }

    //Implement action listener
    @Override
    public void actionPerformed(ActionEvent e){
       //Checkboxes
       if(e.getActionCommand().equals("Small")){
          if (smallCheckbox.isSelected()) {
                    mediumCheckbox.setSelected(false);
                    largeCheckbox.setSelected(false);
                    exLargeCheckbox.setSelected(false);
            }
       }else if(e.getActionCommand().equals("Medium")){
            if (mediumCheckbox.isSelected()) {
                smallCheckbox.setSelected(false);
                largeCheckbox.setSelected(false);
                exLargeCheckbox.setSelected(false);
            }
       }else if(e.getActionCommand().equals("Large")){
            if (largeCheckbox.isSelected()) {
                smallCheckbox.setSelected(false);
                mediumCheckbox.setSelected(false);
                exLargeCheckbox.setSelected(false);
             }

       }else if(e.getActionCommand().equals("Extra Large")){
            if (exLargeCheckbox.isSelected()) {
                smallCheckbox.setSelected(false);
                mediumCheckbox.setSelected(false);
                largeCheckbox.setSelected(false);
            }

       }else if(e.getActionCommand().equals("Thin")){
            if (thinCheckbox.isSelected()) {
                regularCheckbox.setSelected(false);
                panCheckbox.setSelected(false);
            }
       }else if(e.getActionCommand().equals("Regular")){
            if (regularCheckbox.isSelected()) {
                thinCheckbox.setSelected(false);
                panCheckbox.setSelected(false);
            }
       }else if(e.getActionCommand().equals("Pan")){
            if (panCheckbox.isSelected()) {
                thinCheckbox.setSelected(false);
                regularCheckbox.setSelected(false);
            }
       }else if(e.getActionCommand().equals("Back")){
           new MainPage().showMain(true);
           this.dispose();
       }else if(e.getActionCommand().equals("Continue")){
           new ExtrasMenu().showExtrasMenu(true);
           this.dispose();
       }else if(e.getActionCommand().equals("Add to Order")){
            ArrayList<String> vegToppings = new ArrayList<>();
            if (onionCheckbox.isSelected()) {
                vegToppings.add("onions");
            } if (tomatoesCheckbox.isSelected()) {
                vegToppings.add("tomatoes");
            } if (mushroomCheckbox.isSelected()) {
                vegToppings.add("mushrooms");
            } if (pineapplesCheckbox.isSelected()) {
                vegToppings.add("pineapple");
            }

            ArrayList<String> meatToppings = new ArrayList<>();
            if (pepperoniCheckbox.isSelected()) {
                meatToppings.add("pepperoni");
            } else if (sausageCheckbox.isSelected()) {
                meatToppings.add("sausage");
            } else if (hamCheckbox.isSelected()) {
                meatToppings.add("ham");
            }

            ArrayList<String> otherOption = new ArrayList<>();

            if (extraCheeseCheckbox.isSelected()) {
                otherOption.add("extra cheese");
            }if (extraSauceCheckbox.isSelected()) {
                otherOption.add("extra sauce");
            }

            String size = "";
            if (smallCheckbox.isSelected()) {
                size = "Small";
            } else if (mediumCheckbox.isSelected()) {
                size = "Medium";
            } else if (largeCheckbox.isSelected()) {
                size = "Large";
            } else if (exLargeCheckbox.isSelected()) {
                size = "XL";
            }


            String crust = "";
            if (thinCheckbox.isSelected()) {
                crust = "thin";
            } else if (regularCheckbox.isSelected()) {
                crust = "regular";
            } else if (panCheckbox.isSelected()) {
                crust = "pan";
            }

            //making the pizza object here
            pizza = new Pizza(size, crust, vegToppings, meatToppings, otherOption);
            System.out.println(pizza);

            pizzaCount++;      
       }
    }

    public void showPizzaMenu(boolean visible){
        if(visible){
           this.setVisible(true);
        }
    }


//    public static void printOrder(Pizza order){
//        System.out.println(order.size);
//        System.out.println(order.crust);
//
//        for (String t : order.toppingsVeg){
//            System.out.println(t);
//        }
//
//        for (String t : order.toppingsMeat){
//            System.out.println(t);
//        }
//    }
}
