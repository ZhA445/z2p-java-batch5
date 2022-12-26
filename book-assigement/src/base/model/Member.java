package base.model;

import java.time.LocalDate;

public class Member {

	private int id;
	private String name;
	private int rno;
	private MemberCategory year;
	private String acyear;
	private LocalDate created_at;
	private LocalDate expdate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public MemberCategory getYear() {
		return year;
	}
	public void setYear(MemberCategory year) {
		this.year = year;
	}
	public String getAcyear() {
		return acyear;
	}
	public void setAcyear(String acyear) {
		this.acyear = acyear;
	}
	public LocalDate getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}
	public LocalDate getExpdate() {
		return expdate;
	}
	public void setExpdate(LocalDate expdate) {
		this.expdate = expdate;
	}
	
	public String getMemberCat() {
		return this.year.getStdYear();
	}
}
