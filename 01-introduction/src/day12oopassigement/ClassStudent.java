package day12oopassigement;

public class ClassStudent {

	private int studentId;
	private String name;
	private int mark;
	public ClassStudent(int studentId, String name, int mark) {
		this.studentId = studentId;
		this.name = name;
		this.mark = mark;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	public void display() {
		System.out.print(studentId +"\t" +  this.name + "\t" + mark + "\n");
	}
	
}
