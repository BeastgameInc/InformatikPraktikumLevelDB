package functionell;

import java.lang.reflect.Field;

public class Struct {
	
	@Override
	public String toString() {
		
		String out = "";
		Field[] vars = this.getClass().getDeclaredFields();
		try {
			
			for(Field f : vars) {
				out = f.get(this).toString() + ", ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return out;
	}
}
