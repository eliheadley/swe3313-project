import java.awt.event.*;
import javax.swing.*;
class Main{
    static String phoneNumber;
    static String password;
    static String[] user;
    public static void main(String[] args){
        Database db = new Database();

        JFrame f = new JFrame();
        //Create text fields to input data
        final JTextField txtIn1 = new JTextField();
        txtIn1.setBounds(105, 25, 170, 20);
        final JTextField txtIn2 = new JTextField();
        txtIn2.setBounds(105, 75, 170, 20);
        final JTextField txtOut1 = new JTextField();
        txtOut1.setBounds(105, 250, 170, 20);
        final JTextField txtOut2 = new JTextField();
        txtOut2.setBounds(105, 300, 170, 20);
        final JTextField txtOut3 = new JTextField();
        txtOut3.setBounds(105, 350, 170, 20);
        final JTextField txtOut4 = new JTextField();
        txtOut4.setBounds(105, 400, 170, 20);

        
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
                if(user[0] != null){
                    txtOut1.setText(user[2]);
                    txtOut2.setText(user[3]);
                    txtOut3.setText(user[4]);
                    txtOut4.setText(user[5]);
                }else{
                    txtIn1.setText("Invalid Username or Password");
                    txtIn2.setText("Invalid Username or Password");
                }               
            }
        }
        );

        //Clear button action
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtIn1.setText("");
                txtIn2.setText("");
                txtOut1.setText("");
                txtOut2.setText("");
                txtOut3.setText("");
                txtOut4.setText("");
            }
        });

        //add all elements to JFrame
        f.add(b1);
        f.add(b2);
        f.add(txtIn1);
        f.add(txtIn2);
        f.add(txtOut1);
        f.add(txtOut2);
        f.add(txtOut3);
        f.add(txtOut4);
        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
    }
}