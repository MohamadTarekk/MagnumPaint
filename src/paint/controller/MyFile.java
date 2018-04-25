package paint.controller;

public interface MyFile {	
	
	public PaintController theController = new PaintController();
	public String filePath = new String();
	
	public void save(PaintController paintController, String Path);
	public void load(PaintController paintController, String path);
}
