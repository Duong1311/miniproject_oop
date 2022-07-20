package application;

import java.io.IOException;

import Algorithm.Algorithm;
import Graph.Edge;
import Graph.Graph;
import Graph.Vertex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Controller {
	@FXML
	Algorithm algorithm;
	Graph graph = new Graph();
	@FXML
	Stage stage;
	Scene scene;
	Parent root;
	public void setData(Parent root,Scene scene) {
		this.root=root;
		this.scene=scene;
	} 
	
	
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
	void showGraph(AnchorPane root,Graph g)
	{
		for(int i = 0 ; i< g.getListVertex().size();i++)
		{
			Vertex v = g.getListVertex().get(i);
			root.getChildren().add(addButton(v));
		}
		for(int i = 0 ; i< g.getListEdge().size();i++) {
			Edge e = g.getListEdge().get(i);
			addLine(root,e);
		}
	}
	 	Button addButton(Vertex v)
	 	{
	 		double guiX = v.getGuiX();
			double guiY = v.getGuiY();
			int id = v.getId();
			Button roundButton = v.getButton();
			roundButton.setLayoutX(guiX);
			roundButton.setLayoutY(guiY);
			//((FlowPane) root).setHgap(x);
	        //((FlowPane) root).setVgap(y);
			roundButton.setStyle(
		            "-fx-background-radius: 15em; " +
		            "-fx-min-width: 30px; " +
		            "-fx-min-height: 30px; " +
		            "-fx-max-width: 30px; " +
		            "-fx-max-height: 30px;" +
		            "-fx-text-fill: red;"+
		            "-fx-background-color: cyan; "
		    );
			
			return roundButton;
	 	}
		 
	 	public void addLine(Parent root,Edge e)
	 	{
	 		drawArrowLine(e,e.getFrom().getGuiX(),e.getFrom().getGuiY(),
 						  e.getTo().getGuiX(),e.getTo().getGuiY(),	root);
 		}
	 	
	 	
	 	
	 	public static void drawArrowLine(Edge e,double startX, double startY, double endX, double endY, Parent root) {
		      // get the slope of the line and find its angle
		      double slope = (startY - endY) / (startX - endX);
		      double lineAngle = Math.atan(slope);
		      Line line = null;
		      double arrowAngle = startX > endX ? Math.toRadians(45) : -Math.toRadians(225);
		      double x=15;
		     
		      if(startX<endX) { 
		    	  if(startY<endY) {
		    		 
		    		  line = new Line(startX+x -x* Math.cos(lineAngle + arrowAngle), 
	    			  	      startY+x - x* Math.sin(lineAngle + arrowAngle), 
	    			  	      endX+x +  x* Math.cos(lineAngle - arrowAngle), 
	    			  	      endY+x +  x* Math.sin(lineAngle - arrowAngle));
		    	  }
		    	  else {
		    		
		    		  line = new Line(startX+x - x* Math.cos(lineAngle - arrowAngle), 
	    			  	      startY+x - x* Math.sin(lineAngle - arrowAngle), 
	    			  	      endX+x +  x* Math.cos(lineAngle + arrowAngle), 
	    			  	      endY+x +  x* Math.sin(lineAngle + arrowAngle));
		    	  } 
		      }
		      
		      if(startX>endX) {
		    	  if(startY<endY) {
		    		  
		    		  line = new Line(startX+x - x* Math.cos(lineAngle + arrowAngle), 
	    			  	      startY+x - x* Math.sin(lineAngle + arrowAngle), 
	    			  	      endX+x +  x* Math.cos(lineAngle - arrowAngle), 
	    			  	      endY+x +  x* Math.sin(lineAngle - arrowAngle));
		    	  }
		    	  else {
		    		 
		    		  line = new Line(startX+x - x* Math.cos(lineAngle - arrowAngle), 
	    			  	      startY+x - x* Math.sin(lineAngle - arrowAngle), 
	    			  	      endX+x +  x* Math.cos(lineAngle + arrowAngle), 
	    			  	      endY+x +  x* Math.sin(lineAngle + arrowAngle));
		    	  } 

		      }
		   
		      // create the arrow legs
		      Line arrow1 = new Line();
		      arrow1.setStartX(line.getEndX());
		      arrow1.setStartY(line.getEndY());
		      arrow1.setEndX(line.getEndX() + 5* Math.cos(lineAngle - arrowAngle));
		      arrow1.setEndY(line.getEndY() + 5* Math.sin(lineAngle - arrowAngle));

		      Line arrow2 = new Line();
		      arrow2.setStartX(line.getEndX());
		      arrow2.setStartY(line.getEndY());
		      arrow2.setEndX(line.getEndX() + 5*Math.cos(lineAngle + arrowAngle));
		      arrow2.setEndY(line.getEndY() + 5* Math.sin(lineAngle + arrowAngle));
		      line.setStroke(Color.ORANGE);
		      arrow1.setStroke(Color.ORANGE);
		      arrow2.setStroke(Color.ORANGE);
		      ((AnchorPane) root).getChildren().addAll(line, arrow1, arrow2);
		      
		      e.setLine(line);
		   }
	 	
	 	public static Label addLabel(String id, double X, double Y, String text) {
			Label label = new Label(text);
			label.setLayoutX(X);
			label.setLayoutY(Y);
			label.setMinWidth(200);
			label.setId(id);
			label.setBackground(new Background(new BackgroundFill(Color.LAVENDER,null,null)));
			label.setTextFill(Color.BLUE);
	 		return label;
	 	};
	 	
	 	public void changeColor(Label label)
	 	{
	 		label.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW,null,null)));
			label.setTextFill(Color.CRIMSON);
	 	}
	 	public void resetColor(Label label)
	 	{
	 		label.setBackground(new Background(new BackgroundFill(Color.LAVENDER,null,null)));
			label.setTextFill(Color.BLUE);
	 	}
	 	
	 	public void changeColor(Button button,int status)
	 	{
	 		switch(status) {
	 		case 1:
	 			button.setStyle(
			            "-fx-background-radius: 15em; " +
			            "-fx-min-width: 30px; " +
			            "-fx-min-height: 30px; " +
			            "-fx-max-width: 30px; " +
			            "-fx-max-height: 30px;" +
			            "-fx-text-fill: red;"+
			            "-fx-background-color: cyan; "
			    );
	 			break;
	 			
	 		case 2:
	 			button.setStyle(
						"-fx-background-radius: 15em; " +
					            "-fx-min-width: 30px; " +
					            "-fx-min-height: 30px; " +
					            "-fx-max-width: 30px; " +
					            "-fx-max-height: 30px;" +
					            "-fx-text-fill: crimson;"+
					            "-fx-background-color: greenyellow; "
			    );
	 			break;
	 		case 3:
	 			button.setStyle(
						"-fx-background-radius: 15em; " +
					            "-fx-min-width: 30px; " +
					            "-fx-min-height: 30px; " +
					            "-fx-max-width: 30px; " +
					            "-fx-max-height: 30px;" +
					            "-fx-text-fill: White;"+
					            "-fx-background-color: blueviolet; "
			    );
	 			break;
	 		case 4:
	 			button.setStyle(
						"-fx-background-radius: 15em; " +
					            "-fx-min-width: 30px; " +
					            "-fx-min-height: 30px; " +
					            "-fx-max-width: 30px; " +
					            "-fx-max-height: 30px;" +
					            "-fx-text-fill: Gray;"+
					            "-fx-background-color: orange; "
			    );
	 		}
	 	}
	 	public void changeColor(Line line,int status)
	 	{
	 		switch(status) {
	 		case 0:
	 			line.setStroke(Color.ORANGE);
	 			line.setStrokeWidth(1);
	 			break;
	 			
	 		case 1:
	 			line.setStroke(Color.RED);
	 			line.setStrokeWidth(3);
	 			break;
	 		}
	 	}
	 	
		public Graph getGraph() {
			return graph;
		}
		public void setGraph(Graph graph) {
			this.graph = graph;
		}
		
}
