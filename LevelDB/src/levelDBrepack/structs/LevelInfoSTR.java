package levelDBrepack.structs;


import org.json.JSONArray;


public class LevelInfoSTR implements Cloneable{
	public String id;
	public int width = 1;
	public int height = 1;
	public JSONArray props;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public JSONArray getProps() {
		return props;
	}
	public void setProps(JSONArray props) {
		this.props = props;
	}


		
	public LevelInfoSTR(String id, int width, int height, JSONArray props) {
		super();
		this.id = id;
		this.width = width;
		this.height = height;
		this.props = props;
	}
	public LevelInfoSTR(String id) {
		super();
		this.id = id;
	}
	
	@Override
	public String toString() {
		
		return id + ", " + width + ", " + height + ", " + props;
		
	}
	
	public LevelInfoSTR clone()
	{
		return new LevelInfoSTR(this.id, this.width, this.height, this.props);
	}
	
	
}
