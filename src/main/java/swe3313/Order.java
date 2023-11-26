package swe3313;

import java.util.ArrayList;

public class Order {
    ArrayList<Pizza> pizzas;
    ArrayList<Extras> extras;

    public Order(){
        pizzas = new ArrayList<Pizza>();
        extras = new ArrayList<Extras>();
    }

    public Order (Pizza p, Extras e){
        pizzas = new ArrayList<Pizza>();
        extras = new ArrayList<Extras>();
        pizzas.add(p);
        extras.add(e);
    }

    public void addToOrder(Pizza p){
        pizzas.add(p);
    }

    public static void printOrder(Pizza p, Extras e){
        System.out.println(p.size);
        System.out.println(p.crust);

        for (String t : p.toppingsVeg){
            System.out.println(t);
        }

        for (String t : p.toppingsMeat){
            System.out.println(t);
        }


    }
}
