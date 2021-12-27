/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isep.dei.pl18.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.isep.dei.pl18.controller.AplicacaoController;
import org.isep.dei.pl18.model.Prioridade;

/**
 *
 * @author raulcoelho
 */
public class AdicionarTarefaUI implements Initializable{

    
    @FXML
    private Button btnCriarTarefa;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblTarefa;
    @FXML
    private Label lblPrioridade;
    @FXML
    private TextField txtTarefa;
    @FXML
    private ComboBox<Prioridade> cmbPrioridade;
    
    private static final String LABEL_PRIORIDADE = "Prioridade";
    private static final String LABEL_TAREFA="Tarefa";
    private static final String BOTAO_ADICIONAR_TAREFA="Adicionar Tarefa";
    private static final String BOTAO_CANCELAR="Cancelar";
    private static final String TITULO_ALERTA="Nova Tarefa";
    private static final String CABECALHO_VALORES_INVALIDOS="Valores Inválidos";
    private static final String CABECALHO_ADICIONAR_TAREFA="Adicionar Tarefa";
    private static final String MENSAGEM_TAREFA_ADICIONADA="Tarefa adicionada com sucesso!";
    private static final String MENSAGEM_TAREFA_NAO_ADICIONADA="Tarefa não foi adicionada";
    
    private JanelaPrincipalUI janelaPrincipalUI;
    
    private AplicacaoController appController;

    public void initialize(URL url, ResourceBundle rb) {
        iniciarControlos();
    }
    
    public void associarParentUI(JanelaPrincipalUI janelaPrincipalUI) {
        this.janelaPrincipalUI = janelaPrincipalUI;
        appController = this.janelaPrincipalUI.getAplicacaoController();
        
        preencherPrioridades();
    }
    
    public void limparGUI() {
        txtTarefa.clear();
        cmbPrioridade.getSelectionModel().selectFirst();
    }
    
    @FXML
    private void criarTarefaAction(ActionEvent event) {
        try{
            boolean adicionou = appController.adicionarTarefa(txtTarefa.getText().trim(), (Prioridade) cmbPrioridade.getValue());
            
            if(adicionou) {
                janelaPrincipalUI.atualizarListaTarefas();
            }
            criarAlerta(Alert.AlertType.INFORMATION, CABECALHO_ADICIONAR_TAREFA, adicionou ? MENSAGEM_TAREFA_ADICIONADA : MENSAGEM_TAREFA_NAO_ADICIONADA).show();
            
            cancelarAction(event);
        }catch(IllegalArgumentException iae) {
            criarAlerta(Alert.AlertType.ERROR, CABECALHO_VALORES_INVALIDOS, iae.getMessage()).show();
        }
    }

    @FXML
    private void cancelarAction(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }
    
    private void iniciarControlos() {
        lblPrioridade.setText(LABEL_PRIORIDADE);
        lblTarefa.setText(LABEL_TAREFA);
        
        btnCriarTarefa.setText(BOTAO_ADICIONAR_TAREFA);
        btnCancelar.setText(BOTAO_CANCELAR);
    }
    
    private void preencherPrioridades() {
        cmbPrioridade.getItems().setAll(appController.getPrioridades());
        cmbPrioridade.getSelectionModel().selectFirst();
    }
    
    private Alert criarAlerta(Alert.AlertType tipoAlerta, String cabecalho, String mensagem){
        Alert alerta = new Alert(tipoAlerta);
        
        alerta.setTitle(TITULO_ALERTA);
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);
        
        return alerta;
    }
}
