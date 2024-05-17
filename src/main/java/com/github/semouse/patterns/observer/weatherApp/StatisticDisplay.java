package com.github.semouse.patterns.observer.weatherApp;

public class StatisticDisplay implements Observer, WeatherDisplay {
    private final Subject weatherData;
    private float minTemperature;
    private float maxTemperature;
    private float avgTemperature;


    public StatisticDisplay(Subject weatherData) {
        this.minTemperature = Float.MAX_VALUE;
        this.maxTemperature = Float.MIN_VALUE;
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        maxTemperature = Math.max(temperature, maxTemperature);
        minTemperature = Math.min(temperature, minTemperature);
        avgTemperature = (minTemperature + maxTemperature) / 2;

        display();
    }

    @Override
    public void display() {
        System.out.printf("Avg/Max/Min temperature = %.1f/%.1f/%.1f%n", avgTemperature, maxTemperature,
                minTemperature);
    }
}
