package jdbc.pstgresql.connection.src.mypackage.postgresql;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCPostgresql {

    private void connect(){
        System.out.println("Connecting to database...");
        String url = "jdbc:postgresql://localhost:5432/Ums";
        String user = "postgres";
        String password = "mwangi99";
        try(Connection conn= DriverManager.getConnection(url, user, password);) {
            if(conn!=null){
                System.out.println("Connected to server successfully");
            }else {
                System.out.println("Failed to connect to server");
            }
            Connection connection = null;
            Statement statement= connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT VERSION()");
            if(resultSet.next()){
                System.out.println("Select ;"+resultSet.getString(1));
            }



        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JDBCPostgresqlConnect sqlConnect = new JDBCPostgresqlConnect();
        sqlConnect. connect();

    }
}
