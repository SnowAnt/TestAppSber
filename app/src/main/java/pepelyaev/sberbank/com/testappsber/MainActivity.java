package pepelyaev.sberbank.com.testappsber;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mGpsButton;
    Button mCityButton;
    EditText mGditText;
    GPSTracker mGpsTracker;
    TextView temp;
    TextView pressure;
    TextView humidity;
    TextView rain;
    TextView snow;
    TextView city;
    TextView wind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp = findViewById(R.id.temp_value);
        pressure = findViewById(R.id.pressure_value);
        humidity = findViewById(R.id.humidity_value);
        rain = findViewById(R.id.rain_value);
        snow = findViewById(R.id.snow_value);
        city = findViewById(R.id.city_value);
        wind = findViewById(R.id.wind_value);
        mGpsTracker = new GPSTracker(this);
        mGpsButton = findViewById(R.id.gps_button);
        mCityButton = findViewById(R.id.city_button);
        mGditText = findViewById(R.id.edit_text);
        mGpsButton.setOnClickListener(this);
        mCityButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        AsyncTaskWeather asyncTaskWeather;

        switch (view.getId()) {
            case R.id.gps_button:
                asyncTaskWeather = new AsyncTaskWeather(mGpsTracker.getLatitude(),
                        mGpsTracker.getLongitude(),
                        temp,
                        pressure,
                        humidity,
                        rain,
                        snow,
                        city,
                        wind,
                        mGditText.getText().toString(),
                        this.getApplicationContext());

                asyncTaskWeather.execute(R.id.gps_button);
                break;
            case R.id.city_button:
                if (mGditText.getText().toString().equals("")) {
                    Toast.makeText(this, "Введите название города", Toast.LENGTH_SHORT).show();
                    return;
                }
                asyncTaskWeather = new AsyncTaskWeather(mGpsTracker.getLatitude(),
                        mGpsTracker.getLongitude(),
                        temp,
                        pressure,
                        humidity,
                        rain,
                        snow,
                        city,
                        wind,
                        mGditText.getText().toString(),
                        this.getApplicationContext());

                asyncTaskWeather.execute(R.id.city_button);
                break;


        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}

