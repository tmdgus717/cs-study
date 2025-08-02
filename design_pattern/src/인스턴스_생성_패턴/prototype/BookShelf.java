package 인스턴스_생성_패턴.prototype;

import java.util.ArrayList;

public class BookShelf implements Cloneable{

    private ArrayList<Book> shelf;

    public BookShelf() {
        shelf = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        shelf.add(book);
    }

    public ArrayList<Book> getShelf() {
        return shelf;
    }

    public void setShelf(ArrayList<Book> shelf) {
        this.shelf = shelf;
    }

    @Override
    public String toString() {
        return "BookShelf{" +
                "shelf=" + shelf +
                '}';
    }

    //clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        BookShelf another = new BookShelf();
        for (Book book : shelf) {
            another.addBook(new Book(book.getAuthor(), book.getTitle()));
        }
        return another;
    }
}
