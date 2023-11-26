package swe3313;

import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class Receipt extends Page implements ActionListener{
    JLabel img, title, label1, label2, label3, line1, line2, line3, tip, total, signature, date;
    JPanel infoPanel, userInfoPanel, orderPanel;
    Font subTitleFont, textFont, titleFont;

    public Receipt(){
        subTitleFont = new Font("Impact", Font.PLAIN, 24);
        textFont = new Font("Impact", Font.PLAIN, 20);
        titleFont = new Font("Impact", Font.BOLD, 52);

        // create title
        title = new JLabel("Mom and Pop's Pizza Shop Receipt");
        title.setBounds((5*w5p), h5p-10, 800, 50);
        title.setFont(titleFont);

        /*  !!! Create logo using a icon
        img = new JLabel(new ImageIcon("C:/Users/elihe/OneDrive/projects/swe3313-project/images/Mom & Pizza.png"));
        img.setBounds((7*w5p), 3*h5p, 438, 438);
        this.add(img); */

        // make Address Info panel
        infoPanel = new JPanel();
        infoPanel.setBounds(8*w5p, 2*h5p, 300, 55);
        infoPanel.setBackground(Color.decode("#cccccc"));
        infoPanel.add(new JLabel("680 Arntson Rd, Suite 161 Marietta, GA 30060"));
        infoPanel.add(new JLabel("MomAndPopPizzeria.com  |  770 555-1212"));

        //Make first separator line
        line1 = new JLabel();
        line1.setBounds(2*w5p, (4*h5p)+10, 1200, 2);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 10);
        line1.setBorder(border);
        
        // make customer info label
        label1 = new JLabel("Customer Info");
        label1.setFont(subTitleFont);
        label1.setBounds(2*w5p, 3*h5p, 150, 30);

        //make user info panel
        userInfoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 150, 35));
        userInfoPanel.setBounds(w5p, 3*h5p, 1200, 100);
        userInfoPanel.setBackground(Color.decode("#cccccc"));
        //add text to panel
        userInfoPanel.add(new JLabel("Name"));
        userInfoPanel.add(new JLabel("Phone Number"));
        userInfoPanel.add(new JLabel("Address"));
        userInfoPanel.add(new JLabel("Delivery Method"));
        userInfoPanel.add(new JLabel("Estimated Time of Delivery"));

        // make Order item label
        label2 = new JLabel("Order Item(s)");
        label2.setFont(subTitleFont);
        label2.setBounds(2*w5p, 6*h5p, 150, 30);

        //make quantity info label
        label3 = new JLabel("Qty                        Each                       Total");
        label3.setFont(subTitleFont);
        label3.setBounds(14*w5p, 6*h5p, 400, 30);
        
        //Make second separator line
        line2 = new JLabel();
        line2.setBounds(2*w5p, 7*h5p, 1200, 2);
        line2.setBorder(border);

        //make tip label
        tip = new JLabel("Tip: $");
        tip.setFont(subTitleFont);
        tip.setBounds(16*w5p, 14*h5p, 150, 30);
        
        //make order total label
        total = new JLabel("Order Total: $");
        total.setFont(subTitleFont);
        total.setBounds(16*w5p, 15*h5p, 150, 30);

        //make signature label
        signature = new JLabel("Signature");
        signature.setFont(subTitleFont);
        signature.setBounds(2*w5p, (16*h5p)+10, 150, 30);

        //Make signature line
        line3 = new JLabel();
        line3.setBounds((3*w5p)+25, 17*h5p, 825, 2);
        line3.setBorder(border);

        //make date and time label
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/uuuu HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        date = new JLabel("Date: " + dtf.format(now));
        date.setFont(subTitleFont);
        date.setBounds(15*w5p, (16*h5p), 350, 30);
        
        //add elements for Receipt
        this.add(title);
        this.add(infoPanel);
        this.add(label1);
        this.add(line1);
        this.add(userInfoPanel);
        this.add(label2);
        this.add(label3);
        this.add(line2);
        this.add(tip);
        this.add(total);
        this.add(signature);
        this.add(line3);
        this.add(date);

        // set the layout for the frame
        this.getContentPane().setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        this.getContentPane().setBackground(Color.decode("#cccccc"));
    }

    public void showReceipt(boolean visible){
        if(visible){
           this.setVisible(true);
       }
    }

    @Override
     public void actionPerformed(ActionEvent e){
         
     }

    }