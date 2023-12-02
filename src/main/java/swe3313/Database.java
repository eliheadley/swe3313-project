package swe3313;

import java.sql.*;

public class Database{
    // Old URL: "jdbc:hsqldb:hsql://localhost/"
    private static final String URL = "jdbc:hsqldb:file:database/PizzaShop";
    private Connection conn = null;
    private String sql = "";
    public PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public String[] getUser(String phoneNumber){
        sql = "SELECT * FROM users WHERE phone_number = ?";
        String[] querry = null;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            conn = DriverManager.getConnection(URL, "SA", "");            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, phoneNumber);
            rs = pstmt.executeQuery();
            querry = new String[7];
            while(rs.next()){
                for(int i=0; i<querry.length; i++){
                    querry[i] = rs.getString(i+1);
                }                
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return null;            
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return querry;
    }

    public void insertUser(String phoneNumber, String password, String firstName, String lastName, String payment, String deliveryAddress){
        sql = "INSERT INTO users (phone_number,password, first_name, last_name, payment_method, delivery_address, user_type ) VALUES(?,?,?,?,?,?,'Customer') ";
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            conn = DriverManager.getConnection(URL, "SA", "");            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, phoneNumber);
            pstmt.setString(2, password);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, payment);
            pstmt.setString(6, deliveryAddress);
            int row = pstmt.executeUpdate();
            // TODO: Need to check for Unique Key exception - when a duplicate phone number is used
            if (row != 1)
                {
                throw new SQLException("Row not inserted");
                }            
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            System.out.println("Querry failed");            
            sqle.printStackTrace();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}