package base.model;

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

		Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/book_assigement", "root",
				"Zha@2017");

		return con;
	}

	// Librarian Login
	public static librarian login(String email, String password) {
		librarian libran = null;

		try (Connection con = createConnection()) {
			var query = "SELECT * FROM user WHERE email = ? AND password = ?";
			PreparedStatement pstm = con.prepareStatement(query);

			pstm.setString(1, email);
			pstm.setString(2, password);

			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				libran = new librarian();
				libran.setId(rs.getInt("id"));
				libran.setEmail(rs.getString("email"));
				libran.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return libran;
	}

	// SignUp Librarain
	public static void signupLibrarian(librarian libra) throws Exception {
		try (Connection con = createConnection()) {
			var query = "INSERT INTO user (email, password, nrc, phone , created_at) VALUES(? , ? , ? , ?,?)";

			var pstm = con.prepareStatement(query);
			pstm.setString(1, libra.getEmail());
			pstm.setString(2, libra.getPassword());
			pstm.setString(3, libra.getNrc());
			pstm.setString(4, libra.getPhone());
			pstm.setDate(5, Date.valueOf(LocalDate.now()));

			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	// Librarian List

	public static List<librarian> findAllLibrarian() {
		List<librarian> list = new ArrayList<>();
		try (Connection con = createConnection()) {
			var query = "select id,email,nrc,phone,created_at from user";

			var pstm = con.prepareStatement(query);

			var rs = pstm.executeQuery();
			while (rs.next()) {
				var libra = new librarian();
				libra.setId(rs.getInt("id"));
				libra.setEmail(rs.getString("email"));
				libra.setNrc(rs.getString("nrc"));
				libra.setPhone(rs.getString("phone"));
				libra.setCreated_at(LocalDate.parse(rs.getString("created_at")));

				list.add(libra);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	// Librarian Delete ID
	public static void deleteLibrarianById(int id) throws Exception {
		try (Connection con = createConnection()) {
			var query = "DELETE FROM user WHERE id = ?";

			var pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	// Member View
	public static List<Member> findAllMember() {
		List<Member> list = new ArrayList<>();
		try (Connection con = createConnection()) {

			var query = "select member.*, membercategory.stdYear from membercategory, member where member.year = membercategory.id";

			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while (rs.next()) {
				// create member
				var member = new Member();

				// assign data
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setRno(rs.getInt("rno"));
				member.setAcyear(rs.getString("acyear"));
				member.setCreated_at(LocalDate.parse(rs.getString("created_at")));
				member.setExpdate(LocalDate.parse(rs.getString("expdate")));

				var cat = new MemberCategory();
				cat.setId(rs.getInt("year"));
				cat.setStdYear(rs.getString("stdYear"));
				member.setYear(cat);
				// add to list
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void deleteMemberById(int id) throws Exception {
		try (Connection con = createConnection()) {
			var query = "DELETE FROM member WHERE id = ?";

			var pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.executeUpdate();

		} catch (Exception e) {
			throw e;
		}

	}

	public static List<MemberCategory> findAllMemberCategory() {
		List<MemberCategory> list = new ArrayList<>();
		try (Connection con = createConnection()) {
			var query = "SELECT * FROM membercategory";
			var pstm = con.prepareStatement(query);

			var rs = pstm.executeQuery();
			while (rs.next()) {
				var cat = new MemberCategory();
				cat.setId(rs.getInt("id"));
				cat.setStdYear(rs.getString("stdYear"));

				list.add(cat);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static void MemberRegister(Member member) throws Exception {
		try (Connection con = createConnection()) {
			var query = "INSERT INTO member(name,rno,year,acyear,created_at,expdate) VALUES(?,?,?,?,?,?)";

			var pstm = con.prepareStatement(query);
			pstm.setString(1, member.getName());
			pstm.setInt(2, member.getRno());
			pstm.setInt(3, member.getYear().getId());
			pstm.setString(4, member.getAcyear());
			pstm.setDate(5, Date.valueOf(LocalDate.now()));
			pstm.setDate(6, Date.valueOf(LocalDate.now().plusYears(1)));

			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	public static Member findMemberById(int id) {
		Member member = null;
		try (Connection con = createConnection()) {
			var query = "select member.*,membercategory.stdYear from membercategory, member where member.year = membercategory.id && member.id = ?";

			var pstm = con.prepareStatement(query);
			pstm.setInt(1, id);

			var rs = pstm.executeQuery();
			if (rs.next()) {
				member = new Member();

				// assign data
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setRno(rs.getInt("rno"));
				member.setAcyear(rs.getString("acyear"));

				var cat = new MemberCategory();
				cat.setId(rs.getInt("year"));
				cat.setStdYear(rs.getString("stdYear"));

				member.setYear(cat);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	public static void updateMember(Member member) throws Exception {

		try (Connection con = createConnection()) {
			var query = "UPDATE member SET name = ?, rno = ?, year  = ?, acyear = ? WHERE id = ?";

			var pstm = con.prepareStatement(query);
			pstm.setString(1, member.getName());
			pstm.setInt(2, member.getRno());
			pstm.setInt(3, member.getYear().getId());
			pstm.setString(4, member.getAcyear());
			pstm.setInt(5, member.getId());

			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	public static List<Member> searchMember(String id, String name) {
		List<Member> list = new ArrayList<>();
		try (Connection con = createConnection()) {
			var query = "SELECT member.*,membercategory.stdYear FROM membercategory, member WHERE member.year = membercategory.id";

			List<String> params = new ArrayList<>();

			if (!id.isEmpty()) {
				query += " AND member.id LIKE ?";
				params.add("%" + id + "%");
			}
			if (!name.isEmpty()) {
				query += " AND member.name LIKE ?";
				params.add("%" + name + "%");
			}

			var pstm = con.prepareStatement(query);

			// assign value to query parameters
			for (var i = 0; i < params.size(); i++) {
				pstm.setObject((i + 1), params.get(i));
			}

			var rs = pstm.executeQuery();
			if (rs.next()) {
				var member = new Member();

				// assign data
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setRno(rs.getInt("rno"));
				member.setAcyear(rs.getString("acyear"));
				member.setCreated_at(LocalDate.parse(rs.getString("created_at")));
				member.setExpdate(LocalDate.parse(rs.getString("expdate")));

				var cat = new MemberCategory();
				cat.setId(rs.getInt("year"));
				cat.setStdYear(rs.getString("stdYear"));

				member.setYear(cat);

				list.add(member);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static List<Author> findAllAuthor() {
		List<Author> list = new ArrayList<>();
		try (Connection con = createConnection()) {
			var query = "select * from author";

			var pstm = con.prepareStatement(query);

			var rs = pstm.executeQuery();
			while (rs.next()) {
				var author = new Author();
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));

				list.add(author);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static List<BookCategory> findAllBookCategory() {

		List<BookCategory> list = new ArrayList<>();
		try (Connection con = createConnection()) {
			var query = "select * from bookcategory";

			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while (rs.next()) {
				var category = new BookCategory();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void AddBook(Book book) throws Exception {
		try (Connection con = createConnection()) {
			var query = "INSERT INTO book(code,title,publish_date,author_id,category_id) VALUES(?,?,?,?,?)";

			var pstm = con.prepareStatement(query);
			pstm.setInt(1, book.getCode());
			pstm.setString(2, book.getTitle());
			pstm.setDate(3, Date.valueOf(book.getPublish()));
			pstm.setInt(4, book.getAuthor().getId());
			pstm.setInt(5, book.getCategory().getId());

			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	public static Book findBookByCode(int cod) {
		Book book = null;
		try (Connection con = createConnection()) {
			var query = "select book.*,author.name'authorName',bookcategory.name'catName' from bookcategory,author,book where book.author_id = author.id && book.category_id = bookcategory.id && book.code = ?";

			var pstm = con.prepareStatement(query);
			pstm.setInt(1, cod);

			var rs = pstm.executeQuery();
			while (rs.next()) {
				book = new Book();
				// assign data
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublish(LocalDate.parse(rs.getString("publish_date")));

				var author = new Author();
				author.setId(rs.getInt("author_id"));
				author.setName(rs.getString("authorName"));

				var cat = new BookCategory();
				cat.setId(rs.getInt("category_id"));
				cat.setName(rs.getString("catName"));

				book.setAuthor(author);
				book.setCategory(cat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	public static void UpdateBook(Book book) throws Exception {
		try (Connection con = createConnection()) {
			var query = "UPDATE book SET title = ?, author_id = ?, category_id = ? WHERE code = ?";

			var pstm = con.prepareStatement(query);
			pstm.setString(1, book.getTitle());
			pstm.setInt(2, book.getAuthor().getId());
			pstm.setInt(3, book.getCategory().getId());
			pstm.setInt(4, book.getCode());

			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	public static Member checkMemberIdtoBorrow(Integer memid) {
		Member member = null;
		try (Connection con = createConnection()) {
			var query = "select * from member where expdate > localtimestamp() && id = ?";
			// Date date = Date.valueOf(LocalDate.now());

			var pstm = con.prepareStatement(query);

			pstm.setInt(1, memid);

			var rs = pstm.executeQuery();
			while (rs.next()) {
				member = new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setRno(rs.getInt("rno"));
				member.setAcyear(rs.getString("acyear"));
				member.setCreated_at(LocalDate.parse(rs.getString("created_at")));
				member.setExpdate(LocalDate.parse(rs.getString("expdate")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	public static Book checkBookisAvailable(int bookcode) {
		Book book = null;
		try (Connection con = createConnection()) {
			var query = "select * from book where borrow_by is null && code = ?";

			var pstm = con.prepareStatement(query);

			pstm.setInt(1, bookcode);

			var rs = pstm.executeQuery();
			while (rs.next()) {

				book = new Book();

				book.setId(rs.getInt("id"));
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublish(LocalDate.parse(rs.getString("publish_date")));

				var author = new Author();
				author.setId(rs.getInt("author_id"));

				var cat = new BookCategory();
				cat.setId(rs.getInt("category_id"));

				book.setAuthor(author);
				book.setCategory(cat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;

	}

	public static Book RentBook(int memid, int bookcode) {
		Book book = null;
		try (Connection con = createConnection()) {
			var query = "UPDATE book SET borrow_by = ? ,borrow_date = ?, return_date = ? WHERE code = ?";

			var pstm = con.prepareStatement(query);
			pstm.setInt(1, memid);
			pstm.setDate(2, Date.valueOf(LocalDate.now()));
			pstm.setDate(3, Date.valueOf(LocalDate.now().plusMonths(1)));
			pstm.setInt(4, bookcode);

			var rs = pstm.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublish(LocalDate.parse(rs.getString("publish_date")));

				var author = new Author();
				author.setId(rs.getInt("author_id"));

				var cat = new BookCategory();
				cat.setId(rs.getInt("category_id"));

				book.setAuthor(author);
				book.setCategory(cat);

				var mem = new Member();
				mem.setId(rs.getInt("borrow_by"));

				book.setBorrow_by(mem);

				book.setBorrow_date(LocalDate.parse(rs.getString("borrow_date")));
				book.setReturn_date(LocalDate.parse(rs.getString("return_date")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	public static Book checkReturnDate(Integer code) throws Exception {
		Book book = null;
		try (Connection con = createConnection()) {
			var query = "select * from book where return_date >= localtimestamp() && code = ?";

			var pstm = con.prepareStatement(query);

			pstm.setInt(1, code);

			var rs = pstm.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublish(LocalDate.parse(rs.getString("publish_date")));

				var author = new Author();
				author.setId(rs.getInt("author_id"));

				var cat = new BookCategory();
				cat.setId(rs.getInt("category_id"));

				book.setAuthor(author);
				book.setCategory(cat);

				var mem = new Member();
				mem.setId(rs.getInt("borrow_by"));

				book.setBorrow_by(mem);

				book.setBorrow_date(LocalDate.parse(rs.getString("borrow_date")));
				book.setReturn_date(LocalDate.parse(rs.getString("return_date")));
			}
		} catch (Exception e) {
			throw e;
		}
		return book;
	}

	public static void ReturnBook(int code) {
		try (Connection con = createConnection()) {
			var query = "UPDATE book SET borrow_by = null , borrow_date = null, return_date = null WHERE code = ?";

			var pstm = con.prepareStatement(query);

			pstm.setInt(1, code);

			pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static Book checkLateReturnDate(int code) throws Exception {
		Book book = null;
		try (Connection con = createConnection()) {
			var query = "select * from book where return_date < localtimestamp() && code = ?";

			var pstm = con.prepareStatement(query);

			pstm.setInt(1, code);

			var rs = pstm.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublish(LocalDate.parse(rs.getString("publish_date")));

				var author = new Author();
				author.setId(rs.getInt("author_id"));

				var cat = new BookCategory();
				cat.setId(rs.getInt("category_id"));

				book.setAuthor(author);
				book.setCategory(cat);

				var mem = new Member();
				mem.setId(rs.getInt("borrow_by"));

				book.setBorrow_by(mem);

				book.setBorrow_date(LocalDate.parse(rs.getString("borrow_date")));

			}
		} catch (Exception e) {
			throw e;
		}
		return book;
	}

	public static LocalDate countRentamount(int code) {
		Book book = null;
		LocalDate date = null;
		try (Connection con = createConnection()) {
			var query = "select return_date from book where code = ?";

			var pstm = con.prepareStatement(query);
			pstm.setInt(1, code);

			var rs = pstm.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setReturn_date(LocalDate.parse(rs.getString("return_date")));
			}
			date = book.getReturn_date();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return date;
	}

	public static Book checkIdAndcode(int id, int code) {
		Book book = null;
		try (Connection con = createConnection()) {
			var query = "select * from book where code = ? && borrow_by = ?";

			var pstm = con.prepareStatement(query);
			pstm.setInt(1, code);
			pstm.setInt(2, id);

			var rs = pstm.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublish(LocalDate.parse(rs.getString("publish_date")));

				var author = new Author();
				author.setId(rs.getInt("author_id"));

				var cat = new BookCategory();
				cat.setId(rs.getInt("category_id"));

				book.setAuthor(author);
				book.setCategory(cat);

				var mem = new Member();
				mem.setId(rs.getInt("borrow_by"));

				book.setBorrow_by(mem);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return book;
	}

	public static List<Book> findAllBook() {
		List<Book> list = new ArrayList<>();
		try (Connection con = createConnection()) {
			var query = "select book.*,author.name 'authorName',bookcategory.name 'categoryName' from  bookcategory, author, book where book.author_id = author.id && book.category_id = bookcategory.id ";
			
			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while(rs.next()) {
				//create book
				var book = new Book();
				
				//assign data
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublish(LocalDate.parse(rs.getString("publish_date")));
				
				var cat = new BookCategory();
				cat.setId(rs.getInt("category_id"));
				cat.setName(rs.getString("categoryName"));
				
				book.setCategory(cat);
				
				var author = new Author();
				author.setId(rs.getInt("author_id"));
				author.setName(rs.getString("authorName"));
				
				book.setAuthor(author);
				
				//add to list
				list.add(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static List<Book> searchBook(String category, String author, String title) {
		List<Book> list= new ArrayList<>();
		try (Connection con = createConnection()){
			var query = "select book.*,author.name 'authorName',bookcategory.name 'categoryName' from  bookcategory, author, book where book.author_id = author.id && book.category_id = bookcategory.id ";
			
			List<String> params = new ArrayList<>();
			if(!category.isEmpty()) {
				query += " and bookcategory.name like ?";
				params.add("%" + category + "%");
			}
			if(!author.isEmpty()) {
				query += " and author.name like ?";
				params.add("%" + author + "%");
			}
			if(!title.isEmpty()) {
				query += " and book.title like ?";
				params.add("%" + title + "%");
			}
			
			var pstm = con.prepareStatement(query);
			
			for(var i = 0; i< params.size() ; i++) {
				pstm.setObject((i+1), params.get(i));
			}
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				//create book
				var book = new Book();
				
				//assign data
				book.setId(rs.getInt("id"));
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublish(LocalDate.parse(rs.getString("publish_date")));
				
				var cat = new BookCategory();
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

}
