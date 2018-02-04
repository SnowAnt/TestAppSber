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

    static final String KEY="5e59f09ec79683ae0553cb07f650f820";

    static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&APPID="+KEY;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... urls) {
        try {
            URL url = new URL(API_URL);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
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
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }



    }

    @Override
    protected void onPostExecute(String o) {
        parseJackson(o);
        super.onPostExecute(o);
    }

    private void parseJackson(String st){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonWeather jsonWeather = objectMapper.readValue(st, JsonWeather.class);
            Log.d("tag",jsonWeather.getBase());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
