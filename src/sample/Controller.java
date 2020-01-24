package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button botaoAdicionaSalvar;

    @FXML
    private Button botaoAdicionaLimpar;

    @FXML
    private TextField adicionaId;

    @FXML
    private TextField adicionaNome;

    @FXML
    private TextField adicionaEmail;

    @FXML
    private void botaoAddLimpar(ActionEvent event){
        adicionaNome.clear();
        adicionaEmail.clear();
    }

    @FXML
    private void botaoAddSalva(ActionEvent event){

    }
    //=================================================================================================================
    @FXML
    private TextField consultaId;

    @FXML
    private TextField consultaNome;

    @FXML
    private TextField consultaEmail;

    @FXML
    private Button botaoConsultaLimpar;

    @FXML
    private Button botaoConsultaConsult;

    @FXML
    private Label Nome;

    @FXML
    private Label Email;

    @FXML
    private void botaoConConsult(ActionEvent event) {

    }

    @FXML
    private void botaoConLimpar(ActionEvent event) {
        consultaId.clear();
    }
    //=================================================================================================================
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    //=================================================================================================================
}
