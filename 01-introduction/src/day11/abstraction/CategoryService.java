package day11.abstraction;

import java.util.List;

public class CategoryService extends DataBaseUtil{

	@Override
	public void insert() {
		System.out.println("INSERT INTO category");
		
	}

	@Override
	public void update() {
		System.out.println("UPDATE category SET..");
		
	}

	@Override
	public boolean delete(int id) {
		System.out.println("DELETE FROM category WHERE id = " + id);
		return false;
	}

	@Override
	public Object findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
