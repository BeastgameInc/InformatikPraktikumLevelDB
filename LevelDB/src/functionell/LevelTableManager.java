package functionell;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import org.json.*;
import structs.LevelInfoSTR;

public class LevelTableManager {

	private ArrayList<LevelInfoSTR> levelList = new ArrayList<LevelInfoSTR>();


	public void addLevel(LevelInfoSTR str) {
		levelList.add(str);
	}
	public void removeLevel(int index) {
		levelList.remove(index);
	}
	public void removeLevel(LevelInfoSTR obj) {
		levelList.remove(obj);
	}


	public void setID(int index, String nID) {
		levelList.get(index).id = nID;
	}
	public void setWidth(int index, int nWidth) {
		levelList.get(index).width = nWidth;
	}
	public void setHeight(int index, int nHeight) {
		levelList.get(index).height = nHeight;
	}


	public void getSortedQuick(int iLeft, int iRight) {
		if(iLeft < iRight) {
			int divider = divideID(iLeft, iRight);
			getSortedQuick(iLeft, divider - 1);
			getSortedQuick(divider+1, iRight);
		}
	}

	private int divideID(int iLeft, int iRight) {
		int i = iLeft;
		int j = iRight;
		String pivot = levelList.get(iRight).getId();

		do {

			while(i < iRight && (levelList.get(i).getId().compareToIgnoreCase(pivot) < 0)) {
				i++;
			}

			while(j > iLeft && (levelList.get(j).getId().compareToIgnoreCase(pivot) >= 0)) {
				j--;
			}

			if(i < j) {
				Collections.swap(levelList, i, j);
			}
		}
		while (i < j);

		Collections.swap(levelList, i, iRight);
		return i;

	}

	public void saveProgress(String path) {
		try {
			JSONObject obj = new JSONObject();
			for(int i = 0; i<levelList.size();i++) {
				obj.put(""+i, MyJSONCaster.getJSONFromObject(i));
			}
			Files.write(Paths.get(path), obj.toString().getBytes());
		} catch(Exception e) {
			System.err.println("Saving failed!");
			e.printStackTrace();
		}
	}
	
	public void loadProgress(String path) {
		try {
		JSONObject obj = new JSONObject(Files.readString(Paths.get(path)));
		for(int i = 0; i<obj.keySet().size();i++) {
			LevelInfoSTR tmp = new LevelInfoSTR("#MISSING");
			MyJSONCaster.readJSONIntoObject(obj.getJSONObject(""+i), tmp);
			levelList.add(tmp);
		}
		} catch(Exception e) {
			System.err.println("Loading failed!");
			e.printStackTrace();
		}
	}
	
	public void resetProgress() {
		for(LevelInfoSTR i : levelList) {
			levelList.remove(i);
		}
		//TODO might cause error
		
	}

}
