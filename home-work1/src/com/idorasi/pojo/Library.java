package com.idorasi.pojo;

import com.idorasi.util.enums.Genre;
import com.idorasi.util.enums.Zone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "library")
@XmlAccessorType(XmlAccessType.FIELD)
public class Library {

    private String name;
    private Zone zone;

    @XmlElement(name = "books")
    private BookList bookList;

    private Library(String name, Zone zone, BookList bookList) {
        this.name = name;
        this.zone = zone;
        this.bookList = bookList;
    }

    public Library() {
    }

    public String getName() {
        return name;
    }

    public BookList getBookList() {
        return bookList;
    }

    public Zone getZone() {
        return zone;
    }

    public boolean containsGenre(Genre genre) {
        return bookList.getBooks().stream().anyMatch(book -> book.getGenre().equals(genre));
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", zone=" + zone +
                ", bookList=" + bookList +
                '}';
    }

    public static final class LibraryBuilder {
        private String name;
        private Zone zone;
        private BookList bookList;

        private LibraryBuilder() {
        }

        public static LibraryBuilder builder() {
            return new LibraryBuilder();
        }

        public LibraryBuilder name(String name) {
            this.name = name;
            return this;
        }

        public LibraryBuilder zone(Zone zone) {
            this.zone = zone;
            return this;
        }

        public LibraryBuilder bookList(BookList bookList) {
            this.bookList = bookList;
            return this;
        }

        public Library build() {
            return new Library(name, zone, bookList);
        }
    }
}

