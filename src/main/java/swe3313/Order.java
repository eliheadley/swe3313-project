package swe3313;

import java.util.ArrayList;

public class Order {
    Pizza pizzas;
    Extras extras;
    double orderCost = 0f;
    String paymentMethod;
    boolean isDelivery;
    int pizzaCount = 0;

    public Order(){
        pizzas = null;
        extras = null;
    }


    public Order (Pizza p, Extras e){
        pizzas = p;
        extras = e;
    }

    public void addToOrder(Pizza p){
        pizzas = p;
    }

    public void addToOrder(Extras e){
        extras = e;
    }

    // getter and setter for pizza count
    public int getPizzaCount(){
        return pizzaCount;
    }
    public  void incrementPizzaCount(){
        pizzaCount++;
    }
    
    //getters for pizzas and extras
    public Pizza getPizzas(){
        return pizzas;
    }

    public Extras getExtras(){
        return extras;
    }

    // setters for isDelivery and payment method
    public void setDeliveryMethod(boolean isDelivery){
        this.isDelivery = isDelivery;
    }

    public void setPaymentMethod(String s){
        paymentMethod = s;
    }

    // calculate order cost
    public double calcCost(){
        orderCost += pizzas.calcCost();
        orderCost += extras.calcDrinkCost();
        orderCost += extras.calcSideCost();
        orderCost += (orderCost/10); 
        return Math.round(orderCost * 100.0) / 100.0;
    }

    // delete pizza items
    public void deletePizza(){
        pizzas = null;
    }

    // delete extras items
    public void deleteExtras(){
        extras = null;
    }


}
