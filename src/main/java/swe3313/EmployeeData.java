package swe3313;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.event.*;

public class EmployeeData extends Page implements ActionListener {
    JTable table;
    JLabel title;
    JButton back, veiwEmployeeData, editEmployeeData, save;
    Font buttonFont, textFont, titleFont;
    int numEmployes;
    
        String [] columnNames = {"Employee ID", "Fist Name", "Last Name", "Title", "Salary"};
    

    public EmployeeData(){
        numEmployes = 3;
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        textFont = new Font("Impact", Font.PLAIN, 20);
        titleFont = new Font("Impact", Font.BOLD, 64);
        Object [][] data = {
            { "Employee ID", "First Name", "Last Name", "Title", "Salary"}, 
            { " ", " ", " ", " ", " "},
            { " ", " ", " ", " ", " "},
            { " ", " ", " ", " ", " "},
            { " ", " ", " ", " ", " "},
            { " ", " ", " ", " ", " "},
            { " ", " ", " ", " ", " "},
            { " ", " ", " ", " ", " "},
            { " ", " ", " ", " ", " "},
            { " ", " ", " ", " ", " "},
            { " ", " ", " ", " ", " "},
            { " ", " ", " ", " ", " "}};
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
        title = new JLabel("Employee Data");
        title.setBounds((38*w1p), 2*h1p, 40*w1p, 10*h1p);
        title.setFont(titleFont);

        // create buttons
        back = new JButton("Back");
        back.setBounds(w5p, h5p, 10*w1p, 7*h1p);
        back.setBackground(Color.decode("#e06666"));
        back.setFont(buttonFont);
        back.addActionListener(this);

        veiwEmployeeData = new JButton("View Employee Data");
        veiwEmployeeData.setBounds((20*w1p),(95*h1p),15*w1p,7*h1p);//x axis, y axis, width, height
        veiwEmployeeData.setBackground(Color.decode("#e06666"));
        veiwEmployeeData.setFont(buttonFont);
        veiwEmployeeData.addActionListener(this);

        editEmployeeData = new JButton("Edit Employee Data");
        editEmployeeData.setBounds((45*w1p),(95*h1p),15*w1p,7*h1p);//x axis, y axis, width, height
        editEmployeeData.setBackground(Color.decode("#e06666"));
        editEmployeeData.setFont(buttonFont);
        editEmployeeData.addActionListener(this);

        save = new JButton("Save");
        save.setBounds((70*w1p),(95*h1p),8*w1p,7*h1p);//x axis, y axis, width, height
        save.setBackground(Color.decode("#e06666"));
        save.setFont(buttonFont);
        save.addActionListener(this);
        
        

        // add items to JFrame
        this.add(table);
        this.add(title);
        this.add(back);
        this.add(veiwEmployeeData);
        this.add(editEmployeeData);
        this.add(save);

        // set layout for jframe
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        setBackground(Color.decode("#cccccc"));
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.decode("#cccccc"));
    }

    public EmployeeData(Object[][] employees){
        numEmployes = 3;
        buttonFont = new Font("Impact", Font.PLAIN, 20);
        textFont = new Font("Impact", Font.PLAIN, 20);
        titleFont = new Font("Impact", Font.BOLD, 64);
        table = new JTable(employees, columnNames);
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
        title = new JLabel("Employee Data");
        title.setBounds((38*w1p), 2*h1p, 40*w1p, 10*h1p);
        title.setFont(titleFont);

        // create buttons
        back = new JButton("Back");
        back.setBounds(w5p, h5p, 10*w1p, 7*h1p);
        back.setBackground(Color.decode("#e06666"));
        back.setFont(buttonFont);
        back.addActionListener(this);

        veiwEmployeeData = new JButton("Veiw Employee Data");
        veiwEmployeeData.setBounds((20*w1p),(95*h1p),15*w1p,7*h1p);//x axis, y axis, width, height
        veiwEmployeeData.setBackground(Color.decode("#e06666"));
        veiwEmployeeData.setFont(buttonFont);
        veiwEmployeeData.addActionListener(this);

        editEmployeeData = new JButton("Edit Employee Data");
        editEmployeeData.setBounds((45*w1p),(95*h1p),15*w1p,7*h1p);//x axis, y axis, width, height
        editEmployeeData.setBackground(Color.decode("#e06666"));
        editEmployeeData.setFont(buttonFont);
        editEmployeeData.addActionListener(this);

        save = new JButton("Save");
        save.setBounds((70*w1p),(95*h1p),8*w1p,7*h1p);//x axis, y axis, width, height
        save.setBackground(Color.decode("#e06666"));
        save.setFont(buttonFont);
        save.addActionListener(this);
        
        

        // add items to JFrame
        this.add(table);
        this.add(title);
        this.add(back);
        this.add(veiwEmployeeData);
        this.add(editEmployeeData);
        this.add(save);

        // set layout for jframe
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        setBackground(Color.decode("#cccccc"));
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.decode("#cccccc"));

    }

    public void showEmployeeData(boolean visible){
        if(visible){
           this.setVisible(true);
       }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Back")){
            new ManagerPage().showManager(true);
            this.dispose();
        }else if(e.getActionCommand().equals("Veiw Employee Data")){
            Object[][] currentEmployees = {
                { "Employee ID", "First Name", "Last Name", "Title", "Salary"},
                {"1000345698", "Eli", "Headley", "Chef", "$15.00 hourly"},
                {"1000345789", "Max", "Wender", "Manager", "$25.00 hourly"},
                {"1000346123", "Aman", "Bhayani", "Delivery Driver", "$12.00 hourly"},
                { " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " "}
            };
            new EmployeeData(currentEmployees).showEmployeeData(true);
            this.dispose();
        }
    }
    
}
