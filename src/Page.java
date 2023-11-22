import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
public class Page extends JFrame {
    Dimension screenSize;  
    int h5p, w5p;

    public Page(){
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        h5p = (int)(screenSize.getHeight() * 0.05); 
        w5p = (int)(screenSize.getWidth() * 0.05);
    }
    
}
