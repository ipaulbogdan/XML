package com.idorasi.pojo;

import com.idorasi.util.enums.Genre;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    private String title;
    private String author;
    private Genre genre;

    public Book() {
    }

    private Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                '}';
    }

    public static final class BookBuilder {
        private String title;
        private String author;
        private Genre genre;

        private BookBuilder() {
        }

        public static BookBuilder builder() {
            return new BookBuilder();
        }

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder genre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public Book build() {
            Book book = new Book(title, author);
            book.genre = this.genre;
            return book;
        }
    }
}
