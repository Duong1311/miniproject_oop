package Context;
import Algorithm.Algorithm;

public class Context {
	
	Algorithm algorithm;
	
	public void setAlgorithm(Algorithm x) {
		// TODO Auto-generated method stub
		algorithm=x;
	}
	public void doExporation() {
		// TODO Auto-generated method stub
		
		algorithm.explore();
	}
	
}
