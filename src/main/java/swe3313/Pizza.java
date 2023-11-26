package swe3313;

import java.util.ArrayList;

public class Pizza {
    String size;
    String crust;
    ArrayList <String> toppingsVeg = new ArrayList<>();
    ArrayList <String> toppingsMeat = new ArrayList<>();
    ArrayList <String> other = new ArrayList<>();
    double cost = 0f;
    int qty = 0;

    // Overloade constuctors
    public Pizza(String s, String c){
        size = s;
        crust = c;
        qty++;
    }

    public Pizza(String s, String c, ArrayList<String> t){
        size = s;
        crust = c;
        qty++;
        for(String x : t){
            if(x.equals("Onion") || x.equals("Tomatoes") || x.equals("Mushroom") || x.equals("Pineapples")){
                 toppingsVeg = t;
            }else if(x.equals("Pepperoni") || x.equals("Sausage") || x.equals("Ham")){
                toppingsMeat = t;
            }else if(x.equals("Extra Cheese") || x.equals("Extra Sauce")){
                other = t;
            }
        }
       
    }

    public Pizza(String s, String c, ArrayList<String> t1, ArrayList<String> t2){
        size = s;
        crust = c;
        qty++;
        for(String x : t1){
            if(x.equals("Onion") || x.equals("Tomatoes") || x.equals("Mushroom") || x.equals("Pineapples")){
                 toppingsVeg = t1;
            }else if(x.equals("Pepperoni") || x.equals("Sausage") || x.equals("Ham")){
                toppingsMeat = t1;
            }else if(x.equals("Extra Cheese") || x.equals("Extra Sauce")){
                other = t1;
            }
        }
        for(String x : t2){
            if(x.equals("Onion") || x.equals("Tomatoes") || x.equals("Mushroom") || x.equals("Pineapples")){
                 toppingsVeg = t2;
            }else if(x.equals("Pepperoni") || x.equals("Sausage") || x.equals("Ham")){
                toppingsMeat = t2;
            }else if(x.equals("Extra Cheese") || x.equals("Extra Sauce")){
                other = t2;
            }
        }
    }

    public Pizza(String s, String c, ArrayList<String> tV, ArrayList<String> tM,ArrayList<String> o){
        size = s;
        crust = c;
        toppingsVeg = tV;
        toppingsMeat = tM;
        other = o;
        qty++;
    }


    @Override
    public String toString(){
        String s = size + " pizza with " + crust + " crust, ";
        for(String x : toppingsVeg){
            s += x + ", ";
        }
        for(int i = 0; i < toppingsMeat.size(); i++){
            s += toppingsMeat.get(i) + ", ";
        }
        for(int i = 0; i < other.size(); i++){
            s += other.get(i) + ", ";
        }

        return s.substring(0, s.length() - 2);
    }

    public double calcCost(){
        if(size == "Small"){
            cost += 4.00;
            cost += (0.50 * toppingsVeg.size());
            cost += (0.50 * toppingsMeat.size());
            cost += (0.50 * other.size());
            if(!(toppingsMeat.isEmpty()) || !(toppingsVeg.isEmpty()) || !(other.isEmpty())){
                cost -= 0.50;
            }
        }else if(size == "Medium"){
            cost += 6.00;
            cost += (0.75 * toppingsVeg.size());
            cost += (0.75 * toppingsMeat.size());
            cost += (0.75 * other.size());
            if(!(toppingsMeat.isEmpty()) || !(toppingsVeg.isEmpty()) || !(other.isEmpty())){
                cost -= 0.75;
            }
        }else if(size == "Large"){
            cost += 8.00;
            cost += (1.00 * toppingsVeg.size());
            cost += (1.00 * toppingsMeat.size());
            cost += (1.00 * other.size());
             if(!(toppingsMeat.isEmpty()) || !(toppingsVeg.isEmpty()) || !(other.isEmpty())){
                cost -= 1.00;
            }
        }else if(size == "Extra Large"){
            cost += 10.00;
            cost += (1.25 * toppingsVeg.size());
            cost += (1.25 * toppingsMeat.size());
            cost += (1.25 * other.size());
            if(!(toppingsMeat.isEmpty()) || !(toppingsVeg.isEmpty()) || !(other.isEmpty())){
                cost -= 1.25;
            }
        }
        cost *= qty;
        return Math.round(cost * 100.0) / 100.0;
    }

    // increase quantity
    public void incQty(){
        qty++;
    }

}