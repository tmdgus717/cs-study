package 인스턴스_생성_패턴.prototype;

public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        BookShelf bookShelf = new BookShelf();

        bookShelf.addBook(new Book("조정래", "태백산맥"));
        bookShelf.addBook(new Book("남궁성", "자바의 정석"));
        bookShelf.addBook(new Book("문병로", "쉽게 배우는 자료구조"));

        System.out.println(bookShelf);

        //복제
        BookShelf another = (BookShelf) bookShelf.clone();
        System.out.println(another);
        //hashCode 확인
        System.out.println(bookShelf.hashCode());
        System.out.println(another.hashCode());

        bookShelf.getShelf().get(0).setAuthor("조정래");
        bookShelf.getShelf().get(0).setTitle("한강");

        System.out.println(bookShelf);
        System.out.println(another);

    }
}
