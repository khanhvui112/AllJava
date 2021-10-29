package dao;

import DatabaseConnection.DatabaseConnection;
import entities.Book;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author san vui
 * @create 09/09/2021 - 16:11
 * @sanvankhanh@gmail.com
 */
public class BookDao {
    public List<Book> getBook() {
        List<Book> bookList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sqlQuery = "SELECT title, author,datePublish FROM BOOK";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                LocalDate localDate = LocalDate.parse(rs.getString("datePublish"));
                bookList.add(new Book( title,  author, localDate));
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Can not get the book  list: " + e.getMessage());
        }

        return bookList;
    }
//    create booklist
public boolean createBook(List<Book> bookList) throws SQLException {
    // Step 1. Create connection
    Connection connection = null;
    try  {
        connection = DatabaseConnection.getConnection();
        connection.setAutoCommit(false);
        // Step 2: Create statement
        String sqlQuery = "INSERT INTO dbo.BOOK(title,author,datePublish)VALUES(? , ?,?)";
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        int recordInserted = 0;
        for (Book book : bookList) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setDate(3, java.sql.Date.valueOf(book.getDatePublish()));
            statement.addBatch();
        }
        recordInserted = statement.executeBatch().length;
        System.out.println("Inserted success: " + recordInserted);
        connection.commit();
        // Step3: Execute
        return recordInserted == bookList.size();

    } catch (SQLException | ClassNotFoundException throwables) {
        if (Objects.nonNull(connection)){
            connection.rollback();
        }
        throwables.printStackTrace();
    }finally {
        connection.close();
    }

    return false;
}
//delete book
public boolean deleteBook(String author) throws SQLException {
    System.out.println(author+"delete ne");
    try(Connection connection= DatabaseConnection.getConnection()) {
        String sqlQuery = "DELETE FROM dbo.BOOK WHERE author=?";
        PreparedStatement  statement = connection.prepareStatement(sqlQuery);
        statement.setString(1,author);
        return statement.executeUpdate() > 0;
    } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Can not delete the book  list: " + e.getMessage());
    }
    return false;
}
    public boolean updateBook(String author,String title) throws SQLException {
        try(Connection connection = DatabaseConnection.getConnection()) {
            String sqlQuery = "UPDATE dbo.BOOK SET title=?  WHERE author=?";
            PreparedStatement  statement = connection.prepareStatement(sqlQuery);
            statement.setString(2,title);
            statement.setString(1,author);
            return statement.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Can not delete the book  list: " + e.getMessage());
        }
        return false;
    }
}
