package pl.jgraczykowski.model;

import javafx.scene.control.Label;

import java.util.List;

public class Labels {

  private final List<Label> labels;

  public Labels(List<Label> labels) {
    this.labels = labels;
  }

  public void setDate(String date) {
    labels.get(0).setText(date);
  }

  public void setFeelsLikeTemp(String feelsLikeTemp) {
    labels.get(1).setText(feelsLikeTemp);
  }

  public void setMaxTemp(String maxTemp) {
    labels.get(2).setText(maxTemp);
  }

  public void setMinTemp(String minTemp) {
    labels.get(3).setText(minTemp);
  }

  public void setPressure(String pressure) {
    labels.get(4).setText(pressure);
  }

  public void setHumidity(String humidity) {
    labels.get(5).setText(humidity);
  }

  public void setWindSpeed(String windSpeed) {
    labels.get(6).setText(windSpeed);
  }

  public void setCloudsPercentage(String cloudsPercentage) {
    labels.get(7).setText(cloudsPercentage);
  }

  public void setDescription(String description) {
    labels.get(8).setText(description);
  }
}
