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
	
	public ObservableList<LevelProp> getLevelData() {
		return levelData;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("LEVELDB");
		
		initRootLayout();
		
		showLevelTable();
	}

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
	
	public void showLevelTable() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/LevelTable.fxml"));
			AnchorPane levelTable = (AnchorPane) loader.load();
			//Scene scene = new Scene(levelTable);
			rootLayout.setCenter(levelTable);
			//primaryStage.setScene(scene);
			LevelTableController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	public static void main(String[] args) {
		launch(args);
	}

	public Window getPrimaryStage() {
		return primaryStage;
	}

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
	
	public boolean idDuplicat(LevelProp level) {
		for(LevelProp i : levelData) {
			if(i.idEquals(level) && !i.equals(level)) return true;
		} 
		return false;
	}
	
	
}
