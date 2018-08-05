package ProgramBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

        private static  DatabaseConnection instance = new DatabaseConnection();
        private static Connection connection;
        private static String serverName = "DESKTOP-7P10APU\\SQLEXPRESS;";
        private static String dbName = "database=AdventureWorks2014;";
        private static String user = "user=admin;";
        private static String password = "password=admin123;";
        private static String connectionUrl = "jdbc:sqlserver://"+serverName+dbName+user+password;


        private DatabaseConnection() { }


        public static DatabaseConnection getInstance(){
            return instance;
        }


        public Connection getConnection() {
            return connection;
        }

        public boolean openConnection(){
            connection = null;
            try {
                connection = DriverManager.getConnection(connectionUrl);
                System.out.println("SUCCESS Connection established to sql server db");
                return true;

            } catch (SQLException ex) {
                System.out.println("ERROR Couldn't establish sql server connection error: " + ex);
                return false;
            }
        }


        public void closeConnection() {
            try{
                if (connection != null) {
                    connection.close();
                    System.out.println("SUCCESS Connection closed");

                }
                else{
                    System.out.println("ERROR Connection is null");
                }

            }catch (SQLException e){
                System.out.println("ERROR Couldn't close connection error: "+ e);
            }

        }

}
