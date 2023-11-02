import java.sql.*;

public class Database{
    // Old URL: "jdbc:hsqldb:hsql://localhost/"
    private static final String URL = "jdbc:hsqldb:file:c:/Users/elihe/OneDrive/projects/swe3313-project/database/PizzaShop";
    private Connection conn = null;
    private String sql = "";
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public String[] getUser(String userName, String Password){
        sql = "SELECT * FROM customer WHERE PhoneNumber = ? AND Password = ?";
        String[] querry = null;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            conn = DriverManager.getConnection(URL, "SA", "");            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, Password);
            rs = pstmt.executeQuery();
            querry = new String[6];
            while(rs.next()){
                for(int i=0; i<querry.length; i++){
                    querry[i] = rs.getString(i+1);
                }                
            }
        }catch(SQLException sqle){
            return null;            
        }catch(Exception e){
            e.printStackTrace();;
        }
        return querry;
    }

    public void insertUserName(String userName){
        sql = "INSERT INTO customer VALUES(\'?\') ";
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            conn = DriverManager.getConnection(URL, "SA", "");            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            rs = pstmt.executeQuery();            
        }catch(SQLException sqle){
            System.out.println("Querry failed");            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}