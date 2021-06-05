package pl.jgraczykowski.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherProviderTest {
  private WeatherProvider weatherProvider;

  @BeforeEach
  void initializeWeatherProvider() {
    weatherProvider = new WeatherProvider();
  }

  @Test
  void apiResponseResultShouldBeSuccessWhenEverythingIsCorrect() {

    // when
    WeatherForecast weatherForecast = weatherProvider.getWeatherForecast("London");

    // then
    assertEquals(Result.SUCCESS, weatherForecast.getResult());
  }

  @Test
  void apiResponseResultShouldBeWrongCityWhenPassedWrongCity() {

    // when
    WeatherForecast weatherForecast = weatherProvider.getWeatherForecast("WrongCityExample");

    // then
    assertEquals(Result.WRONG_CITY, weatherForecast.getResult());
  }

  @Test
  void weatherListShouldContainFiveObjectsOfWeather() {

    // when
    WeatherForecast weatherForecast = weatherProvider.getWeatherForecast("London");

    // then
    assertThat(weatherForecast.getWeather(), hasSize(5));
  }

  @Test
  void weatherListShouldBeEmptyWhenWrongCityPassed() {

    // when
    WeatherForecast weatherForecast = weatherProvider.getWeatherForecast("WrongCityExample");

    // then
    assertThat(weatherForecast.getWeather(), emptyCollectionOf(Weather.class));
  }

  @Test
  void otherDaysThanFirstShouldHaveSetHourTo3PM() {

    // when
    WeatherForecast weatherForecast = weatherProvider.getWeatherForecast("London");

    // then
    assertEquals("15", weatherForecast.getWeather().get(1).getHour());
    assertEquals("15", weatherForecast.getWeather().get(2).getHour());
    assertEquals("15", weatherForecast.getWeather().get(3).getHour());
    assertEquals("15", weatherForecast.getWeather().get(4).getHour());
  }
}
