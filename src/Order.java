import java.util.ArrayList;

public class Order {
    Pizza pizza;
    Extras extras;


    public Order (Pizza p, Extras e){
        pizza = p;
        extras = e;
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
