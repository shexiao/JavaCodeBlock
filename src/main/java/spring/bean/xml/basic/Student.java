package spring.bean.xml.basic;

public class Student {
	private String name;
	private double height;
	private Info info;
	
	public Student() {}
	
	public Student(String name, double height, Info info) {
		this.name = name;
		this.height = height;
		this.info = info;
	}
	
	
	public static Student student = new Student();
	public static Student createInstance() {
		return student;
	}
	
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
	
	
	
	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public String toString() {
		return "name: " + name + "\nheight: " + height;
	}
	
}
