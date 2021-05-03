package org.openjfx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

  @FXML
  private TextField firstCountry;

  @FXML
  private TextField secondCountry;

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
  private Label firstCityTempLabel;

  public PrimaryController() {
  }

  @FXML
  void firstShowButtonAction() {
    System.out.println("First Button Clicked!");
  }

  @FXML
  void secondShowButtonAction() {
    System.out.println("Second Button Clicked!");
  }

}
