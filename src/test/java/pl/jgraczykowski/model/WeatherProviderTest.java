package pl.jgraczykowski.model;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static pl.jgraczykowski.config.Secrets.EXAMPLE_API_RESPONSE;

@ExtendWith(MockitoExtension.class)
public class WeatherProviderTest {

  @InjectMocks
  private WeatherProvider weatherProvider;

  @Mock
  private JsonReader jsonReader;

  @Test
  void apiResponseResultShouldBeSuccessWhenEverythingIsCorrect() throws IOException {

    // given
    when(jsonReader.readJsonFromUrl(anyString())).thenReturn(
      new JSONObject(EXAMPLE_API_RESPONSE)
    );

    // when
    WeatherForecast weatherForecast = weatherProvider.getWeatherForecast("London");

    // then
    assertEquals(Result.SUCCESS, weatherForecast.getResult());
  }

  @Test
  void apiResponseResultShouldBeWrongCityWhenPassedWrongCity() throws IOException {

    // given
    when(jsonReader.readJsonFromUrl(anyString())).thenThrow(new FileNotFoundException());

    // when
    WeatherForecast weatherForecast = weatherProvider.getWeatherForecast("WrongCityExample");

    // then
    assertEquals(Result.WRONG_CITY, weatherForecast.getResult());
  }

  @Test
  void apiResponseResultUnknownErrorWhenIsMappedCorrectly() throws IOException {

    // given
    when(jsonReader.readJsonFromUrl(anyString())).thenThrow(new IOException());

    // when
    WeatherForecast weatherForecast = weatherProvider.getWeatherForecast("London");

    // then
    assertEquals(Result.UNKNOWN, weatherForecast.getResult());
  }

  @Test
  void weatherListShouldContainFiveObjectsOfWeather() throws IOException {

    // given
    when(jsonReader.readJsonFromUrl(anyString())).thenReturn(
      new JSONObject(EXAMPLE_API_RESPONSE)
    );

    // when
    WeatherForecast weatherForecast = weatherProvider.getWeatherForecast("London");

    // then
    assertThat(weatherForecast.getWeather(), hasSize(5));
  }

  @Test
  void weatherListShouldBeEmptyWhenWrongCityPassed() throws IOException {

    // given
    when(jsonReader.readJsonFromUrl(anyString())).thenThrow(new FileNotFoundException());

    // when
    WeatherForecast weatherForecast = weatherProvider.getWeatherForecast("WrongCityExample");

    // then
    assertThat(weatherForecast.getWeather(), emptyCollectionOf(Weather.class));
  }

  @Test
  void otherDaysThanFirstShouldHaveSetHourTo3PM() throws IOException {

    // given
    when(jsonReader.readJsonFromUrl(anyString())).thenReturn(
      new JSONObject(EXAMPLE_API_RESPONSE)
    );

    // when
    WeatherForecast weatherForecast = weatherProvider.getWeatherForecast("London");

    // then
    assertEquals("15", weatherForecast.getWeather().get(1).getHour());
    assertEquals("15", weatherForecast.getWeather().get(2).getHour());
    assertEquals("15", weatherForecast.getWeather().get(3).getHour());
    assertEquals("15", weatherForecast.getWeather().get(4).getHour());
  }
}
