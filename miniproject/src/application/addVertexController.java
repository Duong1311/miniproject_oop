package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class addVertexController extends Controller{
	@FXML
	static int id= 0;
	
	public void exit(ActionEvent event) throws IOException
	{
		FXMLLoader loader= new FXMLLoader(getClass().getResource("PrimaryStage.fxml"));
		Parent root = loader.load();
		stage = (Stage)( (Node) event.getSource() ).getScene().getWindow();
		scene = new Scene(root);
		showGraph(( AnchorPane)root,graph);
		stage.setScene(scene);
		stage.show();
	}
	public void addVertex(Parent root ,Scene scene) {
		// TODO Auto-generated method stub
		 EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
	         @Override 
	         public void handle(MouseEvent e) { 
	        	AnchorPane a = ( AnchorPane) root;
	        	Button button = new Button();
	        	button = this.addButton(scene,e.getSceneX(),e.getSceneY(),id);
	        	graph.addVertex(id,e.getSceneX(),e.getSceneY(),button);
	        	id++;
	        	a.getChildren().add(button);
	        	
	           
	          }

			private Button addButton(Scene scene, double sceneX, double sceneY,int id) {
				Button button = new Button();
				button.setText(Integer.toString(id));
				button.setLayoutX(sceneX);
				button.setLayoutY(sceneY);
				button.setStyle(
			            "-fx-background-radius: 15em; " +
			            "-fx-min-width: 30px; " +
			            "-fx-min-height: 30px; " +
			            "-fx-max-width: 30px; " +
			            "-fx-max-height: 30px;" +
			            "-fx-text-fill: red;"+
			            "-fx-background-color: cyan; "
			    );
				return button;
				
			} 
	      };  
	      //Registering the event filter 
	    scene.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler); 
	}

	
	
	
	
	
}
