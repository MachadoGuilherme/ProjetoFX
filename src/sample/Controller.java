package sample;

import Dados.DadosPessoa;

import Search.searchPessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public abstract class Controller implements Initializable {

    boolean modoEntrada;
    //=================================================================================================================
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
        limpaDadosAdd();
    }
    @FXML
    private void botaoAddSalva(ActionEvent event) throws SQLException, ClassNotFoundException{
        if (adicionaId.getText().trim().equals("")){
            mensagemInformacao("Cadastro", "Preencha o ID", "Deve Preencher Todos os Campos!");
        }
        else {
            try {
                if (modoEntrada){
                    searchPessoa.addNovosDados(Integer.parseInt(adicionaId.getText()), adicionaNome.getText(), adicionaEmail.getText());
                    mensagemInformacao("Cadastro", "Inserir Registro", "Registro Inserido Com Sucesso");
                    modoEntrada = false;
                    botaoApaga.setVisible(false);
                }
            }
            catch (SQLException e){
                System.out.println("Erro: " + e);
                throw e;
            }
        }

        limpaDadosAdd();
        modoEntrada = true;
        botaoApaga.setVisible(false);
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
                    mensagemInformacao("Consulta", "ID Invalido ou Inexistente!", "Tente Novamente");
                }

            }catch (SQLException e){

                modoEntrada = false;
                throw e;
            }
        }
    }

    @FXML
    private void botaoConLimpar(ActionEvent event) {
        limpaDadosConsult();
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
    private void botaoApagaConsult(ActionEvent event) throws SQLException, ClassNotFoundException{

        if (apagaId.getText().trim().equals("")){
            mensagemInformacao("Consulta", "Preencha o ID", "O ID Deve Ser Numerico!");
        }
        else {
            try {
                DadosPessoa p = searchPessoa.consultaPessoa(Integer.parseInt(apagaId.getText()));

                if (p != null){
                    preencheDadosApagar(p);
                    modoEntrada = true;
                    botaoApaga.setVisible(true);
                }
                else {
                    mensagemInformacao("Consulta", "ID Invalido ou Inexistente!", "Tente Novamente");
                }

            }catch (SQLException e){

                modoEntrada = false;
                throw e;
            }
            botaoApaga.setVisible(false);
        }
    }

    @FXML
    private void botaoApagar(ActionEvent event) throws ClassNotFoundException, SQLException{

        try {

            searchPessoa.apagaDadosPessoa(Integer.parseInt(apagaId.getText()));

            mensagemInformacao("Apagar", "Apagar Dados", "Dados Apagados Com Sucesso!");

            limpaDadosApagar();
            modoEntrada = true;
            botaoApaga.setVisible(false);
        }
        catch (SQLException e){
            throw e;
        }

    }

    @FXML
    private void botaoApagaLimpar(ActionEvent event){
        limpaDadosApagar();
    }
    //=================================================================================================================
    @FXML
    private TextArea txtAreaCTD;

    @FXML
    private Button botaoConCTD;

    @FXML
    private Button botaoLimparCTD;

    @FXML
    private void botaoConsCTD(ActionEvent event) throws SQLException, ClassNotFoundException{

        try {
            txtAreaCTD.clear();

            List lista = searchPessoa.procuraPessoa();
            String texto = "";

            for (int i = 0; i < lista.size(); i++ ) {
                DadosPessoa p = (DadosPessoa) lista.get(i);
                texto = texto  + p.informacao()+ "\n";
            }
            txtAreaCTD.setText(texto);
        }
        catch (SQLException e){
            e.printStackTrace();
            throw e;
        }

    }

    @FXML
    private void botaoLimpaCTD(ActionEvent event){
        limpaConsultaTodosDados();
    }
    //=================================================================================================================
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        limpaDadosAdd();
        limpaDadosConsult();
        limpaDadosApagar();
        modoEntrada = true;
        botaoApaga.setVisible(false);
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
    private void preencheDadosApagar(DadosPessoa p){
        apagaNome.setText(p.getNomePessoa());
        apagaEmail.setText(p.getEmailPessoa());
    }
    //=================================================================================================================
    private void limpaDadosAdd(){
        adicionaId.clear();
        adicionaNome.clear();
        adicionaEmail.clear();
    }
    private void limpaDadosConsult(){
        consultaId.clear();
        consultaNome.clear();
        consultaEmail.clear();
    }
    private void limpaDadosApagar(){
        apagaId.clear();
        apagaNome.clear();
        apagaEmail.clear();
    }
    private void limpaConsultaTodosDados(){
        txtAreaCTD.clear();
    }
    //=================================================================================================================
}
