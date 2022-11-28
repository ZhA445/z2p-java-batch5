package day12_oopassigement_2;

public class Person {

	private String name;
	private String nrcno;
	private String address;
	private String phone;
	public Person () {
		
	}
	public Person(String name, String nrcno, String address, String phone) {
		super();
		this.name = name;
		this.nrcno = nrcno;
		this.address = address;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNrcno() {
		return nrcno;
	}
	public void setNrcno(String nrcno) {
		this.nrcno = nrcno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void showInfo() {
		System.out.println("Name - " + name);
		System.out.println("NRC - " + nrcno);
		System.out.println("Address - " + address);
		System.out.println("Phone - " + phone);
	}
	public static void nrcinfo(String nrc) {
		var state = nrc.substring(0, 1);
		
		switch (state) {
		case "1":
			System.out.println("State - Kachin region");
			break;
		case "2":
			System.out.println("State - Kayar region");
			break;
		case "3":
			System.out.println("State - Kayin region");
			break;
		case "4":
			System.out.println("State - Chin region");
			break;
		case "5":
			System.out.println("State - Sagaing region");
			break;
		case "6":
			System.out.println("State - Tanintharyi region");
			break;
		case "7":
			System.out.println("State - Bago region");
			break;
		case "8":
			System.out.println("State - Magway region");
			break;
		case "9":
			System.out.println("State - Mandalay region");
			break;
		case "10":
			System.out.println("State - Mon region");
			break;
		case "11":
			System.out.println("State - Rakhine region");
			break;
		case "12":
			System.out.println("State - Yangon region");
			break;
		default:
			break;
		}
		
		int start = nrc.indexOf("/");
		int end = nrc.lastIndexOf("(");
		
		var tmp = nrc.substring(start+ 1, end);
		System.out.println("city:" + tmp);
		
		int start1 = nrc.indexOf(")");
		String tmp1 = nrc.substring(start1+1, start1+7);
		System.out.println("Number: " +tmp1);
	}
	
}
