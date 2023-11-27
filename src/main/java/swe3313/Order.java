package swe3313;

import java.util.ArrayList;

public class Order {
    Pizza pizzas;
    Drink drinks;
    Sides sides;
    double orderCost = 0f;
    String paymentMethod;
    boolean isDelivery;

    public Order(){
        pizzas = null;
        drinks = null;
        sides = null;
    }


    public Order (Pizza p, Drink d, Sides s){
        pizzas = p;
        drinks = d;
        sides = s;
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
        this.isDelivery = isDelivery;
    }

    public void setPaymentMethod(String s){
        paymentMethod = s;
    }

    // calculate order cost
    public double calcCost(){
        orderCost += pizzas.calcCost();
        orderCost += drinks.calcDrinkCost();
        orderCost += sides.calcSideCost();
        orderCost += (orderCost/10); 
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

}
