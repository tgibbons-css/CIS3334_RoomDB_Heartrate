package css.roomdb_heartrate;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainViewModel extends AndroidViewModel {

    private HeartrateRepository heartrateRepository;
    private List<Heartrate> heartrateList;


    public MainViewModel(@NonNull Application application) {
        super(application);
        heartrateRepository = new HeartrateRepository(application);
        List heartrateList = new ArrayList<Heartrate>();
        //heartrateList = heartrateRepository.getAllHeartrates();
    }

    List<Heartrate> getAllHeartrates() {
        return heartrateRepository.getAllHeartrates();
    }

    String getHeartratesAsString () {
        // DEBT - currently returns only first heartrate
        String retString = "";
        heartrateList = heartrateRepository.getAllHeartrates();
        for (Heartrate hr:heartrateList) {
            retString = retString +  hr.toString();
        }
        return retString;
    }
    public void insert(Integer heartRate, Integer age) {
        Heartrate hr = new Heartrate(heartRate, age);
        heartrateRepository.insert(hr);
    }

}
