package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable{
	
	// Atributos TextField que irão representar os campos de entrada de dados na interface gráfica
	@FXML
	private TextField txtNumber1;
	@FXML
	private TextField txtNumber2;
	
	// Label que mostrará o resultado da soma
	@FXML
	private Label labelResult;

	// Botão responsável por executar o método de soma
	@FXML
	private Button btSum ;
	
	// Método que será executado ao clicar no botão
	@FXML
	public void onBtSumAction() {
		try {
		Locale.setDefault(Locale.US);
		// Converte o text field para double e o associa às variáveis double
		double number1 = Double.parseDouble(txtNumber1.getText());
		double number2 = Double.parseDouble(txtNumber2.getText());
		double sum = number1 + number2;
		labelResult.setText(String.format("%.2f", sum));
		}
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
	}

	
	// Método responsável por inicializar os métodos de limitações na instanciação do controlador
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtNumber1);
		Constraints.setTextFieldDouble(txtNumber2);
		Constraints.setTextFieldMaxLength(txtNumber1, 12);
		Constraints.setTextFieldMaxLength(txtNumber2, 12);
	}
}
