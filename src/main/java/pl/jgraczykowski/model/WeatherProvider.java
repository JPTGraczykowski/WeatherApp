package pl.jgraczykowski.model;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.jgraczykowski.config.Constants;
import pl.jgraczykowski.config.Secrets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeatherProvider {

  private JSONObject weatherJson;
  private JSONObject mainWeatherJson;
  private static final String MIDDLE_DAY_HOUR = "15";

  public WeatherProvider() {
  }

  public WeatherForecast getWeatherForecast(String city) {
    Result apiResponseResult;
    List<Weather> weatherList = new ArrayList<>();
    JSONObject apiResponse = null;

    try {
      apiResponse = getWeatherApiResponse(city);
      apiResponseResult = Result.SUCCESS;
    } catch (FileNotFoundException e) {
      apiResponseResult = Result.WRONG_CITY;
      e.printStackTrace();
    } catch (Exception e) {
      apiResponseResult = Result.UNKNOWN;
      e.printStackTrace();
    }

    if (apiResponseResult == Result.SUCCESS) {
      weatherList = setWeatherList(apiResponse);

      if (!validateForecastLength(weatherList)) {
        apiResponseResult = Result.UNKNOWN;
      }
    }

    return new WeatherForecast(weatherList, apiResponseResult);
  }

  private JSONObject getWeatherApiResponse(String city) throws IOException {

    return JsonReader.readJsonFromUrl(
      "http://api.openweathermap.org/data/2.5/forecast?q=" +
        city +
        "&cnt=33&lang=en&units=metric&appid=" +
        Secrets.API_KEY
    );
  }

  private List<Weather> setWeatherList(JSONObject apiResponse) {

    List<Weather> weatherList = new ArrayList<>();

    JSONArray weatherForecastJson = apiResponse.getJSONArray("list");
    int listLength = weatherForecastJson.length();

    for (int jsonElement = 0; jsonElement < listLength; jsonElement++) {
      weatherJson = weatherForecastJson.getJSONObject(jsonElement);
      mainWeatherJson = weatherJson.getJSONObject("main");

      // first weather object or weather object at 15:00
      if (jsonElement == 0 || isMiddleDay(weatherJson.getString("dt_txt"))) {
        Weather weather = setWeather();
        weatherList.add(weather);
      }
    }

    return weatherList;
  }

  private boolean validateForecastLength(List<Weather> weatherList) {
    return weatherList.size() == Constants.FORECAST_LENGTH;
  }

  private Weather setWeather() {
    return new Weather(
      getFeelsLikeTemp(),
      getMaxTemp(),
      getMinTemp(),
      getPressure(),
      getHumidity(),
      getWindSpeed(),
      getCloudsPercentage(),
      getDescription(),
      getDate());
  }

  private String getDate() {
    String date = weatherJson.getString("dt_txt");
    date = date.substring(0, 16);
    return date;
  }

  private double getFeelsLikeTemp() {
    return mainWeatherJson.getDouble("feels_like");
  }

  private double getMaxTemp() {
    return mainWeatherJson.getDouble("temp_max");
  }

  private double getMinTemp() {
    return mainWeatherJson.getDouble("temp_min");
  }

  private double getPressure() {
    return mainWeatherJson.getDouble("pressure");
  }

  private double getHumidity() {
    return mainWeatherJson.getDouble("humidity");
  }

  private double getWindSpeed() {
    return weatherJson.getJSONObject("wind").getDouble("speed");
  }

  private double getCloudsPercentage() {
    return weatherJson.getJSONObject("clouds").getDouble("all");
  }

  private String getDescription() {
    return weatherJson
      .getJSONArray("weather")
      .getJSONObject(0)
      .getString("description");
  }

  private boolean isMiddleDay(String date) {
    String hour = date.substring(11, 13);
    return hour.equals(MIDDLE_DAY_HOUR);
  }
}