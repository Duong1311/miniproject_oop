package Step.step;


public  class PseudoStep{
	
	String s = new String();
	int id;
	DetailStep DS = new DetailStep();
	
	
	public void setData(String str,int id) {
		setString(str);
		setId(id);
	}
	
	public void setDetailStep(String str) {
		DetailStep DS = new DetailStep();
		DS.setData(str);
		setDetailStep(DS);
	}
	
	
	//Getter setter DS cua PS
	public DetailStep getDetailStep() {
		return DS;
	}
	public void setDetailStep(DetailStep dS) {
		DS = dS;
	}
	
	//Getter setter string cua PS
	public String getString() {
		return s;
	}
	public void setString(String s) {
		this.s = s;
	}
	
	//Getter setter id cua PS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
