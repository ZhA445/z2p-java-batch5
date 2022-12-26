package base.model;

import java.time.LocalDate;

public class Categories {

	private int id;
	private String name;
	private Author created_by;
	private LocalDate created_at;
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
	public Author getCreated_by() {
		return created_by;
	}
	public void setCreated_by(Author created_by) {
		this.created_by = created_by;
	}
	public LocalDate getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}
	
}
