package com.touriste67.weather;

import android.util.Log;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by Vincent on 14/08/2017.
 */

public class WeatherTypeAdapter extends TypeAdapter<WeatherData> {


    private final static String TAG = WeatherTypeAdapter.class.getName();

    @Override
    public void write(JsonWriter out, WeatherData value) throws IOException {
        Log.i("WeatherTypeAdapter", "value:" + out.toString());
    }

    @Override
    public WeatherData read(JsonReader in) throws IOException {

        Log.i(TAG, "!!! read !!!");

        final WeatherData weather = new WeatherData();

        in.beginObject();
        while (in.hasNext()) {

            Log.i(TAG, "in.nextName()=" + in.nextName());


            switch (in.nextName()) {
                case "coord":
                    String lat = null;
                    String lon = null;

                    while (lat == null && lon == null) {
                        if (in.nextName() == "lat") {
                            lat = in.nextString();
                        }
                        if (in.nextName() == "lon") {
                            lon = in.nextString();
                        }
                    }
                    Log.i(TAG, "coord=" + lat + "|" + lon);


                    break;
                case "weather":
                    Log.i(TAG, "weather");
                    break;
                case "authors":

                    break;
            }

        }
        in.endObject();

        return weather;
    }
}
