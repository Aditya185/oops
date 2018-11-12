package Lab07;

public class BSTTester {
	public static void main(String[] args) {
		BST btree = new BST();
		Book b1 = new Book("121", "ABC", 250);
		btree.put( new Integer(121), b1);
		btree.put( new Integer(133),new Book("133","XYZ", 330) );
		btree.put( new Integer(113),new Book("113","XYZ2", 330) );
		btree.put( new Integer(123),new Book("123","XYZ3", 330) );

		Book x = (Book) btree.get(new Integer(121));
		Book y = (Book) btree.remove(new Integer(121));
		btree.inOrderOutput( System.out );
	}
}

