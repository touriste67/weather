package com.touriste67.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Vincent on 21/03/2017.
 */
public interface OpenWeatherServerInterface {

    static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    //"http://api.openweathermap.org/data/2.5/weather?q=London&APPID=3482a79260584fa99d3997f3883428ce"

    @GET("weather?q={town}&APPID={appId}")
    Call<POST> getTownWeather(@Path("town") String town, @Path("appId") String appId);

    @GET("weather?q=London&APPID=3482a79260584fa99d3997f3883428ce")
    Call<WeatherData> getLondonWeather();

}
