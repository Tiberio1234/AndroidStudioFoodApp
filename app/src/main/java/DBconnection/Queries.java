package DBconnection;



import com.example.myfooapp.models.DetailedDailyModel;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Vector;
import java.util.concurrent.Callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Queries {

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public int Addition(int x, int y){
        return x+y;
    }

    public Future<Vector<DetailedDailyModel>> GetDailyMeals() throws SQLException, InterruptedException {

       return executor.submit(new Callable<>() {
           @Override
           public Vector<DetailedDailyModel> call() throws Exception {
               try {
                   Vector<DetailedDailyModel> dailyMeals = new Vector<>();
                   Statement statement = DatabaseConnection.connection.createStatement();
                   ResultSet resultSet = statement.executeQuery("SELECT * FROM \"detailedDailyMeal\";");
                   while (resultSet.next()) {
                       dailyMeals.add(new DetailedDailyModel(resultSet));
                   }
                   return dailyMeals;
               } catch (Exception e) {
                   System.out.print(e.getMessage());
                   e.printStackTrace();
               }
               return new Vector<DetailedDailyModel>();
           }
       });
    }


}
