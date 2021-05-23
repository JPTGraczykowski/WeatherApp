package pl.jgraczykowski.model;

import java.util.List;

public class WeatherForecast {

  private final List<Weather> weather;
  private final Result result;

  public WeatherForecast(List<Weather> weather, Result result) {
    this.weather = weather;
    this.result = result;
  }

  public List<Weather> getWeather() {
    return weather;
  }

  public Result getResult() {
    return result;
  }
}
