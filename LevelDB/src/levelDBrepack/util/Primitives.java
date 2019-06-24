package levelDBrepack.util;

public class Primitives {
	
	public static Class<?> wrap(Class<?> cl) {

        if (cl.equals(void.class)) {
            return Void.class;
        }
        else if (cl.equals(byte.class)) {
            return Byte.class;
        }
        else if (cl.equals(int.class)) {
            return Integer.class;
        }
        else if (cl.equals(long.class)) {
            return Long.class;
        }
        else if (cl.equals(short.class)) {
            return Short.class;
        }
        else if (cl.equals(double.class)) {
            return Double.class;
        }
        else if (cl.equals(float.class)) {
            return Float.class;
        }
        else if (cl.equals(char.class)) {
            return Character.class;
        }
        else if (cl.equals(boolean.class)) {
            return Boolean.class;
        }
        else {
            return cl;
        }
    }

}
