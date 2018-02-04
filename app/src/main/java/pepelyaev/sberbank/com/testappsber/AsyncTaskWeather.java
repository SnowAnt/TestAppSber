package pepelyaev.sberbank.com.testappsber;

import android.os.AsyncTask;
import android.util.Log;

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

public class AsyncTaskWeather extends AsyncTask<Void, Void, String> {

    private static Double lat;
    private static Double lon;


    static final String KEY = "5e59f09ec79683ae0553cb07f650f820";

    static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&APPID=" + KEY;

    @Override
    protected String doInBackground(Void... urls) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == 200) {
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
            } else {
                urlConnection.disconnect();
            }


        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
        return null;
    }

    @Override
    protected void onPostExecute(String o) {
        super.onPostExecute(o);
        parseJackson(o);
    }

    private void parseJackson(String st) {
        if (st == null) {
            return;
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonWeather jsonWeather = objectMapper.readValue(st, JsonWeather.class);
            Log.d("tempa",jsonWeather.getMain().getTemp()+"");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void update(Double latitude, Double longitude) {
       lat = latitude;
       lon = longitude;


    }
}
