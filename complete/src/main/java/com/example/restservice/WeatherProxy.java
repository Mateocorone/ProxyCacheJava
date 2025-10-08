package com.example.restservice;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class WeatherProxy implements WeatherService {

    private final WeatherService realService;
    private final Map<String, Weather> cache = new HashMap<>();

    public WeatherProxy(WeatherService realService) {
        this.realService = realService;
    }

    @Override
    public Weather getWeather(String city) {
        if (cache.containsKey(city.toLowerCase(Locale.ROOT))) {
            System.out.println("Cache HIT for " + city);
            return cache.get(city);
        }

        System.out.println("Cache MISS for " + city);
        Weather result = realService.getWeather(city);
        cache.put(city.toLowerCase(Locale.ROOT), result);
        return result;
    }
}
