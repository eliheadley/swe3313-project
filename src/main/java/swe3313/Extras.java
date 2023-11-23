package swe3313;

import java.util.ArrayList;

public class Extras {
    String drinkSize;
    ArrayList <String> drinksOptions = new ArrayList<>();
    ArrayList <String> sidesOptions = new ArrayList<>();

    public Extras(String s, ArrayList<String> dO, ArrayList<String> sO){
        drinkSize = s;
        drinksOptions = dO;
        sidesOptions = sO;
    }

}
