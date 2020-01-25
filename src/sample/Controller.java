package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class Controller implements Initializable {

    private static int proximoNum = 0 ;
    private int idDados;
    private String nome;
    private String email;

    public Controller(){
        ++proximoNum;
        idDados = proximoNum;
    }

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

    public void setAdicionaId(TextField adicionaId) {
        this.adicionaId = adicionaId;
        getIdDados();
    }

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

    public int getIdDados() {
        return idDados;
    }
    public void setIdDados(int idDados) {
        this.idDados = idDados;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public TextField getAdicionaId() {
        return adicionaId;
    }

    //=================================================================================================================
}
