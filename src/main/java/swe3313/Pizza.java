package swe3313;

import java.util.ArrayList;

public class Pizza {
    String size;
    String crust;
    ArrayList <String> toppingsVeg = new ArrayList<>();
    ArrayList <String> toppingsMeat = new ArrayList<>();

    ArrayList <String> other = new ArrayList<>();

    public Pizza(String s, String c, ArrayList<String> tV, ArrayList<String> tM,ArrayList<String> o){
        size = s;
        crust = c;
        toppingsVeg = tV;
        toppingsMeat = tM;
        other = o;
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
        s += "and " + other.get(toppingsMeat.size()-1);

        return s;
    }

}