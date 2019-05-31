package com.example.myapplication.weather.request;

import com.example.myapplication.weather.model.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QueryWeatherRequest {
    @GET("weather/101280701.shtml")
    Call<WeatherData> queryWeather();
}
