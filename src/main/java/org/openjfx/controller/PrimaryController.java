package org.openjfx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.openjfx.model.Weather;
import org.openjfx.model.WeatherProvider;

public class PrimaryController {

  @FXML
  private TextField firstCity;

  @FXML
  private TextField secondCity;

  @FXML
  private Label helpLabel1;

  @FXML
  private Label helpLabel2;

  @FXML
  private Label titleLabel;

  @FXML
  private Label errorLabel;

  @FXML
  private Label firstCityFeelsLikeTempLabel1;

  @FXML
  private Label firstCityDateLabel1;

  @FXML
  private ImageView firstCityWeatherIcon1;

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
  private Label errorLabel1;

  @FXML
  private Label secondCityFeelsLikeTempLabel1;

  @FXML
  private Label secondCityDateLabel1;

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
  private Label errorLabel2;

  private final WeatherProvider firstCityWeatherProvider;
  private final WeatherProvider secondCityWeatherProvider;

  public PrimaryController() {
    firstCityWeatherProvider = new WeatherProvider("");
    secondCityWeatherProvider = new WeatherProvider("");
  }

  @FXML
  void firstShowButtonAction() {
    String cityName = getCityName(firstCity);
    setWeatherForTheCity(
      cityName, firstCityWeatherProvider,
      errorLabel1, firstCityDateLabel1,
      firstCityFeelsLikeTempLabel1, firstCityMaxTempLabel1,
      firstCityMinTempLabel1, firstCityPressureLabel1,
      firstCityHumidityLabel1, firstCityWindSpeedLabel1,
      firstCityCloudsLabel1, firstCityDescriptionLabel1
    );
  }

  @FXML
  void secondShowButtonAction() {
    String cityName = getCityName(secondCity);
    setWeatherForTheCity(
      cityName, secondCityWeatherProvider,
      errorLabel, secondCityDateLabel1,
      secondCityFeelsLikeTempLabel1, secondCityMaxTempLabel1,
      secondCityMinTempLabel1, secondCityPressureLabel1,
      secondCityHumidityLabel1, secondCityWindSpeedLabel1,
      secondCityCloudsLabel1, secondCityDescriptionLabel1
    );
  }

  private String getCityName(TextField city) {
    return city.getText();
  }

  private void setWeatherForTheCity(
    String cityName, WeatherProvider weatherProvider,
    Label errorLabel, Label dateLabel,
    Label feelsLikeTempLabel, Label maxTempLabel,
    Label minTempLabel, Label pressureLabel,
    Label humidityLabel, Label windSpeedLabel,
    Label cloudsLabel, Label descriptionLabel
  ) {

    if (validateCityName(cityName)) {
      weatherProvider.setCity(cityName);
      if (weatherProvider.setWeather()) {
        errorLabel.setText("");
        Weather weather = weatherProvider.getWeather();
        dateLabel.setText(weather.getDate());
        feelsLikeTempLabel.setText(String.valueOf(weather.getFeelsLikeTemp()));
        maxTempLabel.setText(String.valueOf(weather.getMaxTemp()));
        minTempLabel.setText(String.valueOf(weather.getMinTemp()));
        pressureLabel.setText(String.valueOf(weather.getPressure()));
        humidityLabel.setText(String.valueOf(weather.getHumidity()));
        windSpeedLabel.setText(String.valueOf(weather.getWindSpeed()));
        cloudsLabel.setText(String.valueOf(weather.getCloudsPercentage()));
        descriptionLabel.setText(weather.getDescription());
      } else {
        errorLabel.setText("Wrong City!");
      }
    } else {
      errorLabel.setText("City Name is required!");
    }
  }

  private boolean validateCityName(String cityName) {
    return !cityName.isEmpty();
  }
}
