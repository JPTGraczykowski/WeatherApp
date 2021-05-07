package org.openjfx.model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openjfx.config.Secrets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeatherProvider {

  private String city;
  private final List<Weather> weatherForecast;
  private final Weather weather;
  private JSONObject weatherJson;
  private JSONObject mainWeatherJson;

  public WeatherProvider(String city) {
    this.city = city;
    weather = new Weather();
    weatherForecast = new ArrayList<>();
  }

  public boolean setWeatherForecast() {
    try {
      JSONObject apiResponse = JsonReader.readJsonFromUrl("http://api.openweathermap.org/data/2.5/forecast?q=" +
        city + "&cnt=33&lang=en&units=metric&appid=" + Secrets.API_KEY);

      JSONArray weatherForecastJson = apiResponse.getJSONArray("list");

      for (int jsonElement = 0; jsonElement < 33; jsonElement += 8) {
        weatherJson = weatherForecastJson.getJSONObject(jsonElement);
        mainWeatherJson = weatherJson.getJSONObject("main");
        setWeather();
        weatherForecast.add(weather);
      }

      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  private void setWeather() {
    setDate();
    setFeelsLikeTemp();
    setMaxTemp();
    setMinTemp();
    setPressure();
    setHumidity();
    setWindSpeed();
    setCloudsPercentage();
    setDescription();
  }

  private void setDate() {
    String date = weatherJson.getString("dt_txt");
    date = date.substring(0,9);
    weather.setDate(date);
  }

  private void setFeelsLikeTemp() {
    weather.setFeelsLikeTemp(mainWeatherJson.getDouble("feels_like"));
  }

  private void setMaxTemp() {
    weather.setMaxTemp(mainWeatherJson.getDouble("temp_max"));
  }

  private void setMinTemp() {
    weather.setMaxTemp(mainWeatherJson.getDouble("temp_min"));
  }

  private void setPressure() {
    weather.setPressure(mainWeatherJson.getDouble("pressure"));
  }

  private void setHumidity() {
    weather.setHumidity(mainWeatherJson.getDouble("humidity"));
  }

  private void setWindSpeed() {
    weather.setWindSpeed(weatherJson.getJSONObject("wind").getDouble("speed"));
  }

  private void setCloudsPercentage() {
    weather.setCloudsPercentage(weatherJson.getJSONObject("clouds").getDouble("all"));
  }

  private void setDescription() {
    weather.setDescription(
      weatherJson
        .getJSONArray("weather")
        .getJSONObject(0)
        .getString("description")
    );
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Weather getWeather() {
    return weather;
  }

  public List<Weather> getWeatherForecast() {
    return weatherForecast;
  }
}