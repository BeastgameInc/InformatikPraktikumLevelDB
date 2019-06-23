package levelDBrepack.view;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import levelDBrepack.MainApp;
import levelDBrepack.model.LevelProp;

public class LevelEditorController {
	
	@FXML
	private TextField transField;
	@FXML
	private TilePane tilePane;
	@FXML
	private HBox hBox;
	
	private Canvas[][] tiles;
	
	private Stage editorStage;
	private LevelProp level;
	
	public LevelEditorController() {
		
		
	}
	
	public void initCanvases() {
		tiles = new Canvas[level.getWidh()][level.getHeight()];
		
		for(int i = 0; i<level.getWidh();i++) {
			for(int j = 0;j<level.getHeight();j++) {
				tiles[i][j] = new Canvas(100,100); //TODO
				tiles[i][j].getGraphicsContext2D().setFill(Color.BLACK);
				tiles[i][j].getGraphicsContext2D().fillRect(0, 0, tiles[i][j].getWidth(), tiles[i][j].getHeight());
				tiles[i][j].getGraphicsContext2D().setFill((Color.WHITE));
				tiles[i][j].getGraphicsContext2D().fillRect(5, 5, tiles[i][j].getWidth()-10, tiles[i][j].getHeight()-10);
				tilePane.getChildren().add(tiles[i][j]); 
			}
		}
		tilePane.setPrefColumns(level.getWidh());
		tilePane.setPrefRows(level.getHeight());
	}
	
	
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
