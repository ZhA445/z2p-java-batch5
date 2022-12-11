package com.mmit.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
	
	private static Connection createConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch5fp" ,"root" , "Zha@2017");
		
		return con;
	}

	public static User login(String user_name, String password) {
		User users = null;
		
		try (Connection con = createConnection()){
			
			var query = "SELECT * FROM user WHERE user_name = ? AND password = ?";
			
			PreparedStatement pstm = con.prepareStatement(query);
			
			pstm.setString(1, user_name);
			pstm.setString(2, password);
			
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				users = new User();
				users.setId(rs.getInt("id"));
				users.setUser_name(rs.getString("user_name"));
				users.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return users;
	}

	public static void saveAuthor(Author author) throws Exception {
		try(Connection con = createConnection()) {
			var query = "INSERT INTO authors(name, birthday , created_by , native_town) VALUES(?,?,?,?)";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, author.getName());
			pstm.setDate(2, Date.valueOf(author.getBirthday()));
			pstm.setInt(3, author.getCreated_by().getId());
			pstm.setString(4, author.getNative_town());
			
			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	public static List<Author> findAllAuthors() {
		
		List<Author> list = new ArrayList<>();
		try(Connection con = createConnection()) {
			var query = """
					select authors.* , user.user_name from authors, user
					where authors.created_by = user.id
					""";
			
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var author = new Author();
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				author.setNative_town(rs.getString("native_town"));
				
				User created = new User();
				created.setId(rs.getInt("created_by"));
				created.setUser_name(rs.getString("user_name"));
				
				author.setCreated_by(created);
				author.setBirthday(LocalDate.parse(rs.getString("birthday")));
				
				list.add(author);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static void updateAuthor(Author author) throws Exception {
		try(Connection con = createConnection()){
			var query = "UPDATE authors SET name = ? , birthday = ? , native_town = ? WHERE id = ?";
			
			var pstm = con.prepareStatement(query);
			pstm.setString(1, author.getName());
			pstm.setDate(2, Date.valueOf(author.getBirthday()));
			pstm.setString(3, author.getNative_town());
			pstm.setInt(4, author.getId());
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public static void deleteAuthorById(int id) {
		try(Connection con = createConnection()) {
			var query = "DELETE FROM authors WHERE id = ?";
			
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			
			pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public static List<Category> findAllCategory() {
		List<Category> list = new ArrayList<>();
		try(Connection con = createConnection()) {
			var query = """
					select categories.*  , user.user_name
					from categories, user where categories.created_by = user.id
					""";
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var cat = new Category();
				cat.setCreated_at(LocalDate.parse(rs.getString("created_at")));
				cat.setName(rs.getString("name"));
				cat.setId(rs.getInt("id"));
				
				var user = new User();
				user.setId(rs.getInt("created_by"));
				user.setUser_name(rs.getString("user_name"));
				
				cat.setCreated_by(user);
				
				list.add(cat);
			}
			
		} catch (Exception e) {
			
		}
		return list;
	}

	public static void saveBook(Book book) throws Exception {
		try(Connection con = createConnection()) {
			var query = "INSERT INTO books(code, title , price , publish_date, category_id, author_id, created_by) VALUES(?,?,?,?,?,?,?)";
			
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, book.getCode());
			pstm.setString(2, book.getTitle());
			pstm.setFloat(3, book.getPrice());
			pstm.setDate(4, Date.valueOf(book.getPublish_date()));
			pstm.setInt(5, book.getCategory().getId());
			pstm.setInt(6, book.getAuthor().getId());
			pstm.setInt(7, book.getCreated_by().getId());
			
			pstm.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		}
		
	}

	public static List<Book> findAllBooks() {
		List<Book> list = new ArrayList<>();
		try(Connection con = createConnection()) {
			var query = """
					select books.*,authors.name 'authorName' , categories.name 'categoryName', user.user_name from authors , books , categories , user
					where books.author_id = authors.id && books.category_id = categories.id && books.created_by = user.id;
					""";
			
			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while(rs.next()) {
				//create book
				var book = new Book();
				
				//assign data
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getFloat("price"));
				book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));
				
				var cat = new Category();
				cat.setId(rs.getInt("category_id"));
				cat.setName(rs.getString("categoryName"));
				
				book.setCategory(cat);
				
				var author = new Author();
				author.setId(rs.getInt("author_id"));
				author.setName(rs.getString("authorName"));
				
				book.setAuthor(author);
				
				var createdBy = new User();
				createdBy.setId(rs.getInt("created_by"));
				createdBy.setUser_name(rs.getString("user_name"));
				
				book.setCreated_by(createdBy);
				
				//add to list
				list.add(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	public static List<Book> searchBook(String category, String author, String title) {
		List<Book> list = new ArrayList<>();
		try(Connection con = createConnection()){
			var query = """
					select books.*,authors.name 'authorName' , categories.name 'categoryName' from authors , books , categories 
					where books.author_id = authors.id && books.category_id = categories.id
					""";
			List<String> params = new ArrayList<>();
			if(!category.isEmpty()) {
				query += " AND categories.name LIKE ?";
				params.add("%" + category + "%");
				
			}
			
			if(!author.isEmpty()) {
				query += " AND authors.name LIKE ?";
				params.add("%" + author + "%");
			}
			
			if(!title.isEmpty()) {
				query += " AND books.title  LIKE ?";
				params.add("%" + title + "%");
			}
			System.out.println("query ==> " + query);
			
			var pstm = con.prepareStatement(query);
			//assign value to query parameters
			for(var i = 0 ; i < params.size() ; i++) {
				pstm.setObject((i+1), params.get(i));
			}
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				//create book
				var book = new Book();
				
				//assign data
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getFloat("price"));
				book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));
				
				var cat = new Category();
				cat.setId(rs.getInt("category_id"));
				cat.setName(rs.getString("categoryName"));
				
				book.setCategory(cat);
				
				var auth = new Author();
				auth.setId(rs.getInt("author_id"));
				auth.setName(rs.getString("authorName"));
				
				book.setAuthor(auth);
				
				//add to list
				list.add(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static Book findBookById(int code) {
		Book book = null;
		try(Connection con = createConnection()) {
			var query = """
					select books.*,authors.name 'authorName' , categories.name 'categoryName' from authors , books , categories 
					where books.author_id = authors.id && books.category_id = categories.id && books.code = ?
					"""; 
			
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, code);
			
			var rs = pstm.executeQuery();
			if(rs.next()) {
				book = new Book();
				//assign data
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getFloat("price"));
				book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));
				
				var cat = new Category();
				cat.setId(rs.getInt("category_id"));
				cat.setName(rs.getString("categoryName"));
				
				book.setCategory(cat);
				
				var auth = new Author();
				auth.setId(rs.getInt("author_id"));
				auth.setName(rs.getString("authorName"));
				
				book.setAuthor(auth);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}

	public static void updateBook(Book book) throws Exception {
		try(Connection con = createConnection()) {
			var query = """
					UPDATE books
					SET title = ?, price = ? , category_id = ? , author_id =?
					WHERE code = ?
					""";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, book.getTitle());
			pstm.setFloat(2, book.getPrice());
			pstm.setInt(3, book.getCategory().getId());
			pstm.setInt(4, book.getAuthor().getId());
			pstm.setInt(5, book.getCode());
			
			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	public static void deleteBookById(int code) throws Exception {
		try (Connection con = createConnection()){
			var query = "DELETE FROM books WHERE code = ?";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, code);
			
			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}
	
//	public static void main(String[] args) throws SQLException {
//		createConnection();
//		System.out.println("og");
//	}
//	

}
