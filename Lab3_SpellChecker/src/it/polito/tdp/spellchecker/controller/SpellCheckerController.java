package it.polito.tdp.spellchecker.controller;
   
    
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dyctionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SpellCheckerController {
	
	Dyctionary dyctionary;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    

    @FXML
    private ChoiceBox<String> btnScelta;
    

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnSpelling;

    @FXML
    private TextArea txtWrong;

    @FXML
    private Label txtError;

    @FXML
    private Button btnClear;

    @FXML
    private Label txttime;

    
    
    @FXML
    void doClearText(ActionEvent event) {
    	txtWrong.clear();
    	txttime.setText("");
    	txtError.setText("");
    	txtWrong.setText("");
    	dyctionary.inizializza();
    
    	

    }
    
    @FXML
    void initialize(MouseEvent event) throws IOException {
    	String parola= btnScelta.getValue();
    	dyctionary.loadDictionary(parola);   
    	txtWrong.setText(" preso dizionarioio " +parola);
    	
    	
    	

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	long c=System.nanoTime();
    	List<String> passare=dyctionary.prendiTesto(txtInput.getText());
    	dyctionary.spellCheckText(passare);
    	txtInput.clear();
    	
    	txtWrong.setText(dyctionary.getParoleSbagliate());
    	txtError.setText("The text contains "+ dyctionary.getNumParoleSbagliate() + "errors.");
    	
    	String a= String.valueOf((System.nanoTime()-c)/(10e9));
    	txttime.setText("Spell check completed in "+a+"seconds");

    }
    
    

  

	/**
	 * @return the dyctionary
	 */
	public Dyctionary getDyctionary() {
		return dyctionary;
	}

	/**
	 * @param dyctionary the dyctionary to set
	 */
	public void setDyctionary(Dyctionary dyctionary) {
		this.dyctionary = dyctionary;
	}

	  @FXML
	    void initialize() {
	         assert btnScelta != null : "fx:id=\"btnScelta\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert btnSpelling != null : "fx:id=\"btnSpelling\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert txtWrong != null : "fx:id=\"txtWrong\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert txtError != null : "fx:id=\"txtError\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert txttime != null : "fx:id=\"txttime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        
	        btnScelta.getItems().addAll("italian", "english");
	        btnScelta.setValue("italian");

	    }
	
	}