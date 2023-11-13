package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://10.0.2.2:5432/Food";
    private static final String USER = "postgres";
    private static final String PASSWORD = "ciocanitoarea";
    public static Connection connection;

    public static void connect()
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try
                {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);

                    System.out.println("connected <3");
                }
                catch (Exception e)
                {
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    static {
        connect();
    }

    /*static {
        try
        {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("connected <3");
        }
        catch (Exception e)
        {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }*/
}