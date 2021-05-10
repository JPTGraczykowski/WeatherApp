package org.openjfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.openjfx.config.Constants;
import org.openjfx.model.Weather;
import org.openjfx.model.WeatherProvider;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

  @FXML
  private TextField firstCity;

  @FXML
  private TextField secondCity;

  @FXML
  private Label errorLabel1;

  @FXML
  private Label errorLabel2;

  // ================= First City ================================

  @FXML
  private Label firstCityDateLabel1;

  @FXML
  private Label firstCityFeelsLikeTempLabel1;

  @FXML
  private Label firstCityMaxTempLabel1;

  @FXML
  private Label firstCityMinTempLabel1;

  @FXML
  private Label firstCityPressureLabel1;

  @FXML
  private Label firstCityHumidityLabel1;

  @FXML
  private Label firstCityWindSpeedLabel1;

  @FXML
  private Label firstCityCloudsLabel1;

  @FXML
  private Label firstCityDescriptionLabel1;

  @FXML
  private Label firstCityDateLabel2;

  @FXML
  private Label firstCityFeelsLikeTempLabel2;

  @FXML
  private Label firstCityMaxTempLabel2;

  @FXML
  private Label firstCityMinTempLabel2;

  @FXML
  private Label firstCityPressureLabel2;

  @FXML
  private Label firstCityHumidityLabel2;

  @FXML
  private Label firstCityWindSpeedLabel2;

  @FXML
  private Label firstCityCloudsLabel2;

  @FXML
  private Label firstCityDescriptionLabel2;

  @FXML
  private Label firstCityDateLabel3;

  @FXML
  private Label firstCityFeelsLikeTempLabel3;

  @FXML
  private Label firstCityMaxTempLabel3;

  @FXML
  private Label firstCityMinTempLabel3;

  @FXML
  private Label firstCityPressureLabel3;

  @FXML
  private Label firstCityHumidityLabel3;

  @FXML
  private Label firstCityWindSpeedLabel3;

  @FXML
  private Label firstCityCloudsLabel3;

  @FXML
  private Label firstCityDescriptionLabel3;

  @FXML
  private Label firstCityDateLabel4;

  @FXML
  private Label firstCityFeelsLikeTempLabel4;

  @FXML
  private Label firstCityMaxTempLabel4;

  @FXML
  private Label firstCityMinTempLabel4;

  @FXML
  private Label firstCityPressureLabel4;

  @FXML
  private Label firstCityHumidityLabel4;

  @FXML
  private Label firstCityWindSpeedLabel4;

  @FXML
  private Label firstCityCloudsLabel4;

  @FXML
  private Label firstCityDescriptionLabel4;

  @FXML
  private Label firstCityDateLabel5;

  @FXML
  private Label firstCityFeelsLikeTempLabel5;

  @FXML
  private Label firstCityMaxTempLabel5;

  @FXML
  private Label firstCityMinTempLabel5;

  @FXML
  private Label firstCityPressureLabel5;

  @FXML
  private Label firstCityHumidityLabel5;

  @FXML
  private Label firstCityWindSpeedLabel5;

  @FXML
  private Label firstCityCloudsLabel5;

  @FXML
  private Label firstCityDescriptionLabel5;

  // ================= Second City ================================

  @FXML
  private Label secondCityDateLabel1;

  @FXML
  private Label secondCityFeelsLikeTempLabel1;

  @FXML
  private Label secondCityMaxTempLabel1;

  @FXML
  private Label secondCityMinTempLabel1;

  @FXML
  private Label secondCityPressureLabel1;

  @FXML
  private Label secondCityHumidityLabel1;

  @FXML
  private Label secondCityWindSpeedLabel1;

  @FXML
  private Label secondCityCloudsLabel1;

  @FXML
  private Label secondCityDescriptionLabel1;

  @FXML
  private Label secondCityDateLabel2;

  @FXML
  private Label secondCityFeelsLikeTempLabel2;

  @FXML
  private Label secondCityMaxTempLabel2;

  @FXML
  private Label secondCityMinTempLabel2;

  @FXML
  private Label secondCityPressureLabel2;

  @FXML
  private Label secondCityHumidityLabel2;

  @FXML
  private Label secondCityWindSpeedLabel2;

  @FXML
  private Label secondCityCloudsLabel2;

  @FXML
  private Label secondCityDescriptionLabel2;

  @FXML
  private Label secondCityDateLabel3;

  @FXML
  private Label secondCityFeelsLikeTempLabel3;

  @FXML
  private Label secondCityMaxTempLabel3;

  @FXML
  private Label secondCityMinTempLabel3;

  @FXML
  private Label secondCityPressureLabel3;

  @FXML
  private Label secondCityHumidityLabel3;

  @FXML
  private Label secondCityWindSpeedLabel3;

  @FXML
  private Label secondCityCloudsLabel3;

  @FXML
  private Label secondCityDescriptionLabel3;

  @FXML
  private Label secondCityDateLabel4;

  @FXML
  private Label secondCityFeelsLikeTempLabel4;

  @FXML
  private Label secondCityMaxTempLabel4;

  @FXML
  private Label secondCityMinTempLabel4;

  @FXML
  private Label secondCityPressureLabel4;

  @FXML
  private Label secondCityHumidityLabel4;

  @FXML
  private Label secondCityWindSpeedLabel4;

  @FXML
  private Label secondCityCloudsLabel4;

  @FXML
  private Label secondCityDescriptionLabel4;

  @FXML
  private Label secondCityDateLabel5;

  @FXML
  private Label secondCityFeelsLikeTempLabel5;

  @FXML
  private Label secondCityMaxTempLabel5;

  @FXML
  private Label secondCityMinTempLabel5;

  @FXML
  private Label secondCityPressureLabel5;

  @FXML
  private Label secondCityHumidityLabel5;

  @FXML
  private Label secondCityWindSpeedLabel5;

  @FXML
  private Label secondCityCloudsLabel5;

  @FXML
  private Label secondCityDescriptionLabel5;

  private WeatherProvider firstCityWeatherProvider;
  private WeatherProvider secondCityWeatherProvider;

  public PrimaryController() {
    firstCityWeatherProvider = new WeatherProvider("");
    secondCityWeatherProvider = new WeatherProvider("");
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    setHomeCityTextField(firstCity, "Lodz");
    setWeatherForecast("Lodz", firstCityWeatherProvider, getListOfLabelsForFirstCity(), errorLabel1);
  }

  @FXML
  void firstShowButtonAction() {
    firstCityWeatherProvider = new WeatherProvider("");
    String cityName = getCityName(firstCity);
    setWeatherForecast(cityName, firstCityWeatherProvider, getListOfLabelsForFirstCity(), errorLabel1);
  }

  @FXML
  void secondShowButtonAction() {
//    String cityName = getCityName(secondCity);
//    setWeatherForTheCity(
//      cityName, secondCityWeatherProvider,
//      errorLabel2, secondCityDateLabel1,
//      secondCityFeelsLikeTempLabel1, secondCityMaxTempLabel1,
//      secondCityMinTempLabel1, secondCityPressureLabel1,
//      secondCityHumidityLabel1, secondCityWindSpeedLabel1,
//      secondCityCloudsLabel1, secondCityDescriptionLabel1
//    );
  }

  private String getCityName(TextField city) {
    return city.getText();
  }

  private void setHomeCityTextField(TextField city, String cityName) {
    city.setText(cityName);
  }

  private void setWeatherForecast(String cityName,
                                  WeatherProvider weatherProvider,
                                  List<List<Label>> listOfLabels,
                                  Label errorLabel) {
    if(validateCityName(cityName)) {
      weatherProvider.setCity(cityName);
      if (weatherProvider.setWeatherForecast()) {
        List<Weather> weatherForecast = weatherProvider.getWeatherForecast();
        errorLabel.setText("");
        int index = 0;
        for(Weather weather: weatherForecast) {
          setDailyWeather(weather, listOfLabels.get(index));
          index++;
        };
      } else {
        errorLabel.setText("Wrong City!");
      }
    } else {
      errorLabel.setText("City Name is required!");
    }
  }

  private void setDailyWeather(Weather weather, List<Label> labels) {
      labels.get(0).setText(weather.getDate());
      labels.get(1).setText(String.valueOf(weather.getFeelsLikeTemp()));
      labels.get(2).setText(String.valueOf(weather.getMaxTemp()));
      labels.get(3).setText(String.valueOf(weather.getMinTemp()));
      labels.get(4).setText(String.valueOf(weather.getPressure()));
      labels.get(5).setText(String.valueOf(weather.getHumidity()));
      labels.get(6).setText(String.valueOf(weather.getWindSpeed()));
      labels.get(7).setText(String.valueOf(weather.getCloudsPercentage()));
      labels.get(8).setText(weather.getDescription());
  }

  private List<List<Label>> getListOfLabelsForFirstCity() {
    return Arrays.asList(
      firstCityDay1Labels(), firstCityDay2Labels(),
      firstCityDay3Labels(), firstCityDay4Labels(),
      firstCityDay5Labels()
    );
  }

  private List<Label> firstCityDay1Labels() {
    return Arrays.asList(
      firstCityDateLabel1,
      firstCityFeelsLikeTempLabel1, firstCityMaxTempLabel1,
      firstCityMinTempLabel1, firstCityPressureLabel1,
      firstCityHumidityLabel1, firstCityWindSpeedLabel1,
      firstCityCloudsLabel1, firstCityDescriptionLabel1
    );
  }

  private List<Label> firstCityDay2Labels() {
    return Arrays.asList(
      firstCityDateLabel2,
      firstCityFeelsLikeTempLabel2, firstCityMaxTempLabel2,
      firstCityMinTempLabel2, firstCityPressureLabel2,
      firstCityHumidityLabel2, firstCityWindSpeedLabel2,
      firstCityCloudsLabel2, firstCityDescriptionLabel2
    );
  }

  private List<Label> firstCityDay3Labels() {
    return Arrays.asList(
      firstCityDateLabel3,
      firstCityFeelsLikeTempLabel3, firstCityMaxTempLabel3,
      firstCityMinTempLabel3, firstCityPressureLabel3,
      firstCityHumidityLabel3, firstCityWindSpeedLabel3,
      firstCityCloudsLabel3, firstCityDescriptionLabel3
    );
  }

  private List<Label> firstCityDay4Labels() {
    return Arrays.asList(
      firstCityDateLabel4,
      firstCityFeelsLikeTempLabel4, firstCityMaxTempLabel4,
      firstCityMinTempLabel4, firstCityPressureLabel4,
      firstCityHumidityLabel4, firstCityWindSpeedLabel4,
      firstCityCloudsLabel4, firstCityDescriptionLabel4
    );
  }

  private List<Label> firstCityDay5Labels() {
    return Arrays.asList(
      firstCityDateLabel5,
      firstCityFeelsLikeTempLabel5, firstCityMaxTempLabel5,
      firstCityMinTempLabel5, firstCityPressureLabel5,
      firstCityHumidityLabel5, firstCityWindSpeedLabel5,
      firstCityCloudsLabel5, firstCityDescriptionLabel5
    );
  }

  private boolean validateCityName(String cityName) {
    return !cityName.isEmpty();
  }
}
