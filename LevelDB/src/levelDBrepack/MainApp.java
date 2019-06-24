package levelDBrepack;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import levelDBrepack.model.LevelProp;
import levelDBrepack.view.LevelDialogController;
import levelDBrepack.view.LevelEditorController;
import levelDBrepack.view.LevelTableController;
import levelDBrepack.view.RootLayoutController;

public class MainApp extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	private ObservableList<LevelProp> levelData = FXCollections.observableArrayList();
	
	public MainApp() {
		// TODO maybe todo constructor for mainApp
	}
	
	
	/**
	 * 
	 * @return Getter for levelData
	 */
	public ObservableList<LevelProp> getLevelData() {
		return levelData;
	}

	/**
	 * JavaFX start method. Initializes the RootLayout and shows the table.
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("LEVELDB");
		
		initRootLayout();
		
		showLevelTable();
	}

	/**
	 * Initializes the RootLayout and shows it.
	 */
	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads and shows the level-table.
	 */
	public void showLevelTable() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/LevelTable.fxml"));
			AnchorPane levelTable = (AnchorPane) loader.load();
			rootLayout.setCenter(levelTable);
			LevelTableController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	/**
	 * The Main method which launches the programm.
	 * @param args Run Arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Getter for the PrimaryStage
	 * @return The PrimaryStage
	 */
	public Window getPrimaryStage() {
		return primaryStage;
	}

	/**
	 * Shows the edit level dialog for selected level in tabe.
	 * @param level The level to edit
	 * @return If edit was successfull or not
	 */
	public boolean showLevelEditDialog(LevelProp level) {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/LevelEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();
	        
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Level");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);
	        
	        LevelDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setLevel(level);
	        
	        dialogStage.showAndWait();
	        
	        return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Shows the level-editor for selected level.
	 * @param level The level to edit
	 */
	public void showLevelEditor(LevelProp level) {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/LevelEditor.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();
			Scene scene = new Scene(pane);
			LevelEditorController controller = loader.getController();
			controller.setLevel(level);
			controller.setMainApp(this);
			controller.initCanvases();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Checks if a level is dublicate in Leveldata list.
	 * @param level The Level to check
	 * @return The result of the check
	 */
	public boolean idDuplicat(LevelProp level) {
		for(LevelProp i : levelData) {
			if(i.idEquals(level) && !i.equals(level)) return true;
		} 
		return false;
	}
	
	
}
