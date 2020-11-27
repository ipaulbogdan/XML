package com.idorasi.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "books")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookList {

    @XmlElement(name = "book")
    private List<Book> books = null;

    private BookList(List<Book> books) {
        this.books = books;
    }

    public BookList() {
    }

    @Override
    public String toString() {
        return "BookList{" +
                "books=" + books +
                '}';
    }

    public List<Book> getBooks() {
        return books;
    }

    public static final class BookListBuilder {
        private List<Book> books = null;

        private BookListBuilder() {
        }

        public static BookListBuilder builder() {
            return new BookListBuilder();
        }

        public BookListBuilder books(List<Book> books) {
            this.books = books;
            return this;
        }

        public BookList build() {
            return new BookList(books);
        }
    }
}
