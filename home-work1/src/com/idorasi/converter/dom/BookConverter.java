package com.idorasi.converter.dom;

import com.idorasi.pojo.Book;
import com.idorasi.util.enums.Genre;
import org.w3c.dom.Node;

public class BookConverter {

    public Book convertFromNode(Node book) {
        return Book.BookBuilder.builder()
                .title(book.getFirstChild().getNodeValue())
                .author(book.getFirstChild().getNextSibling().getNodeValue())
                .genre(Genre.valueOf(book.getLastChild().getNodeValue()))
                .build();
    }
}
