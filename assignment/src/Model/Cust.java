package Model;

public class Cust {
	
	private String name;
    private String parcelNo;
    
	public Cust() {
		
	}
	
	public Cust(String name, String parcelNo) {
		super();
		this.name = name;
		this.parcelNo = parcelNo;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParcelNo() {
		return parcelNo;
	}
	public void setParcelNo(String parcelNo) {
		this.parcelNo = parcelNo;
	}

}
