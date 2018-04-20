package paint.controller;

import java.util.List; 

import paint.model.Shape;
import paint.view.PaintFrame;

public class PaintController implements DrawingEngine {

	private PaintFrame paintFrame;
	
	public PaintController() {
		
	}
	
	public void start() {
		
		paintFrame = new PaintFrame(this);
	}

	@Override
	public void refresh(Object canvas) {
		
	}

	@Override
	public void addShape(Shape shape) {
		
	}

	@Override
	public void removeShape(Shape shape) {
		
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		
	}

	@Override
	public Shape[] getShapes() {

		return null;
	}

	@Override
	public void undo() {
		
	}

	@Override
	public void redo() {
		
	}

	@Override
	public void save(String path) {
		
	}

	@Override
	public void load(String path) {
		
	}
	
	// *************** bonus functions *************** //
	/*
	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {

		return null;
	}

	@Override
	public void installPluginShape(String jarPath) {
		
	}
	//*/
}
