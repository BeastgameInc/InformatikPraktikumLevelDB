package functionell; 

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.json.JSONArray;

import structs.TileInfoSTR;

public class LevelEditorManager {

	private ArrayList<TileInfoSTR> tiles = new ArrayList<TileInfoSTR>();
	private int subimageSize;
	private BufferedImage[] subSprites;
	
	public BufferedImage[] getsubSprites() {
		return subSprites;
	}
	
	public void setLayer(TileInfoSTR tile, String layerID) {
		tile.setLayer(layerID);
	}

	public JSONArray getJSONTiles() throws IllegalArgumentException, IllegalAccessException {
		JSONArray ar = new JSONArray();
		for(TileInfoSTR i : tiles) {
			ar.put(MyJSONCaster.getJSONFromObject(i));
		}
		return ar;
	}

	public void setSubSpritesFile(String URI) throws IOException {
		subSprites = cutSpritesheet(ImageIO.read(new File(URI)));
	}

	public BufferedImage[] cutSpritesheet(BufferedImage big) {

		int rows = (int) Math.ceil(big.getWidth() / (double) subimageSize);
		int cols = (int) Math.ceil(big.getHeight() / (double) subimageSize);
		int size;
		if(rows > cols) size=rows; else size=cols;
		BufferedImage[] sprites = new BufferedImage[size*size];

		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				sprites[i * size + j] = big.getSubimage(j*subimageSize, i+subimageSize, size, size);
			}
		}
		return sprites;
	}



}
