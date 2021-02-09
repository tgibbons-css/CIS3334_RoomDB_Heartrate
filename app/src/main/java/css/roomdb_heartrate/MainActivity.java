package css.roomdb_heartrate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextPulse;
    EditText editTextAge;
    EditText editTextDisplay;
    Button buttonInsert, buttonUpdate;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAge = findViewById(R.id.editTextAge);
        editTextPulse = findViewById(R.id.editTextPulse);
        editTextDisplay = findViewById(R.id.editTextDisplay);
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pulse = Integer.parseInt(editTextPulse.getText().toString());
                Integer age = Integer.parseInt(editTextAge.getText().toString());
                mainViewModel.insert(pulse, age);

            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strRates = mainViewModel.getHeartratesAsString();
                editTextDisplay.setText(strRates);
            }
        });


    }
}