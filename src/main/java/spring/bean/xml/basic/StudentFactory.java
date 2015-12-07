package spring.bean.xml.basic;

public class StudentFactory {
	private static Student student2 = new Student();
	private StudentFactory() {}
	
	public Student createStudent() {
		return student2;
	}
}
