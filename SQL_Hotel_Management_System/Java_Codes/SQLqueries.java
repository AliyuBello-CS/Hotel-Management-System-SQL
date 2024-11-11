
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;


class hhotel {

    public static void selectAll1(String table, Statement st) throws Exception{

        String query = "SELECT * FROM "+table+" JOIN room ON "+table+".roomID = room.roomnumber WHERE room.roomnumber = 777";

        // getting results set
        ResultSet result = st.executeQuery(query);

        // metadata means, other information of the database like number of columns
        ResultSetMetaData rsmd = result.getMetaData();
        int columnNumber = rsmd.getColumnCount();

        while (result.next()) {

            for (int i = 1; i <= columnNumber; i++) {

                System.out.print(result.getString(i) + " ");

            }

            System.out.println();

        }
    }
    public static void selectAll2(String table, Statement st) throws Exception{

        String query = "SELECT * FROM "+table+" JOIN reservation ON "+"reservation.guestID= "+table+".guestID WHERE getdate() between startDate and endDate";


        ResultSet result = st.executeQuery(query);
        ResultSetMetaData rsmd = result.getMetaData();
        int columnNumber = rsmd.getColumnCount();

        while (result.next()) {

            for (int i = 1; i <= columnNumber; i++) {

                System.out.print(result.getString(i) + " ");

            }

            System.out.println();

        }
    }}


