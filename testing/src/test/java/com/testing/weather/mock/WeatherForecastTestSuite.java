package com.testing.weather.mock;

import com.testing.weather.stub.Temperatures;
import com.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    @Test
    void testCalculateForecastWithMock() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateMeanWithMock() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Barcelona", 28.5);
        temperaturesMap.put("Madrid", 29.5);
        temperaturesMap.put("Sevilla", 27.6);
        temperaturesMap.put("Malaga", 25.3);
        temperaturesMap.put("Valencia", 21.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double mean = weatherForecast.calculateMean();

        //Then
        Assertions.assertEquals(26.4, mean);

    }

    @Test
    void testCalculateMedianWithMock() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("London", 7.2);
        temperaturesMap.put("Manchester", 5.5);
        temperaturesMap.put("Liverpool", 6.1);
        temperaturesMap.put("Newcastle upon Tyne", 1.8);
        temperaturesMap.put("Birmingham", 4.6);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double median = weatherForecast.calculateMedian();

        //Then
        Assertions.assertEquals(5.5, median);

    }
}