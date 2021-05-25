package pl.jgraczykowski.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    assertThat(weatherForecast.getWeather(), not(emptyCollectionOf(Weather.class)));
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
    for (int i = 1; i < weatherForecast.getWeather().size(); i++) {
      assertEquals("15", getHourFromWeatherForecastElements(weatherForecast, i));
    }
  }

  private String getHourFromWeatherForecastElements(WeatherForecast weatherForecast, int elementNo) {

    return weatherForecast.getWeather().get(elementNo).getDate().substring(11, 13);
  }


}
