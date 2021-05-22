package pl.jgraczykowski.model;

public class Weather {
  private double feelsLikeTemp;
  private double maxTemp;
  private double minTemp;
  private double pressure;
  private double humidity;
  private double windSpeed;
  private double cloudsPercentage;
  private String description;
  private String date;

  public Weather() {}

  public double getFeelsLikeTemp() {
    return feelsLikeTemp;
  }

  public void setFeelsLikeTemp(double feelsLikeTemp) {
    this.feelsLikeTemp = feelsLikeTemp;
  }

  public double getMaxTemp() {
    return maxTemp;
  }

  public void setMaxTemp(double maxTemp) {
    this.maxTemp = maxTemp;
  }

  public double getMinTemp() {
    return minTemp;
  }

  public void setMinTemp(double minTemp) {
    this.minTemp = minTemp;
  }

  public double getPressure() {
    return pressure;
  }

  public void setPressure(double pressure) {
    this.pressure = pressure;
  }

  public double getHumidity() {
    return humidity;
  }

  public void setHumidity(double humidity) {
    this.humidity = humidity;
  }

  public double getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(double windSpeed) {
    this.windSpeed = windSpeed;
  }

  public double getCloudsPercentage() {
    return cloudsPercentage;
  }

  public void setCloudsPercentage(double cloudsPercentage) {
    this.cloudsPercentage = cloudsPercentage;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
