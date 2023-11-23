package swe3313;

import java.awt.Color;
import javax.swing.*;
import java.awt.FlowLayout;

public class ReportPage extends Page {
    JTable table;

    public ReportPage(){
        setLayout(new FlowLayout());
        String [] columnNames = {
            "First name", "Last name", "Header"};
        Object [][] data = {{ "Bill", "George", "Male"}, 
            {"Marry", "Anna", "Female"}, {"Rick",  
            "Bernard", "Male"}};
        table = new JTable(data, columnNames);
        table.setBounds(7*w5p, h5p, 500, 500);
        table.setFillsViewportHeight(true);
        //JScrollPane scrollPane = new JScrollPane(table);
        this.add(table);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        setBackground(Color.decode("#cccccc"));
    }

    public void showReport(boolean visible){
        if(visible){
           this.setVisible(true);
       }
    }
    
}
