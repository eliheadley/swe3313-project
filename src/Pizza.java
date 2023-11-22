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

}