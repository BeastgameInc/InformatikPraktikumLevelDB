package levelDBrepack.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import levelDBrepack.MainApp;
import levelDBrepack.model.LevelProp;

public class LevelTableController {
	
	@FXML
	private TableView<LevelProp> levelTable;
	
	@FXML
	private TableColumn<LevelProp, String> idColumn;
	@FXML
	private TableColumn<LevelProp, Integer> widthColumn;
	@FXML
	private TableColumn<LevelProp, Integer> heightColumn;
	@FXML
	private TableColumn<LevelProp, String> contentColumn; 
	
	
	private MainApp mainApp;
	
	public LevelTableController() {	
		
	}
	
	@FXML
	private void initialize() {
		idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
		widthColumn.setCellValueFactory(cellData -> cellData.getValue().widthProperty().asObject());
		heightColumn.setCellValueFactory(cellData -> cellData.getValue().heightProperty().asObject());
		contentColumn.setCellValueFactory(cellData -> cellData.getValue().propsProperty());
		
		
		
		//levelTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> show);
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		levelTable.setItems(mainApp.getLevelData());
	}
	
	@FXML
	private void handleDeleteLevel() {
		int selectedIndex = levelTable.getSelectionModel().getSelectedIndex();
		if(selectedIndex >= 0) {
			levelTable.getItems().remove(selectedIndex);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Level Selected");
			alert.setContentText("Please select a level.");
			
			alert.showAndWait();
		}
	}
	
	@FXML
	private void handleNewLevel() {
		LevelProp tempLevel = new LevelProp();
		boolean okClicked = mainApp.showLevelEditDialog(tempLevel);
		if(okClicked) {
			if(!mainApp.idDuplicat(tempLevel))
				mainApp.getLevelData().add(tempLevel);
			else {
				Alert alert = new Alert(AlertType.WARNING);
		        alert.initOwner(mainApp.getPrimaryStage());
		        alert.setTitle("ID Not unique");
		        alert.setHeaderText("ID is not unique!");
		        alert.setContentText("Please choose a different ID.");

		        alert.showAndWait();
			}
		}
	}
	
	@FXML
	private void handleEditLevelProp() {
		LevelProp selectedLevel = levelTable.getSelectionModel().getSelectedItem();
	    if (selectedLevel != null) {
	        boolean okClicked = mainApp.showLevelEditDialog(selectedLevel);
	        if (okClicked) {
	            //showLevelDetails(selectedPerson); //TODO see if mistake
	        	if(mainApp.idDuplicat(selectedLevel)) {
	        		selectedLevel.setID("#DUPLICATE");
	        		Alert alert = new Alert(AlertType.WARNING);
			        alert.initOwner(mainApp.getPrimaryStage());
			        alert.setTitle("ID Not unique");
			        alert.setHeaderText("ID is not unique!");
			        alert.setContentText("Please choose a different ID.");

			        alert.showAndWait();
	        	}
	        	
	        }

	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Level Selected");
	        alert.setContentText("Please select a level.");

	        alert.showAndWait();
	    }
	}
	
	@FXML
	private void handleEditLevel() {
		LevelProp selectedLevel = levelTable.getSelectionModel().getSelectedItem();
		if(selectedLevel != null) {
			mainApp.showLevelEditor(selectedLevel);
		} else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Level Selected");
	        alert.setContentText("Please select a level.");

	        alert.showAndWait();
	    }
	}
}
