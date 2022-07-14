package Step.step;

public  class DetailStep  {

	String s = new String();
	int id;
	
	void setData(String str) {
		setString(str);
	}
	public String getString() {
		return s;
	}
	public void setString(String s) {
		this.s = s; 
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	
}
