package paint.controller;

public interface Save {
	
	public boolean checkFile(String filePath);
	public void createFile(String filePath);
	public void save(String filePath);
	public void load(String filePath);
}
