package com.touriste67.weather;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //Button refreshButton = (Button) findViewById(R.id.refreshButton);
        //refreshButton.add
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static final String BASE_URL = "https://api.github.com";

    private OpenWeatherServerInterface openWeatherServerInterface = null;

    public void createOpenWeatherServerInterface(){

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                //.registerTypeAdapter(WeatherData.class, new WeatherTypeAdapter())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(OpenWeatherServerInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        openWeatherServerInterface = retrofit.create(OpenWeatherServerInterface.class);
    }



    @Click(R.id.refreshButton)
    public void onClickRefreshButton() {

        createOpenWeatherServerInterface();
        openWeatherServerInterface.getLondonWeather().enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                Log.i("BusinessService", "The call is back with success");

                response.body();
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Log.e("BusinessService", "The call is back with error: " + t.getMessage());
            }
        });

    }



}
