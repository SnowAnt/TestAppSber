package pepelyaev.sberbank.com.testappsber;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Data.JsonWeather;

/**
 * Created by Anton on 04.02.2018.
 */

public class AsyncTaskWeather extends AsyncTask<Integer, Void, String> {


    private JsonWeather mJSONWeather;
    private String mAPIURL;
    private Double mLat;
    private Double mLon;
    private TextView mTemp;
    private TextView mPressure;
    private TextView mHumidity;
    private TextView mRain;
    private TextView mSnow;
    private TextView mCity;
    private TextView mWind;
    private String mAPIURLGPS;
    private String mAPIURLCity;
    private String mCityName;
    private Context mContext;


    public AsyncTaskWeather(Double lat,
                            Double lon,
                            TextView temp,
                            TextView pressure,
                            TextView humidity,
                            TextView rain,
                            TextView snow,
                            TextView city,
                            TextView wind,
                            String cityName,
                            Context context) {
        mLat = lat;
        mLon = lon;
        mTemp = temp;
        mPressure = pressure;
        mHumidity = humidity;
        mRain = rain;
        mSnow = snow;
        mCity = city;
        mWind = wind;
        mCityName = cityName;
        mContext = context;
    }

    private String KEY = "5e59f09ec79683ae0553cb07f650f820";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mAPIURLGPS = "http://api.openweathermap.org/data/2.5/weather?lat=" + mLat + "&lon=" + mLon + "&APPID=" + KEY;
        mAPIURLCity = "http://api.openweathermap.org/data/2.5/weather?q=" + mCityName + "&type=like&lang=ru&APPID=" + KEY;
    }

    @Override
    protected String doInBackground(Integer... urls) {

        if (urls[0] == R.id.gps_button) {

            mAPIURL = mAPIURLGPS;
        }
        if (urls[0] == R.id.city_button) {

            mAPIURL = mAPIURLCity;
        }


        try {
            URL url = new URL(mAPIURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() != 200) {

                urlConnection.disconnect();
                return "нет";
            }
            urlConnection.setRequestMethod("POST");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            } finally {
                urlConnection.disconnect();
            }


        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return "нет";
        }

    }

    @Override
    protected void onPostExecute(String o) {
        super.onPostExecute(o);
        if (o.equals("нет")) {
            Toast.makeText(mContext, "Что-то пошло не так!Скорректируйте данные и повторите запрос", Toast.LENGTH_SHORT).show();
            return;
        }
        parseJackson(o);
    }

    private void parseJackson(String st) {
        if (st == null) {
            return;
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            mJSONWeather = objectMapper.readValue(st, JsonWeather.class);
            setValue(mJSONWeather);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void setValue(JsonWeather lJsonWeather) {
        if (lJsonWeather == null) {
            return;
        }
        mTemp.setText("  " + (lJsonWeather.getMain().getTemp() - 273) + " C");
        mPressure.setText("  " + lJsonWeather.getMain().getPressure().toString());
        mHumidity.setText("  " + lJsonWeather.getMain().getHumidity().toString());
        mRain.setText((lJsonWeather.getRain() == null) ? "   -" : "  " + lJsonWeather.getRain().getH().toString());
        mSnow.setText((lJsonWeather.getSnow() == null) ? "   -" : "  " + lJsonWeather.getSnow().getH().toString());
        mCity.setText("  " + lJsonWeather.getName());
        mWind.setText("  " + lJsonWeather.getWind().getSpeed().toString());


    }
}
