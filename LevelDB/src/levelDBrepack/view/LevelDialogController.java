package levelDBrepack.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import levelDBrepack.model.LevelProp;

public class LevelDialogController {
	
	@FXML
	private TextField idField;
	@FXML
	private TextField widthField;
	@FXML
	private TextField heightField;
	
	private Stage dialogStage;
	private LevelProp level;
	private boolean okClicked = false;
	
	@FXML
	private void initialize() {
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setLevel(LevelProp level) {
		this.level = level;
		
		idField.setText(level.getID());
		widthField.setText(""+level.getWidh());
		heightField.setText(""+level.getHeight());
		
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
	@FXML
	private void handleOk() {
		if(isInputValid()) {
			level.setID(idField.getText());
			level.setWidth(Integer.parseInt(widthField.getText()));
			level.setHeight(Integer.parseInt(heightField.getText()));
			
			okClicked = true;
			dialogStage.close();
		}
	}
	
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	private boolean isInputValid() {
		String errorMessage = "";
		
		if(idField.getText() == null || idField.getText().length() == 0) {
			errorMessage += "No valid id!\n";
		}
		if(widthField.getText() == null || widthField.getText().length() == 0) {
			errorMessage += "No valid width!\n";
		} else {
			try {
				Integer.parseInt(widthField.getText());
				if(Integer.parseInt(widthField.getText())<1) {
					errorMessage += "Input must be at least 1!\n";
				}
			} catch (NumberFormatException e) {
				errorMessage += "No valid width (must be an integer)!\n";
			}
		}
		if(heightField.getText() == null || heightField.getText().length() == 0) {
			errorMessage += "No valid height!\n";
		} else {
			try {
				Integer.parseInt(heightField.getText());
				if(Integer.parseInt(heightField.getText())<1) {
					errorMessage += "Input must be at least 1!\n";
				}
			} catch (NumberFormatException e) {
				errorMessage += "No valid height (must be an integer)!\n";
			}
		}
		if(!level.getProps().isEmpty()) {
			errorMessage += "Unable to edit level-size of level with content!\n";
		}
		if(errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
		}
		
	}	

}
