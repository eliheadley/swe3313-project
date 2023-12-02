package swe3313;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.event.*;

public class SalesData extends Page implements ActionListener {
    JTable table;
    JLabel title;
    JButton back, veiwSalesData;
    Font buttonFont, textFont, titleFont;
    int numSales;

    String [] columnNames = {
            "Date", "Expenditure", "Gross Profit", "Net Profit"};
    public SalesData(){
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        textFont = new Font("Impact", Font.PLAIN, 20);
        titleFont = new Font("Impact", Font.BOLD, 64);

        Object [][] data = {
                {"Date", "Expenditure", "Gross Profit", "Net Profit"},
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
        title = new JLabel("Sales Data");
        title.setBounds((42*w1p), 2*h1p, 40*w1p, 10*h1p);
        title.setFont(titleFont);

        // create buttons
        back = new JButton("Back");
        back.setBounds(w5p, h5p, 10*w1p, 7*h1p);
        back.setBackground(Color.decode("#e06666"));
        back.setFont(buttonFont);
        back.addActionListener(this);

        veiwSalesData = new JButton("View Sales Data");
        veiwSalesData.setBounds((45*w1p),(95*h1p),15*w1p,7*h1p);//x axis, y axis, width, height
        veiwSalesData.setBackground(Color.decode("#e06666"));
        veiwSalesData.setFont(buttonFont);
        veiwSalesData.addActionListener(this);



        // add items to JFrame
        this.add(table);
        this.add(title);
        this.add(back);
        this.add(veiwSalesData);

        // set layout for jframe
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        setBackground(Color.decode("#cccccc"));
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.decode("#cccccc"));

    }

    public SalesData(Object [][] sales){
        numSales = 4;
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        textFont = new Font("Impact", Font.PLAIN, 20);
        titleFont = new Font("Impact", Font.BOLD, 64);
        table = new JTable(sales, columnNames);

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
        title = new JLabel("Sales Data");
        title.setBounds((42*w1p), 2*h1p, 40*w1p, 10*h1p);
        title.setFont(titleFont);

        // create buttons
        back = new JButton("Back");
        back.setBounds(w5p, h5p, 10*w1p, 7*h1p);
        back.setBackground(Color.decode("#e06666"));
        back.setFont(buttonFont);
        back.addActionListener(this);

        veiwSalesData = new JButton("View Sales Data");
        veiwSalesData.setBounds((45*w1p),(95*h1p),15*w1p,7*h1p);//x axis, y axis, width, height
        veiwSalesData.setBackground(Color.decode("#e06666"));
        veiwSalesData.setFont(buttonFont);
        veiwSalesData.addActionListener(this);



        // add items to JFrame
        this.add(table);
        this.add(title);
        this.add(back);
        this.add(veiwSalesData);

        // set layout for jframe
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        setBackground(Color.decode("#cccccc"));
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.decode("#cccccc"));

    }

    public void showSalesData(boolean visible){
        if(visible){
            this.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Back")){
            new ManagerPage().showManager(true);
            this.dispose();
        }
        else if (e.getActionCommand().equals("View Sales Data")){
            Object[][] currentSales = {
                    {"Date", "Expenditure", "Gross Profit", "Net Profit"},
                    { "10/01/2023", "$543.12", "$768.96", "$225.84"},
                    { "10/02/2023", "$239.54", "$398.67", "$159.13"},
                    { "10/03/2023", "$143.02", "$301.33", "29"},
                    { "10/04/203", "$78.63", "$293.24", "$214.61"},
                    { " ", " ", " ", " "},
                    { " ", " ", " ", " "},
                    { " ", " ", " ", " "},
                    { " ", " ", " ", " "},
                    { " ", " ", " ", " "},
                    { " ", " ", " ", " "},
                    { " ", " ", " ", " "}};
            new SalesData(currentSales).showSalesData(true);
            this.dispose();
        }
    }

}

