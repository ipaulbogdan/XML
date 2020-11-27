package com.idorasi.converter.dom;

import com.idorasi.pojo.Book;
import com.idorasi.pojo.BookList;
import com.idorasi.pojo.Library;
import com.idorasi.util.enums.Zone;
import org.w3c.dom.Node;

public class LibraryConverter {

    BookListConverter bookListConverter;

    public LibraryConverter() {
        bookListConverter = new BookListConverter();
    }

    public Library convertFromNode(Node libraryNode) {
        return Library.LibraryBuilder.builder()
                .name(libraryNode.getFirstChild().getNodeValue())
                .zone(Zone.valueOf(libraryNode.getFirstChild().getNextSibling().getNodeValue()))
                .bookList(bookListConverter.convertFromNode(libraryNode.getLastChild()))
                .build();
    }
}
