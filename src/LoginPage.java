import java.awt.event.*;
import javax.swing.*;
public class LoginPage {
    static String phoneNumber;
    static String password;
    static String[] user;

    public static void login(boolean visible){
        Database db = new Database();
        //UserPage up = new UserPage();

        JFrame login = new JFrame();
        //Create text fields to input data
        final JTextField txtIn1 = new JTextField();
        txtIn1.setBounds(105, 25, 170, 20);
        final JTextField txtIn2 = new JTextField();
        txtIn2.setBounds(105, 75, 170, 20);

        
        //Create login button
        JButton b1 = new JButton("Login");
        b1.setBounds(145,125,120,30);//x axis, y axis, width, height

        //Creat clear button
        JButton b2 = new JButton("Clear");
        b2.setBounds(165,180,80,30);

    
        //Login button action
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                phoneNumber = txtIn1.getText();
                password = txtIn2.getText();
                user = db.getUser(phoneNumber, password);
                /*if(user[0] != null){
                    txtOut1.setText(user[2]);
                    txtOut2.setText(user[3]);
                    txtOut3.setText(user[4]);
                    txtOut4.setText(user[5]);
                }else{
                    txtIn1.setText("Invalid Username or Password");
                    txtIn2.setText("Invalid Username or Password");
                } */              
            }
        }
        );

        //Clear button action
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtIn1.setText("");
                txtIn2.setText("");
            }
        });

        //add all elements to JFrame
        login.add(b1);
        login.add(b2);
        login.add(txtIn1);
        login.add(txtIn2);
        login.setExtendedState(JFrame.MAXIMIZED_BOTH);
        login.setLayout(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(visible){
            login.setVisible(true);
        }else{
            login.setVisible(false);
        }
    }
    
}
