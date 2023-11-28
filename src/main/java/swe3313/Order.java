package swe3313;


public class Order {
    Pizza pizzas;
    Drink drinks;
    Sides sides;
    double orderCost;
    String paymentMethod;
    String dilveryMethod;
    String signature;
    double tip;
    String phoneNumber;


    public Order(){
        pizzas = null;
        drinks = null;
        sides = null;
        tip = 0;
    }


    public Order (Pizza p, Drink d, Sides s){
        pizzas = p;
        drinks = d;
        sides = s;
        tip = 0;
    }

    public void addToOrder(Pizza p){
        pizzas = p;
    }

    public void addToOrder(Drink d){
        drinks = d;
    }

    public void addToOrder(Sides s){
        sides = s;
    }

    
    //getters for pizzas and extras
    public Pizza getPizzas(){
        return pizzas;
    }

    public Drink getDrinks(){
        return drinks;
    }

    public Sides getSides(){
        return sides;
    }

    // setters for isDelivery and payment method
    public void setDeliveryMethod(boolean isDelivery){
        if(isDelivery){
            dilveryMethod = "Carry Out";
        }else{
            dilveryMethod = "Pick Up";
        }
    }

    public void setPaymentMethod(String s){
        paymentMethod = s;
    }

    // calculate order cost
    public double calcCost(){
        orderCost = 0;
        orderCost += pizzas.calcCost();
        orderCost += drinks.calcDrinkCost();
        orderCost += sides.calcSideCost(); 
        orderCost += tip;
        return Math.round(orderCost * 100.0) / 100.0;
    }

    // delete pizza items
    public void deletePizza(){
        pizzas = null;
    }

    // delete extras items
    public void deleteDrinks(){
        drinks = null;
    }

    public void deleteSides(){
        sides = null;
    }

    public void setTip(double tip){
        this.tip = tip;
    }

    public String getTip(){
        String cost = "$" + String.format("%.2f", tip);
        return cost;
    }

    public void setSignature(String s){
        signature = s;
    }

    public String getSignature(){
        return signature;
    }

    public String getCost(){
        double c = calcCost();
        String cost = "$" + String.format("%.2f", c);
        return cost;
    }

    public void setPhoneNumber(String s){
        phoneNumber = s;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

}
