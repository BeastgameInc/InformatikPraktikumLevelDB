package levelDBrepack.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import levelDBrepack.MainApp;
import levelDBrepack.model.LevelProp;

/**
 * The controller class for the level editor
 * 
 * @author Timon Lomberg
 *
 */
public class LevelEditorController {

	@FXML
	private Label nameLabel;
	@FXML
	private TilePane tilePane;
	@FXML
	private ImageView iv0;
	@FXML
	private ImageView iv1;
	@FXML
	private ImageView iv2;
	@FXML
	private ImageView iv3;
	@FXML
	private ImageView iv4;
	@FXML
	private ImageView iv5;
	@FXML
	private ImageView iv6;


	private File f0;
	private File f1;
	private File f2;
	private File f3;
	private File f4;
	private File f5;
	private File f6;

	private Map<ImageView, File> ma = new HashMap<ImageView, File>();

	private Canvas[][] tiles;
	private double tileSize;

	private ImageView activeImage;
	private File activeFile;
	private LevelProp level;
	private MainApp mainApp;

	public LevelEditorController() {	
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * Initializes the canvas and draws them
	 */
	public void initCanvases() {
		ma.put(iv0, f0);
		ma.put(iv1, f1);
		ma.put(iv2, f2);
		ma.put(iv3, f3);
		ma.put(iv4, f4);
		ma.put(iv5, f5);
		ma.put(iv6, f6);
		nameLabel.setText(level.getID());
		tiles = new Canvas[level.getWidh()][level.getHeight()];
		tileSize= 100;

		for(int i = 0; i<level.getWidh();i++) {
			for(int j = 0;j<level.getHeight();j++) {
				
				if(level.tiles==null || level.tiles[i][j]==null) {
					tiles[i][j] = new Canvas(tileSize, tileSize);
					tiles[i][j].getGraphicsContext2D().setFill(Color.BLACK);
					tiles[i][j].getGraphicsContext2D().fillRect(0, 0, tiles[i][j].getWidth(), tiles[i][j].getHeight());
					tiles[i][j].getGraphicsContext2D().setFill((Color.WHITE));
					tiles[i][j].getGraphicsContext2D().fillRect(5, 5, tiles[i][j].getWidth()-10, tiles[i][j].getHeight()-10);
					tiles[i][j].setId("blank");
				} else {
					tiles[i][j]=level.tiles[i][j];
				}
				tiles[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if(activeFile!=null)
							((Canvas) event.getSource()).getGraphicsContext2D().drawImage(new Image("file:///"+activeFile.getPath()), 0.0, 0.0, tileSize, tileSize);
							((Canvas) event.getSource()).setId("file:///"+activeFile.getPath());
					}
				});
				tilePane.getChildren().add(tiles[i][j]); 
			}
		}
		tilePane.setPrefColumns(level.getWidh());
		tilePane.setPrefRows(level.getHeight());
	}


	@FXML
	private void initialize() {

	}

	/**
	 * Handles back button action
	 */
	@FXML
	private void handleBack() {
		level.tiles = this.tiles;
		level.setProps(contentAsJSON().toString());
		mainApp.initRootLayout();
		mainApp.showLevelTable();
	}
	
	/**
	 * Returns all content of the level as a JSONArray
	 * @return The JSONArray
	 */
	public JSONArray contentAsJSON() {
		JSONArray arr = new JSONArray();
		
		for(int i = 0; i<level.getWidh();i++) {
			for(int j = 0;j<level.getHeight();j++) {
				JSONObject obj = new JSONObject();
				obj.put("x", i);
				obj.put("y", j);
				obj.put("ImageFile", tiles[i][j].getId());
				arr.put(obj);
			}
		}
		return arr;
		
	}


	/**
	 * Handles palet item click
	 */
	@FXML
	private void handleC0() {
		activeImage = iv0;
		activeFile = ma.get(activeImage);
	}
	/**
	 * Handles palet item click
	 */
	@FXML
	private void handleC1() {
		activeImage = iv1;
		activeFile = ma.get(activeImage);
	}
	/**
	 * Handles palet item click
	 */
	@FXML
	private void handleC2() {
		activeImage = iv2;
		activeFile = ma.get(activeImage);
	}
	/**
	 * Handles palet item click
	 */
	@FXML
	private void handleC3() {
		activeImage = iv3;
		activeFile = ma.get(activeImage);
	}
	/**
	 * Handles palet item click
	 */
	@FXML
	private void handleC4() {
		activeImage = iv4;
		activeFile = ma.get(activeImage);
	}
	/**
	 * Handles palet item click
	 */
	@FXML
	private void handleC5() {
		activeImage = iv5;
		activeFile = ma.get(activeImage);
	}
	/**
	 * Handles palet item click
	 */
	@FXML
	private void handleC6() {
		activeImage = iv6;
		activeFile = ma.get(activeImage);
	}

	/**
	 * Handles clear button action
	 */
	@FXML
	private void handleClear() {
		for(int i = 0; i<level.getWidh();i++) {
			for(int j = 0;j<level.getHeight();j++) {
				tiles[i][j].getGraphicsContext2D().setFill(Color.BLACK);
				tiles[i][j].getGraphicsContext2D().fillRect(0, 0, tiles[i][j].getWidth(), tiles[i][j].getHeight());
				tiles[i][j].getGraphicsContext2D().setFill((Color.WHITE));
				tiles[i][j].getGraphicsContext2D().fillRect(5, 5, tiles[i][j].getWidth()-10, tiles[i][j].getHeight()-10);
			}
		}
	}

	/**
	 * Handles setImage button action
	 */
	@FXML
	private void handleSetImage() {
		try {
			FileChooser fc = new FileChooser();
			fc.getExtensionFilters().add(new ExtensionFilter("PNG", "*.png"));
			fc.setTitle("Open Tile Image");
			File file = fc.showOpenDialog(mainApp.getPrimaryStage());
			activeFile = file;
			activeImage.setImage(new Image(new FileInputStream(file.getPath())));
			ma.replace(activeImage, file);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	public void setLevel(LevelProp level) {
		this.level = level;
	}


}
