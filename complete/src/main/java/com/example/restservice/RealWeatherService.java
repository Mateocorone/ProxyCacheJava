package com.example.restservice;

import java.util.Random;

public class RealWeatherService implements WeatherService {

    private static final String[] forecasts = {
            "Soleado", "Lluvioso", "Nublado", "Tormentoso", "Nevado"
    };

    @Override
    public Weather getWeather(String city) {
        // simulamos una llamada lenta
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        String forecast = forecasts[new Random().nextInt(forecasts.length)];
        return new Weather(city, forecast);
    }
}
