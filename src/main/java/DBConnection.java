import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {



    public static Connection getConnection() throws Exception{

        try {

            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/onlineDB";
            String user = "root";
            String password = "Cd123456";
            Class.forName(driver);

           Connection myConnection = DriverManager.getConnection(url + "?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, password);

            System.out.println("Connected");
            return myConnection;
        }
        catch (Exception e){
            System.out.println(e);

        }
        return null;

    }

}


