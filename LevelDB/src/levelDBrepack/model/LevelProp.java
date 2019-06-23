package levelDBrepack.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import structs.LevelInfoSTR;

public class LevelProp {

	private StringProperty id;
	private IntegerProperty width;
	private IntegerProperty height;
	private StringProperty props;
	
	private LevelInfoSTR levelSTR;
	
	public LevelProp(String id, int width, int height) {
		this.id = new SimpleStringProperty(id);
		this.width = new SimpleIntegerProperty(width);
		this.height = new SimpleIntegerProperty(height);
	}
	
	public LevelProp(LevelInfoSTR levelSTR) {
		this.id.set(levelSTR.id);
		this.width.set(levelSTR.width);
		this.height.set(levelSTR.height);
		this.props.set(levelSTR.getProps().toString());
	}
	
	public LevelProp() {
		this(null, 1, 1);
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
		return height.get();
	}
	
	public void setHeight(int width) {
		this.height.set(width);
	}
	
	public IntegerProperty heightProperty() {
		return height;
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
	
	public boolean idEquals(LevelProp level) {
		return this.getID().equals(level.getID());
	}
	
}
