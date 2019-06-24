package levelDBrepack.structs;

public class TileInfoSTR {
	
	
		
		public TileInfoSTR(int x, int y, String layer) {
		super();
		this.x = x;
		this.y = y;
		Layer = layer;
	}
		public int x;
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public String getLayer() {
			return Layer;
		}
		public void setLayer(String layer) {
			Layer = layer;
		}
		public String getTileURI() {
			return TileURI;
		}
		public void setTileURI(String tileURI) {
			TileURI = tileURI;
		}
		public int y;
		public String Layer;
		public String TileURI;
		
	
}
