package levelDBrepack;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import levelDBrepack.structs.LevelInfoSTR;
import levelDBrepack.util.Primitives;

public class MyJSONCaster {

	


	/**
	 * 
	 * @param info	A object from which the fields are read and turned into a JSONObject. All fields must be public!
	 * @return 		The finished JSONObject generated.
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static JSONObject getJSONFromObject(Object info) throws IllegalArgumentException, IllegalAccessException {
		JSONObject jo = new JSONObject();
		Field[] vars = info.getClass().getDeclaredFields();
		for(Field f : vars) {
			String declarator = f.getName();
			Object value = f.get(info);
			jo.put(declarator, Primitives.wrap(f.getType()).cast(value));	
		}
		return jo;
	}

	/**
	 * Reads a JSON file and coppies all attribute values into fitting fielsd of given objects. All attributes must have equal names and types!
	 * 
	 * @param fileUri	The path of the json-file to read. 
	 * @param target	The target object of whom the filed are to be modified.
	 * @throws IOException 
	 * @throws JSONException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void readJSONIntoObject(String fileUri, Object target) throws JSONException, IOException, IllegalArgumentException, IllegalAccessException {
		JSONObject jo = new JSONObject(Files.readString(Paths.get(fileUri)));
		Field[] vars = target.getClass().getDeclaredFields();
		for(Field f : vars) {
			f.set(target, jo.get(f.getName()));
		}
	}
	
	public static void readJSONIntoObject(JSONObject obj, Object target) throws JSONException, IOException, IllegalArgumentException, IllegalAccessException {
		JSONObject jo = obj;
		Field[] vars = target.getClass().getDeclaredFields();
		for(Field f : vars) {
			f.set(target, jo.get(f.getName()));
		}
	}

	
}



