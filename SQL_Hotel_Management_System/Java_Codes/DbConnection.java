

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DbConnection {

    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String databaseName = "Hotel Management System";
            String databaseUser = "root";
            String databasePassword = "root";
            Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:8889/"+databaseName, databaseUser, databasePassword);
            return connection;
        } catch (ClassNotFoundException ex) {
            System.out.println("database engine not found");
        } catch (SQLException ex) { 
            System.out.println("error in creating connection");
        }

        return null;
    }
    
    public static void inserHotel(int Hotel_id,String name,String address,String description) throws SQLException{
        Connection con = createConnection();
        //add hotel
        PreparedStatement stat = con.prepareStatement("insert into hotel values (?,?,?,?)");
            stat.setInt(1, Hotel_id);
            stat.setString(2, name);
            stat.setString(3, address);
            stat.setString(4, description);
            
            int rows=stat.executeUpdate();
            con.close();
            showMessage(rows);
                
    }
    
    public static void inserRoom(int roomnumber,String roomtype,int floornumber,int typicalprice,String occupants) throws SQLException{
        Connection con = createConnection();
        //add hotel
        PreparedStatement stat = con.prepareStatement("insert into room values (?,?,?,?,?)");
            stat.setInt(1, roomnumber);
            stat.setString(2, roomtype);
            stat.setInt(3, floornumber);
            stat.setInt(4, typicalprice);
            stat.setString(5, occupants);
            
            int rows=stat.executeUpdate();
            con.close();
            showMessage(rows);
                
    }
    
    public static void inserReservation(int guest_id,int room_id,String startDate ,String endDate,int reservationPrice) throws SQLException{
        Connection con = createConnection();
        //add hotel
        PreparedStatement stat = con.prepareStatement("insert into reservation values (?,?,?,?,?)");
            stat.setInt(1, guest_id);
            stat.setInt(2, room_id);
            stat.setDate(3, java.sql.Date.valueOf(startDate));
            stat.setDate(4, java.sql.Date.valueOf(endDate));
            stat.setInt(5, reservationPrice);
            
            int rows=stat.executeUpdate();
            con.close();
            showMessage(rows);
                
    }
    
    public static void inserGuest(int guest_id,String name,int passport_id) throws SQLException{
        Connection con = createConnection();
        //add hotel
        PreparedStatement stat = con.prepareStatement("insert into guest values (?,?,?)");
            stat.setInt(1, guest_id);
            stat.setString(2, name);
            stat.setInt(3, passport_id);
    
            
            int rows=stat.executeUpdate();
            con.close();
            showMessage(rows);
                
    }
    
    public static ResultSet loadFrom(String table) throws SQLException{
        Connection con = createConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from "+table);
        return rs;    
        
    }
    
    public static void showMessage(int rows){
        if (rows>0) {
            JOptionPane.showMessageDialog(null, "saved successfully");
            
        }else{
            JOptionPane.showMessageDialog(null, "Save Error");
            
        }
    }

}
