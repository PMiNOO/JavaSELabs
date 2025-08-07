package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

import java.util.List;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library myLibrary = new Library("�߾� ������");

        System.out.println("===== ���� �߰� �׽�Ʈ =====");
        addSampleBooks(myLibrary);

        displayLibraryStatus(myLibrary);

        System.out.println("\n===== ���� �˻� �׽�Ʈ =====");
        testFindBook(myLibrary);

        System.out.println("\n===== ���� ���� �׽�Ʈ =====");
        testCheckOut(myLibrary);
        displayLibraryStatus(myLibrary);

        System.out.println("\n===== ���� �ݳ� �׽�Ʈ =====");
        testReturn(myLibrary);
        displayLibraryStatus(myLibrary);

        System.out.println("\n===== ���� ������ ���� ��� =====");
        displayAvailableBooks(myLibrary);
    }

    private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        System.out.println("������ �߰��Ǿ����ϴ�: �ڹ� ���α׷���");
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        System.out.println("������ �߰��Ǿ����ϴ�: ��ü������ ��ǰ� ����");
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        System.out.println("������ �߰��Ǿ����ϴ�: Clean Code");
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        System.out.println("������ �߰��Ǿ����ϴ�: Effective Java");
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        System.out.println("������ �߰��Ǿ����ϴ�: Head First Java");
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
        System.out.println("������ �߰��Ǿ����ϴ�: �ڹ��� ����");
    }

    private static void displayLibraryStatus(Library library) {
        System.out.println("������ ���� ����:");
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + (library.getTotalBooks() - library.getAvailableBooksCount()));
    }

    private static void testFindBook(Library library) {
        System.out.println("�������� �˻� ���:");
        Book foundByTitle = library.findByTitle("�ڹ��� ����");
        if (foundByTitle != null) {
            System.out.println(foundByTitle);
        }

        System.out.println("\n���ڷ� �˻� ���:");
        List<Book> foundByAuthor = library.findByAuthor("Robert C. Martin");
        if (!foundByAuthor.isEmpty()) {
            for (Book book : foundByAuthor) {
                System.out.println(book);
            }
        }
    }

    private static void testCheckOut(Library library) {
        if (library.checkOutBook("978-89-01-14077-4")) {
            System.out.println("���� ���� ����!");
            System.out.println("����� ���� ����:");
            Book checkedOutBook = library.findByISBN("978-89-01-14077-4");
            if (checkedOutBook != null) {
                System.out.println(checkedOutBook);
            }
        } else {
            System.out.println("���� ���� ����!");
        }
        System.out.println("");
    }

    private static void testReturn(Library library) {
        if (library.returnBook("978-89-01-14077-4")) {
            System.out.println("���� �ݳ� ����!");
            System.out.println("�ݳ��� ���� ����:");
            Book returnedBook = library.findByISBN("978-89-01-14077-4");
            if (returnedBook != null) {
                System.out.println(returnedBook);
            }
        } else {
            System.out.println("���� �ݳ� ����!");
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