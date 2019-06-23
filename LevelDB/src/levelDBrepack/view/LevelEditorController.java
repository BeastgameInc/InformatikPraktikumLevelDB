package levelDBrepack.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import levelDBrepack.model.LevelProp;

public class LevelEditorController {
	
	@FXML
	private TextField transField;
	
	private Stage editorStage;
	private LevelProp level;
	
	@FXML
	private void initialize() {
		
	}
	
	public void setLevelEditorStage(Stage editorStage) {
		this.editorStage = editorStage;
	}
	
	public void setLevel(LevelProp level) {
		this.level = level;
	}

}
