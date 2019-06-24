package levelDBrepack.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import levelDBrepack.MainApp;
import levelDBrepack.model.LevelProp;

/**
 * The controller class for the root layout
 * 
 * @author Timon Lomberg
 *
 */
public class RootLayoutController {
	
	MainApp mainApp;
	
	public RootLayoutController() {
		
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	/**
	 * Handles export menu-item acion
	 */
	@FXML
	public void handleExport() {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("JSON-File", "*.json"));
		File file = fc.showSaveDialog(mainApp.getPrimaryStage());
		String content = "";
		JSONObject obj = new JSONObject();
		for(LevelProp i : mainApp.getLevelData()) {
			obj.put("ID", i.getID());
			obj.put("width", i.getWidh());
			obj.put("height", i.getHeight());
			obj.put("content", new JSONArray(i.getProps()));
			content = obj.toString();
		}
		
		if(file!=null) {
			 try {
		            FileWriter fileWriter = null;
		            
		            fileWriter = new FileWriter(file);
		            fileWriter.write(content);
		            fileWriter.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		}
	}

	@FXML
	private void initialize() {
		
	}
}
