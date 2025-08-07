package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

import java.util.List;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library myLibrary = new Library("중앙 도서관");

        System.out.println("===== 도서 추가 테스트 =====");
        addSampleBooks(myLibrary);

        displayLibraryStatus(myLibrary);

        System.out.println("\n===== 도서 검색 테스트 =====");
        testFindBook(myLibrary);

        System.out.println("\n===== 도서 대출 테스트 =====");
        testCheckOut(myLibrary);
        displayLibraryStatus(myLibrary);

        System.out.println("\n===== 도서 반납 테스트 =====");
        testReturn(myLibrary);
        displayLibraryStatus(myLibrary);

        System.out.println("\n===== 대출 가능한 도서 목록 =====");
        displayAvailableBooks(myLibrary);
    }

    private static void addSampleBooks(Library library) {
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        System.out.println("도서가 추가되었습니다: 자바 프로그래밍");
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        System.out.println("도서가 추가되었습니다: 객체지향의 사실과 오해");
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        System.out.println("도서가 추가되었습니다: Clean Code");
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        System.out.println("도서가 추가되었습니다: Effective Java");
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        System.out.println("도서가 추가되었습니다: Head First Java");
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
        System.out.println("도서가 추가되었습니다: 자바의 정석");
    }

    private static void displayLibraryStatus(Library library) {
        System.out.println("도서관 현재 상태:");
        System.out.println("전체 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + (library.getTotalBooks() - library.getAvailableBooksCount()));
    }

    private static void testFindBook(Library library) {
        System.out.println("제목으로 검색 결과:");
        Book foundByTitle = library.findByTitle("자바의 정석");
        if (foundByTitle != null) {
            System.out.println(foundByTitle);
        }

        System.out.println("\n저자로 검색 결과:");
        List<Book> foundByAuthor = library.findByAuthor("Robert C. Martin");
        if (!foundByAuthor.isEmpty()) {
            for (Book book : foundByAuthor) {
                System.out.println(book);
            }
        }
    }

    private static void testCheckOut(Library library) {
        if (library.checkOutBook("978-89-01-14077-4")) {
            System.out.println("도서 대출 성공!");
            System.out.println("대출된 도서 정보:");
            Book checkedOutBook = library.findByISBN("978-89-01-14077-4");
            if (checkedOutBook != null) {
                System.out.println(checkedOutBook);
            }
        } else {
            System.out.println("도서 대출 실패!");
        }
        System.out.println("");
    }

    private static void testReturn(Library library) {
        if (library.returnBook("978-89-01-14077-4")) {
            System.out.println("도서 반납 성공!");
            System.out.println("반납된 도서 정보:");
            Book returnedBook = library.findByISBN("978-89-01-14077-4");
            if (returnedBook != null) {
                System.out.println(returnedBook);
            }
        } else {
            System.out.println("도서 반납 실패!");
        }
        System.out.println("");
    }

    private static void displayAvailableBooks(Library library) {
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book);
            System.out.println("------------------------");
        }
    }
}