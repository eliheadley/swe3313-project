package swe3313;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.event.*;

public class CurrentOrders extends Page implements ActionListener {
    JTable table;
    JLabel title;
    JButton back, getOrderData, updateOrderStatus;
    Font buttonFont, textFont, titleFont;

    public CurrentOrders(){
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        textFont = new Font("Impact", Font.PLAIN, 20);
        titleFont = new Font("Impact", Font.BOLD, 64);
        String [] columnNames = {
            "Date", "Expenditure", "Gross Profit", "Net Profit"};
        Object [][] data = {
            { "Date", "Expenditure", "Gross Profit", "Net Profit"}, 
            { " ", " ", " ", " "},
            { " ", " ", " ", " "},
            { " ", " ", " ", " "},
            { " ", " ", " ", " "},
            { " ", " ", " ", " "},
            { " ", " ", " ", " "},
            { " ", " ", " ", " "},
            { " ", " ", " ", " "},
            { " ", " ", " ", " "},
            { " ", " ", " ", " "},
            { " ", " ", " ", " "}};
        table = new JTable(data, columnNames);
        for(int i = 0; i < columnNames.length; i++){
            table.getColumnModel().getColumn(i).setPreferredWidth(250);
        }
        table.setRowHeight(50);
        table.setFillsViewportHeight(true);
        table.setBounds(3*w5p, 3*h5p, 15*w5p, 40*w1p);
        Border border1 = BorderFactory.createLineBorder(Color.BLACK);
        table.setBorder(border1);
        table.setFont(textFont);

        // create title
        title = new JLabel("Current Orders");
        title.setBounds((42*w1p), 2*h1p, 40*w1p, 10*h1p);
        title.setFont(titleFont);

        // create buttons
        back = new JButton("Back");
        back.setBounds(w5p, h5p, 10*w1p, 7*h1p);
        back.setBackground(Color.decode("#e06666"));
        back.setFont(buttonFont);
        back.addActionListener(this);

        getOrderData = new JButton("Get Order Data");
        getOrderData.setBounds((30*w1p),(95*h1p),15*w1p,7*h1p);//x axis, y axis, width, height
        getOrderData.setBackground(Color.decode("#e06666"));
        getOrderData.setFont(buttonFont);
        getOrderData.addActionListener(this);

        updateOrderStatus = new JButton("Update Order Status");
        updateOrderStatus.setBounds((60*w1p),(95*h1p),15*w1p,7*h1p);//x axis, y axis, width, height
        updateOrderStatus.setBackground(Color.decode("#e06666"));
        updateOrderStatus.setFont(buttonFont);
        updateOrderStatus.addActionListener(this);
        
        

        // add items to JFrame
        this.add(table);
        this.add(title);
        this.add(back);
        this.add(getOrderData);
        this.add(updateOrderStatus);

        // set layout for jframe
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        setBackground(Color.decode("#cccccc"));
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.decode("#cccccc"));

    }

    public void showCurrentOrders(boolean visible){
        if(visible){
           this.setVisible(true);
       }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Back")){
            new EmployeePage().showEmployee(true);
            this.dispose();
        }
    }
    
}
