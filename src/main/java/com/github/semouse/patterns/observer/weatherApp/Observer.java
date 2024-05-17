package com.github.semouse.patterns.observer.weatherApp;

public interface Observer {
    void update(float temperature, float humidity, float pressure);
}
