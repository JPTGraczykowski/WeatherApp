package org.openjfx.model;

import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherProvider {

  private String city;
  private final Weather weather;

  private JSONObject weatherJson;
  private JSONObject mainWeatherJson;

  public WeatherProvider(String city) {
    this.city = city;
    weather = new Weather();
  }

  public boolean setWeather() {
    try {
      weatherJson = JsonReader.readJsonFromUrl("http://api.openweathermap.org/data/2.5/weather?q=" +
        city + "&appid=" + Constants.API_KEY + "&lang=en&units=metric");

      mainWeatherJson = weatherJson.getJSONObject("main");

      setWeatherAttributes();
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  private void setWeatherAttributes() {
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
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();

    weather.setDate(formatter.format(date));
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
}