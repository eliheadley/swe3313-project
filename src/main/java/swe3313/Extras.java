package swe3313;

import java.util.ArrayList;

public class Extras {
    String drinkSize;
    String drinkChoice;
    ArrayList <String> sidesOptions;
    int sideQty = 0;
    int drinkQty= 0;

    public Extras(String s, String dO){
        drinkSize = s;
        drinkChoice = dO;
        drinkQty++;
    }

    public Extras(ArrayList<String> sO){
        sidesOptions = sO;
        sideQty++;
    }

    public Extras(String s, String dO, ArrayList<String> sO){
        drinkSize = s;
        drinkChoice = dO;
        sidesOptions = sO;
        sideQty++;
        drinkQty++;
    }

    // getters for drinks and sides
    public String getSides(){
        String s = "";
        for(String x : sidesOptions){
            s += x + ", ";
        }
        return s.substring(0, s.length() - 2);
    }

    public String getDrinks(){
        String s = drinkSize + " " + drinkChoice;       
        return s;
    }

    public double calcDrinkCost(){
        double cost = 0;
        cost += 1.00;
        cost *= drinkQty;
        return cost;
    }

    public double calcSideCost(){
        double cost = 0;
        for(String x : sidesOptions){
            if(x.equals("Breadsticks")){
                cost += 4.00;
            }else if(x.equals("Breadsticks Bites")){
                cost += 2.00;
            }else if(x.equals("Big Chocolate Chip Cookie")){
                cost += 4.00;
            }
        }
        if(!(sidesOptions.isEmpty())){
            return cost * sideQty;
        }
        return cost;
    }


    // increment qty
    public void incSideQty(){
        sideQty++;
    }
    // increment qty
    public void incDrinkQty(){
        drinkQty++;
    }

    // decrement qty's
    public void decSideQty(){
        sideQty--;
    }
    public void decDrinkQty(){
        drinkQty--;
    }

    // get drink cost
    public String getDrinkCost(){
        double c = calcDrinkCost();
        String cost = "$" + String.format("%.2f", c);
        return cost;
    }

    // get side cost
    public String getSideCost(){
        double c = calcSideCost();
        String cost = "$" + String.format("%.2f", c);
        return cost;
    }

    // getter for side quantity
    public String getSideQty(){
        String s = "";
        s += sideQty;
        return s;
    }

    // getter for drink quantity
    public String getDrinkQty(){
        String s = "";
        s += drinkQty;
        return s;
    }
}
