import Entity.Author;
import Entity.Book;
import Entity.Customer;
import Entity.Gender;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();


        Author author = new Author("John", "Doe@gmail.com", Gender.M);
        Author author1 = new Author("Rowling", "jk@example.com", Gender.F);
        Author author2 = new Author("Martin", "george@example.com", Gender.M);
        Author author3 = new Author("Tolkien", "tolkien@example.com", Gender.M);


        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter", author1, 20, 100));
        books.add(new Book("Doraemon", author2, 19.99, 100));
        books.add(new Book("Conan", author2, 38, 100));
        books.add(new Book("Shin", author3, 38, 100));


//        books.stream().sorted(Comparator.comparing(Book::getName)).forEach(System.out::println);

        // Tìm cuốn sách có giá cao nhất
//        Book maxPrice = books.stream().max(Comparator.comparing(Book::getPrice)).orElse(null);
//        if(maxPrice != null) {
//            System.out.println("Cuốn sách có giá tối đa là: " + maxPrice);
//        } else {
//            System.out.println("Không tìm thấy sách.");
//        }


        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên tác giả để liệt kê sách: ");
        String authorName = scanner.nextLine().trim();

        if (!authorName.isEmpty()) {
            List<Book> booksByAuthor = new ArrayList<>();
            for (Book b : books) {
                if (b.getAuthor().getName().equalsIgnoreCase(authorName)) {
                    booksByAuthor.add(b);
                }
            }

            if (booksByAuthor.isEmpty()) {
                System.out.println("Không tìm thấy sách của tác giả: " + authorName);
            } else {
                System.out.println("Danh sách sách của tác giả " + authorName + ":");
                for (Book b : booksByAuthor) {
                    System.out.println(b);
                }
            }
        } else {
            System.out.println("Tên tác giả không được để trống.");
        }

        scanner.close();
    }
}
