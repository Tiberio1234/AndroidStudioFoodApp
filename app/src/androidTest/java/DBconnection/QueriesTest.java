package DBconnection;

import static org.junit.Assert.*;

import com.example.myfooapp.activities.DetailedDailyMealActivity;
import com.example.myfooapp.models.DetailedDailyModel;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class QueriesTest {

    @Test
     public void TestIfGetsData() {
        Queries q = new Queries();
        int a = q.Addition(3,4);
        assert (a == 7);
    }

}