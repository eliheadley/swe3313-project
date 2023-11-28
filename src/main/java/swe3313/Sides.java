package swe3313;

import java.util.ArrayList;

public class Sides {
    ArrayList <String> sidesOptions;
    int sideQty = 0;

    public Sides(ArrayList<String> sO){
        sidesOptions = sO;
        sideQty++;
    }
     // getter for sides
    public String getSides(){
        String s = "";
        for(String x : sidesOptions){
            s += x + ", ";
        }
        return s.substring(0, s.length() - 2);
    }

    // calculate sides cost
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

     // decrement qty's
    public void decSideQty(){
        sideQty--;
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

}
