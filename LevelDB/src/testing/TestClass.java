package testing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import functionell.MyJSONCaster;

import org.json.JSONArray;
import org.json.JSONException;

import structs.LevelInfoSTR;

public class TestClass {
	
	public static void main(String args[]) {
		testjson();
	}
	
	/** 
	 * Input: Schreiben: "test", 11, 10, new JSONArray(), new JSONArray() Lesen: "testfile.json"
	 * Output: Schreiben: {"width":11,"layers":[],"id":"test","height":10,"props":[]} Lesen: test, 11, 10, [], []
	 * Erwarteter Output: Schreiben: {"width":11,"layers":[],"id":"test","height":10,"props":[]} Lesen: test, 11, 10, [], []
	 */
	public static void testjson() {
		LevelInfoSTR test = new LevelInfoSTR("test", 11, 10, new JSONArray(), new JSONArray());
		LevelInfoSTR testout = new LevelInfoSTR("");

		try {
			Files.write(Paths.get("testfile.json"), MyJSONCaster.getJSONFromObject(test).toString().getBytes());
			MyJSONCaster.readJSONIntoObject("testfile.json", testout);

			System.out.println(testout.toString());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
