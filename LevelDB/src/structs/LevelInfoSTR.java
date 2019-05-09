package structs;


import org.json.JSONArray;

public class LevelInfoSTR extends functionell.Struct {
	public String id;
	public int width = 1;
	public int height = 1;
	public JSONArray props;
	public JSONArray layers;
	
	public LevelInfoSTR(String id, int width, int height, JSONArray props, JSONArray layers) {
		super();
		this.id = id;
		this.width = width;
		this.height = height;
		this.props = props;
		this.layers = layers;
	}
	public LevelInfoSTR(String id) {
		super();
		this.id = id;
	}
	
	@Override
	public String toString() {
		
		return id + ", " + width + ", " + height + ", " + props + ", " + layers;
		
	}
	
	
}
