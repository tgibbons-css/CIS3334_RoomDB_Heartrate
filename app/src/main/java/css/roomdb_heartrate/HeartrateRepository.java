package css.roomdb_heartrate;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class HeartrateRepository {
    private HeartrateDao heartrateDao;
    private List<Heartrate> allHeartrates;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    HeartrateRepository(Application application) {
        HeartrateDatabase db = HeartrateDatabase.getDatabase(application);
        Log.d("CIS 3334", "Setting up the Dao and  database");
        heartrateDao = db.heartrateDao();
        //allHeartrates = heartrateDao.getAll();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    List<Heartrate> getAllHeartrates() {
        Log.d("CIS 3334", "HeartrateRepository in getAllHeartrates");
        allHeartrates = heartrateDao.getAll();
        return allHeartrates;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Heartrate heartrate) {
        HeartrateDatabase.databaseWriteExecutor.execute(() -> {
            heartrateDao.insert(heartrate);
            Log.d("CIS 3334", "Inserting heartrate into database");
            Log.d ("CIS 3334", heartrate.toString());
        });
    }

}
