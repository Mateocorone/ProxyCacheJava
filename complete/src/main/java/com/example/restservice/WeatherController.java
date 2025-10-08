package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService service = new WeatherProxy(new RealWeatherService());

    @GetMapping("/weather")
    public Weather getWeather(@RequestParam(defaultValue = "Roma") String city) {
        return service.getWeather(city);
    }
}
