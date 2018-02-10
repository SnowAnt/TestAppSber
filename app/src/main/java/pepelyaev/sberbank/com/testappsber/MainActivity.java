package pepelyaev.sberbank.com.testappsber;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Data.JsonWeather;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button mGpsButton;
    Button mCityButton;
    EditText mGditText;
    GPSTracker mGpsTracker;
    JsonWeather jsonWeather;
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
        temp=findViewById(R.id.temp_value);
        pressure=findViewById(R.id.pressure_value);
        humidity=findViewById(R.id.humidity_value);
        rain=findViewById(R.id.rain_value);
        snow=findViewById(R.id.snow_value);
        city=findViewById(R.id.city_value);
        wind=findViewById(R.id.wind_value);
         mGpsTracker=new GPSTracker(this);
        mGpsButton=findViewById(R.id.gps_button);
        mCityButton=findViewById(R.id.city_button);
        mGditText=findViewById(R.id.edit_text);
        mGpsButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {



        switch (view.getId()){
            case R.id.gps_button:
                AsyncTaskWeather asyncTaskWeather=new AsyncTaskWeather(mGpsTracker.getLatitude(),mGpsTracker.getLongitude());
                asyncTaskWeather.execute(R.id.gps_button);
                jsonWeather= asyncTaskWeather.getmJSONWeather();
                setValue(jsonWeather);
                break;


        }

    }

    public void setValue(JsonWeather jsonWeather) {
        if( jsonWeather==null){

        }
         temp.setText((jsonWeather.getMain().getTemp()-273) +" C");
         pressure.setText(jsonWeather.getMain().getPressure().toString());
         humidity.setText(jsonWeather.getMain().getHumidity().toString());
        // rain.setText(jsonWeather.getRain().getHThree());
        // snow.setText(jsonWeather.getSnow());
         city.setText(jsonWeather.getName());
         wind.setText(jsonWeather.getName());


    }
}

