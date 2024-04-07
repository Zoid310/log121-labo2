package models;

public class Image {
	
	private String path;
	private int[] size;
	
	public Image(String cPath, int[] cSize) {
		this.path = cPath;
        this.size = cSize;
	}

	//#region Getters/Setters

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int[] getSize() {
		return size;
	}

	public void setSize(int[] size) {
		this.size = size;
	}
	//#endregion
}
// okok
