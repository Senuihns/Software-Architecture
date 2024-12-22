package Model;

public class Parcel {
	
	private String parcelNo;
	private int days;
	private int weight;
	private int length;
	private int width;
	private int height;
	public String getParcelNo() {
		return parcelNo;
	}
	public void setParcelNo(String parcelNo) {
		this.parcelNo = parcelNo;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public Parcel() {
		
	}
	public Parcel(String parcelNo, int days, int weight, int length, int width, int height) {
		super();
		this.parcelNo = parcelNo;
		this.days = days;
		this.weight = weight;
		this.length = length;
		this.width = width;
		this.height = height;
	}
	

}
