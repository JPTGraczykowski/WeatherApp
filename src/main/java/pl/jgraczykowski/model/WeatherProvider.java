package pl.jgraczykowski.model;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.jgraczykowski.config.Secrets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeatherProvider {

  private final List<Weather> weatherForecast;
  private Weather weather;
  private JSONObject apiResponse;
  private JSONObject weatherJson;
  private JSONObject mainWeatherJson;

  public WeatherProvider() {
    weatherForecast = new ArrayList<>();
  }

  public boolean setWeatherForecast(String city) {
    boolean succeeded = getWeatherApiResponse(city);
    if (succeeded) {
      JSONArray weatherForecastJson = apiResponse.getJSONArray("list");
      int listLength = weatherForecastJson.length();

      for (int jsonElement = 0; jsonElement < listLength; jsonElement++) {
        weatherJson = weatherForecastJson.getJSONObject(jsonElement);
        mainWeatherJson = weatherJson.getJSONObject("main");

        // first weather object or weather object at 15:00
        if (jsonElement == 0 || isMiddleDay(weatherJson.getString("dt_txt"))) {
          weather = new Weather();
          setWeather();
          weatherForecast.add(weather);
        }
      }
    }
    return succeeded;
  }

  private boolean getWeatherApiResponse(String city) {
    try {
      apiResponse = JsonReader.readJsonFromUrl(
        "http://api.openweathermap.org/data/2.5/forecast?q=" +
          city +
          "&cnt=33&lang=en&units=metric&appid=" +
          Secrets.API_KEY
      );
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
    date = date.substring(0, 16);
    weather.setDate(date);
  }

  private void setFeelsLikeTemp() {
    weather.setFeelsLikeTemp(mainWeatherJson.getDouble("feels_like"));
  }

  private void setMaxTemp() {
    weather.setMaxTemp(mainWeatherJson.getDouble("temp_max"));
  }

  private void setMinTemp() {
    weather.setMinTemp(mainWeatherJson.getDouble("temp_min"));
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

  private boolean isMiddleDay(String date) {
    String hour = date.substring(10, 13);
    String middleDayHour = "15";
    return hour.trim().equals(middleDayHour);
  }

  public List<Weather> getWeatherForecast() {
    return weatherForecast;
  }
}