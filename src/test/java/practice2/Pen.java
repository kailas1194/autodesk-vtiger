package practice2;

public class Pen {
	
	private String color;
	private String brand;
	private int price;
	
	
	 Pen(String color, String brand, int price) {
		this.color = color;
		this.brand = brand;
		this.price = price;
	}
	 
	 void write() {
		 System.out.println(color);
	 }
	
	

}
