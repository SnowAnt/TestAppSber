package pepelyaev.sberbank.com.testappsber;

import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;
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
    private String API_URL;
    private Double mLat;
    private Double mLon;


    public AsyncTaskWeather(Double lat,Double lon){
        mLat=lat;
        mLon=lon;
    }

    private  String KEY = "5e59f09ec79683ae0553cb07f650f820";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
         API_URL ="http://api.openweathermap.org/data/2.5/weather?lat="+mLat+"&lon="+mLon+"&APPID=" + KEY;;
         System.out.println(API_URL);
    }

    @Override
    protected String doInBackground(Integer... urls) {

   //     if (urls[0]==R.id.gps_button){

          //  API_URL =API_URL;
     //   }





        try {
            URL url = new URL(API_URL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            System.out.println(urlConnection.getResponseCode()+"");
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
             mJSONWeather = objectMapper.readValue(st, JsonWeather.class);



        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public JsonWeather getmJSONWeather() {
        return mJSONWeather;
    }
}
