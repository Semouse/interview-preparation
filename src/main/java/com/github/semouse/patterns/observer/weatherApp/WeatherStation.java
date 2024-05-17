package com.github.semouse.patterns.observer.weatherApp;

public class WeatherStation {
    public static void main(String[] args) {
        var weatherData = new WeatherData();
        var currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        var statisticDisplay = new StatisticDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30);
        weatherData.setMeasurements(82, 70, 29);
        weatherData.setMeasurements(78, 90, 29);

    }
}
