import java.sql.*;

public class jdbcConnection {
    public static void main(String[] args) throws SQLException {
//        Creating connection
//       URL: "jdbc:mysql://+host + ":"+port+"/databasename"
        String host = "localhost";
        String port = "3306";
        Connection con = DriverManager.getConnection("jdbc:mysql://"+host + ":"+port+"/seleniumtest", "root", "root");

//        Executing query
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select * from Employeeinfo  where age <22");
        while (rs.next()) {
//        Think of next as a two-step process. First it gets the next item in the iterator, then it increments the pointer to point to the next item. So, when you create a new iterator, it is initialized to return the first item (index 0) in your list.
            String location = rs.getString("name");
            System.out.println(location);

//            We are basically saying if the query returned anything only then print
        }





    }
}
