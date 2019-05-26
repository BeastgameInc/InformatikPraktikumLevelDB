package structs;

public class TileInfoSTR {
		
		private int x;
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
		private int y;
		private String Layer;
		private String TileURI;
		
	
}
