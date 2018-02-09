package pepelyaev.sberbank.com.testappsber;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button mGpsButton;
    Button mCityButton;
    EditText mGditText;
    GPSTracker mGpsTracker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                break;


        }

    }
}

