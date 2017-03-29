package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.*;
import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

	Model model;
	List<Studente> studenti = new ArrayList<Studente>();
	void setModel(Model model){
		this.model=model;
		comboCorso.getItems().addAll(model.getCorsi());
	}
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> comboCorso;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnCercaNome;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doCercaCorsi(ActionEvent event) {

    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	
    	if(comboCorso.getValue()==null){
    		txtResult.setText("Selezionare corso");
    	}
    	else{
    		studenti.addAll(model.getIscritti(comboCorso.getValue()));
    		if(studenti.size()>0){
    			
	    		for(Studente s : studenti){
	    			txtResult.appendText(s+"\n");
	    		}
    		}
    		else{
    			txtResult.setText("Nessun iscritto al corso");
    			return;
    		}
    	}

    }

    @FXML
    void doCercaNome(ActionEvent event) {
    	String matricola = txtMatricola.getText();
    	if(matricola.matches("[0-9]+")){
	    	if(model.getStudentFromMatricola(Integer.parseInt(matricola))!=null){
	    		txtNome.setText(model.getStudentFromMatricola(Integer.parseInt(matricola)).getNome());
	    		txtCognome.setText(model.getStudentFromMatricola(Integer.parseInt(matricola)).getCognome());
	    	}
	    	else{
	    		txtResult.setText("Studente non presente");
	    		txtMatricola.clear();
	    		txtNome.clear();
	    		txtCognome.clear();
	    	}
    	}
    	else{
    		txtResult.setText("Inserimento matricola errato");
    		txtMatricola.clear();
    		txtNome.clear();
    		txtCognome.clear();
    	}
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert comboCorso != null : "fx:id=\"comboCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

        
    }
}

