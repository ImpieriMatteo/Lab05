package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.angrammi.model.Anagramma;
import it.polito.tdp.angrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParolaIniziale;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    void handleCalcolaAnagrammi(ActionEvent event) {
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiErrati.clear();
    	
    	String parola = this.txtParolaIniziale.getText();
    	
    	if(parola.equals("")) {
    		this.txtAnagrammiCorretti.setText("Devi inserire una parola!");
    		return;
    	}
    	
    	if(!parola.matches("[a-zA-Z]*")) {
    		this.txtAnagrammiCorretti.setText("La parola inserita non è valida!");
    		return;
    	}
    	
    	this.txtParolaIniziale.setText(parola.toLowerCase());
    	
    	List<Anagramma> anagrammi = model.cercaAnagrammi(parola);
    	
    	for(Anagramma a : anagrammi) {
    		if(a.isCorretto()) 
    			this.txtAnagrammiCorretti.appendText(a.getAnagramma()+"\n");
    		else
    			this.txtAnagrammiErrati.appendText(a.getAnagramma()+"\n");
    	}
    }

    @FXML
    void handleReset(ActionEvent event) {
    	this.txtParolaIniziale.clear();
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtParolaIniziale != null : "fx:id=\"txtParolaIniziale\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
	}
 
}
