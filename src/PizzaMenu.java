import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;

public class PizzaMenu extends Page implements ActionListener {
    JPanel toppingsPanel, leftPanel, vegetablesPanel, meatPanel, otherPanel;
    JLabel title, toppingsLabel, vegLabel, meatLabel, otherLabel, sizeLabel,  crustLabel;
    JCheckBox onionCheckbox, tomatoesCheckbox, mushroomCheckbox, pineapplesCheckbox, pepperoniCheckbox, sausageCheckbox, hamCheckbox,
    extraCheeseCheckbox, extraSauceCheckbox, smallCheckbox, mediumCheckbox, largeCheckbox, exLargeCheckbox, thinCheckbox,
    regularCheckbox, panCheckbox;
    Font font1, font2, titleFont, buttonFont, checkBoxFont;
    JButton continueButton, backButton, addToOrderButton;

    public PizzaMenu(){
        //Create fonts for buttons and text
        font1 = new Font("Impact", Font.BOLD, 44);
        font2 = new Font("Impact", Font.BOLD, 34);
        titleFont = new Font("Impact", Font.BOLD, 64);
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        checkBoxFont = new Font("Impact", Font.PLAIN, 24);

        // create title
        title = new JLabel("Pizza Menu");
        title.setBounds((8*w5p), h5p, 700, 60);
        title.setFont(titleFont);
        
        //create the toppingsPanel and the leftPanel for crust and size
        toppingsLabel = new JLabel("Toppings:");
        toppingsLabel.setBounds(11*w5p, 6*h5p, 200, 60);
        toppingsPanel = new JPanel(new GridLayout(1, 3)); // Use a 1x3 grid layout
        toppingsPanel.setBounds(8*w5p, 7*h5p, 900, 300);
        leftPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); // Vertical layout
        leftPanel.setBounds(4*w5p, 6*h5p, 150, 400);


        // Create sub-panels for "Vegetables," "Meat," and "Other" using BoxLayout
        vegetablesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        vegetablesPanel.setPreferredSize(new Dimension(300, 100));
        vegetablesPanel.setBackground(Color.decode("#cccccc"));
        vegetablesPanel.setLayout(new BoxLayout(vegetablesPanel, BoxLayout.Y_AXIS)); // Vertical layout
        vegetablesPanel.setBorder(BorderFactory.createTitledBorder("Vegetables"));
        vegetablesPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10)); // Add some space

        meatPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        meatPanel.setPreferredSize(new Dimension(300, 100));
        meatPanel.setBackground(Color.decode("#cccccc"));
        meatPanel.setLayout(new BoxLayout(meatPanel, BoxLayout.Y_AXIS)); // Vertical layout
        meatPanel.setBorder(BorderFactory.createTitledBorder("Meat"));
        meatPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10)); // Add some space

        otherPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        otherPanel.setPreferredSize(new Dimension(300, 100));
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

        // Size checkboxes
        smallCheckbox = new JCheckBox("Small");
        smallCheckbox.setFont(checkBoxFont);
        mediumCheckbox = new JCheckBox("Medium");
        mediumCheckbox.setFont(checkBoxFont);
        largeCheckbox = new JCheckBox("Large");
        largeCheckbox.setFont(checkBoxFont);
        exLargeCheckbox = new JCheckBox("Extra Large");
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
        regularCheckbox = new JCheckBox("Regular");
        regularCheckbox.setFont(checkBoxFont);
        panCheckbox = new JCheckBox("Pan");
        panCheckbox.setFont(checkBoxFont);
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
        backButton.setBounds(w5p, h5p, 150,50);
        backButton.setBackground(Color.decode("#e06666"));
        backButton.setFont(buttonFont);
        backButton.addActionListener(this);
        //create continue button and set layout
        continueButton = new JButton("Continue");
        continueButton.setBounds((17*w5p)+10,h5p,150,50);
        continueButton.setBackground(Color.decode("#e06666"));
        continueButton.setFont(buttonFont);
        continueButton.addActionListener(this);
        //create addToOrderButton and set layout
        addToOrderButton = new JButton("Add to Order");
        addToOrderButton.setBounds((17*w5p)+10,17*h5p,150,50);
        addToOrderButton.setBackground(Color.decode("#e06666"));
        addToOrderButton.setFont(buttonFont);


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
            this.dispose();
       }
    }

    public void showPizzaMenu(boolean visible){
        if(visible){
           this.setVisible(true);
        }

        /*  int pizzaCount = 0;

       do {
            ArrayList<String> vegToppings = new ArrayList<>();

            if (onionCheckbox.isSelected()) {
                vegToppings.add(String.valueOf(onionCheckbox));
            } else if (tomatoesCheckbox.isSelected()) {
                vegToppings.add(String.valueOf(tomatoesCheckbox));
            } else if (mushroomCheckbox.isSelected()) {
                vegToppings.add(String.valueOf(mushroomCheckbox));
            } else if (pineapplesCheckbox.isSelected()) {
                vegToppings.add(String.valueOf(pineapplesCheckbox));
            }

            ArrayList<String> meatToppings = new ArrayList<>();

            if (pepperoniCheckbox.isSelected()) {
                meatToppings.add(String.valueOf(pepperoniCheckbox));
            } else if (sausageCheckbox.isSelected()) {
                meatToppings.add(String.valueOf(sausageCheckbox));
            } else if (hamCheckbox.isSelected()) {
                meatToppings.add(String.valueOf(hamCheckbox));
            }

            ArrayList<String> otherOption = new ArrayList<>();

            if (extraCheeseCheckbox.isSelected()) {
                otherOption.add(String.valueOf(extraCheeseCheckbox));
            } else if (extraSauceCheckbox.isSelected()) {
                otherOption.add(String.valueOf(extraSauceCheckbox));
            }

            String size = "";
            if (smallCheckbox.isSelected()) {
                size = String.valueOf(smallCheckbox);
            } else if (mediumCheckbox.isSelected()) {
                size = String.valueOf(mediumCheckbox);
            } else if (largeCheckbox.isSelected()) {
                size = String.valueOf(largeCheckbox);
            } else if (exLargeCheckbox.isSelected()) {
                size = String.valueOf(exLargeCheckbox);
            }


            String crust = "";
            if (thinCheckbox.isSelected()) {
                crust = String.valueOf(thinCheckbox);
            } else if (regularCheckbox.isSelected()) {
                crust = String.valueOf(regularCheckbox);
            } else if (panCheckbox.isSelected()) {
                crust = String.valueOf(panCheckbox);
            }

            //making the pizza object here
            Pizza pizza = new Pizza(size, crust, vegToppings, meatToppings, otherOption);

            pizzaCount++;
        } while (addToOrderButton.isSelected() && pizzaCount < 11); */
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
