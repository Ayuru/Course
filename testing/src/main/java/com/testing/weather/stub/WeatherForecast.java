package com.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateMean() {

        double sum = 0;
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            sum = sum + temperature.getValue();

        }

        return sum / temperatures.getTemperatures().size();
    }

    public double calculateMedian() {

        List<Double> sortedTemperatures = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(sortedTemperatures);

        return sortedTemperatures.get(sortedTemperatures.size() / 2);
    }
}