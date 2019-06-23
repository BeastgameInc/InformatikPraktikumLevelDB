package levelDBrepack.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LevelProp {

	private StringProperty id;
	private IntegerProperty width;
	private IntegerProperty height;
	private StringProperty props;
	
	public LevelProp(String id, int width, int height) {
		this.id = new SimpleStringProperty(id);
		this.width = new SimpleIntegerProperty(width);
		this.height = new SimpleIntegerProperty(height);
	}
	
	public LevelProp() {
		this(null, 0, 0);
	}

	public String getID() {
		return id.get();
	}
	
	public void setID(String id) {
		this.id.set(id);
	}
	public StringProperty idProperty() {
		return id;
	}
	
	public int  getWidh() {
		return width.get();
	}
	
	public void setWidth(int width) {
		this.width.set(width);
	}
	
	public IntegerProperty widthProperty() {
		return width;
	}
	
	public int  getHeight() {
		return width.get();
	}
	
	public void setHeight(int width) {
		this.width.set(width);
	}
	
	public IntegerProperty heightProperty() {
		return width;
	}
	
	public String getProps() {
		return props.get();
	}
	
	public void setProps(String props) {
		this.props.set(props );
	}
	
	public StringProperty propsProperty() {
		return props;
	}
	
}
