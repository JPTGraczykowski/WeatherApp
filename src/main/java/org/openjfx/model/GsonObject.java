package org.openjfx.model;

import java.util.List;

public class GsonObject {
  private List<FullWeatherData> fullWeatherData;
  private City city;

  public List<FullWeatherData> getFullWeatherData() {
    return fullWeatherData;
  }

  public void setFullWeatherData(List<FullWeatherData> fullWeatherData) {
    this.fullWeatherData = fullWeatherData;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }
}
