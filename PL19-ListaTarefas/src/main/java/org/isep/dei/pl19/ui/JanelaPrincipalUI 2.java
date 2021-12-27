/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isep.dei.pl19.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import org.isep.dei.pl19.controller.AplicacaoController;
import org.isep.dei.pl19.model.ListaTarefas;
import org.isep.dei.pl19.model.Tarefa;

/**
 * FXML Controller class
 *
 * @author raulcoelho
 */
public class JanelaPrincipalUI implements Initializable {

    @FXML
    private Menu mnuFicheiro;
    @FXML
    private MenuItem mnuFicheiroGuardarTexto;
    @FXML
    private MenuItem mnuFicheiroGuardarBinario;
    @FXML
    private MenuItem mnuFicheiroSair;
    @FXML
    private Menu mnuTarefa;
    @FXML
    private MenuItem mnuTarefaAdicionar;
    @FXML
    private Menu mnuTarefaRemover;
    @FXML
    private MenuItem mnuTarefaRemoverSeleccionada;
    @FXML
    private MenuItem mnuTarefaRemoverTodas;
    @FXML
    private ListView<String> lstViewTarefas;
    
    private static final String MENU_FICHEIRO="Ficheiro";
    private static final String MENU_FICHEIRO_GUARDAR_TEXTO = "Guardar como texto";
    private static final String MENU_FICHEIRO_GUARDAR_BINARIO = "Guardar como binário";
    private static final String MENU_FICHEIRO_SAIR = "Sair";
    
    private static final String MENU_TAREFA = "Tarefa";
    private static final String MENU_TAREFA_ADICIONAR="Adicionar";
    private static final String MENU_TAREFA_MENU_REMOVER = "Remover";
    private static final String MENU_TAREFA_MENU_REMOVER_SELECIONADA = "Selecionada";
    private static final String MENU_TAREFA_MENU_REMOVER_TODAS = "Todas";
    
    private static final String CABECALHO_ERRO_FATAL = "Erro Fatal";
    private static final String CABECALHO_ERRO_FUNCAO = "Erro Função";
    
    private static final String TITULO_ALERTA_LISTA_TAREFAS = "Lista de Tarefas";
    
    private static final String TITULO_PALCO_NOVA_TAREFA = "Nova Tarefa";
    
    private static final String MENSAGEM_LISTA_VAZIA = "Lista de Tarefas Vazia";
    
    private static final String CABECALHO_REMOVER_TAREFA = "Remover Tarefa";
    private static final String CONTEXTO_REMOVER_TAREFA = "Confirma a remoção da seguinte tarefa?";
    
    private static final String CABECALHO_GUARDAR_FICHEIRO_TEXTO = "Guardar lista num ficheiro de texto";
    private static final String CONTEXTO_CONFIRMAR_GUARDAR_FICHEIRO_TEXTO ="Deseja guardar a lista num ficheiro de texto?";
    private static final String CONTEXTO_SUCESSO_GUARDAR_FICHEIRO_TEXTO ="Ficheiro de texto gravado com sucesso";
    private static final String CONTEXTO_INSUCESSO_GUARDAR_FICHEIRO_TEXTO = "Não foi possível gravar o ficheiro de texto";
    
    private static final String CABECALHO_GUARDAR_FICHEIRO_BINARIO = "Guardar lista num ficheiro binário";
    private static final String CONTEXTO_CONFIRMAR_GUARDAR_FICHEIRO_BINARIO ="Deseja guardar a lista num ficheiro binário?";
    private static final String CONTEXTO_SUCESSO_GUARDAR_FICHEIRO_BINARIO ="Ficheiro binário gravado com sucesso";
    private static final String CONTEXTO_INSUCESSO_GUARDAR_FICHEIRO_BINARIO= "Não foi possível gravar o ficheiro binário";
    

    private AplicacaoController appController;
    
    private AdicionarTarefaUI adicionarTarefaUI;
    
    private Stage novaTarefaStage;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         iniciarControlos();
        try {
            appController = new AplicacaoController();
            novaTarefaStage = new Stage();
            novaTarefaStage.initModality(Modality.APPLICATION_MODAL);

            novaTarefaStage.setTitle(TITULO_PALCO_NOVA_TAREFA);
            novaTarefaStage.setResizable(false);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarTarefaScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            novaTarefaStage.setScene(scene);
            novaTarefaStage.sizeToScene();

            novaTarefaStage.setOnHiding(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    adicionarTarefaUI.limparGUI();
                }
            });
            
            adicionarTarefaUI = loader.getController();
            adicionarTarefaUI.associarParentUI(this);
        } catch(Exception ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, TITULO_ALERTA_LISTA_TAREFAS,CABECALHO_ERRO_FATAL, ex.getMessage()).showAndWait();
            Platform.exit();
        }
    }
    
      public AplicacaoController getAplicacaoController() {
        return appController;
    }
      
      public void atualizarListaTarefas() {
          lstViewTarefas.getItems().setAll(appController.getArrayListTarefas());
      }
     

    @FXML
    private void mnuFicheiroGuardarTextoAction(ActionEvent event) {
        if(AlertaUI.criarAlerta(Alert.AlertType.CONFIRMATION, TITULO_ALERTA_LISTA_TAREFAS, CABECALHO_GUARDAR_FICHEIRO_TEXTO, CONTEXTO_CONFIRMAR_GUARDAR_FICHEIRO_TEXTO).showAndWait().get() == ButtonType.OK) {
            boolean guardou = appController.guardarFicheiroTexto();
            
            AlertaUI.criarAlerta(guardou ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR, TITULO_ALERTA_LISTA_TAREFAS, CABECALHO_GUARDAR_FICHEIRO_TEXTO,
                    guardou ? CONTEXTO_SUCESSO_GUARDAR_FICHEIRO_TEXTO : CONTEXTO_INSUCESSO_GUARDAR_FICHEIRO_TEXTO).show();
        }
    }

    @FXML
    private void mnuFicheiroGuardarBinarioAction(ActionEvent event) {
        if(AlertaUI.criarAlerta(Alert.AlertType.CONFIRMATION, TITULO_ALERTA_LISTA_TAREFAS, CABECALHO_GUARDAR_FICHEIRO_BINARIO, CONTEXTO_CONFIRMAR_GUARDAR_FICHEIRO_BINARIO).showAndWait().get() == ButtonType.OK) {
            boolean guardou = appController.guardarFicheiroBinario();
            
            AlertaUI.criarAlerta(guardou ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR, TITULO_ALERTA_LISTA_TAREFAS, CABECALHO_GUARDAR_FICHEIRO_BINARIO,
                    guardou ? CONTEXTO_SUCESSO_GUARDAR_FICHEIRO_BINARIO : CONTEXTO_INSUCESSO_GUARDAR_FICHEIRO_BINARIO).show();
        } 
    }

    @FXML
    private void mnuFicheiroSairAction(ActionEvent event) {
        Window janela = mnuFicheiroSair.getParentPopup().getOwnerWindow();
        
        janela.fireEvent(new WindowEvent(janela, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    @FXML
    private void mnuFicheiroShowing(Event event) {
        mnuFicheiroGuardarTexto.setDisable(appController.listaVazia());
        mnuFicheiroGuardarBinario.setDisable(appController.listaVazia());
    }

    @FXML
    private void mnuTarefaAdicionarAction(ActionEvent event) {
        novaTarefaStage.show();
    }

    @FXML
    private void mnuTarefaRemoverSeleccionadaAction(ActionEvent event) {
        String tarefaSelecionada =  lstViewTarefas.getSelectionModel().getSelectedItem();
        Alert alertaConfirmacaoAccao = AlertaUI.criarAlerta(Alert.AlertType.CONFIRMATION, TITULO_ALERTA_LISTA_TAREFAS, CABECALHO_REMOVER_TAREFA, String.format("%s\n%s", CONTEXTO_REMOVER_TAREFA, tarefaSelecionada));
        
        if(alertaConfirmacaoAccao.showAndWait().get() == ButtonType.OK) {
            appController.eliminarTarefa(tarefaSelecionada);
            
            atualizarListaTarefas();
        }
    }

    @FXML
    private void mnuTarefaRemoverTodasAction(ActionEvent event) {
        appController.eliminarTarefas();
        
        atualizarListaTarefas();
    }

    @FXML
    private void mnuTarefaRemoverShowing(Event event) {
        mnuTarefaRemoverSeleccionada.setDisable(lstViewTarefas.getSelectionModel().isEmpty());
    }

    @FXML
    private void mnuTarefaShowing(Event event) {
        mnuTarefaRemover.setDisable(appController.listaVazia());
    }

    @FXML
    private void teclaRatoLibertadaAction(MouseEvent event) {     
        if(event.getButton().equals(MouseButton.SECONDARY)) {
            ContextMenu cmEasterEgg = new ContextMenu();
            
            MenuItem miAdicionarTarefas = new MenuItem("Adicionar Tarefas com valores aleatorios");
            miAdicionarTarefas.setOnAction(action -> {
                appController.preencher();
                
                atualizarListaTarefas();
            });
            cmEasterEgg.getItems().add(miAdicionarTarefas);
            
            cmEasterEgg.show(((Node) event.getSource()).getScene().getWindow(), event.getSceneX(), event.getSceneY());
        }
    }

    @FXML
    private void teclaPressionadaAction(KeyEvent event) {
        if(event.isShortcutDown()) {
            if(!appController.listaVazia()) {
                if(event.getCode() == KeyCode.O) {
                    atualizarListaTarefas(ListaTarefas.ORDENACAO.INSERCAO);
                }else{
                    if(event.getCode()==KeyCode.P) {
                        atualizarListaTarefas(ListaTarefas.ORDENACAO.PRIORIDADE);
                    }else{
                        if(event.getCode() == KeyCode.Z) {
                            appController.eliminarUltimaTarefa();
                            atualizarListaTarefas();
                        }
                    }
                }
            }else{
                AlertaUI.criarAlerta(Alert.AlertType.ERROR, TITULO_ALERTA_LISTA_TAREFAS, CABECALHO_ERRO_FUNCAO, MENSAGEM_LISTA_VAZIA).show();
            }
        }
    }
    
    public void iniciarControlos() {
        mnuFicheiro.setText(MENU_FICHEIRO);
        mnuFicheiroGuardarTexto.setText(MENU_FICHEIRO_GUARDAR_TEXTO);
        mnuFicheiroGuardarBinario.setText(MENU_FICHEIRO_GUARDAR_BINARIO);
        mnuFicheiroSair.setText(MENU_FICHEIRO_SAIR);
        
        mnuTarefa.setText(MENU_TAREFA);
        mnuTarefaAdicionar.setText(MENU_TAREFA_ADICIONAR);
        mnuTarefaRemover.setText(MENU_TAREFA_MENU_REMOVER);
        mnuTarefaRemoverSeleccionada.setText(MENU_TAREFA_MENU_REMOVER_SELECIONADA);
        mnuTarefaRemoverTodas.setText(MENU_TAREFA_MENU_REMOVER_TODAS);
    }
    
    private void atualizarListaTarefas(ListaTarefas.ORDENACAO ordem) {
        lstViewTarefas.getItems().setAll( ordem == ListaTarefas.ORDENACAO.INSERCAO ? appController.getArrayListTarefas() : appController.getArrayListTarefasPorPrioridade());
    }
    
}
