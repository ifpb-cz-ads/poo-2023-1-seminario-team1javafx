package controllers;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class ViewController {
	@FXML
	private Button buttonStart;
	
	@FXML
	private Button buttonReset; 
	
	@FXML
	private Button buttonStop;
	
	@FXML
	private Label labelHoras;
	
	@FXML
	private Label labelMinutos;
	
	@FXML
	private Label labelSegundos;
	
	@FXML
	public void onButtonResetAction() {
		try {
			labelHoras.setText("00");
			labelMinutos.setText("00");
			labelSegundos.setText("00");
		} catch(Exception e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
	@FXML
	public void onButtonStartAction() {
	}
	
	@FXML
	public void obButtonStopAction() {
	}
}
