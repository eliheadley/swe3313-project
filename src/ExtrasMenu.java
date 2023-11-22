import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExtrasMenu extends Page implements ActionListener {
    JPanel rightPanel, drinkChoices, drinkSizes, leftPanel, pepsi_oragange, rtBeer_lemonade;
    JLabel drinksLabel, drinkSizeLabel, sidesLabel, title;
    JCheckBox pepsi, dietPepsi, orange, dietOrange, rootBeer, dietRB, sierraMist, lemonade, small,
    medium, large, breadSticks, breadSticksBites, cookie;
    JButton finishButton, backButton, addToOrderButton;
    Font font1, font2, titleFont, buttonFont, checkBoxFont;

    public ExtrasMenu(){
        //Create fonts for buttons and text
        font1 = new Font("Impact", Font.BOLD, 44);
        font2 = new Font("Impact", Font.BOLD, 34);
        titleFont = new Font("Impact", Font.BOLD, 64);
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        checkBoxFont = new Font("Impact", Font.PLAIN, 24);

        rightPanel = new JPanel(new GridLayout(2, 1)); // Use a 1x3 grid layout
        rightPanel.setBounds(8*w5p, 7*h5p, 900, 300);

        //sub panels
        drinkChoices = new JPanel(new GridLayout(1,2));
        drinkChoices.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10)); // Add some space
        //create sub panels for first drink column and second drink column
        pepsi_oragange = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pepsi_oragange.setLayout(new BoxLayout(pepsi_oragange, BoxLayout.Y_AXIS)); // Vertical layout
        rtBeer_lemonade = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rtBeer_lemonade.setLayout(new BoxLayout(rtBeer_lemonade, BoxLayout.Y_AXIS)); // Vertical layout

        drinkSizes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        drinkSizes.setLayout(new BoxLayout(drinkSizes, BoxLayout.Y_AXIS)); // Vertical layout
        drinkSizes.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

        drinksLabel = new JLabel("Drinks");
        this.add(drinksLabel);

        // create check boxes for drink menu
        pepsi = new JCheckBox("Pepsi");
        dietPepsi = new JCheckBox("Diet Pepsi");
        orange = new JCheckBox("Orange");
        dietOrange = new JCheckBox("Diet Orange");
        rootBeer = new JCheckBox("Root Beer");
        dietRB = new JCheckBox("Diet Root Beer");
        sierraMist = new JCheckBox("Sierra Mist");
        lemonade = new JCheckBox("Lemonade");

        drinkSizeLabel = new JLabel("Size");
        drinkSizes.add(drinkSizeLabel);

        small = new JCheckBox("Small");
        medium = new JCheckBox("Medium");
        large = new JCheckBox("Large");
        
        // add drink choice check boxes to panel
        pepsi_oragange.add(pepsi);
        pepsi_oragange.add(dietPepsi);
        pepsi_oragange.add(orange);
        pepsi_oragange.add(dietOrange);
        rtBeer_lemonade.add(rootBeer);
        rtBeer_lemonade.add(dietRB);
        rtBeer_lemonade.add(sierraMist);
        rtBeer_lemonade.add(lemonade);

        // add size check boxes to panel
        drinkSizes.add(small);
        drinkSizes.add(medium);
        drinkSizes.add(large);

        // add panels to their correct place
        drinkChoices.add(pepsi_oragange);
        drinkChoices.add(rtBeer_lemonade);
        rightPanel.add(drinkChoices);
        rightPanel.add(drinkSizes);

        // create left panel to hold sides
        leftPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); // Vertical layout
        leftPanel.setBounds(4*w5p, 6*h5p, 150, 400);

        // create lable for sides and add to panel
        sidesLabel = new JLabel("Sides");
        leftPanel.add(sidesLabel);

        // create checkboxes for side options
        breadSticks = new JCheckBox("Bread Sticks");
        breadSticksBites = new JCheckBox("Bread Sticks Bites");
        cookie = new JCheckBox("Big Chocolate Chip Cookie");

        // checkboxes to left panel
        leftPanel.add(breadSticks);
        leftPanel.add(breadSticksBites);
        leftPanel.add(cookie);

        //create finish button and set layout
        finishButton = new JButton("Finish");
        finishButton.setBounds((17*w5p)+10,h5p,150,50);
        finishButton.setBackground(Color.decode("#e06666"));
        finishButton.setFont(buttonFont);
        finishButton.addActionListener(this);
        //create back button and set layout
        backButton = new JButton("Back");
        backButton.setBounds(w5p, h5p, 150,50);
        backButton.setBackground(Color.decode("#e06666"));
        backButton.setFont(buttonFont);
        backButton.addActionListener(this);
        //create addToOrderButton and set layout
        addToOrderButton = new JButton("Add to Order");
        addToOrderButton.setBounds((17*w5p)+10,17*h5p,150,50);
        addToOrderButton.setBackground(Color.decode("#e06666"));
        addToOrderButton.setFont(buttonFont);

        // create title
        title = new JLabel("Extras");
        title.setFont(titleFont);
        title.setBounds((9*w5p), h5p, 500, 60);



        this.getContentPane().setLayout(null);
        this.add(title);
        this.add(backButton);
        this.add(finishButton);
        this.add(addToOrderButton);
        this.add(rightPanel);
        this.add(leftPanel);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.decode("#cccccc"));

    }
    
    public void showExtrasMenu(boolean visible){
        if(visible){
            this.setVisible(true);
         }
 
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //Checkboxes
        if(e.getActionCommand().equals("Back")){
            new PizzaMenu().showPizzaMenu(true);
            this.dispose();
        }
    }
}