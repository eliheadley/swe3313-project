package swe3313;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ExtrasMenu extends Page implements ActionListener {
    JPanel rightPanel, drinkChoices, drinkSizes, leftPanel, pepsi_oragange, rtBeer_lemonade;
    JLabel drinksLabel, drinkSizeLabel, sidesLabel, title, pricing;
    JCheckBox pepsi, dietPepsi, orange, dietOrange, rootBeer, dietRB, sierraMist, lemonade, small,
    medium, large, breadSticks, breadSticksBites, cookie;
    JButton finishButton, backButton;
    Font font1, font2, titleFont, buttonFont, checkBoxFont;

    public ExtrasMenu(){
        //Create fonts for buttons and text
        font1 = new Font("Impact", Font.BOLD, 44);
        font2 = new Font("Impact", Font.BOLD, 34);
        titleFont = new Font("Impact", Font.BOLD, 64);
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        checkBoxFont = new Font("Impact", Font.PLAIN, 24);

        rightPanel = new JPanel(new GridLayout(2, 1)); // Use a 1x3 grid layout
        rightPanel.setBounds(8*w5p, 7*h5p, 50*w1p, 45*h1p);

        //sub panels
        drinkChoices = new JPanel(new GridLayout(1,2));
        drinkChoices.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10)); // Add some space
        drinkChoices.setPreferredSize(new Dimension(10*w1p, 20*h1p));
        drinkChoices.setBackground(Color.decode("#cccccc"));
        //create sub panels for first drink column and second drink column
        pepsi_oragange = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pepsi_oragange.setBackground(Color.decode("#cccccc"));
        pepsi_oragange.setLayout(new BoxLayout(pepsi_oragange, BoxLayout.Y_AXIS)); // Vertical layout
        rtBeer_lemonade = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rtBeer_lemonade.setBackground(Color.decode("#cccccc"));
        rtBeer_lemonade.setLayout(new BoxLayout(rtBeer_lemonade, BoxLayout.Y_AXIS)); // Vertical layout

        drinkSizes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        drinkSizes.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        drinkSizes.setBackground(Color.decode("#cccccc"));

        drinksLabel = new JLabel("Drinks:");
        drinksLabel.setFont(font1);
        drinksLabel.setBounds(41*w1p, 5*h5p, 30*w1p, 10*h1p);

        // create check boxes for drink menu
        pepsi = new JCheckBox("Pepsi");
        pepsi.setFont(checkBoxFont);
        pepsi.addActionListener(this);
        dietPepsi = new JCheckBox("Diet Pepsi");
        dietPepsi.setFont(checkBoxFont);
        dietPepsi.addActionListener(this);
        orange = new JCheckBox("Orange");
        orange.setFont(checkBoxFont);
        orange.addActionListener(this);
        dietOrange = new JCheckBox("Diet Orange");
        dietOrange.setFont(checkBoxFont);
        dietOrange.addActionListener(this);
        rootBeer = new JCheckBox("Root Beer");
        rootBeer.setFont(checkBoxFont);
        rootBeer.addActionListener(this);
        dietRB = new JCheckBox("Diet Root Beer");
        dietRB.setFont(checkBoxFont);
        dietRB.addActionListener(this);
        sierraMist = new JCheckBox("Sierra Mist");
        sierraMist.setFont(checkBoxFont);
        sierraMist.addActionListener(this);
        lemonade = new JCheckBox("Lemonade");
        lemonade.setFont(checkBoxFont);
        lemonade.addActionListener(this);

        drinkSizeLabel = new JLabel("Size:  ");
        drinkSizeLabel.setFont(font1);
        drinkSizes.add(drinkSizeLabel);

        small = new JCheckBox("Small  ");
        small.setFont(checkBoxFont);
        small.addActionListener(this);
        medium = new JCheckBox("Medium  ");
        medium.setFont(checkBoxFont);
        medium.addActionListener(this);
        large = new JCheckBox("Large  ");
        large.setFont(checkBoxFont);
        large.addActionListener(this);
        
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
        leftPanel.setBounds(2*w5p, 6*h5p, 30*w1p, 50*h1p);

        // create lable for sides and add to panel
        sidesLabel = new JLabel("Sides:");
        sidesLabel.setFont(font1);
        leftPanel.add(sidesLabel);

        // create checkboxes for side options
        breadSticks = new JCheckBox("Bread Sticks $4");
        breadSticks.setFont(checkBoxFont);
        breadSticksBites = new JCheckBox("Bread Sticks Bites $2");
        breadSticksBites.setFont(checkBoxFont);
        cookie = new JCheckBox("Big Chocolate Chip Cookie $4");
        cookie.setFont(checkBoxFont);

        // checkboxes to left panel
        leftPanel.add(breadSticks);
        leftPanel.add(breadSticksBites);
        leftPanel.add(cookie);

        //create finish button and set layout
        finishButton = new JButton("Finish");
        finishButton.setBounds(87*w1p,h5p,10*w1p, 7*h1p);
        finishButton.setBackground(Color.decode("#e06666"));
        finishButton.setFont(buttonFont);
        finishButton.addActionListener(this);
        //create back button and set layout
        backButton = new JButton("Back");
        backButton.setBounds(w5p, h5p, 10*w1p,7*h1p);
        backButton.setBackground(Color.decode("#e06666"));
        backButton.setFont(buttonFont);
        backButton.addActionListener(this);

        // create title
        title = new JLabel("Extras");
        title.setFont(titleFont);
        title.setBounds((9*w5p), h5p, 30*w1p, 7*h1p);

        // create pricing JLabel
        pricing = new JLabel("Pricing: all drinks are $1 for any size");
        pricing.setFont(new Font("Impact", Font.PLAIN, 24));
        pricing.setBounds(52*w1p, 29*h1p, 40*w1p, 7*h1p);

        // set background for all elements
        pepsi.setBackground(Color.decode("#cccccc"));
        dietPepsi.setBackground(Color.decode("#cccccc"));
        orange.setBackground(Color.decode("#cccccc"));
        dietOrange.setBackground(Color.decode("#cccccc"));
        rootBeer.setBackground(Color.decode("#cccccc"));
        dietRB.setBackground(Color.decode("#cccccc"));
        sierraMist.setBackground(Color.decode("#cccccc"));
        lemonade.setBackground(Color.decode("#cccccc"));
        small.setBackground(Color.decode("#cccccc"));
        medium.setBackground(Color.decode("#cccccc"));
        large.setBackground(Color.decode("#cccccc"));
        breadSticks.setBackground(Color.decode("#cccccc"));
        breadSticksBites.setBackground(Color.decode("#cccccc"));
        cookie.setBackground(Color.decode("#cccccc"));
        rightPanel.setBackground(Color.decode("#cccccc"));
        leftPanel.setBackground(Color.decode("#cccccc"));

        // add all the elements
        this.getContentPane().setLayout(null);
        this.add(title);
        this.add(backButton);
        this.add(finishButton);
        this.add(rightPanel);
        this.add(leftPanel);
        this.add(drinksLabel);
        this.add(pricing);
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

    //back button
    @Override
    public void actionPerformed(ActionEvent e){
        //back button
        if(e.getActionCommand().equals("Back")){
            new PizzaMenu().showPizzaMenu(true);
            this.dispose();        
        }else if(e.getActionCommand().equals("Finish")){
             // set the drink size
            String size = "";
            if (small.isSelected()) {
                size = "Small";
            } else if (medium.isSelected()) {
                size = "Medium";
            } else if (large.isSelected()) {
                size = "Large";
            }

            // get the sides
            ArrayList<String> sides = new ArrayList<String>();
            if(breadSticks.isSelected()){
                sides.add("Breadsticks");
            } if(breadSticksBites.isSelected()){
                sides.add("Breadsticks Bites");
            } if(cookie.isSelected()){
                sides.add("Big Chocolate Chip Cookie");
            }

            //get the sides
            String drinkChoice = "";
            if(pepsi.isSelected()){
                drinkChoice  = "Pepsi";
            }else if(dietPepsi.isSelected()){
                drinkChoice  = "Diet Pepsi";
            }else if(orange.isSelected()){
                drinkChoice  = "Orange";
            }else if(dietOrange.isSelected()){
                drinkChoice  = "Diet Orange";
            }else if(rootBeer.isSelected()){
                drinkChoice  = "Root Beer";
            }else if(dietRB.isSelected()){
                drinkChoice  = "Diet Root Beer";
            }else if(sierraMist.isSelected()){
                drinkChoice  = "Sierra Mist";
            }else if(lemonade.isSelected()){
                drinkChoice  = "Lemonade";
            }

            if(validateSelection()){
                JOptionPane.showMessageDialog(null, "Must select both drink and size","Ivalide Selection", JOptionPane.ERROR_MESSAGE);
            }else{
                Drink drinks = new Drink(size, drinkChoice);
                Sides sideObj = new Sides(sides);
                currentOrder.addToOrder(drinks);
                currentOrder.addToOrder(sideObj);
                new OrderSummary().showOrderSummary(true);
                this.dispose();
            }
        //Checkboxes
        }else if(e.getActionCommand().equals("Small  ")){
            if (small.isSelected()) {
                      medium.setSelected(false);
                      large.setSelected(false);
              }
        }else if(e.getActionCommand().equals("Medium  ")){
              if (medium.isSelected()) {
                  small.setSelected(false);
                  large.setSelected(false);
              }
        }else if(e.getActionCommand().equals("Large  ")){
              if (large.isSelected()) {
                  small.setSelected(false);
                  medium.setSelected(false);
               }
    
        }else if(e.getActionCommand().equals("Pepsi")){
            selectDrink("Pepsi");
        }else if(e.getActionCommand().equals("Diet Pepsi")){
            selectDrink("Diet Pepsi");
        }else if(e.getActionCommand().equals("Orange")){
            selectDrink("Orange");
        }else if(e.getActionCommand().equals("Diet Orange")){
            selectDrink("Diet Orange");
        }else if(e.getActionCommand().equals("Root Beer")){
            selectDrink("Root Beer");
        }else if(e.getActionCommand().equals("Diet Root Beer")){
            selectDrink("Diet Root Beer");
        }else if(e.getActionCommand().equals("Sierra Mist")){
            selectDrink("Sierra Mist");
        }else if(e.getActionCommand().equals("Lemonade")){
            selectDrink("Lemonade");
        }else if(e.getActionCommand().equals("Add to Order")){
           
           
            
        }
    }

    public void selectDrink(String s){
        // p, dp, o, do, rb, drb, sm, l
        boolean[] selected = {false, false, false, false, false, false, false, false};
        switch (s.toLowerCase()){
            case "pepsi":
                selected[0] = true;
                break;
            case "diet pepsi":
                selected[1] = true;
                break;
            case "orange":
                selected[2] = true;
                break;
            case "diet orange":
                selected[3] = true;
                break;
            case "root beer":
                selected[4] = true;
                break;
            case "diet root beer":
                selected[5] = true;
                break;
            case "sierra mist":
                selected[6] = true;
                break;
            case "lemonade":
                selected[7] = true;
                break;
        }
        pepsi.setSelected(selected[0]);
        dietPepsi.setSelected(selected[1]);
        orange.setSelected(selected[2]);
        dietOrange.setSelected(selected[3]);
        rootBeer.setSelected(selected[4]);
        dietRB.setSelected(selected[5]);
        sierraMist.setSelected(selected[6]);
        lemonade.setSelected(selected[7]);

    }

    public boolean validateSelection(){
         if(!(small.isSelected()) && !(medium.isSelected()) && !(large.isSelected())){
            if(pepsi.isSelected() || dietPepsi.isSelected() || orange.isSelected() || dietOrange.isSelected() || rootBeer.isSelected() || dietRB.isSelected() || sierraMist.isSelected() || lemonade.isSelected()){
                return true;
            }
         }else if(!(pepsi.isSelected() || dietPepsi.isSelected() || orange.isSelected() || dietOrange.isSelected() || rootBeer.isSelected() || dietRB.isSelected() || sierraMist.isSelected() || lemonade.isSelected())){
            if(small.isSelected() || medium.isSelected() || large.isSelected()){
                return true;
            }
         }
         return false;
    }
}
