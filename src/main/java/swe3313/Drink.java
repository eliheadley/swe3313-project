package swe3313;


public class Drink {
    String drinkSize;
    String drinkChoice;
    int drinkQty= 0;

    public Drink(String s, String dO){
        drinkSize = s;
        drinkChoice = dO;
        drinkQty++;
    }

    // getters for drinks
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


   
    // increment qty
    public void incDrinkQty(){
        drinkQty++;
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

    // getter for drink quantity
    public String getDrinkQty(){
        String s = "";
        s += drinkQty;
        return s;
    }
}
