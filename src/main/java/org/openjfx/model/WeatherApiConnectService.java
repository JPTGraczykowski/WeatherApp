package org.openjfx.model;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.openjfx.model.StaticValues.*;

public class WeatherApiConnectService {

  private String country;
  private String city;
  private GsonObject gsonObject = new GsonObject();
  private List<FullWeatherData> fullWeatherData;

  public WeatherApiConnectService(String country, String city) {
    this.country = country;
    this.city = city;
  }

  public void getResponse() throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create(
        "http://api.openweathermap.org/data/2.5/weather?q=" +
          city + "," + country +
          "&units=metric&lang=en&appid=" +
          API_KEY
        ))
      .GET()
      .build();

    try {
      var response = client.send(request, HttpResponse.BodyHandlers.ofString());

      gsonObject = new Gson().fromJson(response.body(), GsonObject.class);
      fullWeatherData = gsonObject.getFullWeatherData();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public GsonObject getGsonObject() {
    return gsonObject;
  }

  public void setGsonObject(GsonObject gsonObject) {
    this.gsonObject = gsonObject;
  }

  public List<FullWeatherData> getFullWeatherData() {
    return fullWeatherData;
  }

  public void setFullWeatherData(List<FullWeatherData> fullWeatherData) {
    this.fullWeatherData = fullWeatherData;
  }
}
