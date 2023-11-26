package swe3313;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Page extends JFrame {
    Dimension screenSize;  
    int h5p, w5p, h1p, w1p;
    static Order currentOrder = new Order();

    public Page(){
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        h5p = (int)(screenSize.getHeight() * 0.05); 
        w5p = (int)(screenSize.getWidth() * 0.05);
        h1p = (int)(screenSize.getHeight()/100); 
        w1p = (int)(screenSize.getWidth()/100);

    }
    
}
