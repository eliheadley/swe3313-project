package swe3313;

import java.util.ArrayList;

public class Extras {
    String drinkSize;
    String drinkChoice;
    ArrayList <String> sidesOptions;
    double cost = 0f;
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

    public double calcCost(){
        cost += 1.00;
        cost *= drinkQty;
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
            cost *= sideQty;
        }
        return Math.round(cost * 100.0) / 100.0;
    }

    // increment qty
    public void incSideQty(){
        sideQty++;
    }
    // increment qty
    public void incDrinkQty(){
        drinkQty++;
    }
}
