/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dei.pl16;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import org.dei.pl16.model.Data;
import org.dei.pl16.model.DiaInvalidoException;
import org.dei.pl16.model.MesInvalidoException;

/**
 * FXML Controller class
 *
 *
 */
public class SceneController implements Initializable {

    @FXML
    private Button btnDiaDaSemana;
    @FXML
    private Button btnDataPorExtenso;
    @FXML
    private Button btnLimpar;
    @FXML
    private Label lblData;
    @FXML
    private TextField txtData;
    @FXML
    private Label lblDiaDaSemana;
    @FXML
    private TextField txtDiaDaSemana;
    @FXML
    private Label lblDataPorExtenso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private Data getData() {
        String[] data = txtData.getText().split("/");
        return new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
    }

    @FXML
    private void trataEventoBtn(ActionEvent event) {
        try {
            Object obj = event.getSource();
            if (obj == btnDiaDaSemana) {
                txtDiaDaSemana.setText(getData().diaDaSemana());
            } else if (obj == btnDataPorExtenso) {
                lblDataPorExtenso.setText(getData().toString());
            } else if (obj == btnLimpar) {
                txtData.setText("");
                txtDiaDaSemana.setText("");
                lblDataPorExtenso.setText(null);
                txtData.requestFocus();
            }
        } catch( DiaInvalidoException | MesInvalidoException ex) {
            lblDataPorExtenso.setText(null);
            txtDiaDaSemana.setText(null);
            
            Alert alert = new Alert(AlertType.ERROR, ex.getMessage());
            
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            txtData.requestFocus();
        }catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
            
            Alert alert = new Alert(AlertType.ERROR, "Data é inválida!");
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            txtData.requestFocus();
        }
    }

    @FXML
    private void trataEventoTxt(ActionEvent event) {
        try{
            txtDiaDaSemana.setText(getData().diaDaSemana());
            lblDataPorExtenso.setText(getData().toString());
            txtData.requestFocus();
        } catch( DiaInvalidoException | MesInvalidoException ex) {
            lblDataPorExtenso.setText(null);
            txtDiaDaSemana.setText(null);
            
            Alert alert = new Alert(AlertType.ERROR, ex.getMessage());
            
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            txtData.requestFocus();
        }catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
            
            Alert alert = new Alert(AlertType.ERROR, "Data é inválida!");
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            txtData.requestFocus();
        }
    }

}
