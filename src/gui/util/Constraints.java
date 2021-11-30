package gui.util;

import javafx.scene.control.TextField;

public class Constraints {

	
//	Verificações
	
//	Caso o newValue não passe na verificação, o método retornará ao oldValue	
//	Dessa forma, fica impossível digitar letras nos campos numéricos da interface gráfica
	
	// Verifica se o numero digitado é nulo, e se é Integer
	// \\d = se é um número | * = qualquer quantidade
	public static void setTextFieldInteger(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*"))
				txt.setText(oldValue);
		});
	}
	
	// Verifica se a quantidade de caracteres digitados é maior que o limite estabelecido
	public static void setTextFieldMaxLength(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}
	
	// Verifica se o número digitado é um valor Double
	public static void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			
			// \\d* = Qualquer quantidade de dígitos
			// \\.  = separador de casas decimais
			// \\d* = qualquer quantidade de dígitos após a casa decimal
			if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")){
				txt.setText(oldValue);
			}
		});
	}
}
