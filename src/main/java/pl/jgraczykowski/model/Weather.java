package pl.jgraczykowski.model;

public class Weather {
  private final double feelsLikeTemp;
  private final double maxTemp;
  private final double minTemp;
  private final double pressure;
  private final double humidity;
  private final double windSpeed;
  private final double cloudsPercentage;
  private final String description;
  private final String date;

  public Weather(double feelsLikeTemp, double maxTemp, double minTemp, double pressure, double humidity, double windSpeed, double cloudsPercentage, String description, String date) {
    this.feelsLikeTemp = feelsLikeTemp;
    this.maxTemp = maxTemp;
    this.minTemp = minTemp;
    this.pressure = pressure;
    this.humidity = humidity;
    this.windSpeed = windSpeed;
    this.cloudsPercentage = cloudsPercentage;
    this.description = description;
    this.date = date;
  }

  public double getFeelsLikeTemp() {
    return feelsLikeTemp;
  }

  public double getMaxTemp() {
    return maxTemp;
  }

  public double getMinTemp() {
    return minTemp;
  }

  public double getPressure() {
    return pressure;
  }

  public double getHumidity() {
    return humidity;
  }

  public double getWindSpeed() {
    return windSpeed;
  }

  public double getCloudsPercentage() {
    return cloudsPercentage;
  }

  public String getDescription() {
    return description;
  }

  public String getDate() {
    return date;
  }

  public String getHour() {
    return date.substring(11, 13);
  }
}
