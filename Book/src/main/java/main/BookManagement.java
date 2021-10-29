package main;

import dao.BookDao;
import entities.Book;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author san vui
 * @create 09/09/2021 - 16:28
 * @sanvankhanh@gmail.com
 */
public class BookManagement {
    public static void main(String[] args) throws SQLException {
        BookDao bookDao = new BookDao();
        String date = "25/10/2015";
        String date2 = "26/10/2015";
        String date3 = "27/10/2015";
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dates1 = LocalDate.parse(date, dateFormat);
        LocalDate dates2 = LocalDate.parse(date2, dateFormat);
        LocalDate dates3 = LocalDate.parse(date3, dateFormat);
        Book book = new Book("san khanh","khanh ne",dates1);
        Book book1 = new Book("chicken fly","khanh vui",dates2);
        Book book2 = new Book("pig fly","khanh san",dates3);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book1);
        bookList.add(book2);
        // 1. Create
        boolean isSuccess = bookDao.createBook(bookList);
        System.out.println("Create account is successful: " + isSuccess);

        // 2.Select
        List<Book> bookList1 = bookDao.getBook();
        System.out.println(bookList1.toString());

        // 3. Delete
        Scanner scanner = new Scanner(System.in);
        String author = "khanh san";
        isSuccess = bookDao.deleteBook(author);
        System.out.println("Delete account is successful: " + isSuccess);


        // 3. Update
        String author1 = "khanh vui";
        String title = "da update nha";
        isSuccess = bookDao.updateBook(author1,title);
        System.out.println("Update account is successful: " + isSuccess);

    }
}
