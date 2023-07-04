package gui;

import gui.utils.Alerts;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import models.entities.Cronometro;

public class ViewController {

    @FXML
    private Button buttonStart;

    @FXML
    private Button buttonReset;

    @FXML
    private Button buttonStop;

    @FXML
    private Label labelMinutos;

    @FXML
    private Label labelSegundos;

    @FXML
    private Label labelMilissegundos;

    private Cronometro cronometro = new Cronometro(0, 0, 0);
    private Timeline timeline;
    private boolean isRunner = false;

    @FXML
    public void onButtonResetAction() {
        try {
        	isRunner = false;
            cronometro.setMinutos(0);;
            cronometro.setSegundos(0);
            cronometro.setMilissegundos(0);
            labelMinutos.setText("00");
            labelSegundos.setText("00");
            labelMilissegundos.setText("000");
        } catch (Exception e) {
            Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
        }
    }

    @FXML
    public void onButtonStartAction() {
        if(!isRunner) {
        	// Criação da timeline para atualizar o contador a cada milissegundo
            timeline = new Timeline(
                    new KeyFrame(Duration.millis(1), (ActionEvent event) -> {
                        cronometro.setMilissegundos(cronometro.getMilissegundos() + 1);
                        if (cronometro.getMilissegundos() >= 1000) {
                            cronometro.setMilissegundos(0);
                            cronometro.setSegundos(cronometro.getSegundos() + 1);
                            if (cronometro.getSegundos() >= 60) {
                                cronometro.setSegundos(0);
                                cronometro.setMinutos(cronometro.getMinutos() + 1);
                            }
                        }
                        // Atualiza os rótulos de minutos, segundos e milissegundos
                        labelMinutos.setText(String.format("%02d", cronometro.getMinutos()));
                        labelSegundos.setText(String.format("%02d", cronometro.getSegundos()));
                        labelMilissegundos.setText(String.format("%02d", cronometro.getMilissegundos()));
                    })
            );
            timeline.setCycleCount(Timeline.INDEFINITE); // Executa indefinidamente

            // Inicia a timeline
            isRunner = true;
            timeline.play();
        } else {
        	Alerts.showAlert("Information", null, "Cronometro em execução", AlertType.INFORMATION);
        }
    }

    @FXML
    public void onButtonStopAction() {
        // Para a timeline
        timeline.stop();
        isRunner = false;
    }
}
