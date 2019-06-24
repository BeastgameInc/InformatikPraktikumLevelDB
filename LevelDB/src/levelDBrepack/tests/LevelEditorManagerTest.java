package levelDBrepack.tests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.junit.Test;

import levelDBrepack.LevelEditorManager;
import levelDBrepack.structs.TileInfoSTR;

public class LevelEditorManagerTest {
	LevelEditorManager myLevelEditorManager = new LevelEditorManager();
	@Test
	public void derTest1() throws IllegalArgumentException, IllegalAccessException {
		myLevelEditorManager.addTile(new TileInfoSTR(0,0,"Vordergrund"));
		myLevelEditorManager.addTile(new TileInfoSTR(1,1,"Vordergrund"));
		myLevelEditorManager.addTile(new TileInfoSTR(2,2,"Vordergrund"));
		String umwandeln;
		umwandeln = myLevelEditorManager.getJSONTiles().toString();
		System.out.println(umwandeln);
		Assert.assertEquals("[{\"x\":0,\"y\":0,\"Layer\":\"Vordergrund\"},{\"x\":1,\"y\":1,\"Layer\":\"Vordergrund\"},{\"x\":2,\"y\":2,\"Layer\":\"Vordergrund\"}]", umwandeln);

	}
	
	@Test
	public void derTest2() throws IOException {
		BufferedImage img = ImageIO.read(new File("testimage.png"));
		BufferedImage[] aer = myLevelEditorManager.cutSpritesheet(img);
		Assert.assertNotNull(aer);
	}
	
	@Test
	public void derTest3( ) throws IOException {
		myLevelEditorManager.setSubSpritesFile("testimage.png");
		Assert.assertNotNull(myLevelEditorManager.getsubSprites());
	}

}

