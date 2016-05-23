package it.polito.tdp.dizionario.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.dizionario.model.Xmodel;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioController {
	Xmodel x=new Xmodel();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNumber;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnGrafo;

    @FXML
    private Button btnNeigh;

    @FXML
    private Button btnConnection;

    @FXML
    private TextArea textResult;

    @FXML
    private Button btnreset;

    @FXML
    void allConnection(ActionEvent event) {
    	textResult.setText("");
    	try{
    	String word=txtWord.getText();
    	x.GenerateConner(word);
    	textResult.appendText("Numero Parole Connesse:"+x.connerTot().size()+ "\n");
    	for(String s:x.connerTot()){
        		textResult.appendText(s+"\n");
    	}
    
    	}
    	catch(NumberFormatException nfe){
    		textResult.appendText("Errore\t102: formato dati inserito non valido");
    	}
    	catch(IllegalArgumentException IAE){
    		textResult.appendText("Errore\t103: Nessun Risultato Trovato");
    	}
    }

    @FXML
    void cercaVicini(ActionEvent event) {
    	textResult.setText("");
    	try{
    	String word=txtWord.getText();
    	textResult.appendText("Numero Parole Vicine:"+x.GenerateNeigh(word).size()+ "\n");
    	for(String s:x.GenerateNeigh(word)){
        		textResult.appendText(s+"\n");
    	}
    
    	}
    	catch(NumberFormatException nfe){
    		textResult.appendText("Errore\t102: formato dati inserito non valido");
    	}
    	catch(IllegalArgumentException IAE){
    		textResult.appendText("Errore\t103: Nessun Risultato Trovato");
    	}
    
    }

    @FXML
    void createGrafo(ActionEvent event) {
    	textResult.setText("");
    	//Task<String> task=new Task<String>(){
    	try{
    	int numero=Integer.parseInt(txtNumber.getText());
    	textResult.appendText("Numero Parole Vicine:"+x.GenerateGraph(numero).size()+ "\n");
    	for(String s:x.GenerateGraph(numero)){
    		textResult.appendText(s+"\n");
    	}}
    	catch(NumberFormatException nfe){
    		textResult.appendText("Errore\t101: formato dati inserito non valido");
    	}
    
    	
    }


    @FXML
    void reset(ActionEvent event) {
    	textResult.setText("");
    	txtWord.setText("");
    	txtNumber.setText("");
       // btnNeigh.setDisable(true);
      //  btnConnection.setDisable(true);
    }

    @FXML
    void initialize() {
        assert txtNumber != null : "fx:id=\"txtNumber\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnGrafo != null : "fx:id=\"btnGrafo\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnNeigh != null : "fx:id=\"btnNeigh\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnConnection != null : "fx:id=\"btnConnection\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert textResult != null : "fx:id=\"textResult\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnreset != null : "fx:id=\"btnreset\" was not injected: check your FXML file 'Dizionario.fxml'.";

        //btnNeigh.setDisable(true);
       // btnConnection.setDisable(true);
        textResult.setEditable(false);
    }
}
