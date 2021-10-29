package entities;

import java.time.LocalDate;

/**
 * @author san vui
 * @create 09/09/2021 - 16:09
 * @sanvankhanh@gmail.com
 */
public class Book {
    private String title;
    private String Author;
    private LocalDate datePublish;

    public Book() {
    }

    public Book(String title, String author, LocalDate datePublish) {
        this.title = title;
        Author = author;
        this.datePublish = datePublish;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public LocalDate getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(LocalDate datePublish) {
        this.datePublish = datePublish;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", Author='" + Author + '\'' +
                ", datePublish=" + datePublish +
                '}';
    }
}
