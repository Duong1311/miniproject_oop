	package Graph;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;

public class Vertex {
	double guiX;
	double guiY;
	Button button = new Button();
	private int id;
	private String label;
	boolean completed;
	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	List<Integer> state = new ArrayList<Integer>(); 
	
	public List<Integer> getState() {
		return state;
	}
	
	public Vertex()
	{
		state.add(0,1);
	}
	
	
	public Vertex(int id,String label)
	{
		this.setLabel(Integer.toString(id)); 
		this.setId(id);
		state.add(0,1);
	}
	public Vertex(int id,String label,double x,double y,Button button)
	{
		this.setGuiX(x);
		this.setGuiY(y);
		this.setLabel(Integer.toString(id)); 
		this.setId(id);
		this.setButton(button);
		state.add(0,1);
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
