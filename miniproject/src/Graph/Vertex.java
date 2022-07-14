	package Graph;

import javafx.scene.control.Button;

public class Vertex {
	double guiX;
	double guiY;
	Button button = new Button();
	private int id;
	private String label;
	public Vertex() {}
	public Vertex(int id,String label)
	{
		this.setLabel(Integer.toString(id)); 
		this.setId(id);
	}
	public Vertex(int id,String label,double x,double y,Button button)
	{
		this.setGuiX(x);
		this.setGuiY(y);
		this.setLabel(Integer.toString(id)); 
		this.setId(id);
		this.setButton(button);
	}
	
	public double getGuiX() {
		return guiX;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public void setGuiX(double guiX) {
		this.guiX = guiX;
	}

	public double getGuiY() {
		return guiY;
	}

	public void setGuiY(double guiY) {
		this.guiY = guiY;
	}

	
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
