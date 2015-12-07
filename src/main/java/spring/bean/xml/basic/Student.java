package spring.bean.xml.basic;

public class Student {
	private String name;
	private double height;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	public String toString() {
		return "name: " + name + "\nheight: " + height;
	}
	
}
