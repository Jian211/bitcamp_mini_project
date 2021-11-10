package object;

public class Book {
	private int		bookid;		 //	책 고유번호
	private String  bookName;	 // 책 이름
	private int 	price;		 // 책 가격
	private String  witer;		 // 책 저자
	private String  category;	 // 책 카테고리
	private String  publisher;	 // 책 정보
	private int		stock;		 // 책 재고
	
	public Book(int bookid, String bookName, int price, String witer, String category, String publisher, int stock) {
		super();
		this.bookid = bookid;
		this.bookName = bookName;
		this.price = price;
		this.witer = witer;
		this.category = category;
		this.publisher = publisher;
		this.stock = stock;
	}
	
	
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookName=" + bookName + ", price=" + price + ", witer=" + witer
				+ ", category=" + category + ", publisher=" + publisher + ", stock=" + stock + "]";
	}


	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWiter() {
		return witer;
	}
	public void setWiter(String witer) {
		this.witer = witer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}	
