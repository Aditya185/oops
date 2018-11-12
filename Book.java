package Lab07;

import java.util.Objects;

/**
 * Describes an invoice for a set of purchased products.
 * @author pm jat @ daiict
*/
public class Book {

    public Book() {
        this(null, null, 0);
    }     
    public Book(String isbn, String title, double price) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.qty= 0;
    }
    /**
	@return ISBN
    */
    public String getIsbn() {
        return isbn;
    }
    /**
	sets ISBN of a Book
	@param isbn
    */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /**
	@return Price
    */
    public double getPrice() {
        return price;
    }
    /**
	sets Price of a Book
	@param price
    */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
        @return title
    */
    public String getTitle() {
        return title;
    }
    /**
	sets Title of a Book
	@param title
    */
    public void setTitle(String title) {
        this.title = title;
    }
/*
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.isbn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        return this.isbn.equals(other.isbn);
    }
*/    
    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn 
                + ", title=" + title 
                + ", price=" + price 
                + ", qty=" + qty + '}';
    }
   
    private String isbn = "";
    private String title = "";
    private double price = 0;
    private int qty = 0;    

}