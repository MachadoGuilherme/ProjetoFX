package sample;

import Dados.DadosPessoa;

import Search.searchPessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public abstract class Controller implements Initializable {

    boolean modoEntrada;

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
    private void botaoConConsult(ActionEvent event) throws ClassNotFoundException, SQLException {

        if (consultaId.getText().trim().equals("")){
            mensagemInformacao("Consulta", "Preencha o ID", "O ID Deve Ser Numerico!");
        }
        else {
            try {
                DadosPessoa p = searchPessoa.consultaPessoa(Integer.parseInt(consultaId.getText()));

                if (p != null){
                    preencheDados(p);
                    modoEntrada = true;
                }
                else {
                    mensagemInformacao("Consulta", "ID Invalido ou Inexistente!", "T");
                }

            }catch (SQLException e){

                modoEntrada = false;
                throw e;
            }
        }
    }

    @FXML
    private void botaoConLimpar(ActionEvent event) {
        consultaId.clear();
        consultaNome.clear();
        consultaEmail.clear();
    }
    //=================================================================================================================
    @FXML
    private TextField apagaId;

    @FXML
    private TextField apagaNome;

    @FXML
    private TextField apagaEmail;

    @FXML
    private Button botaoApagaLimpar;

    @FXML
    private Button botaoApaga;

    @FXML
    private Button botaoApagaConsult;

    @FXML
    private void botaoApagaConsult(ActionEvent event){

    }
    @FXML
    private void botaoApagar(ActionEvent event){

    }
    @FXML
    private void botaoApagaLimpar(ActionEvent event){
        apagaId.clear();
        apagaNome.clear();
        apagaEmail.clear();
    }
    //=================================================================================================================
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    //=================================================================================================================
    private void mensagemInformacao(String titulo, String cabecalho, String texto) {
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecalho);
        alert.setContentText(texto);
        alert.show();
    }
    //=================================================================================================================
    private void preencheDados(DadosPessoa p ) {

        consultaId.setText(String.valueOf(p.getIdPessoa()));
        consultaNome.setText(p.getNomePessoa());
        consultaEmail.setText(p.getEmailPessoa());

    }
    //=================================================================================================================
}
